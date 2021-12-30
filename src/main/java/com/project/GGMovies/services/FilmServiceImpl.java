package com.project.GGMovies.services;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.models.Category;
import com.project.GGMovies.models.Film;
import com.project.GGMovies.models.Language;
import com.project.GGMovies.repos.CategoryRepository;
import com.project.GGMovies.repos.FilmRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements IFilmService {

    @Autowired
    FilmRepository filmRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired 
    ICategoryService iCategoryService;
    
    @Autowired
    ILanguageService iLanguageService; 
    
 

    @Override
    public List<FilmDto> getAllMovies() {
        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.findAll();
        for (Film film : allMoviesFromDb) {
            FilmDto temp = new FilmDto(film);
            temp.setCategories(iCategoryService.getCategoryByMovieId(temp.getId()));
            temp.setFilmLanguage(iLanguageService.getLanguageByMovieId(temp.getId()));
            result.add(temp);
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
    public List<FilmDto> getMoviesByLanguageId(Integer id) {

        List<FilmDto> result = new ArrayList();
        List<Film> allMoviesFromDb = filmRepository.getMoviesByLanguageId(id);
        for (Film film : allMoviesFromDb) {
            result.add(new FilmDto(film));
        }
        return result;
    }

    @Override
    @Transactional
    public void insertMovie(FilmDto newFilm) {
        Film temp = new Film(newFilm);
        temp.setLanguage(new Language(newFilm.getFilmLanguage()));
        System.out.println(temp.getLanguage());
        Set<Category> categorySet = new HashSet();
        filmRepository.save(temp);
        for(CategoryDto categoryDto : newFilm.getCategories()){
            Category tempCategory =iCategoryService.getCategoryById(categoryDto.getId());
            tempCategory.getFilmSet().add(temp);
            categoryRepository.save(tempCategory);
            categorySet.add(tempCategory);
        }
        temp.setCategorySet(categorySet);
        System.out.println(temp.getCategorySet());
    }

    @Override
    public void deleteMovie(Integer id) {
        filmRepository.deleteById(id);
    }

    @Override
    public boolean filmExists(String title, String description) {
        if (filmRepository.checkFilmByTitleAndDescription(title, description) != null) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public List<FilmDto> getTopRatedMoviesByCategoryId(Integer id) {
        List<FilmDto> result = filmRepository.getTopRatedMoviesByCategoryId(id, PageRequest.of(0, 13));
        for (FilmDto film : result) {
            film.setCategories(iCategoryService.getCategoryByMovieId(film.getId()));
            film.setFilmLanguage(iLanguageService.getLanguageByMovieId(film.getId()));
        }
        
        return result;
    }

    @Override
    @Transactional
    public List<FilmDto> getMostPopularMoviesByCategoryId(Integer id) {
        List<FilmDto> result = filmRepository.getMostPopularMoviesByCategoryId(id, PageRequest.of(0, 13));
        for (FilmDto film : result) {
            film.setCategories(iCategoryService.getCategoryByMovieId(film.getId()));
            film.setFilmLanguage(iLanguageService.getLanguageByMovieId(film.getId()));
        }
        
        return result;
    }
    
    @Override
    @Transactional
    public List<FilmDto> getMostRecentMoviesByCategoryId(Integer id) {
        List<FilmDto> result = filmRepository.getMostRecentMoviesByCategoryId(id, PageRequest.of(0, 13));
        for (FilmDto film : result) {
            film.setCategories(iCategoryService.getCategoryByMovieId(film.getId()));
            film.setFilmLanguage(iLanguageService.getLanguageByMovieId(film.getId()));
        }
        
        return result;
    }

    @Override
    public List<FilmDto> getTopRatedMovies() {
        System.out.println("sdfdfd");
        List<FilmDto> result = filmRepository.getTopRatedMovies(PageRequest.of(0, 13));
        for (FilmDto film : result) {
            film.setCategories(iCategoryService.getCategoryByMovieId(film.getId()));
            film.setFilmLanguage(iLanguageService.getLanguageByMovieId(film.getId()));
        }
        
        return result;
    }
    @Override
    public List<FilmDto> getMostPopularMovies() {
        System.out.println("sdfdfd");
        List<FilmDto> result = filmRepository.getMostPopularMovies(PageRequest.of(0, 13));
        for (FilmDto film : result) {
            film.setCategories(iCategoryService.getCategoryByMovieId(film.getId()));
            film.setFilmLanguage(iLanguageService.getLanguageByMovieId(film.getId()));
        }
        
        return result;
    }
    @Override
    public List<FilmDto> getMostRecentMovies() {
        System.out.println("sdfdfd");
        List<FilmDto> result = filmRepository.getMostRecentMovies(PageRequest.of(0, 13));
        for (FilmDto film : result) {
            film.setCategories(iCategoryService.getCategoryByMovieId(film.getId()));
            film.setFilmLanguage(iLanguageService.getLanguageByMovieId(film.getId()));
        }
        
        return result;
    }
    
}
