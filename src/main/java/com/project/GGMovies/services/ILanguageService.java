/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.services;

import com.project.GGMovies.dtos.LanguageDto;

/**
 *
 * @author odi
 */
public interface ILanguageService {
    public LanguageDto getLanguageByMovieId(Integer id);
    
    public LanguageDto getLanguageByName(String name);
}
