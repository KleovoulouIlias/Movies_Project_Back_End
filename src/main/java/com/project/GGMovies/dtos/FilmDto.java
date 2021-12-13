/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.GGMovies.dtos;

import com.project.GGMovies.models.Category;
import com.project.GGMovies.models.Film;
import com.project.GGMovies.models.Language;
import com.project.GGMovies.models.UserList;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Home
 */
public class FilmDto {

    private Integer id;
    private String filmTitle;
    private String filmDescription;
    private Date filmReleaseDate;
    private Short filmLength;
    private BigDecimal filmRating;
    private String filmBackgorundUrl;
    private String filmPosterUrl;
    private BigDecimal filmPopularity;
    private boolean filmAdultOnly;

    public FilmDto() {
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
    }

}
