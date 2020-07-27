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
 * @author kinvo
 */
public class ProfileAction extends ActionSupport {

    String id;
    User blogger;
    public ProfileAction() {
    }

    public String execute() throws Exception {
        id = ServletActionContext.getRequest().getParameter("id");
        User user;
        UserDAO dao = new UserDAO();
        user = dao.searchByID(Integer.parseInt(id));
        System.out.println("TEst" + user);
        if (user != null) {
            blogger = user;
            user = (User) ServletActionContext.getRequest().getSession().getAttribute("user"); 
            if (user!=null) {
                id = Integer.toString(user.getUserId()); 
            }else{
                id = "0"; 
            }
            return SUCCESS;
        }
        return "failure";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getBlogger() {
        return blogger;
    }

    public void setBlogger(User blogger) {
        this.blogger = blogger;
    }
}
