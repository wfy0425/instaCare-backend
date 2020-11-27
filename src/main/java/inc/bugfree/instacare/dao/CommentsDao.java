package inc.bugfree.instacare.dao;

import inc.bugfree.instacare.bean.CommentsBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface CommentsDao {
    List<CommentsBean> getCommentsByRequestId(String requestId) throws InterruptedException, ExecutionException;

    String updateCommentByRequestId(String requestId, CommentsBean commentsBean) throws InterruptedException, ExecutionException;
}
