package com.project.GGMovies.services;

import com.project.GGMovies.dtos.LanguageDto;
import com.project.GGMovies.repos.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements ILanguageService {

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public LanguageDto getLanguageByMovieId(Integer id) {

        return languageRepository.getLanguageByMovieId(id);
    }

    @Override
    public LanguageDto getLanguageByName(String name) {
        return languageRepository.getLanguageByName(name);
    }
}
