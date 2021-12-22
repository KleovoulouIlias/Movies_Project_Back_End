/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.dtos;

import com.project.GGMovies.models.Category;

/**
 *
 * @author odi
 */
public class CategoryDto {
    
    private Integer id;
    private String categoryName;

    public CategoryDto() {
    }
    
    public CategoryDto(Category category) {
        this.id = category.getCategoryId();
        this.categoryName = category.getName();
    }

    public CategoryDto(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
}
