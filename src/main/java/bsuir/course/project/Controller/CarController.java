package bsuir.course.project.Controller;


import bsuir.course.project.Entity.Car;
import bsuir.course.project.Entity.User;
import bsuir.course.project.Interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/carmenu")
    public ResponseEntity<List<Car>> CarGet(){
        System.out.println("Получен get запрос для машин " + LocalDateTime.now());
        return new ResponseEntity<>( carService.getAllCars(), HttpStatus.OK);
    }

    @DeleteMapping("/cardelete/{id}")
    public HttpStatus carDelete(@PathVariable Integer id){
        System.out.println("Получен delete запрос для машины для id "+ id);
        carService.deleteCarById(id);
        return HttpStatus.OK;
    }
    @GetMapping("/carupdate/{id}")
    public ResponseEntity<Car> carUpdateGet(@PathVariable Integer id){
        System.out.println("Получен get запрос для машины с id " +id);
        return new ResponseEntity<>( carService.getCarById(id).get(), HttpStatus.OK);
    }
    @PostMapping("/carupdate/{id}")
    public HttpStatus carUpdatePut(@RequestBody Car car, @PathVariable Integer id){
        System.out.println("Получен post запрос для машины с id" +id);
        car.setCar_id(id);
        carService.updateCar(car);
        return HttpStatus.ACCEPTED;
    }


    @PostMapping("/carcreate")
    public HttpStatus CarCreate(@RequestBody Car car){
        System.out.println("Принята машина");
        carService.createCar(car);
        return HttpStatus.ACCEPTED;
    }
}
