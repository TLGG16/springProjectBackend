package bsuir.course.project.Controller;


import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Entity.DiscussionComment;
import bsuir.course.project.Entity.Favourite;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Interfaces.DiscussionCommentService;
import bsuir.course.project.Interfaces.DiscussionService;
import bsuir.course.project.Interfaces.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FavouriteController {
    @Autowired
    FavouriteService favouriteService;

    @PostMapping("/favourite/create")
    public HttpStatus favouriteCreate(@RequestBody Favourite favourite){
        System.out.println("Созданно Favourite");
        System.out.println(favourite.getAdvert().getAdvert_id());
        favouriteService.createFavourite(favourite);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/favourite/user{id}")
    public ResponseEntity<List<Favourite>> discussionGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для favourite " + LocalDateTime.now());

        return new ResponseEntity<>( favouriteService.getAllFavourites().stream().filter(favourite ->id.equals( favourite.getUser().getUser_id())).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping("/favourite/{id}")
    public HttpStatus favouriteDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для favourite для id "+ id);
        favouriteService.deleteFavouriteById(id);
        return HttpStatus.OK;
    }



}
