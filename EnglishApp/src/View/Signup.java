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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Admin
 */
public class Signup extends JFrame implements ActionListener{
    // Variables declaration
     private JFrame fr;
     private JPanel contentPane;
     private JTextField textField, txtusername;
     private JPasswordField passwordField, pfpass;
     private JPasswordField passwordField_1;
     private Account model;
     private JButton signin;
     private JButton btn_signUp;
    
    public Signup(){
       setBackground(Color.GREEN);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setBounds(600, 300, 729, 476);
       setResizable(false);
       contentPane = new JPanel();
       contentPane.setBackground(Color.WHITE);
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
       setContentPane(contentPane);
       contentPane.setLayout(null);
		
       JPanel panel = new JPanel();
       panel.setBackground(Color.DARK_GRAY);
       panel.setBounds(0, 0, 346, 490);
       contentPane.add(panel);
       panel.setLayout(null);
       
       JLabel lblNewLabel = new JLabel("EDA");
       lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
       lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
       lblNewLabel.setForeground(new Color(240, 248, 255));
       lblNewLabel.setBounds(139, 305, 84, 27);
       panel.add(lblNewLabel);
		
       JLabel label = new JLabel(""); 
       label.setBounds(-38, 0, 420, 275);
        label.setVerticalAlignment(SwingConstants.TOP);
	label.setIcon(new ImageIcon(Signup.class.getResource("/images/bg.jpg")));
	panel.add(label);
		
	JLabel lbls = new JLabel("....Let's study....");
	lbls.setHorizontalAlignment(SwingConstants.CENTER);
	lbls.setForeground(new Color(240, 248, 255));
	lbls.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lbls.setBounds(111, 343, 141, 27);
	panel.add(lbls);
	
        JLabel lb_member = new JLabel("Already a member?");
        JLabel lb_signin = new JLabel("Log in");
        lb_signin.setFont(new Font("Courier", Font.BOLD,14));
        lb_member.setBounds(450, 290, 133, 14);
        lb_signin.setBounds(565, 290, 133, 14);
        contentPane.add(lb_member);
        contentPane.add(lb_signin);
        
	btn_signUp = new JButton("Sign Up");
        
 
	btn_signUp.setForeground(Color.WHITE);
	btn_signUp.setBackground(new Color(241, 57, 83));
	btn_signUp.setBounds(395, 340, 283, 36);
	contentPane.add(btn_signUp);
	
        // username textfield
	textField = new JTextField();
	textField.setBounds(395, 83, 283, 36);
	contentPane.add(textField);
	textField.setColumns(10);
        
	// username
	JLabel lblUsername = new JLabel("USERNAME");
	lblUsername.setBounds(395, 58, 114, 14);
	contentPane.add(lblUsername);
       	
	// password field		
	JLabel lblPassword = new JLabel("PASSWORD");
	lblPassword.setBounds(395, 130, 96, 14);
	contentPane.add(lblPassword);
		
	JLabel lblRepeatPassword = new JLabel("REPEAT PASSWORD");
	lblRepeatPassword.setBounds(395, 200, 133, 14);
	contentPane.add(lblRepeatPassword);
		
	passwordField = new JPasswordField();
	passwordField.setBounds(395, 154, 283, 36);
	contentPane.add(passwordField);
		
	passwordField_1 = new JPasswordField();
	passwordField_1.setBounds(395, 226, 283, 36);
	contentPane.add(passwordField_1);
	
        // close button
	JLabel lbl_close = new JLabel("X");
	lbl_close.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {				
			System.exit(0);
		}
	});
        
        // sign in
        lb_signin.addMouseListener(new MouseAdapter() {
            @Override
		public void mouseClicked(MouseEvent arg0) {
                    setVisible(false);
                    Signin si = new Signin();
                    si.setVisible(true);                                      
		}              
        });
   
        
        btn_signUp.addActionListener(this);
        
	lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_close.setForeground(new Color(241, 57, 83));
	lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lbl_close.setBounds(691, 0, 37, 27);
	contentPane.add(lbl_close);
      
}
        
    public boolean checkBlank(){
        if(textField.getText().trim().equals("") || passwordField.getText().trim().equals(null) || passwordField_1.getText().trim().equals(null)  ){
            return false;
        }
        return true;     
    }
    
    public boolean checkLength(){
        if(textField.getText().trim().length() < 5){
            return false;
        }else{
            return true;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn.equals(btn_signUp)){
             btnSubmit_actionperformed();
        }
    }
    
    public void btnSubmit_actionperformed(){
         model = getUser();
         DAO d = new DAO();
         
        if(checkBlank()){
            if(checkLength()){
                if(d.Signup(model)){
                    showMessage("Succes!");
                    new Signin().setVisible(true);
                    setVisible(false);
                }else{
                    showMessage("Failed!");
                }
            }else{
                showMessage("Usernames must be at least 5 characters ");
            }
        }else{
            showMessage("field can't be empty");
        }   
    }
       
    public Account getUser(){
        model = new Account(textField.getText(), passwordField.getText());
        return model;      
    }
  
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
  
}

