package DAO;

import Entity.Post;
import config.DatabaseHelper;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class PostDAO {

    //-----------------------------INSERT---------------------------------------
    public int addNewPost(int userId, String title, String content, int categoryId, String location, String backGround) {
        int rc = 0;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Date date = new Date();
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Insert into post(users_id, title, content, category, location, date_modify) values (?, ?, ?, ?, ?, ?)";
            if (backGround == null) {
                backGround = "https://wallpaperplay.com/walls/full/c/7/0/195311.jpg";
            }
            String sql = "Insert into post(users_id, title, content, category, location, date_modify, background) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, title);
            stmt.setString(3, content);
            stmt.setInt(4, categoryId);
            stmt.setString(5, location);
            stmt.setString(6, dFormate.format(date));
            stmt.setString(7, backGround);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Add new post successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Add new post failure!");
        }
        return rc;
    }

    //----------------------------GET ALL---------------------------------------
    public ArrayList<Post> getAllPosts() {
        ArrayList<Post> allPosts = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from post");
            while (rs.next()) {
                int postId = rs.getInt(1);
                int userId = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String background = rs.getString(5);
                int categoryId = rs.getInt(6);
                String location = rs.getString(7);
                Date dateModify = dFormate.parse(rs.getString(8));
                allPosts.add(new Post(postId, userId, categoryId, title, content, background, location, dateModify));
            }
            conn.close();
            System.out.println("Get all posts successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all posts failure!");
        }
        Collections.reverse(allPosts);
        return allPosts;
    }

    //----------------------------UPDATE----------------------------------------
    public int updatePost(int postId, String title, String content, int categoryId, String location, String backGround) {
        int rc = 0;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Date date = new Date();
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Update post set title = ?, content = ?, category = ?, location = ? where post_id = ?";
            if (backGround == null) {
                backGround = "https://wallpaperplay.com/walls/full/c/7/0/195311.jpg";
            }
            String sql = "Update post set title = ?, content = ?, category = ?, location = ?, background = ? where post_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, categoryId);
            stmt.setString(4, location);
            stmt.setString(5, backGround);
            stmt.setInt(6, postId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Update post successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Update post failure!");
        }
        return rc;
    }

    //---------------------------SEARCH-----------------------------------------
    public Post searchById(int aTitle) {
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from post where post_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aTitle);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int postId = rs.getInt(1);
                int userId = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String background = rs.getString(5);
                int categoryId = rs.getInt(6);
                String location = rs.getString(7);
                Date dateModify = dFormate.parse(rs.getString(8));
                return new Post(postId, userId, categoryId, title, content, background, location, dateModify);
            }
            conn.close();
            System.out.println("Get all posts by id successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all posts by id failure!");
        }
        return null;
    }

    public ArrayList<Post> searchByCate(int aCategoryId) {
        ArrayList<Post> aCategories = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from post where category = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, aCategoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int postId = rs.getInt(1);
                int userId = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String background = rs.getString(5);
                int categoryId = rs.getInt(6);
                String location = rs.getString(7);
                Date dateModify = dFormate.parse(rs.getString(8));
                aCategories.add(new Post(postId, userId, categoryId, title, content, background, location, dateModify));
            }
            conn.close();
            System.out.println("Get all posts by category successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all posts by category failure!");
        }
        Collections.reverse(aCategories);
        return aCategories;
    }

    //------------------------User----------------------------------------------
    public ArrayList<Post> searchByUser(int userID) {
        ArrayList<Post> aPosts = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "select post.*, users.users_name\n"
                    + "from post\n"
                    + "left join users on post.users_id = users.users_id\n"
                    + "where post.users_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int postId = rs.getInt(1);
                int userId = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String background = rs.getString(5);
                int categoryId = rs.getInt(6);
                String location = rs.getString(7);
                Date dateModify = dFormate.parse(rs.getString(8));
                aPosts.add(new Post(postId, userId, categoryId, title, content, background, location, dateModify));
            }
            conn.close();
            System.out.println("Get all posts by user successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all posts by user failure!");
        }
        Collections.reverse(aPosts);
        return aPosts;
    }

    //-----------------------------Search By Keywords---------------------------
    public ArrayList<Post> searchByKeywordAndCate(String keyword, int cateId) {
        ArrayList<Post> aPosts = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "select p1.*, p2.rank "
                    + "from post as p1 inner join FreeTexttable(post,(title,content), ?) as p2 "
                    + "on p1.post_id = p2.[KEY] "
                    + "where p2.rank>2 and p1.category = ? "
                    + "order by p2.rank desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, keyword);
            stmt.setInt(2, cateId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int postId = rs.getInt(1);
                int userId = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String background = rs.getString(5);
                int categoryId = rs.getInt(6);
                String location = rs.getString(7);
                Date dateModify = dFormate.parse(rs.getString(8));
                aPosts.add(new Post(postId, userId, categoryId, title, content, background, location, dateModify));
            }
            conn.close();
            System.out.println("Get posts by key word: " + keyword + " successfully!");
        } catch (Exception e) {
            System.err.println("Get posts by key word: " + keyword + " failure!");
            System.err.println(e);
        }
        Collections.reverse(aPosts);
        return aPosts;
    }

    public ArrayList<Post> searchByKeywordAndUser(String keyword, int aUserId) {
        ArrayList<Post> aPosts = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "select p1.*, p2.rank "
                    + "from post as p1 inner join FreeTexttable(post,(title,content), ?) as p2 "
                    + "on p1.post_id = p2.[KEY] "
                    + "where p2.rank>2 and p1.users_id = ? "
                    + "order by p2.rank desc";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, keyword);
            stmt.setInt(2, aUserId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int postId = rs.getInt(1);
                int userId = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String background = rs.getString(5);
                int categoryId = rs.getInt(6);
                String location = rs.getString(7);
                Date dateModify = dFormate.parse(rs.getString(8));
                aPosts.add(new Post(postId, userId, categoryId, title, content, background, location, dateModify));
            }

            conn.close();
            System.out.println("Get posts by key word: " + keyword + " successfully!");
        } catch (Exception e) {
            System.err.println("Get posts by key word: " + keyword + " failure!");
            System.err.println(e);
        }
        Collections.reverse(aPosts);
        return aPosts;
    }

    //----------------------------Delete----------------------------------------
    public int deletePostById(int id) {
        int rc = 0;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "delete from post where post_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Delete post by id successfully!");
        } catch (Exception e) {
            System.err.println("Delete post by id failure!");
            System.err.println(e);
        }
        return rc;
    }

    public static void main(String[] args) {
        PostDAO dap = new PostDAO();
        System.out.println(dap.searchByKeywordAndCate("dolor elit", 2));
    }
}
