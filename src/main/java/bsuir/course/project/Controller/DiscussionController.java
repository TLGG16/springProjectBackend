package bsuir.course.project.Controller;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.Discussion;
import bsuir.course.project.Interfaces.AdvertService;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Interfaces.DiscussionService;
import bsuir.course.project.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DiscussionController {
    @Autowired
    DiscussionService discussionService;
    @Autowired
    CarService carService;

    @PostMapping("/discussion/create")
    public HttpStatus AdvertCreate(@RequestBody Discussion discussion){
        System.out.println("Созданно обсуждение");
        discussionService.createDiscussion(discussion);
        return HttpStatus.ACCEPTED;

    }


}