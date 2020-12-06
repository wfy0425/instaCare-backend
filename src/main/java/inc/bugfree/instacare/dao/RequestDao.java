package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
public interface RequestDao {

    String saveRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException;

    List<RequestBean> getRequestsByUid(String id, Integer userType) throws ExecutionException, InterruptedException;
    List<RequestBean> getPastRequestsByUid(String id) throws ExecutionException, InterruptedException;
    RequestBean getRequestByRequestId(String id) throws ExecutionException, InterruptedException;
    List<RequestBean> getAllOnGoingRequests() throws ExecutionException, InterruptedException;

    String updateRequest(String requestId, Map<String, Object> updateData) throws ExecutionException, InterruptedException;
    String deletePastRequest(String requestId) throws ExecutionException, InterruptedException;
//    String cancelRequest(String requestId) throws ExecutionException, InterruptedException;
}