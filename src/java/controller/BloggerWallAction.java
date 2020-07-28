/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PostDAO;
import DAO.UserDAO;
import Entity.Post;
import Entity.User;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author kinvo
 */
public class BloggerWallAction extends ActionSupport {

    private String id;
    private UserDAO ud = new UserDAO();
    private ArrayList<Post> wall;
    private User user; 
    
    public BloggerWallAction() {
    }

    public String execute() throws Exception {
        String keyword = ServletActionContext.getRequest().getParameter("key");
        PostDAO pd = new PostDAO(); 
        id = ServletActionContext.getRequest().getParameter("id"); 
        user = ud.searchByID(Integer.parseInt(id)); 
        if (keyword != null) {
            wall = pd.searchByKeywordAndUser(keyword, Integer.parseInt(id));
        } else {
            wall = pd.searchByUser(user.getUserId());
        }   
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Post> getWall() {
        return wall;
    }

    public void setWall(ArrayList<Post> wall) {
        this.wall = wall;
    }

    public UserDAO getUd() {
        return ud;
    }

    public void setUd(UserDAO ud) {
        this.ud = ud;
    }

}
