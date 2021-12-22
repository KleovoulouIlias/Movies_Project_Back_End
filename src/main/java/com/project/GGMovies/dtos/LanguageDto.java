/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.dtos;

import com.project.GGMovies.models.Language;

/**
 *
 * @author odi
 */
public class LanguageDto {
    
    private Integer id;
    private String name;

    public LanguageDto() {
    }
    
    public LanguageDto(Language language) {
        this.id = language.getLanguageId();
        this.name = language.getName();
    }

    public LanguageDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
