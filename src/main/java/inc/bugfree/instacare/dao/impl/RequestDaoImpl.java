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
        requestBean.setId(uid);
        requestBean.setRequestId(docRef.getId());
        requestBean.setSeniorId(uid);
        requestBean.setStatus(0); // 0 is ongoing
        ApiFuture<WriteResult> result = docRef.create(requestBean);

        return result.get().getUpdateTime().toString();
    }

    @Override
    public List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
//        Query result = requestPlaza.orderBy("create_time", Query.Direction.DESCENDING);
        Query queryId = requestPlaza.whereEqualTo("id", id);
        Query ongoing = queryId.whereEqualTo("status", 0);

        ApiFuture<QuerySnapshot> apiFuture = ongoing.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
                list.add(requestBean);

        }
        list.sort(new Comparator<RequestBean>() {
            @Override
            public int compare(RequestBean o1, RequestBean o2) {
                return o2.getCreateTime().compareTo(o1.getCreateTime());
            }
        });

        return list;
    }

    @Override
    public List<RequestBean> getPastRequestsByUid(String id) throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
        Query queryId = requestPlaza.whereEqualTo("id", id);
        Query pastRequest = queryId.whereEqualTo("status", 1);
        ApiFuture<QuerySnapshot> apiFuture = pastRequest.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
                list.add(requestBean);
        }

        list.sort(new Comparator<RequestBean>() {
            @Override
            public int compare(RequestBean o1, RequestBean o2) {
                return o2.getCreateTime().compareTo(o1.getCreateTime());
            }
        });

        return list;
    }

    @Override
    public List<RequestBean> getAllOnGoingRequests() throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference requestPlaza = dbFirestore.collection("requestPlaza");
        Query result = requestPlaza.whereEqualTo("status", 0);
        ApiFuture<QuerySnapshot> apiFuture = result.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            list.add(requestBean);
        }

        list.sort(new Comparator<RequestBean>() {
            @Override
            public int compare(RequestBean o1, RequestBean o2) {
                return o2.getCreateTime().compareTo(o1.getCreateTime());
            }
        });

        return list;
    }


}