package DAO;

import Entity.Category;
import config.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDAO {

    //--------------------------------INSERT------------------------------------
    public int addNewCategory(String name, int fatherCategory) {
        int rc = 0;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Insert into category(name, father_category) values (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, fatherCategory);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Add new category!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Add new category failure!");
        }
        return rc;
    }

    //--------------------------------GET ALL-----------------------------------
    public static ArrayList<Category> getAllCategories() {
        ArrayList<Category> allCategories = new ArrayList<>();
        try {
            Connection conn = DatabaseHelper.openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from category");
            while (rs.next()) {
                int categoryId = rs.getInt(1);
                String name = rs.getString(2);
                int fatherCategory = rs.getInt(3);
                allCategories.add(new Category(categoryId, fatherCategory, name));
            }
            conn.close();
            System.out.println("Get all categories successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get all categories failure!");
        }
        return allCategories;
    }

    //--------------------------------UPDATE------------------------------------
    public int updateCategory(int categoryId, String name, int fatherCategory) {
        int rc = 0;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Update category set name = ?, father_category = ? where category_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, fatherCategory);
            stmt.setInt(3, categoryId);
            rc = stmt.executeUpdate();
            conn.close();
            System.out.println("Update category successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Update category failure!");
        }
        return rc;
    }

    //--------------------------------SEARCH------------------------------------
    public Category searchById(int categoryId) {
        Category cat = null;
        try {
            Connection conn = DatabaseHelper.openConnection();
            String sql = "Select * from category where category_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categoryId = rs.getInt(1);
                String name = rs.getString(2);
                int fatherCategory = rs.getInt(3);
                cat = new Category(categoryId, fatherCategory, name);
            }
            conn.close();
            System.out.println("Get category by ID successfully!");
        } catch (Exception e) {
            System.err.println(e);
            System.err.println("Get category by ID failure!");
        }
        return cat;
    }
    //----------------------------Delete----------------------------------------
    public int deleteCategoryById(int id){
        deleteCatByFatherCat(id);
        int rc = 0; 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            String sql = "delete from category where category_id = ?"; 
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
    
    public static int deleteCatByFatherCat(int id){
        int rc = 0; 
        try {
            Connection conn = DatabaseHelper.openConnection(); 
            String sql = "delete from category where father_category = ?"; 
            PreparedStatement stmt = conn.prepareStatement(sql); 
            stmt.setInt(1, id);
            rc = stmt.executeUpdate(); 
            conn.close();
            System.out.println("Delete comment by father_cat successfully!");
        } catch (Exception e) {
            System.err.println("Delete comment by father_cat failure!");
            System.err.println(e);
        }
        return rc; 
    } 
    public static void main(String[] args) {
        ArrayList<Category> c = getAllCategories(); 
        for(Category ca : c){
            System.out.println(ca.getFatherCategoryId());
        }
    }
    //-----------------------------Find Parent Category-------------------------
    public ArrayList<Category> findParentCategories(){
        ArrayList<Category> parentCategories = new ArrayList<>(); 
        ArrayList<Category> allCategories = getAllCategories(); 
        for(Category cate : allCategories){
            if (cate.getFatherCategoryId()==0) {
                parentCategories.add(cate); 
            }
        }
        return parentCategories; 
    }
    
    //--------------------------Find Child Category-----------------------------
    public  ArrayList<Category> findChildrenCategories(Category parent){
        ArrayList<Category> allCategories = getAllCategories(); 
        ArrayList<Category> childrentCategories = new ArrayList<>(); 
        
        for(Category cate : allCategories){
            if (cate.getFatherCategoryId() == parent.getCategoryId()) {
                childrentCategories.add(cate); 
            }
        }
        return childrentCategories; 
    }
}
