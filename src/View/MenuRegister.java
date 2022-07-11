/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

//import Controller.LoginController;
import Controller.DatabaseControl;
import Model.CategoryUser;
import Model.User;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Devan
 */
public class MenuRegister{
    private JLabel labelEmail, labelPassword, labelName, labelChoose, labelBox;
    private JTextField textEmail, textName;
    private JPasswordField textPassword;
    private JFileChooser chooseFile;
    private JComboBox boxCategory;
    private JButton buttonRegister, buttonBack, buttonChoose;
    private JFrame frame = new JFrame("Login");
    private String filePath;
    public MenuRegister(){
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<CategoryUser> categories = new ArrayList<>();
        DatabaseControl controller = new DatabaseControl();
        categories = controller.getAllCategoryUser();
        
        String[] category = new String[categories.size()];
        for(int i = 0; i < categories.size(); i++){
            category[i] = categories.get(i).getName();
        }
        
        labelEmail = new JLabel("Email");
        labelName = new JLabel("Name");
        labelPassword = new JLabel("Password");
        labelChoose = new JLabel("Pilih Gambar");
        labelBox = new JLabel("Pilih Kategori");
        labelEmail.setBounds(300, 210, 100, 50);
        labelName.setBounds(300, 260, 100, 50);
        labelPassword.setBounds(300, 310, 100, 50);
        labelChoose.setBounds(300, 360, 100, 50);
        labelBox.setBounds(300, 410, 100, 50);
        
        textEmail = new JTextField();
        textEmail.setBounds(400, 226, 150, 20);
        textName = new JTextField();
        textName.setBounds(400, 276, 150, 20);
        textPassword = new JPasswordField();
        textPassword.setBounds(400, 326, 150, 20);
        boxCategory = new JComboBox(category);
        boxCategory.setBounds(400, 426, 150, 20);
        
        buttonRegister = new JButton("Register");
        buttonBack = new JButton("Back");
        buttonChoose = new JButton("Choose");
        buttonRegister.setBounds(300, 500, 100, 30);
        buttonBack.setBounds(410, 500, 100, 30);
        buttonChoose.setBounds(400, 376, 150, 20);
        
        buttonBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new MainMenu();
            }
        });
        buttonChoose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                chooseFile = new JFileChooser();
                int i = chooseFile.showOpenDialog(frame);
                if(i == JFileChooser.APPROVE_OPTION){
                    File f = chooseFile.getSelectedFile();
                    filePath = f.getPath();
                }
            }
        });
        buttonRegister.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                User user = new User();
                user.setEmail(textEmail.getText());
                user.setName(textName.getText());
                user.setPassword(textPassword.getText());
                user.setIdCategory(boxCategory.getSelectedIndex()+1);
                user.setPhoto(filePath);
                if(user.insertUser(user)){
                    JOptionPane.showMessageDialog(null, "Registrasi Sukses");
                    new MainMenu();
                }else{
                    JOptionPane.showMessageDialog(null, "Registrasi Gagal", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        frame.add(buttonRegister);
        frame.add(buttonBack);
        frame.add(buttonChoose);
        frame.add(textEmail);
        frame.add(textName);
        frame.add(boxCategory);
        frame.add(textPassword);
        frame.add(labelEmail);
        frame.add(labelName);
        frame.add(labelPassword);
        frame.add(labelBox);
        frame.add(labelChoose);
        frame.setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}