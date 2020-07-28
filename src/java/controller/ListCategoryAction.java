/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CategoryDAO;
import DAO.PostDAO;
import Entity.Category;
import Entity.Post;
import Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ListCategoryAction extends ActionSupport {

    final String SUCCESS = "success";

    private CategoryDAO dao;
    private ArrayList<Category> parentList;
    //==
    private PostDAO pdao;
    private int id;
    private String title;
    private String content;
    private int cid;
    private String location;
    private Post post;
    private boolean admin;

    public CategoryDAO getDao() {
        return dao;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Category> getParentList() {
        return parentList;
    }

    public void setParentList(ArrayList<Category> parentList) {
        this.parentList = parentList;
    }

    public String execute() throws Exception {
        dao = new CategoryDAO();
        parentList = dao.findParentCategories();
        return SUCCESS;
    }

    public String editPage() {
        System.out.println(id);
        User u = (User) ActionContext.getContext().getSession().get("user");
        pdao = new PostDAO();
        post = pdao.searchById(id);
        dao = new CategoryDAO();
        parentList = dao.findParentCategories();
        if (post != null) {
            if (u.getUserId() == 1) {
                admin = true;
            }
                return SUCCESS;
            }
            return ERROR;
        }

    public PostDAO getPdao() {
        return pdao;
    }

    public void setPdao(PostDAO pdao) {
        this.pdao = pdao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean isCondition() {
        return admin;
    }

    public void setCondition(boolean condition) {
        this.admin = condition;
    }

}
