/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.GGMovies.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.GGMovies.dtos.FilmDto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author PcStratos
 */
@Entity
@Table(name = "film")
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findByFilmId", query = "SELECT f FROM Film f WHERE f.filmId = :filmId"),
    @NamedQuery(name = "Film.findByTitle", query = "SELECT f FROM Film f WHERE f.title = :title"),
    @NamedQuery(name = "Film.findByReleaseDate", query = "SELECT f FROM Film f WHERE f.releaseDate = :releaseDate"),
    @NamedQuery(name = "Film.findByLength", query = "SELECT f FROM Film f WHERE f.length = :length"),
    @NamedQuery(name = "Film.findByRating", query = "SELECT f FROM Film f WHERE f.rating = :rating"),
    @NamedQuery(name = "Film.findByBackgorundUrl", query = "SELECT f FROM Film f WHERE f.backgorundUrl = :backgorundUrl"),
    @NamedQuery(name = "Film.findByPosterUrl", query = "SELECT f FROM Film f WHERE f.posterUrl = :posterUrl"),
    @NamedQuery(name = "Film.findByPopularity", query = "SELECT f FROM Film f WHERE f.popularity = :popularity"),
    @NamedQuery(name = "Film.findByAdultOnly", query = "SELECT f FROM Film f WHERE f.adultOnly = :adultOnly")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "film_id")
    private Integer filmId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name = "length")
    private Short length;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "rating")
    private BigDecimal rating;
    @Basic(optional = false)
    @Column(name = "background_url")
    private String backgorundUrl;
    @Basic(optional = false)
    @Column(name = "poster_url")
    private String posterUrl;
    @Basic(optional = false)
    @Column(name = "popularity")
    private BigDecimal popularity;
    @Basic(optional = false)
    @Column(name = "adult_only")
    private boolean adultOnly;
    @ManyToMany(mappedBy = "filmSet")
    @JsonManagedReference
    private Set<Category> categorySet;
    @JoinColumns({
        @JoinColumn(name = "language_id", referencedColumnName = "language_id")})
    @ManyToOne(optional = false)
    @JsonBackReference
    private Language language;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "film")
    private Set<UserList> userListSet;

    public Film() {
    }

    public Film(Integer filmId) {
        this.filmId = filmId;
    }

  public Film(FilmDto film){
        this.filmId = film.getId();
        this.title = film.getFilmTitle();
        this.description = film.getFilmDescription();
        this.releaseDate = film.getFilmReleaseDate();
        this.rating = film.getFilmRating();
        this.backgorundUrl = film.getFilmBackgorundUrl();
        this.posterUrl = film.getFilmPosterUrl();
        this.popularity = film.getFilmPopularity();
        this.adultOnly = film.isFilmAdultOnly();
        //this.categorySet = film.getCategories();
    }    
    
    public Film(Integer filmId, String title, String description, Date releaseDate, BigDecimal rating, String backgorundUrl, String posterUrl, BigDecimal popularity, boolean adultOnly) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.backgorundUrl = backgorundUrl;
        this.posterUrl = posterUrl;
        this.popularity = popularity;
        this.adultOnly = adultOnly;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getBackgorundUrl() {
        return backgorundUrl;
    }

    public void setBackgorundUrl(String backgorundUrl) {
        this.backgorundUrl = backgorundUrl;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public BigDecimal getPopularity() {
        return popularity;
    }

    public void setPopularity(BigDecimal popularity) {
        this.popularity = popularity;
    }

    public boolean getAdultOnly() {
        return adultOnly;
    }

    public void setAdultOnly(boolean adultOnly) {
        this.adultOnly = adultOnly;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<UserList> getUserListSet() {
        return userListSet;
    }

    public void setUserListSet(Set<UserList> userListSet) {
        this.userListSet = userListSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmId != null ? filmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmId == null && other.filmId != null) || (this.filmId != null && !this.filmId.equals(other.filmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.GGMovies.models.Film[ filmId=" + filmId + " ]";
    }
    
}
