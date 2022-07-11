/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import Controller.LoginController;
import Model.User;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Devan
 */
public class MenuLogin{
    private JLabel labelEmail, labelPassword, labelKonfirmasi, labelGambar;
    private JTextField textEmail;
    private JPasswordField textPassword;
    private JButton buttonSubmit, buttonBack;
    private JFrame frame = new JFrame("Login");
    public MenuLogin(){
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelGambar = new JLabel("");
        labelGambar.setIcon(new ImageIcon("../image/logo.jpg"));
        labelGambar.setBounds(280, 0, 250, 250);
        
        labelEmail = new JLabel("Email");
        labelPassword = new JLabel("Password");
        labelEmail.setBounds(300, 210, 100, 50);
        labelPassword.setBounds(300, 260, 100, 50);
        
        textEmail = new JTextField();
        textEmail.setBounds(363, 226, 150, 20);
        textPassword = new JPasswordField();
        textPassword.setBounds(363, 276, 150, 20);
        
        buttonSubmit = new JButton("Submit");
        buttonBack = new JButton("Back");
        
        buttonSubmit.setBounds(300, 310, 100, 30);
        buttonBack.setBounds(410, 310, 100, 30);
        
        buttonSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                User user = new User();
                user.setEmail(textEmail.getText());
                user.setPassword(textPassword.getText());
                boolean cek = user.getUser(user);
                if(cek){
                    JOptionPane.showMessageDialog(null, "Login Sukses!!");
                    frame.setVisible(false);
                    new MainMenu();
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal!!", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MainMenu();
            }
        });
        
        labelKonfirmasi = new JLabel();
        
        labelKonfirmasi.setBounds(100, 300, 100, 30);
        
        frame.add(labelKonfirmasi);
        frame.add(buttonSubmit);
        frame.add(buttonBack);
        frame.add(labelGambar);
        frame.add(textEmail);
        frame.add(textPassword);
        frame.add(labelEmail);
        frame.add(labelPassword);
        frame.setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}