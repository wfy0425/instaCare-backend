package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.AddressBean;
import inc.bugfree.instacare.bean.RatingBean;
import inc.bugfree.instacare.bean.ResponseBean;
import inc.bugfree.instacare.service.AddressService;
import inc.bugfree.instacare.service.RatingService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//import inc.bugfree.instacare.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/rating")
public class RatingController {

    private static final Logger LOGGER = LogManager.getLogger(RatingController.class);

    private RatingService ratingService = null;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseBean getRatingsByUserId(@PathVariable String userId) throws Exception {
        List<RatingBean> ans = ratingService.getRatingsByUserId(userId);
        return new ResponseBean(200, "OK", ans);
    }

    @PostMapping("/{requestId}")
    @ResponseBody
    public ResponseBean addRatingsByRequestId(@PathVariable String requestId,@RequestBody RatingBean ratingBean) throws Exception {
        String ans = ratingService.addRatingsByUserId(requestId,ratingBean);
        return new ResponseBean(200, "OK", ans);
    }



}
