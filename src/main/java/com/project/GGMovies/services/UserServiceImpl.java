package com.project.GGMovies.services;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.models.User;
import com.project.GGMovies.repos.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {

        return userRepository.getAllUsers();
    }

    @Override
    public UserDto checkUserById(String email){
        return userRepository.checkUserById(email);
    }
    
    public void insertUser(UserDto newUser){
    
    }
}
