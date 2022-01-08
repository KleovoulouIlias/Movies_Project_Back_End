package com.project.GGMovies.dtos;

import com.project.GGMovies.models.Transaction;
import com.project.GGMovies.models.User;
import java.util.Date;
import java.util.Set;

public class UserDto {
    
    private Integer id;
    private String userEmail;
    private String userPassword;
    private Date dateCreated;
    private Date dateExpires;
    private boolean isLocked;
    private boolean isEnabled;
    private Integer roleId;
    private Set<Transaction> transactions;

    public UserDto() {
    }
    
    public UserDto(User user) {
        this.id = user.getUserId();
        this.userEmail = user.getEmail();
    }
            
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

    public UserDto(Integer id, String userEmail, String userPassword, Date dateCreated, Date dateExpires, boolean isLocked, boolean isEnabled, Integer roleId, Set<Transaction> transactions) {
        this.id = id;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.dateCreated = dateCreated;
        this.dateExpires = dateExpires;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
        this.roleId = roleId;
        this.transactions = transactions;
    }

    public UserDto(Integer id){
        this.id = id;
    }

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
}
