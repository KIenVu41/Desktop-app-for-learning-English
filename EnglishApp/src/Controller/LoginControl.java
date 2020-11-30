/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import View.LoginSignUp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Admin
 */
public class LoginControl {
    private LoginSignUp lg;
    private Account acc;
    
    public LoginControl(LoginSignUp view){
        this.lg = view;
        lg.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
               acc = lg.getUser();
               if(checkUser(lg)){
                    lg.showMessage("Login succesfully!");
                }else{
                   lg.showMessage("Invalid username and/or password!");
                }             
            }catch(Exception ex){
                 lg.showMessage(ex.getStackTrace().toString());
            }
        }
        
    }
    
     public boolean checkUser(Account user) throws Exception {
       
         try{
                String dbURL = "jdbc:sqlserver://localhost;databaseName=UserInfor;user=sa;password=123456";
                Connection conn = DriverManager.getConnection(dbURL);
                String query = "Select * FROM userdb WHERE userName ='" + user.getUserName()
                + "' AND password ='" + user.getPass() + "'";
                PreparedStatement ps = conn.prepareStatement(query);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                if(rs.next()){
                    return true;}
                 conn.close();            
        }catch(Exception e) {
            throw e;
        }
        return false;
      }
}



