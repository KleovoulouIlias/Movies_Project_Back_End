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
    FilmRepository filmRepository;

    @Override
    public List<FilmDto> getAllMovies() {
        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.findAll();
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }

    @Override
    public List<FilmDto> getAllMoviesByCategoryId(Integer id) {

        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.getMoviesByCategoryId(id);
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }

    @Override
    public List<FilmDto> getUserListByUserId(Integer id) {

        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.getUserListByUserId(id);
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }

    @Override
    public List<FilmDto> getMoviesByTitle(String title) {

        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.getMoviesByTitle(title);
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }


    @Override
     public List<FilmDto> getMoviesByLanguageId(Integer id){
         
        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.getMoviesByLanguageId(id);
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }

}
