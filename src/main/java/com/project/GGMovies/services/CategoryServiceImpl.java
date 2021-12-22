/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.CategoryDto;
import com.project.GGMovies.repos.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author odi
 */
@Service
public class CategoryServiceImpl implements ICategoryService {
 
    @Autowired
    CategoryRepository categoryRepository;

    
    @Override
    public List<CategoryDto> geCategoryByMovieId(Integer id) {
        return  categoryRepository.geCategoryByMovieId(id);

   
    }
    
}
