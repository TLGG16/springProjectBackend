package bsuir.course.project.Controller;

import bsuir.course.project.Entity.Advert;
import bsuir.course.project.Entity.Car;
import bsuir.course.project.Interfaces.AdvertService;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdvertController {
    @Autowired
    AdvertService advertService;
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;

    @PostMapping("/advert/create")
    public HttpStatus AdvertCreate(@RequestBody Advert advert){
        System.out.println("Созданно объявление");
        advertService.createAdvert(advert);
        return HttpStatus.ACCEPTED;

    }


}
