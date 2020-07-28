/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CategoryDAO;
import DAO.CommentDAO;
import DAO.PostDAO;
import DAO.UserDAO;
import Entity.Category;
import Entity.Comment;
import Entity.Post;
import Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Admin
 */
public class PostAction extends ActionSupport {

    private Category curentCate, parentCate; //Nhan ten cua category hien tai
    private UserDAO ud = new UserDAO(); //Get user name
    private PostDAO dao = new PostDAO(); //Dung cho add new Post  +  list Posts the cate
    private CommentDAO cd = new CommentDAO();
    private ArrayList<Comment> commentOnPost;
    private Post post;
    private User user;
    private ArrayList<Post> postsByCate;
    private int id;
    private String keyword;
    private String title;
    private String content;
    private int cid;
    private String location;
    private String url;
    private int cate;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public UserDAO getUd() {
        return ud;
    }

    public void setUd(UserDAO ud) {
        this.ud = ud;
    }

    public Category getParentCate() {
        return parentCate;
    }

    public void setParentCate(Category parentCate) {
        this.parentCate = parentCate;
    }

    public Category getCurentCate() {
        return curentCate;
    }

    public void setCurentCate(Category curentCate) {
        this.curentCate = curentCate;
    }

    public PostDAO getDao() {
        return dao;
    }

    public void setDao(PostDAO dao) {
        this.dao = dao;
    }

    public ArrayList<Post> getPostsByCate() {
        return postsByCate;
    }

    public void setPostsByCate(ArrayList<Post> postsByCate) {
        this.postsByCate = postsByCate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CommentDAO getCd() {
        return cd;
    }

    public void setCd(CommentDAO cd) {
        this.cd = cd;
    }

    public ArrayList<Comment> getCommentOnPost() {
        return commentOnPost;
    }

    public void setCommentOnPost(ArrayList<Comment> commentOnPost) {
        this.commentOnPost = commentOnPost;
    }

    public PostAction() {
        dao = new PostDAO();
    }

    public String posts() {
        int cate = Integer.parseInt(ServletActionContext.getRequest().getParameter("cate"));
        String keyword = ServletActionContext.getRequest().getParameter("key");
        CategoryDAO d = new CategoryDAO();
        ud = new UserDAO();
        curentCate = d.searchById(cate);//take current category
        parentCate = d.searchById(curentCate.getFatherCategoryId()); //take parent category

        if (keyword == null) {
            if (curentCate.getFatherCategoryId() == 0) {
                ArrayList<Category> childCate = d.findChildrenCategories(curentCate);
                postsByCate = new ArrayList<>();
                for (Category child : childCate) {
                    for (Post p : dao.searchByCate(child.getCategoryId())) {
                        postsByCate.add(p);
                    }
                }
            } else {
                postsByCate = dao.searchByCate(cate); //take post list by category
            }
            return SUCCESS;
        }

        if (curentCate.getFatherCategoryId() == 0) {
            ArrayList<Category> childCate = d.findChildrenCategories(curentCate);
            postsByCate = new ArrayList<>();
            for (Category child : childCate) {
                for (Post p : dao.searchByKeywordAndCate(keyword, child.getCategoryId())) {
                    postsByCate.add(p);
                }
            }
        } else {
            postsByCate = dao.searchByKeywordAndCate(keyword, cate); //take post list by category
        }
        return SUCCESS;
    }

    public PostAction(Category curentCate, Category parentCate, ArrayList<Comment> commentOnPost, Post post, User user, ArrayList<Post> postsByCate, int id) {
        this.curentCate = curentCate;
        this.parentCate = parentCate;
        this.commentOnPost = commentOnPost;
        this.post = post;
        this.user = user;
        this.postsByCate = postsByCate;
        this.id = id;
    }

    public String addNew() throws Exception {
        user = (User) ActionContext.getContext().getSession().get("user");
        int check = dao.addNewPost(user.getUserId(), post.getTitle(), post.getContent(), post.getCategoryId(), post.getLocation());
        if (check > 0) {
            return SUCCESS;
        }
        return "fail";
    }

    public String read() throws Exception {
        post = dao.searchById(id);
        if (post != null) {
            post.setContent(post.getContent().replace("\n", "<br>"));
            commentOnPost = cd.searchByPostId(id);
            System.out.println(commentOnPost);
            System.out.println(commentOnPost);
            return SUCCESS;
        }
        return "failure";
    }

    public String delete() {
        if (dao.deletePostById(id) > 0) {
            id = ((User) ActionContext.getContext().getSession().get("user")).getUserId();
            url = "wall?id=" + id;
            return SUCCESS;
        }
        return ERROR;
    }

    public String edit() {
        System.out.println(id);
        System.out.println(cid);
        int uid = ((User) ActionContext.getContext().getSession().get("user")).getUserId();

        if (dao.updatePost(id, title, content, cate, location) > 0) {
//            dao.updatePost(uid, uid, title, content, location, cid, location)
            return SUCCESS;
        }
        return NONE;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }

    
}
