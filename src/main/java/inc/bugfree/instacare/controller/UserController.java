package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.ResponseBean;
//import inc.bugfree.instacare.service.UserService;


import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.CommentsService;
import inc.bugfree.instacare.service.UserService;
import org.apache.catalina.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {



    private UserService userService = null;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/test")
    public ResponseBean getTest() {
        //use responseBean to warp the response
        return new ResponseBean(200, "OK", null);
//        return null;
    }


    @GetMapping("/getAll")
    @ResponseBody
    public List<UserBean> getAllUser() throws Exception {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseBean getUserById(@PathVariable String id) throws Exception {
        UserBean ans = userService.getUserById(id);
        return new ResponseBean(200, "OK", ans);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseBean addUser(@PathVariable String id, @RequestBody UserBean user ) throws Exception {
        String ans = userService.addUser(id,user);
        return new ResponseBean(200, "OK", ans);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseBean updateUser(@PathVariable String id, @RequestBody Map<String, Object> updateData ) throws Exception {
        String ans = userService.updateUser(id,updateData);
        return new ResponseBean(200, "OK", ans);
    }

}
