package com.fundamentosplatzi.springboot.fundamentos.controller;


import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    //create , get , delete ,update
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    @GetMapping("/")
    List<User> get(){
    return getUser.getAll();
    }

    /*

odo: Ejemplo con responseEntity

//    @PostMapping("/users")
//    ResponseEntity<User> newUserResponseEntity(@RequestBody User newUser) {
//        return new ResponseEntity<>(userRepository.save(newUser), HttpStatus.CREATED);
//    }

    @GetMapping("/{id}")
    User getOne(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


//    @GetMapping("/users/{id}")
//    ResponseEntity<User> getOne(@PathVariable Long id) {
//        if (userRepository.existsById(id)) {
//            return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//    }

    @PutMapping("/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setBirthDate(newUser.getBirthDate());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }


//    @PutMapping("/users/{id}")
//    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id) {
//        if (userRepository.existsById(id)) {
//            return new ResponseEntity(userRepository.findById(id)
//                    .map(user -> {
//                        user.setEmail(newUser.getEmail());
//                        user.setBirthDate(newUser.getBirthDate());
//                        user.setName(newUser.getName());
//                        return userRepository.save(user);
//                    }).get(), HttpStatus.OK);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        userRepository.deleteById(id);
    }


//    @DeleteMapping("/users/{id}")
//    ResponseEntity deleteUser(@PathVariable Long id) {
//        boolean existsUserById = userRepository.existsById(id);
//        if (existsUserById) {
//            userRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
//
//    }

    @GetMapping("/pageable")
    public List<User> getUserPageable(@RequestParam int page, @RequestParam int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }


    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }


*/

}
