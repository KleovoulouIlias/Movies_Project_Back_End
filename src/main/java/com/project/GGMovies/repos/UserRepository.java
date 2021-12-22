package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.UserDto;
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

    
    //to do:
    // public List<UserDto> getUsersByRoleId(Integer roleId);
}
