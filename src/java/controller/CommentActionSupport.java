/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CommentDAO;
import Entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author kinvo
 */
public class CommentActionSupport extends ActionSupport {

    private int id;
    private String cmtContent;

    public CommentActionSupport() {
    }

    public String execute() throws Exception {
        CommentDAO cmtdao = new CommentDAO();
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        if (user == null) {
            return "failure";
        }
        if (cmtdao.addNewComment(id, cmtContent, user.getUserId()) > 0) {
            return SUCCESS;
        }
        return ERROR;

    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
