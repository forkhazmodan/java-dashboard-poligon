package com.chmax.polygon.service;

import com.chmax.polygon.model.User;
import com.chmax.polygon.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
