package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class RequestDaoImpl implements RequestDao {

    private final FirebaseService db;

    public RequestDaoImpl(FirebaseService db) {
        this.db = db;
    }

    @Override
    public void saveRequest(RequestBean requestBean, String uid) {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("requests").document(uid);
        DocumentReference requestInfo = docRef.collection("onGoing").document();
        requestInfo.set(requestBean);
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

        return list;
    }


}
