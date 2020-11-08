package inc.bugfree.instacare.dao.impl;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

@Component
public class RequestDaoImpl implements RequestDao {

    private final FirebaseService db;

    public RequestDaoImpl(FirebaseService db) {
        this.db = db;
    }

    @Override
    public void saveRequest(RequestBean requestBean, String uid) {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("request").document(uid);
        DocumentReference requestInfo = docRef.collection("requestInfo").document();
        requestInfo.set(requestBean);
    }
}
