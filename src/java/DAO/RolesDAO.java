package DAO;

import Entity.Roles;
import config.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RolesDAO {

    //--------------------------------INSERT------------------------------------
    public int addNewRole(String name, String decription){
        int rc = 0; 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            String sql = "Insert into roles(name,decription) values (?, ?)"; 
            PreparedStatement stml = conn.prepareStatement(sql); 
            stml.setString(1, name);
            stml.setString(2, decription);
            rc = stml.executeUpdate(); 
            conn.close(); 
            System.out.println("Add new role successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Add new role failure!");
        }
        return rc; 
    }
    //-------------------------------GET ALL------------------------------------
    public ArrayList<Roles> getAllRoles(){
        ArrayList<Roles> allRoles = new ArrayList<>(); 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery("Select * from roles"); 
            while (rs.next()) {                
                int roleId = rs.getInt(1); 
                String name = rs.getString(2); 
                String decription = rs.getString(3); 
                allRoles.add(new Roles(roleId, name, decription)); 
            }
            conn.close();
            System.out.println("Get all roles successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all roles failure!");
        }
        return allRoles; 
    }
    //-------------------------------UPDATE-------------------------------------
    public int updateRole(int roleId, String name, String decription){
        int rc = 0; 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            String sql = "Update roles set name = ?, decription = ? where role_id = ?"; 
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setString(1, name);
            stmt.setString(2, decription);
            stmt.setInt(3, roleId);
            rc = stmt.executeUpdate(); 
            conn.close();
            System.out.println("Update role successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Update role failure!");
        }
        return rc; 
    }
    //-------------------------------SEARCH-------------------------------------
    public ArrayList<Roles> searchByName(String aName){
        ArrayList<Roles> aRole = new ArrayList<>(); 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            String sql = "Select * from roles where name = ?"; 
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setString(1, aName);
            ResultSet rs = stmt.executeQuery(sql); 
            while (rs.next()) {                
                int roleId = rs.getInt(1); 
                String name = rs.getString(2); 
                String decription = rs.getString(3); 
                aRole.add(new Roles(roleId, name, decription)); 
            }
            conn.close(); 
            System.out.println("Get roles by name successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get roles by name failure!");
        }
        return aRole; 
    }
}
