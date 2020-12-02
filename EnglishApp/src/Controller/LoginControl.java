/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import View.Signup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Admin
 */
public class LoginControl {
    private Signup lg;
    private Account acc;
    
    public LoginControl(Signup view){
        this.lg = view;
        //lg.addSignUpListener(new SignUpListener());
        //lg.addSignInListener(new SignInListener());
    }
    
    
    class SignInListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                acc = lg.getUser();
                if(checkUser(acc)){
                    lg.showMessage("SignInListener()");
                }else{
                    lg.showMessage("Invalid username and/or password!");
                }
            }catch(Exception ex){
                lg.showMessage(ex.getStackTrace().toString());
            }
        }
        
    }
    class SignUpListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
               acc = lg.getUser();           
               if(insertUser(acc)){
               lg.showMessage("Succes!");}
               else{
                   lg.showMessage("Failed");
               }
                                         
            }catch(Exception ex){
                 lg.showMessage(ex.getStackTrace().toString());
            }
        }
        
    }
     // insert into table
     public boolean insertUser(Account user) throws Exception {
       
         try{
                String dbURL = "jdbc:sqlserver://localhost;databaseName=UserInfor;user=sa;password=123456";
             try (Connection conn = DriverManager.getConnection(dbURL)) {
                 String query = "INSERT INTO userdb(userName, password) VALUES(?,?)";
                 PreparedStatement stmt = conn.prepareStatement(query);
                 stmt.setString(1, user.getUserName());
                 stmt.setString(2, user.getPass());
                 
                 // excute
                 stmt.executeUpdate();
                 conn.close();
                 return true;
             }          
        }catch(Exception e) {
            e.printStackTrace();
        }
         return false;
      }
     
     public boolean checkUser(Account user) throws Exception{
         try{
         String dbURL = "jdbc:sqlserver://localhost;databaseName=UserInfor;user=sa;password=123456";
         Connection conn = DriverManager.getConnection(dbURL);
         String query = "Select * FROM users WHERE username ='" + user.getUserName();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
              return true;
            }
           
            conn.close();
        }catch(Exception e) {
            throw e;
        }
        return false;
      }
                         
}



