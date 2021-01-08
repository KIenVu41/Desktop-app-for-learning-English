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
public class GrammarModel {
    private String subjects;

    public GrammarModel() {
    }
    
    public GrammarModel(String subjects) {
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
    
}
