package bsuir.course.project.Controller;

import bsuir.course.project.Entity.User;
import bsuir.course.project.Interfaces.PersonService;
import bsuir.course.project.Interfaces.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegController {
    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;

    public RegController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<Optional<User>> LoginRequest(@RequestBody User user){
        return new ResponseEntity<>( userService.existsByLoginPassword(user), HttpStatus.OK);
    }
    @PostMapping("/register")
    public HttpStatus RegisterRequest(@RequestBody User user){
        User newUser = new User();
        newUser.setRole("customer");
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        userService.createUser(newUser);
        return HttpStatus.ACCEPTED;
    }


    @GetMapping("/users/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


}
