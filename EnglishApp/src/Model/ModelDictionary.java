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
public class ModelDictionary {
    private String TuDon;
    private String LoaiTu;
    private String Nghia;

    public ModelDictionary() {
    }

    public ModelDictionary(String TuDon, String LoaiTu, String Nghia) {
        this.TuDon = TuDon;
        this.LoaiTu = LoaiTu;
        this.Nghia = Nghia;
    }

    public String getTuDon() {
        return TuDon;
    }

    public void setTuDon(String TuDon) {
        this.TuDon = TuDon;
    }

    public String getLoaiTu() {
        return LoaiTu;
    }

    public void setLoaiTu(String LoaiTu) {
        this.LoaiTu = LoaiTu;
    }

    public String getNghia() {
        return Nghia;
    }

    public void setNghia(String Nghia) {
        this.Nghia = Nghia;
    }
    
}
