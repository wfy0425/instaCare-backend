package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface RequestDao {

    void saveRequest(RequestBean requestBean, String uid);

    List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException;

    void saveRequestToPlazza(RequestBean requestBean);
}