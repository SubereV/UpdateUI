/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PostDAO;
import Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author kinvo
 */
public class CreatePostAction extends ActionSupport {
    String id; 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    String title;
    String content;
    int cate;
    String location, backGround;
    
    String url1; 
    public CreatePostAction() {
    }

    public String execute() throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        PostDAO pdao = new PostDAO();

        if (user != null && pdao.addNewPost(user.getUserId(), title, content, cate, location, backGround) > 0) {
            url1 = "wall?id="+ user.getUserId(); 
            return SUCCESS;
        }
        return "failure";
    }

    public String getBackGround() {
        return backGround;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }
    
    
    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
