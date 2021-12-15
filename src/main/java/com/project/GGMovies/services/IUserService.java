package com.project.GGMovies.services;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.models.User;
import java.util.List;

public interface IUserService {
    
    public List<UserDto> getAllUsers();
    public UserDto checkUserById(String email);
}
