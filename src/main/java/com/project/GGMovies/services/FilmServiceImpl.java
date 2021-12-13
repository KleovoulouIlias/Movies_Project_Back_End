
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.models.Film;
import com.project.GGMovies.repos.FilmRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements IFilmService {
    
    
    @Autowired 
    FilmRepository  filmRepository; 
    
    public List<FilmDto> getAllMovies(){
        
       List<FilmDto> result = new ArrayList(); 
       List<Film> allMoviesFromDb = filmRepository.findAll();
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }
    
}
