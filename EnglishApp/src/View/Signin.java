/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.Account;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Signin extends JFrame implements ActionListener{
    private JButton signIn;
    private JTextField username;
    private JPasswordField pass;
    private Account users;
   
    public Signin(){       
        setSize(380, 476);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
        setVisible(true);
        setLayout(null); 
        
        JLabel lb_member = new JLabel("Don't have an account yet?");
        JLabel lb_signUp = new JLabel("Sign Up");
        lb_signUp.setFont(new Font("Courier", Font.BOLD,14));
        lb_member.setBounds(70, 270, 160, 14);
        lb_signUp.setBounds(225, 270, 133, 14);
        add(lb_member);
        add(lb_signUp); 
        
        //  sign up if you don't have an account
        lb_signUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {				
                Signup su = new Signup();
                su.setVisible(true);
                setVisible(false);
            }
	});
        
        //Login label
        JLabel jlb = new JLabel();
        jlb.setText("Log In");
        jlb.setForeground(Color.black);
        jlb.setFont(new Font("Consolas",Font.BOLD, 30));
        jlb.setBounds(120,30, 150, 100);
        add(jlb);
        
        //User textfield
        JLabel user2 = new JLabel();
        user2.setText("USERNAME");
        user2.setFont(new Font("Courier", Font.BOLD,12));
        user2.setBounds(50,80, 100, 100);
        add(user2);
        
        // username textfield
        username = new JTextField();
        username.setBounds(50, 150, 250, 30);
        add(username);
        
        // Password field
        JLabel pw2 = new JLabel();
        pw2.setText("PASSWORD");
        pw2.setFont(new Font("Courier", Font.BOLD,12));
        pw2.setBounds(50,150, 100, 100);
        add(pw2);
        pass = new JPasswordField();
        pass.setBounds(50, 220, 250, 30);
        add(pass);
        
        //Sign In
        signIn = new JButton("Sign In");
        signIn.setForeground(Color.WHITE);
        signIn.setBackground(new Color(241, 57, 83));
        signIn.setBounds(50, 300, 250, 30);
        add(signIn);
      
       signIn.addActionListener(this);
    }   
    
    // checking the empty field
     public boolean checkBlank(){
         if(username.getText().equals("") || pass.getText().equals("")){
             return false;
         }else{
             return true;
         }
     }
     
     // get username and password 
    public Account getUserif(){
        users = new Account(username.getText(), pass.getText());
        return users;      
    }
      
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn.equals(signIn)){   
            try {
                btnSignin_actionperformed();
            } catch (Exception ex) {
                Logger.getLogger(Signin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void btnSignin_actionperformed() throws Exception{
        users = getUserif();
        DAO d = new DAO();
        if(checkBlank()){
            if(d.checkUser(users)){
                showMessage("Welcome");
                new mainFrame(username.getText()).setVisible(true);
                setVisible(false);
          }else{
                showMessage("Invalid username and/or password!");
          }
        }else{
             JOptionPane.showMessageDialog(this, "Field cant blank");
        }
        
    }
}

