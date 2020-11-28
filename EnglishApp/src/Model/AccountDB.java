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
public class AccountDB {
    // phuong thuc nay lay du lieu va tao account
    public static Account getAccount(){
        Account acc = new Account();
        acc.setUserName("");
        acc.setPass("");
        return acc;
    }
}
