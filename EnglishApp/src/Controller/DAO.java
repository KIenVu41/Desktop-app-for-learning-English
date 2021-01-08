/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Account;
import Model.GrammarModel;
import Model.ModelDictionary;
import Model.SubAns;
import Model.VocabularyModel;
import View.Dictionary;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
        String query = "INSERT INTO Submit(ID, submitAns, userName) VALUES(?, ?, ?)";
         try{
             PreparedStatement stmt = conn.prepareStatement(query);
             stmt.setInt(1, sub.getId());
             stmt.setString(2, sub.getSubmit());
             stmt.setString(3, sub.getUserName());
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
    
    public void getWord(DefaultTableModel tv, String cd){
        
        String truyvan = "select* from Vocabulary Where subjects = '" + cd + "'";
        String []dulieu = new String[4];
        try {
            Statement lenh = conn.createStatement();
            ResultSet rs= lenh.executeQuery(truyvan);
            while(rs.next()){
                dulieu[0] = rs.getString(1);
                dulieu[1]= rs.getString(2);
                dulieu[2]= rs.getString(3);
                dulieu[3]= rs.getString(4);
                tv.addRow(dulieu);             
        }
            conn.close();               
        } catch (Exception e) {
        }
    
}
    public boolean addWord(VocabularyModel md, String name, DefaultTableModel model){
        String truyvan="insert into Vocabulary(ID ,subjects, MeansEng, MeansVn, userName) values (?,?,?,?,?) ";
        try {
            PreparedStatement ps = conn.prepareStatement(truyvan);
            ps.setInt(1, md.getId());
            ps.setString(2, md.getChude());
            ps.setString(3, md.getTienganh());
            ps.setString(4, md.getTiengviet());
            ps.setString(5, name);
            ps.executeUpdate();
            
            String query = "select * from Vocabulary Where subjects = '" + md.getChude() + "'" + "and ID = '" + md.getId() +"'";
            String []dulieu = new String[4];
        
            Statement lenh = conn.createStatement();
            ResultSet rs = lenh.executeQuery(query);
            if(rs.next()){
                dulieu[0]= rs.getString(1);
                dulieu[1]= rs.getString(2);
                dulieu[2]= rs.getString(3);
                dulieu[3]= rs.getString(4);
                model.addRow(dulieu);             
        }
            conn.close();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    public int maxid(){
        String truyvan="select max(ID) from Vocabulary";
        try {
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(truyvan);
            if (rs.next())
            {
                //return Integer.parseInt(rs.getString(1));
                return rs.getInt(1);
            }
        } catch (Exception e) {
        } return -1;
    }
    
    public void getGrammar(JTextArea jta, GrammarModel grammarModel){
        String query =  "select path from Grammar where name = '" + grammarModel.getSubjects() + "'";
        try{
            Statement lenh = conn.createStatement();
            ResultSet rs= lenh.executeQuery(query);
            if(rs.next()){
               File file = new File(rs.getString(1));
               InputStream inputStream = new FileInputStream(file);
               InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
               BufferedReader reader = new BufferedReader(inputStreamReader);
 
               String line = "";
               String newLine = "";
               while((line = reader.readLine()) != null){
                    newLine = newLine.concat(line + "\n");
               }
               jta.setText(newLine);
               
               reader.close();
               inputStream.close();
               inputStreamReader.close();
 
            }
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // dictionary
    public void show(Dictionary obj){
        try{
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery("select * from Dictionary");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Words");
            model.addColumn("Type of word");
            model.addColumn("Translate");
           
            while (rs.next() ){
                Object a[]={rs.getString(1),rs.getString(2), rs.getString(3)};
                model.addRow(a);
                }
            obj.tbTable.setModel(model);
            
            //System.out.println("Connection DB Thành Công!");
        } catch(Exception i) {
            System.out.println(i);
    }
    }
    
    
    public void Sua(ModelDictionary md, Dictionary obj, String name){
        try {
            PreparedStatement prest = conn.prepareStatement("UPDATE Dictionary SET typeOfWord =?, translate = ?, userName = ? WHERE words = ?;");  
            prest.setString(1, md.getLoaiTu());
            prest.setString(2, md.getNghia()); 
            prest.setString(3, name);
            prest.setString(4, md.getTuDon());
            
            prest.executeUpdate();
            prest.close();
               
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery("select * from Dictionary;");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Words");
            model.addColumn("Type of word");
            model.addColumn("Translate");
            while (rs.next() ){
                Object a[]={rs.getString(1),rs.getString(2), rs.getString(3)};
                model.addRow(a);
                }
            obj.tbTable.setModel(model); 
        } catch(Exception i) {
            System.out.println(i);  
    }
    }
    
    
     public void Tim(Dictionary obj, ModelDictionary md){  
            try {
      
            Statement st= conn.createStatement(); 
            ResultSet rs= st.executeQuery("select * from Dictionary;");
            boolean check=false;
           
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Words");
            model.addColumn("Type of word");
            model.addColumn("Translate"); 
            
            while (rs.next()){
                if (rs.getString(1).equals(md.getTuDon()) ){
                    check = true;
                    Object a[]={rs.getString(1),rs.getString(2), rs.getString(3)};
                    model.addRow(a);
                }
            }
            
            obj.tbTable.setModel(model);
            
            
        } catch(Exception i) {
            System.out.println(i);
    }
 }
     
      public boolean Xoa(Dictionary obj, ModelDictionary md){
       
        try {
            PreparedStatement prest = conn.prepareStatement("delete from Dictionary where words =?;");
            prest.setString(1, md.getTuDon());
            
            prest.executeUpdate();
            prest.close();
            
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery("select * from Dictionary;");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Words");
            model.addColumn("Type of word");
            model.addColumn("Translate"); 
            while (rs.next() ){
                Object a[]={rs.getString(1),rs.getString(2), rs.getString(3)};
                model.addRow(a);
                }
            obj.tbTable.setModel(model);
            conn.close();
            return true;
        } catch(Exception i) {
            System.out.println(i);
    }
        return false;
    }
         
}
