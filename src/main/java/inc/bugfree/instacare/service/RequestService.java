package inc.bugfree.instacare.service;

import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@Service
public class RequestService {

    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    public String saveRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException {
        requestBean.setSeniorId(uid);
        requestBean.setStatus(1); // 1 is ongoing, 2 is taken, 3 is completed, 4 is canceled
        SimpleDateFormat ISO_8601_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");

        String now = ISO_8601_FORMAT.format(new Date());
        requestBean.setCreateTime(now);
        return requestDao.saveRequest(requestBean, uid);
    }

    public List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException {
        return requestDao.getRequestsByUid(id);
    }

    public List<RequestBean> getPastRequestsByUid(String id) throws ExecutionException, InterruptedException {
        return requestDao.getPastRequestsByUid(id);
    }

    public List<RequestBean> getAllOnGoingRequest() throws ExecutionException, InterruptedException {
        return requestDao.getAllOnGoingRequests();
    }

    public String updateRequest(String requestId, Map<String, Object> updateData) throws ExecutionException, InterruptedException {
        return requestDao.updateRequest(requestId, updateData);
    }
}