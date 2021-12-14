package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.FilmDto;
import com.project.GGMovies.models.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

  
    @Query("select f from Film f join f.categorySet c where c.categoryId=?1")
    public List<Film> getMoviesByCategoryId(Integer id);
    
    @Query("select f from Film f join f.userListSet l where l.user.userId=?1")
    public List<Film> getUserListByUserId(Integer id);
    
    @Query("select f from Film f where f.title like %?1%")
    public List<Film> getMoviesByTitle(String title);
    
    @Query("select f from Film f where f.language.languageId=?1")
    public List<Film> getMoviesByLanguageId(Integer id);
    
}
