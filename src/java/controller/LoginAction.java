/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UserDAO;
import Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author kinvo
 */
public class LoginAction extends ActionSupport {

    String email;
    String password;
    String message;
    String url;

    public LoginAction() {
    }

    public String execute() throws Exception {
        UserDAO dao = new UserDAO();
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = dao.checkLogin(email, password);
        if (user != null) {
            url = "wall?id="+ user.getUserId();
            session.setAttribute("user", user);
            return "redirect";
        } else {
            message = "Wrong email or password";
            return "fail";
        }
    }

    public String logout() {
        Map currentSession = ActionContext.getContext().getSession();
        currentSession.put("user", null);
        return SUCCESS;
    }

    public String direct() {
        return SUCCESS;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
