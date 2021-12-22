package com.project.GGMovies.controllers;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.models.Category;
import com.project.GGMovies.services.ICategoryService;
import com.project.GGMovies.services.IFilmService;
import com.project.GGMovies.services.IRoleService;
import com.project.GGMovies.services.IUserService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @Autowired 
    ICategoryService iCategoryService;

    @GetMapping("/movies")
    public ResponseEntity<List<FilmDto>> getAllMovies() {
        return ResponseEntity.ok().body(iFilmService.getAllMovies());
    }

    @PostMapping(value = "/insertMovie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> insertMovie(@RequestBody FilmDto film) {
        System.out.println("dsdsdsds");
        if (!iFilmService.filmExists(film.getFilmTitle(), film.getFilmDescription())) {
            System.out.println("gfgfggfdgd");
            iFilmService.insertMovie(film);
            return ResponseEntity.ok().body(film);
        } else {
            return ResponseEntity.badRequest().body(film);
        }
    }

    @GetMapping("/deleteMovie/{film_id}")
    public void deleteMovie(@PathVariable(value = "film_id") Integer id) {
        iFilmService.deleteMovie(id);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(iUserService.getAllUsers());
    }

    @GetMapping("/test/{role_id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("role_id") Integer id) {
        return ResponseEntity.ok().body(iRoleService.getRoleById(id));
    }

    @GetMapping("/test/name/{name}")
    public ResponseEntity<RoleDto> getRoleByRoleName(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(iRoleService.getRoleByRoleName(name));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("user_id") Integer id) {
        return ResponseEntity.ok().body(iUserService.getUserById(id));
    }

    @PostMapping("/getFormJson")
    public ResponseEntity<UserDto> insertNewUser(@RequestBody UserDto user) {

        if (!iUserService.isUsedEmail(user.getUserEmail())) {
            iUserService.insertUser(user);
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.badRequest().body(user);
        }
    }

    @GetMapping("/deleteUser/{user_id}")
    public void deleteUser(@PathVariable(value = "user_id") Integer id) {
        iUserService.deleteUser(id);
    }
    // public List<UserDto> getUsersByRoleId(Integer roleId);

    @GetMapping("/topRated/{category_id}")
    public ResponseEntity<List<FilmDto>> topRatedMoviesCategoryId(@PathVariable(value = "category_id") Integer id) {
        return ResponseEntity.ok().body(iFilmService.getTopRatedMoviesByCategoryId(id));
    }

    @GetMapping("/getCategoies/{film_id}")
    public ResponseEntity<List<CategoryDto>> geCategoryByMovieId(@PathVariable(value = "film_id") Integer id) {
        
        return ResponseEntity.ok().body(iCategoryService.geCategoryByMovieId(id));

    }

}
