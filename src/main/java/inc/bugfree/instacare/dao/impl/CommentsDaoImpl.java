package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.dao.CommentsDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class CommentsDaoImpl implements CommentsDao{

    private final FirebaseService db;

    public CommentsDaoImpl(FirebaseService db) {this.db = db;}

    @Override
    public CommentsBean getCommentById(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("comments").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        CommentsBean commentsBean = null;
        if(document.exists()) {
            commentsBean = document.toObject(CommentsBean.class);
            return commentsBean;
        }
        else{
            return null;
        }
    }

    @Override
    public String addComments(CommentsBean commentsBean, String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("comments").document(id);
        DocumentReference commentInfo = docRef.collection("onGoing").document(id);
        commentsBean.setId(commentInfo.getId());
        ApiFuture<WriteResult> result = commentInfo.set(commentsBean);
        return result.get().getUpdateTime().toString();
    }
}
