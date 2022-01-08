package com.project.GGMovies.services;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.dtos.UserStatsDto;
import com.project.GGMovies.models.Role;
import com.project.GGMovies.models.User;
import com.project.GGMovies.repos.UserRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserStatsDto> getLastTwoDaysUserStats() {
        LocalDate yesterdayLocalDate = LocalDate.now().minusDays(1);
        Date yesterday = Date.valueOf(yesterdayLocalDate);
        List<UserStatsDto> result = new ArrayList();
        result.add(userRepository.getThisDayNewUsers(yesterday));
        result.add(userRepository.getThisDayNewUsers());
        return result;
    }

    @Override
    public List<UserStatsDto> getLastTwoMonthsUserStats() {
        LocalDate lastStart = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate lastEnd = LocalDate.now().minusMonths(1).withDayOfMonth(lastStart.lengthOfMonth());
        LocalDate thisStart = LocalDate.now().withDayOfMonth(1);
        LocalDate thisEnd = LocalDate.now().withDayOfMonth(thisStart.lengthOfMonth());
        List<UserStatsDto> result = new ArrayList();
        result.add(userRepository.getThisMonthNewUsers(Date.valueOf(lastStart), Date.valueOf(lastEnd)));
        result.add(userRepository.getThisMonthNewUsers(Date.valueOf(thisStart), Date.valueOf(thisEnd)));
        return result;
    }

    @Override
    public List<UserStatsDto> getLastTwoYearsUserStats() {
        List<UserStatsDto> result = new ArrayList();
        result.add(userRepository.getLastYearNewUsers());
        result.add(userRepository.getThisYearNewUsers());
        return result;
    }

}
