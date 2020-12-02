/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


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
  
}


