package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.ResponseBean;
//import inc.bugfree.instacare.service.UserService;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

//    private UserService userService = null;
//
//    @Autowired
//    public void setService(UserService userService) {
//        this.userService = userService;
//    }


    @GetMapping("/test")
    public ResponseBean getTest() {
        //use responseBean to warp the response
        return new ResponseBean(200, "OK", null);
//        return null;
    }
}
