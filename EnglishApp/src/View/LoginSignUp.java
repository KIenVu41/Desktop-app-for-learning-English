/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Admin
 */
public class LoginSignUp extends JFrame implements ActionListener{
    // Variables declaration
     private JPanel contentPane;
     private JTextField textField;
     private JTextField textField_1;
     private JPasswordField passwordField;
     private JPasswordField passwordField_1;
    

    public LoginSignUp(){
       setBackground(Color.GREEN);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 729, 476);
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
	label.setIcon(new ImageIcon(LoginSignUp.class.getResource("/images/bg.jpg")));
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
        lb_member.setBounds(450, 347, 133, 14);
        lb_signin.setBounds(565, 347, 133, 14);
        contentPane.add(lb_member);
        contentPane.add(lb_signin);
        
	JButton btn_signUp = new JButton("Sign Up");
        
	btn_signUp.setForeground(Color.WHITE);
	btn_signUp.setBackground(new Color(241, 57, 83));
	btn_signUp.setBounds(395, 380, 283, 36);
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
        
	// email	
	JLabel lblEmail = new JLabel("EMAIL");
	lblEmail.setBounds(395, 132, 54, 14);
	contentPane.add(lblEmail);
        
	//email textfield	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(395, 157, 283, 36);
	contentPane.add(textField_1);
		
	JLabel lblPassword = new JLabel("PASSWORD");
	lblPassword.setBounds(395, 204, 96, 14);
	contentPane.add(lblPassword);
		
	JLabel lblRepeatPassword = new JLabel("REPEAT PASSWORD");
	lblRepeatPassword.setBounds(395, 275, 133, 14);
	contentPane.add(lblRepeatPassword);
		
	passwordField = new JPasswordField();
	passwordField.setBounds(395, 229, 283, 36);
	contentPane.add(passwordField);
		
	passwordField_1 = new JPasswordField();
	passwordField_1.setBounds(395, 293, 283, 36);
	contentPane.add(passwordField_1);
		
	JLabel lbl_close = new JLabel("X");
	lbl_close.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {				
			System.exit(0);
		}
	});
        
        // 
        lb_signin.addMouseListener(new MouseAdapter() {
            @Override
		public void mouseClicked(MouseEvent arg0) {				
                    JFrame fr = new JFrame("Log In");
                    fr.setVisible(true);
                    fr.setSize(500,500);
                    fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    fr.setLocationRelativeTo(null);
              
                    fr.setLayout(null);
                    dispose();
                    
                    JButton back = new JButton("Back");
                    back.setBounds(300, 250, 100, 100);
                    fr.add(back);
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             setVisible(true);
                             fr.setVisible(false);
                        }
                        
                    });
		}
            
        });
        
        // checking for empty field
        btn_signUp.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                checkBlank();
           }
       });
        
	lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_close.setForeground(new Color(241, 57, 83));
	lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lbl_close.setBounds(691, 0, 37, 27);
	contentPane.add(lbl_close);
}
        
    private boolean checkBlank(){
        if(textField.getText().trim().equals("") || passwordField_1.getText().trim().equals(null) || textField_1.getText().trim().equals(null) ){
            JOptionPane.showMessageDialog(contentPane, "field can't be empty");
            return false;
        }
        return true;     
    }
    
    public static void main(String[] args) { 
        new LoginSignUp().setVisible(true);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

