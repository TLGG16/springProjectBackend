package bsuir.course.project.Controller;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DiscussionController {
    @Autowired
    DiscussionService discussionService;
    @Autowired
    CarService carService;

    @Autowired
    DiscussionCommentService discussionCommentService;

    @PostMapping("/discussion/create")
    public HttpStatus discussionCreate(@RequestBody Discussion discussion){
        System.out.println("Созданно discussion");
        discussionService.createDiscussion(discussion);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/discussionmenu")
    public ResponseEntity<List<Discussion>> discussionGet(){
        System.out.println("Получен get запрос для discussion " + LocalDateTime.now());
        return new ResponseEntity<>( discussionService.getAllDiscussions(), HttpStatus.OK);
    }
    @GetMapping("/discussion/{id}")
    public ResponseEntity<List<DiscussionComment>> discussionComsGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для discussion " + LocalDateTime.now());
        return new ResponseEntity<>( discussionCommentService.getDiscussionCommentsByDiscussionId(id), HttpStatus.OK);
    }
    @GetMapping("/discussionget/{id}")
    public ResponseEntity<Discussion> discussionGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для discussion " + LocalDateTime.now());
        return new ResponseEntity<>( discussionService.getDiscussionById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/discussiondelete/{id}")
    public HttpStatus discussionDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для discussion для id "+ id);
        discussionService.deleteDiscussionById(id);
        return HttpStatus.OK;
    }
    @GetMapping("/discussionupdate/{id}")
    public ResponseEntity<Discussion> discussionUpdateGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для discussion с id " +id);
        return new ResponseEntity<>( discussionService.getDiscussionById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/discussionupdate/{id}")
    public HttpStatus discussionUpdatePut(@RequestBody Discussion discussion, @PathVariable Integer id){
        System.out.println("Получен post запрос для discussion с id" +id);
        discussion.setDiscussion_id(id);
        discussionService.updateDiscussion(discussion);
        return HttpStatus.ACCEPTED;
    }


}