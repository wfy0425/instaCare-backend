package inc.bugfree.instacare.service;

import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.dao.CommentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CommentsService {
    private CommentsDao commentsDao = null;

    @Autowired
    public void setCommentsDao(CommentsDao commentsDao) {this.commentsDao = commentsDao;}

    public List<CommentsBean> getCommentByUid(String userId, String commentId) throws InterruptedException, ExecutionException {
        return commentsDao.getCommentByUid(userId, commentId);
    }

    public String updateCommentByUid(String userId, String commentId, CommentsBean commentsBean) throws InterruptedException, ExecutionException {
        return commentsDao.updateCommentByUid(userId, commentId, commentsBean);
    }
}
