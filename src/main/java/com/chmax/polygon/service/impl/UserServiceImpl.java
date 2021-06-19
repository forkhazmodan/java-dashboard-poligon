package com.chmax.polygon.service.impl;

import com.chmax.polygon.model.User;
import com.chmax.polygon.repository.UserRepository;
import com.chmax.polygon.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
