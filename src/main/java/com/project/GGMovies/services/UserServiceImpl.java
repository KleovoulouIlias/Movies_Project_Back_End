package com.project.GGMovies.services;

import com.project.GGMovies.dtos.SalesStatsDto;
import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.dtos.UserStatsDto;
import com.project.GGMovies.models.Role;
import com.project.GGMovies.models.User;
import com.project.GGMovies.repos.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IRoleService IRoleService;

    @Override
    public List<UserDto> getAllUsers() {

        return userRepository.getAllUsers();
    }

    @Override
    public boolean isUsedEmail(String email) {
        if (userRepository.checkUserById(email) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insertUser(UserDto newUser) {
        User userToInsert = new User(newUser);
        userToInsert.setRoleId(new Role(IRoleService.getRoleById(newUser.getRole())));
        userRepository.saveAndFlush(userToInsert);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
    
    @Override
    public void deleteUser(Integer id) {
      userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getUsersByRoleId(Integer id) {
        return userRepository.getUsersByRoleId(id);
    }


    @Override
    public List<UserStatsDto> getUserStats() {
       return userRepository.getUserStats();
    }

    @Override
    public UserStatsDto getThisMonthNewUsers() {
        return userRepository.getThisMonthNewUsers();
    }

    @Override
    public UserStatsDto getThisYearNewUsers() {
        return userRepository.getThisYearNewUsers();
    }

    @Override
    public UserStatsDto getThisDayNewUsers() {
        return userRepository.getThisDayNewUsers();
    }

   

  

   
   
}
