package inc.bugfree.instacare.dao;

import inc.bugfree.instacare.bean.CommentsBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface CommentsDao {
    List<CommentsBean> getCommentByUid(String userId, String commentId) throws InterruptedException, ExecutionException;

    String updateCommentByUid(String userId, String commentId, CommentsBean commentsBean) throws InterruptedException, ExecutionException;
}
