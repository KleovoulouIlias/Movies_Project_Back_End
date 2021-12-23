package com.project.GGMovies.services;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.models.User;

import java.util.List;

public interface IUserService {
    
    public List<UserDto> getAllUsers();
    public boolean isUsedEmail(String email);
    public void insertUser(UserDto newUser);
    public UserDto getUserById(Integer id);
    public void deleteUser(Integer id);
    public List<UserDto> getUsersByRoleId(Integer id);
}
