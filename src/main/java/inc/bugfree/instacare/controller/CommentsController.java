package inc.bugfree.instacare.controller;

import inc.bugfree.instacare.bean.CommentsBean;
import inc.bugfree.instacare.bean.ResponseBean;
import inc.bugfree.instacare.dao.CommentsDao;
import inc.bugfree.instacare.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentsService commentsService = null;

    @Autowired
    public void setService(CommentsService commentsService) {this.commentsService=commentsService;}

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseBean getCommentById(@PathVariable String id) throws Exception {
        CommentsBean commentsBean = commentsService.getCommentById(id);
        return new ResponseBean(200, "OK", commentsBean);
    }

    @PostMapping("/{id}")
    @ResponseBody
    public ResponseBean addComments(@PathVariable String id, @RequestBody CommentsBean commentsBean) throws Exception {
        String ans = commentsService.addComments(commentsBean, id);
        return new ResponseBean(200, "OK", ans);
    }
}
