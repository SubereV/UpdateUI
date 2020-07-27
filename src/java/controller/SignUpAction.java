/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Admin
 */
public class SignUpAction extends ActionSupport {
    private String name, email, password;

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
    
    
    public SignUpAction() {
    }
    
    public String checkEmail() throws Exception{
        UserDAO dao = new UserDAO(); 
        if (!dao.checkSignUp(email)) {
            return INPUT; 
        }
        dao.addNewUser(name, email, 2, password, null); 
        return SUCCESS; 
    }
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
