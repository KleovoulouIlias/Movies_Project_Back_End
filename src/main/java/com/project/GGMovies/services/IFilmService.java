package com.project.GGMovies.services;

import com.project.GGMovies.dtos.FilmDto;
import java.util.List;

public interface IFilmService {
    
     public List<FilmDto> getAllMovies();
     public List<FilmDto> getAllMoviesByCategoryId(Integer id);
     public List<FilmDto> getUserListByUserId(Integer id);
     public List<FilmDto> getMoviesByTitle(String title);
     public List<FilmDto> getMoviesByLanguageId(Integer id);
     public boolean filmExists(String title, String description);
     public void insertMovie(FilmDto newFilm);
     public void deleteMovie(Integer id);   
     public List<FilmDto> getTopRatedMoviesByCategoryId(Integer id);
     public List<FilmDto> getMostPopularMoviesByCategoryId(Integer id);
     public List<FilmDto> getMostRecentMoviesByCategoryId(Integer id);
     public List<FilmDto> getTopRatedMovies();
     public List<FilmDto> getMostPopularMovies();
     public List<FilmDto> getMostRecentMovies();
     public FilmDto getRandomMovie();
     public FilmDto getMovieById(Integer id);
}
