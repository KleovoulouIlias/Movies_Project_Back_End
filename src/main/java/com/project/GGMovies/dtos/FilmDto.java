/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.GGMovies.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.GGMovies.models.Category;
import com.project.GGMovies.models.Film;
import com.project.GGMovies.models.Language;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;



public class FilmDto {

    private Integer id;
    private String filmTitle;
    private String filmDescription;
    private Date filmReleaseDate;
    private Short filmLength;
    private BigDecimal filmRating;
    private String filmBackgorundUrl;
    //@JsonIgnore
    private List<CategoryDto> categories;
    private String filmPosterUrl;
    private BigDecimal filmPopularity;
    private boolean filmAdultOnly;
    //@JsonIgnore
    private LanguageDto filmLanguage;

    public FilmDto() {
    }
    
    public FilmDto(Integer id){
        this.id = id;
    }

  /*  public FilmDto(Integer id, String filmTitle, String filmDescription, Date filmReleaseDate, Short filmLength, BigDecimal filmRating, String filmBackgorundUrl, String filmPosterUrl, BigDecimal filmPopularity, boolean filmAdultOnly, LanguageDto filmLanguage) {
        this.id = id;
        this.filmTitle = filmTitle;
        this.filmDescription = filmDescription;
        this.filmReleaseDate = filmReleaseDate;
        this.filmLength = filmLength;
        this.filmRating = filmRating;
        this.filmBackgorundUrl = filmBackgorundUrl;
        this.filmPosterUrl = filmPosterUrl;
        this.filmPopularity = filmPopularity;
        this.filmAdultOnly = filmAdultOnly;
        //this.filmLanguage = filmLanguage;
    } */

    public FilmDto(Integer id, String filmTitle, String filmDescription, Date filmReleaseDate, Short filmLength, BigDecimal filmRating, String filmBackgorundUrl, String filmPosterUrl, BigDecimal filmPopularity, boolean filmAdultOnly, List<CategoryDto> categories) {
        this.id = id;
        this.filmTitle = filmTitle;
        this.filmDescription = filmDescription;
        this.filmReleaseDate = filmReleaseDate;
        this.filmLength = filmLength;
        this.filmRating = filmRating;
        this.filmBackgorundUrl = filmBackgorundUrl;
        this.filmPosterUrl = filmPosterUrl;
        this.filmPopularity = filmPopularity;
        this.filmAdultOnly = filmAdultOnly;
        this.categories = categories;
    }
    public FilmDto(Integer id, String filmTitle, String filmDescription, Date filmReleaseDate, Short filmLength, BigDecimal filmRating, String filmBackgorundUrl, String filmPosterUrl, BigDecimal filmPopularity, boolean filmAdultOnly) {
        this.id = id;
        this.filmTitle = filmTitle;
        this.filmDescription = filmDescription;
        this.filmReleaseDate = filmReleaseDate;
        this.filmLength = filmLength;
        this.filmRating = filmRating;
        this.filmBackgorundUrl = filmBackgorundUrl;
        this.filmPosterUrl = filmPosterUrl;
        this.filmPopularity = filmPopularity;
        this.filmAdultOnly = filmAdultOnly;
        
    }
    
    public FilmDto(Film film){
        this.id = film.getFilmId();
        this.filmTitle = film.getTitle();
        this.filmDescription = film.getDescription();
        this.filmReleaseDate = film.getReleaseDate();
        this.filmLength = film.getLength();
        this.filmRating = film.getRating();
        this.filmBackgorundUrl = film.getBackgorundUrl();
        this.filmPosterUrl = film.getPosterUrl();
        this.filmPopularity = film.getPopularity();
        this.filmAdultOnly = film.getAdultOnly();
        //this.categoryIds = film.getCategorySet();
        //this.filmLanguage = film.getLanguage();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public Date getFilmReleaseDate() {
        return filmReleaseDate;
    }

    public void setFilmReleaseDate(Date filmReleaseDate) {
        this.filmReleaseDate = filmReleaseDate;
    }

    public Short getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(Short filmLength) {
        this.filmLength = filmLength;
    }

    public BigDecimal getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(BigDecimal filmRating) {
        this.filmRating = filmRating;
    }

    public String getFilmBackgorundUrl() {
        return filmBackgorundUrl;
    }

    public void setFilmBackgorundUrl(String filmBackgorundUrl) {
        this.filmBackgorundUrl = filmBackgorundUrl;
    }

    public String getFilmPosterUrl() {
        return filmPosterUrl;
    }

    public void setFilmPosterUrl(String filmPosterUrl) {
        this.filmPosterUrl = filmPosterUrl;
    }

    public BigDecimal getFilmPopularity() {
        return filmPopularity;
    }

    public void setFilmPopularity(BigDecimal filmPopularity) {
        this.filmPopularity = filmPopularity;
    }

    public boolean isFilmAdultOnly() {
        return filmAdultOnly;
    }

    public void setFilmAdultOnly(boolean filmAdultOnly) {
        this.filmAdultOnly = filmAdultOnly;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    } 

    public LanguageDto getFilmLanguage() {
        return filmLanguage;
    }

    public void setFilmLanguage(LanguageDto filmLanguage) {
        this.filmLanguage = filmLanguage;
    }

   

   
    
}
