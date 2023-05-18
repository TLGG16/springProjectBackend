package bsuir.course.project.Controller;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.Comment;
import bsuir.course.project.Interfaces.AdvertService;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Interfaces.CommentService;
import bsuir.course.project.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment/create")
    public HttpStatus commentCreate(@RequestBody Comment comment){
        System.out.println("Созданно comment");
        commentService.createComment(comment);
        return HttpStatus.ACCEPTED;
    }


    @GetMapping("/commentmenu")
    public ResponseEntity<List<Comment>> commentGet(){
        System.out.println("Получен get запрос для comment " + LocalDateTime.now());
        return new ResponseEntity<>( commentService.getAllComments(), HttpStatus.OK);
    }
    @GetMapping("/comment/{id}")
    public ResponseEntity<Comment> commentGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для advert " + LocalDateTime.now());
        return new ResponseEntity<>( commentService.getCommentById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/commentdelete/{id}")
    public HttpStatus commentDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для advert для id "+ id);
        commentService.deleteCommentById(id);
        return HttpStatus.OK;
    }
    @GetMapping("/commentupdate/{id}")
    public ResponseEntity<Comment> commentUpdateGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для advert с id " +id);
        return new ResponseEntity<>( commentService.getCommentById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/commentupdate/{id}")
    public HttpStatus commentUpdatePut(@RequestBody Comment comment, @PathVariable Integer id){
        System.out.println("Получен post запрос для advert с id" +id);
        comment.setComment_id(id);
        commentService.updateComment(comment);
        return HttpStatus.ACCEPTED;
    }



}
