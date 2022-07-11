/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseControl;
import Controller.UserManager;

/**
 *
 * @author Devan
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int idCategory;
    private String photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public boolean getUser(User user){
        DatabaseControl controller = new DatabaseControl();
        User cek = controller.getUser(user);
        if(cek.getEmail().equals(user.getEmail())){
            UserManager.getInstance().setUser(cek);
            return true;
        }else{
            return false;
        }
    }
    public boolean insertUser(User user){
        DatabaseControl controller = new DatabaseControl();
        return controller.insertNewUser(user);
    }
}
