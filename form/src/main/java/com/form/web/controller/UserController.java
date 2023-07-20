package com.form.web.controller;

import com.form.domain.User;
import com.form.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAll(){
    return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") int userId) {
    Optional<User> userOptional = userService.getUser(userId);
    if (userOptional.isPresent()) {
      User user = userOptional.get();
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/save")
  public ResponseEntity<User> save (@RequestBody User user){
    //log.info("IN: "+ jsonUtil.toJson(user));
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  }

  @PutMapping("/update")
  public ResponseEntity<User> update (@RequestBody User user){
    //log.info("IN: "+ jsonUtil.toJson(user));
    return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int userId){
    //log.info("IN: " + jsonUtil.toJson(userId));
    if(userService.delete(userId)){
      return new ResponseEntity<>(HttpStatus.OK);
    }else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
