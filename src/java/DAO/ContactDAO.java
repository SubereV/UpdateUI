/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Contact;
import config.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ContactDAO {
    //------------------------------GET ALL-------------------------------------
    public ArrayList<Contact> getAllContacts(){
        ArrayList<Contact> allContacts = new ArrayList<>(); 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery("Select * from contact"); 
            while (rs.next()) {                
                int contactId = rs.getInt(1); 
                String name = rs.getString(2); 
                String email = rs.getString(3); 
                String phoneNumber = rs.getString(4); 
                String content = rs.getString(5); 
                allContacts.add(new Contact(contactId, name, email, phoneNumber, content)); 
            }
            conn.close();
            System.out.println("Get all contacts successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all contacts failure!");
        }
        return allContacts; 
    }
    
    //--------------------------------DELETE------------------------------------
    public int deleteContact(int contactId){
        int rc = 0; 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            String sql = "delete from contact where contact_id = ?"; 
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setInt(1, contactId);
            rc = stmt.executeUpdate(); 
            System.out.println("Delete contact successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Delelte contact failure!");
        }
        return rc; 
    }
}
