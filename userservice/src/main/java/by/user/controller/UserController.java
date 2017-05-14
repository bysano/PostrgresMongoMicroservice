package by.user.controller;

import by.user.domain.User;
import by.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/info")
    public String info() {
        return "Hello!";
    }

    @GetMapping("/save")
    public void save() {
        User testUser=new User("test","test");
        userService.addUser(testUser);
    }
//
//    @GetMapping("/test")
//    public void delete() {
//        User newtestUser = new User("xxxxx", "yyyy");
//        userService.addUser(newtestUser);
//        userService.deleteUserByName("xxxxx");
//    }
}
