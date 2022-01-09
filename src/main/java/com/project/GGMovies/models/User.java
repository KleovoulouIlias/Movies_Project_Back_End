package com.project.GGMovies.models;

import com.project.GGMovies.dtos.UserDto;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByCreated", query = "SELECT u FROM User u WHERE u.created = :created"),
    @NamedQuery(name = "User.findByExpires", query = "SELECT u FROM User u WHERE u.expires = :expires"),
    @NamedQuery(name = "User.findByLocked", query = "SELECT u FROM User u WHERE u.locked = :locked"),
    @NamedQuery(name = "User.findByEnabled", query = "SELECT u FROM User u WHERE u.enabled = :enabled")})
public class User implements Serializable {
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "created", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "expires")
    @Temporal(TemporalType.DATE)
    private Date expires;
    @Basic(optional = false)
    @Column(name = "locked")
    private boolean locked;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserList userList;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Transaction> transactionSet;

    public User() {
    }

    public User(String email, String password, Role roleId, Date expires,boolean locked, boolean enabled) {
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.expires = expires;
        this.locked = locked;
        this.enabled = enabled;
    }
    public User(Integer id,String email, String password, Role roleId, Date expires,boolean locked, boolean enabled) {
        this.userId=id;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.expires = expires;
        this.locked = locked;
        this.enabled = enabled;
    }
    public User(Integer id,String email, Role roleId, Date expires,boolean locked, boolean enabled) {
        this.userId=id;
        this.email = email;
        this.roleId = roleId;
        this.expires = expires;
        this.locked = locked;
        this.enabled = enabled;
    }

    public User(Integer userId) {
        this.userId = userId;
    }
    
    public User(UserDto user){
        this.email = user.getUserEmail();
        this.password = user.getUserPassword();
        this.expires = user.getDateExpires();
        this.locked = user.getIsIsLocked();
        this.enabled = user.getIsIsEnabled();
    }

    public User(Integer userId, String email, String password, Date created, Date expires, boolean locked, boolean enabled) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.created = created;
        this.expires = expires;
        this.locked = locked;
        this.enabled = enabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Set<Transaction> getTransactionSet() {
        return transactionSet;
    }

    public void setTransactionSet(Set<Transaction> transactionSet) {
        this.transactionSet = transactionSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.GGMovies.models.User[ userId=" + userId + " ]";
    }
    
}
