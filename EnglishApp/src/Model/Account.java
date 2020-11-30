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
    
    public Account() {
    }

    public Account(String userName, String pass) {
        this.userName = userName;
        this.password = pass;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPass() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    
    /*get information from the database and then compare it with the imported data*/
    
    public boolean checkLogin(String name, String pass){
        return (userName == name && password == pass);
    }
}


