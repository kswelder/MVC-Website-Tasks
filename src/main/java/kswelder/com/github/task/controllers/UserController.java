package kswelder.com.github.task.controllers;

import kswelder.com.github.task.dto.UserDTO;
import kswelder.com.github.task.models.User;
import kswelder.com.github.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/list/all")
    public ResponseEntity<List<UserDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAllUsers());
    }
    @GetMapping("/find/id/{id}")
    public ResponseEntity<User> findUserId(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getUserById(id));
    }
    @GetMapping("/find/username/{username}")
    public ResponseEntity<User> findUserUsername(@PathVariable("username") String username) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getUserByUsername(username));
    }
    @GetMapping("/find/email/{email}")
    public ResponseEntity<User> findUserEmail(@PathVariable("email") String email) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getUserByEmail(email));
    }
    @PostMapping("/save")
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        service.saveUser(user);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        service.updateUser(id, user);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        service.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
