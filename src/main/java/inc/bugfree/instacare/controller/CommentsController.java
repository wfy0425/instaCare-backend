package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.bean.ResponseBean;
import inc.bugfree.instacare.dao.CommentsDao;
import inc.bugfree.instacare.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentsService commentsService = null;

    @Autowired
    public void setService(CommentsService commentsService) {this.commentsService=commentsService;}

    @GetMapping("/{requestId}")
    @ResponseBody
    public ResponseBean getCommentsByRequestId(@PathVariable String requestId) throws Exception {
        List<CommentsBean> commentsBeans = commentsService.getCommentsByRequestId(requestId);
        return new ResponseBean(200, "OK", commentsBeans);
    }

    @PostMapping("/{requestId}")
    @ResponseBody
    public ResponseBean updateCommentByRequestId(@PathVariable String requestId, @RequestBody CommentsBean commentsBean) throws Exception {
        String ans = commentsService.updateCommentByRequestId(requestId, commentsBean);
        return new ResponseBean(200, "OK", ans);
    }
}
