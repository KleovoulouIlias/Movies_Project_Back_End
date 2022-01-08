package com.project.GGMovies.services;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.models.Category;
import java.util.List;

public interface ICategoryService {
    
    public List<CategoryDto> getCategoryByMovieId(Integer id);
    public List<CategoryDto> getAllCategories();
    public Category getCategoryById(Integer id);
    public CategoryDto getCategoryByName(String categoryName); 
}
