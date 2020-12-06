package inc.bugfree.instacare.dao;


import inc.bugfree.instacare.bean.RatingBean;
import inc.bugfree.instacare.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Repository
public interface RatingDao {
    List<RatingBean> getRatingsByUserId(String userId) throws InterruptedException, ExecutionException;

    String addRatingsByUserId(RatingBean ratingBean, String userId) throws InterruptedException, ExecutionException;


    String insertRatingByRid(String requestId, RatingBean ratingBean) throws ExecutionException, InterruptedException;
}