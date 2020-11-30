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
import java.util.Map;
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
    public ResponseBean saveRequest(@RequestBody RequestBean requestBean, @PathVariable String id) throws ExecutionException, InterruptedException {
        return new ResponseBean(200, "OK",requestService.saveRequest(requestBean, id));
    }

    @GetMapping("/{id}")
    public ResponseBean getRequestByUid(@PathVariable String id, @RequestParam(value = "userType") Integer userType) throws ExecutionException, InterruptedException {
        return new ResponseBean(200, "OK",requestService.getRequestsByUid(id, userType));
    }

    @GetMapping("/past/{id}")
    public ResponseBean getPastRequestByUid(@PathVariable String id) throws ExecutionException, InterruptedException {
        return new ResponseBean(200, "OK",requestService.getPastRequestsByUid(id));
    }

    @GetMapping("/all")
    public ResponseBean getAllOnGoingRequest() throws ExecutionException, InterruptedException {
        return new ResponseBean(200, "OK",requestService.getAllOnGoingRequest());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseBean updateRequest(@PathVariable String id, @RequestBody Map<String, Object> updateData ) throws Exception {
        String ans = requestService.updateRequest(id,updateData);
        return new ResponseBean(200, "OK", ans);
    }

    @DeleteMapping("/{id}")
    public ResponseBean deletePastRequest(@PathVariable String id) throws Exception {
        String ans = requestService.deletePastRequest(id);
        return new ResponseBean(200, "OK", ans);
    }

}