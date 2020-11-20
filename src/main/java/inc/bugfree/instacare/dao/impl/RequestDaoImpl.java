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
        DocumentReference docRef = dbFirestore.collection("requests").document(uid);
        DocumentReference requestInfo = docRef.collection("onGoing").document();
        requestBean.setId(requestInfo.getId());
        ApiFuture<WriteResult> result = requestInfo.create(requestBean);
        return requestInfo.getId();
    }

    @Override
    public String savePastRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("requests").document(uid);
        DocumentReference requestInfo = docRef.collection("past").document();
        docRef.collection("onGoing").document(requestBean.getId()).delete();
        requestBean.setId(requestInfo.getId());
        ApiFuture<WriteResult> result = requestInfo.create(requestBean);
        return requestInfo.getId();
    }


    @Override
    public List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException {
        List<RequestBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        DocumentReference requests = dbFirestore.collection("requests").document(id);
        CollectionReference onGoing = requests.collection("onGoing");
        ApiFuture<QuerySnapshot> apiFuture = onGoing.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            list.add(requestBean);
        }
        // TODO use orderBy
        // sort request list by create time
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
        DocumentReference requests = dbFirestore.collection("requests").document(id);
        CollectionReference past = requests.collection("pastRequests");
        ApiFuture<QuerySnapshot> apiFuture = past.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RequestBean requestBean = document.toObject(RequestBean.class);
            list.add(requestBean);
        }

        return list;
    }


}
