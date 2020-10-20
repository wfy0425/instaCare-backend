package inc.bugfree.carego.service;

import inc.bugfree.carego.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private UserDao userDao = null;

    @Autowired
    public void setDao(UserDao userDao) {
        this.userDao = userDao;
    }




}
