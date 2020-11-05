package inc.bugfree.instacare.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class UserService {

    private UserDao userDao = null;

    @Autowired
    public void setDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public List<UserBean> getAll() throws Exception {
        return userDao.getAll();
    }

    public UserBean getUserById(String id)  throws InterruptedException, ExecutionException {
        return userDao.getUserById(id);
    }

    public String addUser(String uid, UserBean user) throws ExecutionException, InterruptedException {
//        UserBean userBean = new UserBean();
        user.setId(uid);
//        userBean.setUserType(userType);
        return userDao.addUser(user);
    }

}
