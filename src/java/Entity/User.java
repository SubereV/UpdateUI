package Entity;

import java.util.Date;

public class User {

    private int userId, permission;

    private String name, email, password, description, avatar, fbLink, adress, major;
    private Date dateModify;

    public User() {
    }


    public User(int userId, int permission, String name, String email, String password, String description, String avatar, String fbLink, String adress, String major, Date dateModify) {
        this.userId = userId;
        this.permission = permission;
        this.name = name;
        this.email = email;
        this.password = password;
        this.description = description;
        this.avatar = avatar;
        this.fbLink = fbLink;
        this.adress = adress;
        this.major = major;
        this.dateModify = dateModify;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    @Override
    public String toString() {
        return "{" + "userId:" + userId + ", permission:" + permission + ", name:\"" + name + "\", email:\"" + email + "\", password:\"" + password + "\", description:\"" + description + "\", dateModify:\"" + dateModify + "\"}";
    }

}
