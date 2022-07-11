/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.UserManager;
import Model.User;
import View.MainMenu;

/**
 *
 * @author Devan
 */
public class main {
    public static void main(String[] args) {
        User user = new User();
        UserManager.getInstance().setUser(user);
        new MainMenu();
    }
}
