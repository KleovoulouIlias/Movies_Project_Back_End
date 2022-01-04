package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.dtos.UserStatsDto;
import com.project.GGMovies.models.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.password, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u")
    public List<UserDto> getAllUsers();

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId) from User u where u.email=?1")
    public UserDto checkUserById(String email);

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.password, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u where u.userId=?1")
    public UserDto getUserById(Integer id);

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.password, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u where u.roleId.roleId=?1")
    public List<UserDto> getUsersByRoleId(Integer roleId);
    
    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Month(u.created),Count(u)) from User u GROUP BY Month(u.created)")
    public List<UserStatsDto> getUserStats();
    
     @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where MONTH(u.created)=MONTH(curdate())")
     public UserStatsDto getThisMonthNewUsers();
    
     @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where YEAR(u.created)=YEAR(curdate())")
     public UserStatsDto getThisYearNewUsers();
    
     @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where DAY(u.created)=DAY(curdate())")
     public UserStatsDto getThisDayNewUsers();
    
    
}
