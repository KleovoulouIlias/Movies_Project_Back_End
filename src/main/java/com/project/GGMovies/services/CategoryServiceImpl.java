package com.project.GGMovies.services;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.models.Category;
import com.project.GGMovies.repos.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
 
    @Autowired
    CategoryRepository categoryRepository;

    
    @Override
    public List<CategoryDto> getCategoryByMovieId(Integer id) {
        return  categoryRepository.getCategoryByMovieId(id);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> result = new ArrayList();
        List<Category> categories = categoryRepository.findAll();
        for(Category category : categories){
            result.add(new CategoryDto(category));
        }
        return result;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName) {
        return categoryRepository.getCategoryByName(categoryName);
    }  
}
