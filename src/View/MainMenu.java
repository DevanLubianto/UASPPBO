/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Devan
 */
public class MainMenu {
    private JFrame frame = new JFrame();
    private JButton buttonLogin, buttonRegister, buttonData;
    
    public MainMenu(){
        frame.setSize(640, 360);
        frame.setTitle("Main Menu");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buttonLogin = new JButton("Login");
        buttonRegister = new JButton("Register");
        buttonData = new JButton("Data");
        
        buttonLogin.setBounds(100, 145, 100, 30);
        buttonRegister.setBounds(205, 145, 100, 30);
        buttonData.setBounds(310, 145, 100, 30);
        
        buttonLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuLogin();
            }
        });
        buttonRegister.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MenuRegister();
            }
        });
        
        frame.add(buttonLogin);
        frame.add(buttonRegister);
        frame.add(buttonData);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
