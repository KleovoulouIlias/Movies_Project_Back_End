package com.project.GGMovies.dtos;

import com.project.GGMovies.models.Role;
import com.project.GGMovies.models.Transaction;
import com.project.GGMovies.models.User;
import com.project.GGMovies.models.UserList;
import com.project.GGMovies.services.IFilmService;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDto {
    
    private Integer id;
    private String UserEmail;
    private String UserPassword;
    private Date DateCreated;
    private Date DateExpires;
    private boolean isLocked;
    private boolean isEnabled;
    //private List<FilmDto> userList;
    private Integer roleId;
    private Set<Transaction> transactions;

    public UserDto() {
    }
    
    //(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId)
            
     public UserDto(Integer id, String UserEmail, String password,Date DateCreated, Date DateExpires, boolean isLocked, boolean isEnabled, Integer roleId) {
        this.id = id;
        this.UserEmail = UserEmail;
        this.UserPassword = password;
        this.DateCreated = DateCreated;
        this.DateExpires = DateExpires;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
        this.roleId = roleId;
    }  

    public UserDto(Integer id){
        this.id = id;
    }

//    public UserDto(Integer id, String UserEmail, String UserPassword, Date DateCreated, Date DateExpires, short isLocked, short isEnabled, String role) {
//        this.id = id;
//        this.UserEmail = UserEmail;
//        this.UserPassword = UserPassword;
//        this.DateCreated = DateCreated;
//        this.DateExpires = DateExpires;
//        this.isLocked = isLocked;
//        this.isEnabled = isEnabled;
//        //this.userList = userList;
//        this.role = role;
//    }
//    @Autowired
//    IFilmService iFilmService;
    
//    public UserDto(User user) {
//        this.id = user.getUserId();
//        this.UserEmail = user.getEmail();
//        this.UserPassword = user.getPassword();
//        this.DateCreated = user.getCreated();
//        this.DateExpires = user.getExpires();
//        this.isLocked = user.getLocked();
//        this.isEnabled = user.getEnabled();
//        //this.userList = iFilmService.getUserListByUserId(this.id);
//        //this.userList = null;
//        this.role = user.getRoleId().getName();
//        this.transactions = user.getTransactionSet();
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date DateCreated) {
        this.DateCreated = DateCreated;
    }

    public Date getDateExpires() {
        return DateExpires;
    }

    public void setDateExpires(Date DateExpires) {
        this.DateExpires = DateExpires;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

//    public List<FilmDto> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<FilmDto> userList) {
//        this.userList = userList;
//    }

    public Integer getRole() {
        return roleId;
    }

    public void setRole(Integer roleId) {
        this.roleId = roleId;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

//    public IFilmService getiFilmService() {
//        return iFilmService;
//    }
//
//    public void setiFilmService(IFilmService iFilmService) {
//        this.iFilmService = iFilmService;
//    }
    
    
}
