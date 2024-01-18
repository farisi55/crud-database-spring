package com.example.latihandatabase.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "tbl_user")

public class User implements Serializable {

    private static final long  serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message =  "Description is require")
    @Column(name = "full_name", length = 500)
    private String fullName;

    @NotEmpty(message =  "Description is require")
    @Column(name = "user_name", length = 100)
    private String userName;

    @NotEmpty(message =  "Description is require")
    @Column(name = "mail", length = 100)
    private String mail;

    @NotEmpty(message =  "Description is require")
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "last_login")
    private Date lastLogin;

   private int activeToken;

   @Column(name = "created_by", length = 100)
   private String createdBy;

    @Column(name = "update_by", length = 100)
    private String updateBy;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "crated_at")
    private Date cratedAt;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "is_shown")
    private boolean shown;

    public User(){}

    public User(Long id, String fullName, String userName, String mail, String password, Date lastLogin, int activeToken, String createdBy, String updateBy, Date cratedAt, Date deletedAt, boolean shown) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.lastLogin = lastLogin;
        this.activeToken = activeToken;
        this.createdBy = createdBy;
        this.updateBy = updateBy;
        this.cratedAt = cratedAt;
        this.deletedAt = deletedAt;
        this.shown = shown;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getActiveToken() {
        return activeToken;
    }

    public void setActiveToken(int activeToken) {
        this.activeToken = activeToken;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(Date cratedAt) {
        this.cratedAt = cratedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }
}
