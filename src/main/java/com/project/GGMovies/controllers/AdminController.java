package com.project.GGMovies.controllers;

import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.models.Role;
import com.project.GGMovies.models.User;
import com.project.GGMovies.services.IFilmService;
import com.project.GGMovies.services.IRoleService;
import com.project.GGMovies.services.IUserService;
import com.project.GGMovies.services.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired 
    IFilmService iFilmService;
    
    @Autowired
    IUserService iUserService;
    
    @Autowired
    IRoleService iRoleService;
    
    @GetMapping("/movies")
    public ResponseEntity<List<FilmDto>>getAllMovies(){
        return  ResponseEntity.ok().body(iFilmService.getAllMovies());
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>>getAllUsers(){
        return ResponseEntity.ok().body(iUserService.getAllUsers());
    }
    
    @GetMapping("/test/{role_id}")
    public ResponseEntity<RoleDto>getRoleById(@PathVariable("role_id") Integer id){
        return ResponseEntity.ok().body(iRoleService.getRoleById(id));
    }
    
    @GetMapping("/test/name/{name}")
    public ResponseEntity<RoleDto>getRoleByRoleName(@PathVariable("name") String name){
        return ResponseEntity.ok().body(iRoleService.getRoleByRoleName(name));
    }
    
    @GetMapping("/user/{user_id}")
    public ResponseEntity<UserDto>getUserById(@PathVariable("user_id") Integer id){
        return ResponseEntity.ok().body(iUserService.getUserById(id));
    }
     
    @PostMapping("/getFormJson")
    public ResponseEntity<UserDto> insertNewUser(@RequestBody UserDto user){
        
        if(!iUserService.isUsedEmail(user.getUserEmail())){
            iUserService.insertUser(user);
            return ResponseEntity.ok().body(user);
        }
        else{
            return ResponseEntity.badRequest().body(user);
        }
    }
}
