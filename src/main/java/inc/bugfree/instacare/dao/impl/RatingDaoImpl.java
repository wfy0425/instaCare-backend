package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.RatingBean;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RatingDao;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class RatingDaoImpl implements RatingDao {

    private final FirebaseService db;
    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

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

    @Override
    public String insertRatingByRid(String requestId, RatingBean ratingBean) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = db.getFirestore();
        RequestBean request = requestDao.getRequestByRequestId(requestId);
        DocumentReference docRef = dbFirestore.collection("requestPlaza").document(requestId);
        Map<String, Object> updateData = new HashMap<>();
        if (request.getRating() == null || request.getNumOfRating() == null){
            updateData.put("rating", ratingBean.getUserRating());
            updateData.put("numOfRating", 1);
        }else{
            updateData.put("numOfRating", 2);
            float result = (request.getRating()+ratingBean.getUserRating())/(request.getNumOfRating()+1);
           updateData.put("rating", result);
        }
        ApiFuture<WriteResult> result = docRef.update(updateData);
        return result.get().getUpdateTime().toString();
    }
}
