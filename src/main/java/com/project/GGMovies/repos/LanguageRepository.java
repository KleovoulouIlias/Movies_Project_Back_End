/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.GGMovies.repos;

import com.project.GGMovies.dtos.LanguageDto;
import com.project.GGMovies.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author odi
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {
    
    
    @Query("SELECT new com.project.GGMovies.dtos.LanguageDto(l.languageId, l.name) from Language l join l.filmSet f where f.filmId =?1")
    public LanguageDto getLanguageByMovieId(Integer id);
    
}