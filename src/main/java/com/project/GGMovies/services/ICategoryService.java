/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.CategoryDto;
import java.util.List;

/**
 *
 * @author odi
 */

public interface ICategoryService {
    
    public List<CategoryDto> geCategoryByMovieId(Integer id);
    
}
