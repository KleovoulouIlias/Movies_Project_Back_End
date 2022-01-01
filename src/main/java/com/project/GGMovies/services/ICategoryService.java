/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.models.Category;
import java.util.List;

/**
 *
 * @author odi
 */

public interface ICategoryService {
    
    public List<CategoryDto> getCategoryByMovieId(Integer id);
    public List<CategoryDto> getAllCategories();
    public Category getCategoryById(Integer id);
    public CategoryDto getCategoryByName(String categoryName);
    
}
