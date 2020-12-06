package inc.bugfree.instacare.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.RatingBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.AddressDao;
import inc.bugfree.instacare.dao.RatingDao;
import inc.bugfree.instacare.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@Service
public class RatingService {

    private UserDao userDao = null;
    private RatingDao ratingDao = null;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setRatingDao(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }



    public List<RatingBean> getRatingsByUserId(String userId) throws InterruptedException, ExecutionException {
        return ratingDao.getRatingsByUserId(userId);
    }

    public String addRatingsByUserId( String userId, RatingBean ratingBean) throws InterruptedException, ExecutionException {
        UserBean user = userDao.getUserById(userId);

        Map<String, Object> updateData = new HashMap<>();
        int numOfRating = user.getNumOfRating();
        updateData.put("numOfRating",numOfRating+1);
        updateData.put("accumulativeRating",(numOfRating*user.getAccumulativeRating()+ratingBean.getUserRating())/(numOfRating+1));
        userDao.updateUser(userId, updateData);

        return ratingDao.addRatingsByUserId(ratingBean,userId);
    }


    public String insertRatingByRid(String requestId, RatingBean ratingBean) throws ExecutionException, InterruptedException {
        return ratingDao.insertRatingByRid(requestId, ratingBean);
    }
}
