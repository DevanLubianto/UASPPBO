/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import javax.swing.JOptionPane;

/**
 *
 * @author Devan
 */
public class DatabaseControl {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public static ArrayList<User> getAllUser(){
        ArrayList<User> users = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                user.setPhoto(rs.getString("photo"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    public static User getUser(User user) {
        conn.connect();
        String query = "SELECT * FROM user WHERE email='" + user.getEmail() + "' AND password = '" + user.getPassword() + "'";
        User users = new User();
        users.setId(0);
        users.setName("");
        users.setEmail("");
        users.setPassword("");
        users.setIdCategory(0);
        users.setPhoto("");
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setEmail(rs.getString("email"));
                users.setPassword(rs.getString("password"));
                users.setIdCategory(rs.getInt("idCategory"));
                users.setPhoto(rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (users);
    }
    public static boolean deleteUser(String name) {
        conn.connect();

        String query = "DELETE FROM user WHERE name='" + name + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static boolean insertNewUser(User user){
        conn.connect();
        String query = "INSERT INTO user(id, name, email, password, idCategory, photo) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 0);
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getIdCategory());
            stmt.setString(6, user.getPhoto());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    public static ArrayList<CategoryUser> getAllCategoryUser(){
        ArrayList<CategoryUser> categories = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM categoryuser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser category = new CategoryUser();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (categories);
    }
}
