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

@Entity
@Table(name = "user_list")
@NamedQueries({
    @NamedQuery(name = "UserList.findAll", query = "SELECT u FROM UserList u"),
    @NamedQuery(name = "UserList.findByUserId", query = "SELECT u FROM UserList u WHERE u.userListPK.userId = :userId"),
    @NamedQuery(name = "UserList.findByFilmId", query = "SELECT u FROM UserList u WHERE u.userListPK.filmId = :filmId")})
public class UserList implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserListPK userListPK;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Film film;
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private User user;

    public UserList() {
    }

    public UserList(UserListPK userListPK) {
        this.userListPK = userListPK;
    }

    public UserList(int userId, int filmId) {
        this.userListPK = new UserListPK(userId, filmId);
    }

    public UserListPK getUserListPK() {
        return userListPK;
    }

    public void setUserListPK(UserListPK userListPK) {
        this.userListPK = userListPK;
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
        hash += (userListPK != null ? userListPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserList)) {
            return false;
        }
        UserList other = (UserList) object;
        if ((this.userListPK == null && other.userListPK != null) || (this.userListPK != null && !this.userListPK.equals(other.userListPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.GGMovies.models.UserList[ userListPK=" + userListPK + " ]";
    }
    
}
