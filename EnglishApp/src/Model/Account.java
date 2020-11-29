/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Account {
    private String password;
    private String userName;
    private String useremail;
    
    public Account() {
    }

    public Account(String pass, String userName, String email) {
        this.password = pass;
        this.userName = userName;
        this.useremail = email;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }
    
    
    public String getPass() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUseremail() {
        return useremail;
    }
    
    /*get information from the database and then compare it with the imported data*/
    public void getCredentials(){
        try{
                String dbURL = "jdbc:sqlserver://localhost;databaseName=test;user=sa;password=123456";
                Connection conn = DriverManager.getConnection(dbURL);
                String sql = "select * from Userinfor\n"
                        + "where usernames  = ? and passwords = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username_login.getText());
                ps.setString(2, password_login.getText());
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
                }else{
                    JOptionPane.showMessageDialog(this, "Dang nhap that bai");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    
    public boolean checkLogin(String name, String pass){
        return (userName == name && password == pass);
    }
}


