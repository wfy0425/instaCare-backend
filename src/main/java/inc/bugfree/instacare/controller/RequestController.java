package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.RequestBean;
import inc.bugfree.instacare.bean.ResponseBean;
import inc.bugfree.instacare.bean.UserBean;
import inc.bugfree.instacare.dao.UserDao;
import inc.bugfree.instacare.service.RequestService;
import inc.bugfree.instacare.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/request")
public class RequestController {


    private RequestService requestService;

    @Autowired
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/{id}")
    public void saveRequest(@RequestBody RequestBean requestBean, @PathVariable String id){
        requestService.saveRequest(requestBean, id);
    }

    @GetMapping("/{id}")
    public List<RequestBean> getRequestByUid(@PathVariable String id) throws ExecutionException, InterruptedException {
        return requestService.getRequestsByUid(id);
    }

    @PostMapping("/save")
    public void saveRequestToPlazza(@RequestBody RequestBean requestBean){
        requestService.saveRequestToPlazza(requestBean);
    }

}
