package inc.bugfree.instacare.service;

import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.dao.CommentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CommentsService {
    private CommentsDao commentsDao = null;

    @Autowired
    public void setDao(CommentsDao commentsDao) {this.commentsDao = commentsDao;}

    public CommentsBean getCommentById(String id) throws InterruptedException, ExecutionException {
        return commentsDao.getCommentById(id);
    }

    public String addComments(CommentsBean commentsBean, String id) throws InterruptedException, ExecutionException {
        return commentsDao.addComments(commentsBean, id);
    }
}
