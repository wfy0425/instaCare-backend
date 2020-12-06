package inc.bugfree.instacare.service;

import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
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

        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        requestBean.setCreateTime(nowAsISO);
        return requestDao.saveRequest(requestBean, uid);
    }

    public List<RequestBean> getRequestsByUid(String id, Integer userType) throws ExecutionException, InterruptedException {
        return requestDao.getRequestsByUid(id, userType);
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

    public String deletePastRequest(String requestId) throws ExecutionException, InterruptedException {
        return requestDao.deletePastRequest(requestId);
    }


    public RequestBean getRequestsByRequestId(String id) throws ExecutionException, InterruptedException {
        return requestDao.getRequestByRequestId(id);
    }


}