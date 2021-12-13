
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.FilmDto;
import java.util.List;


public interface IFilmService {
    
     public List<FilmDto> getAllMovies();
}
