package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.dao.CommentsDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class CommentsDaoImpl implements CommentsDao{

    private final FirebaseService db;

    public CommentsDaoImpl(FirebaseService db) {this.db = db;}

    @Override
    public List<CommentsBean> getCommentByUid(String userId, String commentId) throws InterruptedException, ExecutionException {
        List<CommentsBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        DocumentReference commentDocRef = dbFirestore.collection("comments").document(commentId);
        CollectionReference commentsColRef = commentDocRef.collection("allComments");
        Query query = commentsColRef.whereEqualTo("userId", userId).orderBy("createTime", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> apiFuture = query.get();
        for (DocumentSnapshot document : apiFuture.get().getDocuments()) {
            CommentsBean commentsBean = document.toObject(CommentsBean.class);
            list.add(commentsBean);
        }
        return list;
    }

    @Override
    public String updateCommentByUid(String userId, String commentId, CommentsBean commentsBean) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference docRef = dbFirestore.collection("comments").document(commentId);
        DocumentReference commentDoc = docRef.collection("allComments").document();
        commentsBean.setId(commentDoc.getId());
        ApiFuture<WriteResult> result = commentDoc.create(commentsBean);
        return result.get().getUpdateTime().toString();
    }
}
