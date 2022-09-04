package com.example.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    UserRepository userRepo;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String welcome() {
        return "<html><body>"
                + "<h1>WELCOME</h1>"
                + "</body></html>";
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    @RequestMapping("/getallusers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserEntity getuserbyid(@PathVariable(value = "id") int id) {
        return userRepo.findById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/getbyusername", consumes = { "application/json" })
    public List<UserEntity> getbyusername(@RequestBody UserEntity entity) {
        return userRepo.findByUsername(entity.getUsername());
    }

    @GetMapping("/getuser")
    public List<UserEntity> getuser(@RequestParam(value = "username") String username) {
        return userRepo.findByUsername(username);
    }

    @GetMapping("/getbypassword")
    public List<UserEntity> getbypassword(@RequestParam(value = "password") String password) {

        return userRepo.findByPassword(password);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/checkuser", consumes = { "application/json" })
    public LoginLog checkUserCreds(@RequestBody UserEntity entity) {
        return userService.checkUserData(entity);
    }

}
