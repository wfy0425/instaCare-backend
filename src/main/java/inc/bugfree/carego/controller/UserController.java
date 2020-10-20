package inc.bugfree.carego.controller;

import inc.bugfree.carego.bean.ResponseBean;
import inc.bugfree.carego.bean.UserBean;
import inc.bugfree.carego.exception.UnauthorizedException;
import inc.bugfree.carego.service.UserService;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    private UserService userService = null;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public ResponseBean getUserInfoByUserId(@PathVariable int id) {
        //use responseBean to warp the response
        //return new ResponseBean(200, "OK", userBean);
        return null;
    }
}
