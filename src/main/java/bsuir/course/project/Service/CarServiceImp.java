package bsuir.course.project.Service;

import bsuir.course.project.Entity.Car;
import bsuir.course.project.Interfaces.CarService;
import bsuir.course.project.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void deleteCarById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Integer id) {
        return carRepository.findById(id);
    }
}
