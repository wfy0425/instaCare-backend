package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface RequestDao {

    String saveRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException;
    String savePastRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException;


    List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException;
    List<RequestBean> getPastRequestsByUid(String id) throws ExecutionException, InterruptedException;

    List<RequestBean> getAddressByAddressId(String id) throws ExecutionException, InterruptedException;
}