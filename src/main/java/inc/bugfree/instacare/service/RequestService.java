package inc.bugfree.instacare.service;

import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.RequestDao;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class RequestService {

    private RequestDao requestDao;

    @Autowired
    public void setRequestDao(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    public String saveRequest(RequestBean requestBean, String uid) throws ExecutionException, InterruptedException {
        return requestDao.saveRequest(requestBean, uid);
    }

    public List<RequestBean> getRequestsByUid(String id) throws ExecutionException, InterruptedException {
       return requestDao.getRequestsByUid(id);
    }

    public List<RequestBean> getPastRequestsByUid(String id) throws ExecutionException, InterruptedException {
        return requestDao.getPastRequestsByUid(id);
    }
}
