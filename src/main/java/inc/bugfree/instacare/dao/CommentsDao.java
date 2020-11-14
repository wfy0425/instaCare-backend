package inc.bugfree.instacare.dao;

import inc.bugfree.instacare.bean.CommentsBean;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public interface CommentsDao {
    CommentsBean getCommentById(String id) throws InterruptedException, ExecutionException;

    String addComments(CommentsBean commentsBean, String id) throws InterruptedException, ExecutionException;
}
