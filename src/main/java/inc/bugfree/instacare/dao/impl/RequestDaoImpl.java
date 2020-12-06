package inc.bugfree.instacare.dao.impl;


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
    public List<RequestBean> getRequestsByUid(String id, Integer userType) throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
        // Query ongoing = requestPlaza.whereLessThan("status", 3).orderBy("status", Query.Direction.ASCENDING).orderBy("createTime", Query.Direction.DESCENDING);
        Query result;
        if (userType==0){
            // 这边orderBy createTime无法用与whereLessThan("status", 3)
            // 所以在下面加了判断不等于3的情况
            result = requestPlaza.whereEqualTo("seniorId", id).orderBy("createTime", Query.Direction.DESCENDING );
        }else {
            result = requestPlaza.whereEqualTo("status", 2).whereEqualTo("volunteerId", id)
                    .orderBy("createTime", Query.Direction.DESCENDING);
        }

        ApiFuture<QuerySnapshot> apiFuture = result.get();

        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            if (requestBean.getStatus() != 3){
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
        Query pastRequest = requestPlaza.whereEqualTo("status", 3).orderBy("createTime", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> apiFuture = pastRequest.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            if ((requestBean.getVolunteerId()!=null && requestBean.getVolunteerId().equals(id)) || requestBean.getSeniorId().equals(id)){
                list.add(requestBean);
            }
        }
        return list;
    }

    @Override
    public RequestBean getRequestByRequestId(String id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference request = dbFirestore.collection("requestPlaza").document(id);
        ApiFuture<DocumentSnapshot> future = request.get();
        DocumentSnapshot document = future.get();

        if(document.exists()) {
            return document.toObject(RequestBean.class);
        }else {
            return null;
        }
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

    @Override
    public String deletePastRequest(String requestId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("requestPlaza").document(requestId);
        ApiFuture<WriteResult> result = docRef.delete();
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