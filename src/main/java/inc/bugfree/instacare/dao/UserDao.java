package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<UserBean> getByCourse(String department, String courseCode);

    List<UserBean> findAll() throws Exception;
}