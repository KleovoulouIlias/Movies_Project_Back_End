/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.GGMovies.models;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Home
 */
@Entity
@Table(name = "list")
@NamedQueries({
    @NamedQuery(name = "List.findAll", query = "SELECT l FROM List l"),
    @NamedQuery(name = "List.findByUserId", query = "SELECT l FROM List l WHERE l.listPK.userId = :userId"),
    @NamedQuery(name = "List.findByFilmId", query = "SELECT l FROM List l WHERE l.listPK.filmId = :filmId")})
public class List implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListPK listPK;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false),
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private User user;

    public List() {
    }

    public List(ListPK listPK) {
        this.listPK = listPK;
    }

    public List(int userId, int filmId) {
        this.listPK = new ListPK(userId, filmId);
    }

    public ListPK getListPK() {
        return listPK;
    }

    public void setListPK(ListPK listPK) {
        this.listPK = listPK;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listPK != null ? listPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof List)) {
            return false;
        }
        List other = (List) object;
        if ((this.listPK == null && other.listPK != null) || (this.listPK != null && !this.listPK.equals(other.listPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.GGMovies.models.List[ listPK=" + listPK + " ]";
    }
    
}
