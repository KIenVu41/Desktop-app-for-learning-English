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

    public Account(String pass, String userName) {
        this.password = pass;
        this.userName = userName;
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
    
    public boolean checkLogin(String name, String pass){
        return (userName == name && password == pass);
    }
}


