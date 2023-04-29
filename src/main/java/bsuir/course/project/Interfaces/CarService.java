package bsuir.course.project.Interfaces;

import bsuir.course.project.Entity.Car;
import bsuir.course.project.Entity.User;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void createCar(Car car );
    void deleteCar(Car car);
    void deleteCarById(Integer id);
    void updateCar(Car car);
    List<Car> getAllCars();
    Optional<Car> getCarById(Integer id);
}
