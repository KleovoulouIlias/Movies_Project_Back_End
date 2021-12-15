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
    private String userEmail;
    private String userPassword;
    private Date dateCreated;
    private Date dateExpires;
    private boolean isLocked;
    private boolean isEnabled;
    //private List<FilmDto> userList;
    private Integer roleId;
    private Set<Transaction> transactions;

    public UserDto() {
    }
    
    //(u.userId, u.email, u.created, u.expires, u.locked, u.enabled, u.roleId)
            
     public UserDto(Integer id, String userEmail, String password,Date dateCreated, Date dateExpires, boolean isLocked, boolean isEnabled, Integer roleId) {
        this.id = id;
        this.userEmail = userEmail;
        this.userPassword = password;
        this.dateCreated = dateCreated;
        this.dateExpires = dateExpires;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
        this.roleId = roleId;
    }

    public UserDto(String userEmail, String userPassword, Date dateExpires, boolean isLocked, boolean isEnabled, Integer roleId) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.dateExpires = dateExpires;
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
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    public boolean getIsIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean getIsIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
