package DAO;

import Entity.User;
import config.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserDAO {

    //----------------------------INSERT----------------------------------------
    public static int addNewUser(String name, String email, int permission, String password, String description, String avatar, String fbLink, String adress, String major) {
        int rc = 0;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Date date = new Date();
            Connection conn = DatabaseHelper.openConnection();
            if (avatar == null) {
                avatar = "https://previews.123rf.com/images/yupiramos/yupiramos1610/yupiramos161005146/63681963-avatar-man-smiling-wearing-sunglasses-and-travel-suitcases-over-white-background-vector-illustration.jpg";
            }

            String sql = "INSERT INTO [dbo].[users]\n"
                    + "([users_name]\n"
                    + ",[email]\n"
                    + ",[permission]\n"
                    + ",[user_password]\n"
                    + ",[date_modify]\n"
                    + ",[description]\n"
                    + ",[avatar]\n"
                    + ",[fb_link]\n"
                    + ",[address]\n"
                    + ",[major])\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stml = conn.prepareStatement(sql);
            stml.setString(1, name);
            stml.setString(2, email);
            stml.setInt(3, permission);
            stml.setString(4, password);
            stml.setString(5, dFormate.format(date));
            stml.setString(6, description);
            stml.setString(7, avatar);
            stml.setString(8, fbLink);
            stml.setString(9, adress);
            stml.setString(10, major);
            rc = stml.executeUpdate();
            conn.close();
            System.out.println("Add new user successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Add new user failure!");
        }
        return rc;
    }

    //----------------------------GET ALL---------------------------------------
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from users");
            while (rs.next()) {
                int userId = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                int permission = rs.getInt(4);
                String password = rs.getString(5);
                Date dateModify = dFormate.parse(rs.getString(6));
                String description = rs.getString(7);
                String avatar = rs.getString(8);
                String fbLink = rs.getString(9);
                String adress = rs.getString(10);
                String major = rs.getString(11);
                allUsers.add(new User(userId, permission, name, email, password, description, avatar, fbLink, adress, major, dateModify));
                            }
            conn.close();
            System.out.println("Get all users successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all users failure!");
        }
        return allUsers;
    }

    //----------------------------UPDATE----------------------------------------
    public int updateUser(int userId, String name, String email, int permission, String password, String description, String avatar, String fbLink, String adress, String major) {
        int rc = 0;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Date date = new Date();
            Connection conn = DatabaseHelper.openConnection();
            if (avatar == null) {
                avatar = "https://previews.123rf.com/images/yupiramos/yupiramos1610/yupiramos161005146/63681963-avatar-man-smiling-wearing-sunglasses-and-travel-suitcases-over-white-background-vector-illustration.jpg";
            }
            String sql = "Update users set users_name = ?, email = ?, permission = ?, user_password = ?, description = ?, avatar = ?, fb_link = ?, address = ?, major = ? where users_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, permission);
            stmt.setString(4, password);
            stmt.setString(5, description);
            stmt.setString(6, avatar);
            stmt.setString(7, fbLink);
            stmt.setString(8, adress);
            stmt.setString(9, major);
            stmt.setInt(10, userId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Check: " + userId + name + email + permission + password + description);
            System.out.println("Update User successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Update User failure!");
        }
        return rc;
    }

    //----------------------------SEARCH----------------------------------------
    public User searchByID(int id) {
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from users where users_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                int permission = rs.getInt(4);
                String password = rs.getString(5);
                Date dateModify = dFormate.parse(rs.getString(6));
                String description = rs.getString(7);
                String avatar = rs.getString(8);
                String fbLink = rs.getString(9);
                String adress = rs.getString(10);
                String major = rs.getString(11);
                return new User(userId, permission, name, email, password, description, avatar, fbLink, adress, major, dateModify);
            }
            conn.close();
            System.out.println("Get users by name successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get users by name failure!");
        }
        return null;
    }

    //--------------------------------------------------------------------------
    public User checkLogin(String email, String password) {
        User user = null;
        try {
            SimpleDateFormat dFormate = new SimpleDateFormat("MMM dd yyyy HH:mma");
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from users where email=? and user_password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt(1);
                String name = rs.getString(2);
                email = rs.getString(3);
                int permission = rs.getInt(4);
                password = rs.getString(5);
                Date dateModify = dFormate.parse(rs.getString(6));
                String description = rs.getString(7);
                String avatar = rs.getString(8);
                String fbLink = rs.getString(9);
                String adress = rs.getString(10);
                String major = rs.getString(11);
                return new User(userId, permission, name, email, password, description, avatar, fbLink, adress, major, dateModify);
            }
            conn.close();
            System.out.println("Get users by name successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get users by name failure!");
        }
        return user;
    }

    public boolean checkSignUp(String email) {
        boolean check = false;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from users where email=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            check = !rs.next();
            conn.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return check;
    }

    //------------------------------Delete User---------------------------------
    public int deleteUser(int userId) {
        deleteCommentByUserId(userId);
        int rc = 0;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "delete from users where users_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Delete User successfully!");
        } catch (Exception e) {
            System.err.println("Delete User failure!");
            System.err.println(e);
        }
        return rc;
    }

    public int deleteCommentByUserId(int userId) {
        int rc = 0;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "delete from comment where users_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Delete comments by users_id successfully!");
        } catch (Exception e) {
            System.err.println("Delete comments by users_id failure!");
            System.err.println(e);
        }
        return rc;
    }
}
