package DAO;

import Entity.Comment;
import config.DatabaseHelper;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CommentDAO {

    //--------------------------------INSERT------------------------------------
    public int addNewComment(int postId, String content, int userId) {
        int rc = 0;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Date date = new Date();
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Insert into comment(post_id, content, users_id) values (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, postId);
            stmt.setString(2, content);
            stmt.setInt(3, userId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Add new comment successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Add new comment failure!");
        }
        return rc;
    }

    //--------------------------------GET ALL-----------------------------------
    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> allComments = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from comment");
            while (rs.next()) {
                int commentId = rs.getInt(1);
                int postId = rs.getInt(2);
                String content = rs.getString(3);
                Date dateModify = dFormate.parse(rs.getString(4));
                int userId = rs.getInt(5);
                allComments.add(new Comment(commentId, postId, userId, content, dateModify));
            }
            conn.close();
            System.out.println("Get all comments successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all comments failure!");
        }
        return allComments;
    }

    //--------------------------------UPDATE------------------------------------
    public int updateComment(int commentId, int postId, String content, Date dateModify, int userId) {
        int rc = 0;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Date date = new Date();
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Update comment set post_id = ?, content = ?, date_modify = ?, users_id = ? where comment_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, postId);
            stmt.setString(2, content);
            stmt.setString(3, dFormate.format(date));
            stmt.setInt(4, userId);
            stmt.setInt(5, commentId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Update comment successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Update comment failure!");
        }
        return rc;
    }

    //--------------------------------SEARCH------------------------------------
    public ArrayList<Comment> searchByPostId(int aPostId) {
        ArrayList<Comment> aComments = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from comment where post_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aPostId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int commentId = rs.getInt(1);
                int postId = rs.getInt(2);
                String content = rs.getString(3);
                Date dateModify = dFormate.parse(rs.getString(4));
                int userId = rs.getInt(5);
                aComments.add(new Comment(commentId, postId, userId, content, dateModify));
            }
            conn.close();
            System.out.println("Get comment by postId successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get comment by postId failure!");
        }
        return aComments;
    }

    //----------------------------Delete Comment--------------------------------
    public static int delCommentById(int id) {
        int rc = 0;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "delete from comment where comment_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Delete comment by id successfully!");
        } catch (Exception e) {
            System.err.println("Delete comment by id failure!");
            System.err.println(e);
        }
        return rc;
    }

    public static void main(String[] args) {
        CommentDAO cmtdao = new CommentDAO();
        System.out.println(cmtdao.addNewComment(5, "new Comment bro", 9));

    }
}
