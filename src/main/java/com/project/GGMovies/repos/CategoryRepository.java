/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.models.Category;
import com.project.GGMovies.models.Film;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author odi
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
     @Query("SELECT new com.project.GGMovies.dtos.CategoryDto(c.categoryId, c.name) from Category c join c.filmSet f where f.filmId =?1")
    public List<CategoryDto> getCategoryByMovieId(Integer id);
    
}
