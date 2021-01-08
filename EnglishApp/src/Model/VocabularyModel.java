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
public class VocabularyModel {
    int id;
    String chude;
    String tienganh;
    String tiengviet;

    public VocabularyModel(int id, String chude, String tienganh, String tiengviet) {
        this.id = id;
        this.chude = chude;
        this.tienganh = tienganh;
        this.tiengviet = tiengviet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChude() {
        return chude;
    }

    public void setChude(String chude) {
        this.chude = chude;
    }

    public String getTienganh() {
        return tienganh;
    }

    public void setTienganh(String tienganh) {
        this.tienganh = tienganh;
    }

    public String getTiengviet() {
        return tiengviet;
    }

    public void setTiengviet(String tiengviet) {
        this.tiengviet = tiengviet;
    }
    
}
