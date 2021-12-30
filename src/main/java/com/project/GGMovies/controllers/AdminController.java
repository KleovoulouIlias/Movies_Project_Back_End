package com.project.GGMovies.controllers;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.dtos.RoleDto;
import com.project.GGMovies.dtos.TransactionDto;
import com.project.GGMovies.dtos.UserDto;
import com.project.GGMovies.models.Category;
import com.project.GGMovies.models.User;
import com.project.GGMovies.services.ICategoryService;
import com.project.GGMovies.services.IFilmService;
import com.project.GGMovies.services.IRoleService;
import com.project.GGMovies.services.ITransactionService;
import com.project.GGMovies.services.IUserService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    
    @Autowired 
    ITransactionService iTransactionService;

    @GetMapping("/movies")
    public ResponseEntity<List<FilmDto>> getAllMovies() {
        return ResponseEntity.ok().body(iFilmService.getAllMovies());
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(iCategoryService.getAllCategories());
    }

    @PostMapping(value = "/insertMovie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> insertMovie(@RequestBody FilmDto film) {
        if (!iFilmService.filmExists(film.getFilmTitle(), film.getFilmDescription())) {
            iFilmService.insertMovie(film);
            return ResponseEntity.ok().body(film);
        } else {
            return ResponseEntity.badRequest().body(film);
        }
    }
    @PostMapping(value = "/updateMovie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FilmDto> updateMovie(@RequestBody FilmDto film) { 
            iFilmService.insertMovie(film);
            return ResponseEntity.ok().body(film);
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
    
    @GetMapping("/topRatedMovies")
    public ResponseEntity<List<FilmDto>> getTopRatedMovies() {
        return ResponseEntity.ok().body(iFilmService.getTopRatedMovies());
    }
    
    @GetMapping("/mostPopularMovies")
    public ResponseEntity<List<FilmDto>> getMostPopularMovies() {
        return ResponseEntity.ok().body(iFilmService.getMostPopularMovies());
    }
    @GetMapping("/mostRecentMovies")
    public ResponseEntity<List<FilmDto>> getMostRecentMovies() {
        return ResponseEntity.ok().body(iFilmService.getMostRecentMovies());
    }

    @GetMapping("/getCategories/{film_id}")
    public ResponseEntity<List<CategoryDto>> getCategoryByMovieId(@PathVariable(value = "film_id") Integer id) {

        return ResponseEntity.ok().body(iCategoryService.getCategoryByMovieId(id));
    }

    @GetMapping("/mostPopular/{category_id}")
    public ResponseEntity<List<FilmDto>> mostPopularMoviesByCategoryId(@PathVariable(value = "category_id") Integer id) {

        return ResponseEntity.ok().body(iFilmService.getMostPopularMoviesByCategoryId(id));
    }

    @GetMapping("/mostRecent/{category_id}")
    public ResponseEntity<List<FilmDto>> mostRecentMoviesByCategoryId(@PathVariable(value = "category_id") Integer id) {

        return ResponseEntity.ok().body(iFilmService.getMostPopularMoviesByCategoryId(id));
    }

    @GetMapping("/userByRole/{user_id}")
    public ResponseEntity<List<UserDto>> getUsersByRoleId(@PathVariable(value = "user_id") Integer id) {

        return ResponseEntity.ok().body(iUserService.getUsersByRoleId(id));
    }
    
    
    @GetMapping("/getAllTransactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto>  result = iTransactionService.getAllTransactions();
       
        return ResponseEntity.ok().body(result);
    }

}
