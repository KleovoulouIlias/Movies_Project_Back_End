package com.project.GGMovies.services;

import com.project.GGMovies.dtos.LanguageDto;

public interface ILanguageService {
    public LanguageDto getLanguageByMovieId(Integer id);
    
    public LanguageDto getLanguageByName(String name);
}
