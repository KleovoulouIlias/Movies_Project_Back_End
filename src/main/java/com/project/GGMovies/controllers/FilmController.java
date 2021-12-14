
package com.project.GGMovies.controllers;

import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.services.IFilmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {
    
    @Autowired 
    IFilmService iFilmService;
    
    @GetMapping("/movies")
    public ResponseEntity<List<FilmDto>>getAllMovies(){
    return  ResponseEntity.ok().body(iFilmService.getAllMovies());
    }
    
    @GetMapping("/movies/{id}")
    public ResponseEntity<List<FilmDto>>getAllMoviesByCategoryId(@PathVariable("id") Integer id){
    return  ResponseEntity.ok().body(iFilmService.getAllMoviesByCategoryId(id));
    }
    
    @GetMapping("/{user_id}")
    public ResponseEntity<List<FilmDto>>getUserListByUserId(@PathVariable("user_id") Integer id){   
    return  ResponseEntity.ok().body(iFilmService.getUserListByUserId(id));
    }
}
