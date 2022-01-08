package com.project.GGMovies.services;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.dtos.UserStatsDto;

import java.util.List;

public interface IUserService {

    public List<UserDto> getAllUsers();

    public boolean isUsedEmail(String email);

    public void insertUser(UserDto newUser);

    public UserDto getUserById(Integer id);

    public void deleteUser(Integer id);

    public List<UserDto> getUsersByRoleId(Integer id);

    public List<UserStatsDto> getUserStats();

    public List<UserStatsDto> getLastTwoDaysUserStats();

    public List<UserStatsDto> getLastTwoMonthsUserStats();

    public List<UserStatsDto> getLastTwoYearsUserStats();
    public UserDto getUserDtoByEmail(String email);
    public List<UserDto> getAllUsersExeptByRoleId(Integer roleId);

}
