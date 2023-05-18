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
    public HttpStatus advertCreate(@RequestBody Advert advert){
        System.out.println("Созданно объявление");
        advertService.createAdvert(advert);
        return HttpStatus.ACCEPTED;
    }


    @GetMapping("/advertmenu")
    public ResponseEntity<List<Advert>> advertGet(){
        System.out.println("Получен get запрос для advert " + LocalDateTime.now());
        return new ResponseEntity<>( advertService.getAllAdverts(), HttpStatus.OK);
    }
    @GetMapping("/advert/{id}")
    public ResponseEntity<Advert> advertGetById(@PathVariable Integer id){
        System.out.println("Получен get запрос для advert " + LocalDateTime.now());
        return new ResponseEntity<>( advertService.getAdvertById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/advertdelete/{id}")
    public HttpStatus advertDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для advert для id "+ id);
        advertService.deleteAdvertById(id);
        return HttpStatus.OK;
    }
    @GetMapping("/advertupdate/{id}")
    public ResponseEntity<Advert> advertUpdateGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для advert с id " +id);
        return new ResponseEntity<>( advertService.getAdvertById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/advertupdate/{id}")
    public HttpStatus advertUpdatePut(@RequestBody Advert advert, @PathVariable Integer id){
        System.out.println("Получен post запрос для advert с id" +id);
        advert.setAdvert_id(id);
        advertService.updateAdvert(advert);
        return HttpStatus.ACCEPTED;
    }



}
