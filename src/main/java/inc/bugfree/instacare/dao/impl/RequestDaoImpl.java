package inc.bugfree.instacare.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.gson.JsonObject;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class RequestDaoImpl implements RequestDao {

    private final FirebaseService db;

    public RequestDaoImpl(FirebaseService db) {
        this.db = db;
    }

    @Override
    public String saveRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("requestPlaza").document();
//        dbFirestore.collection("requestPlaza").orderBy("create_time", Query.Direction.DESCENDING);
        requestBean.setId(docRef.getId());

        ApiFuture<WriteResult> result = docRef.create(requestBean);

        return result.get().getUpdateTime().toString();
    }

    @Override
    public List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
        Query ongoing = requestPlaza.whereLessThan("status", 3).orderBy("status", Query.Direction.ASCENDING).orderBy("createTime", Query.Direction.DESCENDING);

        ApiFuture<QuerySnapshot> apiFuture = ongoing.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            if (requestBean.getVolunteerId()==null){
                if (requestBean.getSeniorId().equals(id)){
                    list.add(requestBean);
                }
            }else if (requestBean.getVolunteerId().equals(id)){
                list.add(requestBean);
            }

        }

        return list;
    }

    @Override
    public List<RequestBean> getPastRequestsByUid(String id) throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
        Query pastRequest = requestPlaza.whereEqualTo("status", 3).whereEqualTo("seniorId", id).orderBy("createTime", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> apiFuture = pastRequest.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            list.add(requestBean);
        }
        return list;
    }

    @Override
    public List<RequestBean> getAllOnGoingRequests() throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
        Query result = requestPlaza.whereEqualTo("status", 1).orderBy("createTime", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> apiFuture = result.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            list.add(requestBean);
        }

        return list;
    }

    @Override
    public String updateRequest(String requestId, Map<String, Object> updateData) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("requestPlaza").document(requestId);
        ApiFuture<WriteResult> result = docRef.update(updateData);
        return result.get().getUpdateTime().toString();
    }

//    @Override
//    public String cancelRequest(String requestId) throws ExecutionException, InterruptedException {
//        Firestore dbFirestore = db.getFirestore();
//        DocumentReference docRef = dbFirestore.collection("requestPlaza").document(requestId);
//        ApiFuture<WriteResult> result = docRef.update(updateData);
//        return result.get().getUpdateTime().toString();
//    }
}
// 1 is ongoing, 2 is taken, 3 is completed, 4 is canceled