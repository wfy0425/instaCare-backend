package inc.bugfree.instacare.dao.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.dao.CommentsDao;
import inc.bugfree.instacare.service.FirebaseService;
import org.springframework.stereotype.Component;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class CommentsDaoImpl implements CommentsDao{

    private final FirebaseService db;

    public CommentsDaoImpl(FirebaseService db) {this.db = db;}

    @Override
    public List<CommentsBean> getCommentsByRequestId(String requestId) throws InterruptedException, ExecutionException {
        List<CommentsBean> list = new ArrayList<>();
        Firestore dbFirestore = db.getFirestore();
        DocumentReference requestDocRef = dbFirestore.collection("requestPlaza").document(requestId);
        CollectionReference commentsColRef = requestDocRef.collection("comments");
        Query query = commentsColRef.orderBy("createTime", Query.Direction.DESCENDING);
        ApiFuture<QuerySnapshot> apiFuture = query.get();
        for (DocumentSnapshot document: apiFuture.get().getDocuments()){
            CommentsBean commentsBean = document.toObject(CommentsBean.class);
            list.add(commentsBean);
        }
        return list;
    }

    @Override
    public String updateCommentByRequestId(String requestId, CommentsBean commentsBean) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = db.getFirestore();
        DocumentReference requestDocRef = dbFirestore.collection("requestPlaza").document(requestId);
        DocumentReference commentDocRef = requestDocRef.collection("comments").document();
        commentsBean.setId(commentDocRef.getId());
        ApiFuture<WriteResult> result = commentDocRef.create(commentsBean);
        return result.get().getUpdateTime().toString();
    }
}
