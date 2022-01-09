package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.dtos.UserStatsDto;
import com.project.GGMovies.models.User;
import java.sql.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u")
    public List<UserDto> getAllUsers();

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId) from User u where u.email=?1")
    public UserDto checkUserById(String email);

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u where u.userId=?1")
    public UserDto getUserById(Integer id);

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u where u.roleId.roleId=?1")
    public List<UserDto> getUsersByRoleId(Integer roleId);

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u where u.roleId.roleId<>?1")
    public List<UserDto> getAllUsersExeptByRoleId(Integer roleId);

    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Month(u.created),Count(u)) from User u where Year(u.created)=Year(curdate()) GROUP BY Month(u.created)")
    public List<UserStatsDto> getUserStats();

    @Query("SELECT u from User u where u.email=?1")
    public User getUserByEmail(String email);

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u where u.email=?1")
    public UserDto getUserDtoByEmail(String email);

    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where Date(u.created)=curdate()")
    public UserStatsDto getThisDayNewUsers();

    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where Date(u.created)=?1")
    public UserStatsDto getThisDayNewUsers(Date date);

    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where date(created)>?1 and date(created)<?2")
    public UserStatsDto getThisMonthNewUsers(Date monthStart, Date monthEnd);

    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where Year(u.created)=Year(curdate())")
    public UserStatsDto getThisYearNewUsers();

    @Query("SELECT new com.project.GGMovies.dtos.UserStatsDto(Count(u)) from User u where Year(u.created)=Year(curdate())-1")
    public UserStatsDto getLastYearNewUsers();

    @Query("SELECT new com.project.GGMovies.dtos.UserDto(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId.roleId) from User u ORDER BY (u.created) desc")
    public List<UserDto> getLastUsers(Pageable pageable);
}
