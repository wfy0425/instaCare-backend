package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public interface UserDao {
    List<UserBean> findAll() throws Exception;
    void saveUserType(UserBean user);

    UserBean getUserById(String id) throws InterruptedException, ExecutionException;

}