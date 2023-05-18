package bsuir.course.project.Controller;

import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Interfaces.DiscussionCommentService;
import bsuir.course.project.Interfaces.DiscussionService;
import bsuir.course.project.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DiscussionCommentController {
    @Autowired
    DiscussionCommentService discussionCommentService;
    @Autowired
    DiscussionService discussionService;
    @Autowired
    CarService carService;
    @Autowired
    UserService userService;

    @PostMapping("/discussioncomment/create")
    public HttpStatus discussionCommentCreate(@RequestBody DiscussionComment discussionComment){
        System.out.println("Созданно DiscussionComment");
        discussionCommentService.createDiscussionComment(discussionComment);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/discussioncommentmenu")
    public ResponseEntity<List<DiscussionComment>> discussionCommentGet(){
        System.out.println("Получен get запрос для DiscussionComment " + LocalDateTime.now());
        return new ResponseEntity<>( discussionCommentService.getAllDiscussionComments(), HttpStatus.OK);
    }
    @GetMapping("/chartdata")
    public ResponseEntity<Map<String, Integer>> chartData(){
        System.out.println("Получен get запрос для DiscussionComment " + LocalDateTime.now());
        Map<String,Integer> map = new HashMap<>();
        List<DiscussionComment> discussionCommentList = discussionCommentService.getAllDiscussionComments();
        for (DiscussionComment d: discussionCommentList
             ) {
            if (!map.containsKey( d.getDiscussion().getTheme())){
                map.put(d.getDiscussion().getTheme(), 1);
            }
            else {
                map.replace(d.getDiscussion().getTheme(), map.get(d.getDiscussion().getTheme()+1));
            }
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @GetMapping("/discussioncomment/{id}")
    public ResponseEntity<DiscussionComment> discussionCommentGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для DiscussionComment " + LocalDateTime.now());
        return new ResponseEntity<>( discussionCommentService.getDiscussionCommentById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/discussioncommentdelete/{id}")
    public HttpStatus discussionCommentDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для DiscussionComment для id "+ id);
        discussionCommentService.deleteDiscussionCommentById(id);
        return HttpStatus.OK;
    }
    @GetMapping("/discussioncommentupdate/{id}")
    public ResponseEntity<DiscussionComment> discussionCommentUpdateGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для DiscussionComment с id " +id);
        return new ResponseEntity<>( discussionCommentService.getDiscussionCommentById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/discussioncommentupdate/{id}")
    public HttpStatus discussionCommentUpdatePut(@RequestBody DiscussionComment discussionComment, @PathVariable Integer id){
        System.out.println("Получен post запрос для DiscussionComment с id" +id);
        discussionComment.setDiscussion_comment_id(id);
        discussionCommentService.updateDiscussionComment(discussionComment);
        return HttpStatus.ACCEPTED;
    }


}