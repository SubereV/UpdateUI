package Entity;

import java.util.Date;

public class User {

    private int userId, permission;
    private String name, email, password, description;
    private Date dateModify;

    public User() {
    }

    public User(int userId, int permission, String name, String email, String password, Date dateModify, String description) {
        this.userId = userId;
        this.permission = permission;
        this.name = name;
        this.email = email;
        this.password = password;
        this.description = description;
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
