/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ContactDAO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Admin
 */
public class ContactAction extends ActionSupport {
    String message, name, email, phone; 

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public ContactAction() {
    }
    
    public String execute() throws Exception {
        ContactDAO dao = new ContactDAO(); 
        int rc =dao.addNewContact(name, email, phone, message); 
        if (rc>0) {
            return SUCCESS; 
        }
        return INPUT; 
    }
    
}
