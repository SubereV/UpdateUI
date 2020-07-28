/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import Entity.User;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class AdminAction extends ActionSupport {

    private ArrayList<User> userList;
    private UserDAO dao;
    private String name, email, password, description, avatar, address, fbLink, major;
    private int permission, userId;

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public String editUser() throws Exception {
        if (dao.updateUser(userId, name, email, permission, password, description, avatar, fbLink, address, major) > 0) {
            return SUCCESS;
        }
        return NONE;
    }

    public String deleteUser() throws Exception {
        int rc = dao.deleteUser(userId);
        if (rc > 0) {
            return SUCCESS;
        }
        return NONE;
    }

    public AdminAction() {
        dao = new UserDAO();
    }

    public String loadContent() throws Exception {
        userId = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
        return SUCCESS;
    }

    @Override
    public String execute() {
        try {
            userList = dao.getAllUsers();
            return SUCCESS;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ERROR;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public UserDAO getDao() {
        return dao;
    }

    public void setDao(UserDAO dao) {
        this.dao = dao;
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

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
