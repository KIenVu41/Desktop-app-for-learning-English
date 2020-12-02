/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
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
public class DAO {
    private Connection conn;
    
    public DAO() {
        String dbURL = "jdbc:sqlserver://localhost;databaseName=UserInfor;user=sa;password=123456";
        try{
        conn = DriverManager.getConnection(dbURL);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean Signup(Account user){
         String query = "INSERT INTO userdb(userName, password) VALUES(?,?)";
         try{
             PreparedStatement stmt = conn.prepareStatement(query);
                 stmt.setString(1, user.getUserName());
                 stmt.setString(2, user.getPass());
                 
                 // excute
                 stmt.executeUpdate();
                 conn.close();
                 return true;
         }catch(Exception e){
              e.printStackTrace();
         }
         return false;
    }
    
    public boolean checkUser(Account user) throws Exception{
         try{   
         String query =  "Select * FROM userdb WHERE userName ='"
+ user.getUserName() + "' AND password ='"
+ user.getPass() + "'";
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
