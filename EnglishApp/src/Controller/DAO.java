/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.SubAns;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
         
   
        if(rs.next()) {
            if(rs.getString("userName").equals("") && rs.getString("password").equals("")){
                return false;
            }else{
                return true;
            }
        }
            
            conn.close();
        }catch(Exception e) {
            throw e;
        }
        return false;
      }
    
    // insert submit answers into db
    public boolean sumbitAns(SubAns sub){
        String query = "INSERT INTO Submit(ID, submitAns) VALUES(?,?)";
         try{
             PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setString(1, String.valueOf(sub.getId()));
             stmt.setString(2, sub.getSubmit());
             
             // excute
             stmt.executeUpdate();
             conn.close();
             return true;
         }catch(Exception e){
              e.printStackTrace();
         }
         return false;
    }
    
    public void reset(int id){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM Submit WHERE ID = " + id + ";");
            st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public int checkAns(){
        String query = "select count(ans) as score from Submit as sb, Answers as a where sb.ID = a.ID";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next());
                int score  = rs.getInt("score");
            return score;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
