package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.RatingBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RatingDao;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class RatingDaoImpl implements RatingDao {

    private final FirebaseService db;

    public RatingDaoImpl(FirebaseService db) {
        this.db = db;
    }

    //TODO: align with db schema
    @Override
    public List<RatingBean> getRatingsByUserId(String userId) throws InterruptedException, ExecutionException {
        List<RatingBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        CollectionReference colRef = dbFirestore.collection("requests").document(userId)
                .collection("ratings");
        ApiFuture<QuerySnapshot> apiFuture = colRef.get();
        for (QueryDocumentSnapshot document : apiFuture.get().getDocuments()) {
            RatingBean ratingBean = document.toObject(RatingBean.class);
            list.add(ratingBean);
        }
        return list;
    }

    //TODO: align with db schema
    @Override
    public String addRatingsByUserId(RatingBean ratingBean, String userId) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("requests").document(userId)
                .collection("ratings").document();
        ratingBean.setId(docRef.getId());
        ApiFuture<WriteResult> result = docRef.create(ratingBean);
        return docRef.getId();
    }
}
