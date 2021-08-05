package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log logger = LogFactory.getLog(this.getClass());
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransaccional(List<User> users){
        users.stream()
                .peek(user -> logger.info("user insertado"+user.toString()))
                .forEach(user -> userRepository.save(user));


    }

    public List<User> getAllUser(){
      return userRepository.findAll();
    }




}
