
package com.project.GGMovies.controllers;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.services.ICategoryService;
import com.project.GGMovies.services.IFilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    
    @Autowired 
    IFilmService iFilmService;
    
    @Autowired
    ICategoryService iCategoryService;
    
    @GetMapping("/movies")
    public ResponseEntity<List<FilmDto>>getAllMovies(){
        return  ResponseEntity.ok().body(iFilmService.getAllMovies());
    }
    @GetMapping("/getRandomMovie")
    public ResponseEntity<FilmDto>getRandomMovie(){
        FilmDto randomMovie = iFilmService.getRandomMovie();
        return  ResponseEntity.ok().body(randomMovie);
    }
    
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(iCategoryService.getAllCategories());
    }
    
    @GetMapping("/movies/{id}")

    public ResponseEntity<List<FilmDto>>getAllMoviesByCategoryId(@PathVariable("id") Integer id){
        return  ResponseEntity.ok().body(iFilmService.getAllMoviesByCategoryId(id));
    }
    
    @GetMapping("/{user_id}")
    public ResponseEntity<List<FilmDto>>getUserListByUserId(@PathVariable("user_id") Integer id){   
        return  ResponseEntity.ok().body(iFilmService.getUserListByUserId(id));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<FilmDto>>getMoviesByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok().body(iFilmService.getMoviesByTitle(title));
    }
    
    @GetMapping("/search/language/{language_id}")
    public ResponseEntity<List<FilmDto>>getMoviesByLanguageId(@PathVariable("language_id") Integer id){
         return ResponseEntity.ok().body(iFilmService.getMoviesByLanguageId(id));
    }
    
    @GetMapping("/getCategory/{category_name}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable("category_name") String name) {
        return ResponseEntity.ok().body(iCategoryService.getCategoryByName(name));
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
    
    @GetMapping("/topRated/{category_id}")
    public ResponseEntity<List<FilmDto>> topRatedMoviesCategoryId(@PathVariable(value = "category_id") Integer id) {
        return ResponseEntity.ok().body(iFilmService.getTopRatedMoviesByCategoryId(id));
    }
    
    @GetMapping("/mostPopular/{category_id}")
    public ResponseEntity<List<FilmDto>> mostPopularMoviesByCategoryId(@PathVariable(value = "category_id") Integer id) {

        return ResponseEntity.ok().body(iFilmService.getMostPopularMoviesByCategoryId(id));
    }

    @GetMapping("/mostRecent/{category_id}")
    public ResponseEntity<List<FilmDto>> mostRecentMoviesByCategoryId(@PathVariable(value = "category_id") Integer id) {

        return ResponseEntity.ok().body(iFilmService.getMostPopularMoviesByCategoryId(id));
    }
    
}
   

