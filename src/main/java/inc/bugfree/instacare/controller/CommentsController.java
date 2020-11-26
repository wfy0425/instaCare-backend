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

    @GetMapping("/{userId}/{commentId}")
    @ResponseBody
    public ResponseBean getCommentByUid(@PathVariable String userId, @PathVariable String commentId) throws Exception {
        List<CommentsBean> commentsBeans = commentsService.getCommentByUid(userId, commentId);
        return new ResponseBean(200, "OK", commentsBeans);
    }

    @PostMapping("/{userId}/{commentId}")
    @ResponseBody
    public ResponseBean updateCommentByUid(@PathVariable String userId, @PathVariable String commentId, @RequestBody CommentsBean commentsBean) throws Exception {
        String ans = commentsService.updateCommentByUid(userId, commentId, commentsBean);
        return new ResponseBean(200, "OK", ans);
    }
}
