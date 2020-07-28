/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import Entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class EditInforByUser extends ActionSupport {

    private String id, q1_name, email, password, description, avatar, fbLink, address, major;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQ1_name() {
        return q1_name;
    }

    public void setQ1_name(String q1_name) {
        this.q1_name = q1_name;
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

    public EditInforByUser() {
    }

    public String execute() throws Exception {
        id = ServletActionContext.getRequest().getParameter("id");
        UserDAO dao = new UserDAO();
        User user = dao.searchByID(Integer.parseInt(id));
        q1_name = user.getName();
        email = user.getEmail();
        description = user.getDescription();
        password = user.getPassword();
        return SUCCESS;
    }

    public String editInfo() throws Exception {
        UserDAO dao = new UserDAO(); 

        int rc = dao.updateUser(Integer.parseInt(id), q1_name, email, 1, password, description);
        if (rc>0) {
            return SUCCESS; 
        }
        return INPUT; 
    }
}
