package inc.bugfree.instacare.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;


@Service
public class UserService {

    private UserDao userDao = null;

    @Autowired
    public void setDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserBean getUserById(String id)  throws InterruptedException, ExecutionException {
        return userDao.getUserById(id);
    }


}
