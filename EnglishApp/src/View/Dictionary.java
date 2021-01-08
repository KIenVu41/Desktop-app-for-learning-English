/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.ModelDictionary;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Dictionary  implements ActionListener{
    public JFrame mainFrame;
    public JPanel nen1Panel;
    public JButton Settingbtn, btnExit;
    public JTable tbTable;
    public ModelDictionary model_dictionary;
    String userName;
 
    
     public Dictionary(String name) {
        userName = name;
        dictionary();
    }
     
    public void dictionary(){
        mainFrame = new JFrame("Dictionary");   
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        nen1Panel = new JPanel( new BorderLayout());
        JPanel tsxPanel = new JPanel(new FlowLayout());
        
        Settingbtn = new JButton("Setting");
        Settingbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                setting();
            }
        });
        tsxPanel.add(Settingbtn);
       
        btnExit = new JButton("Exit");
        tsxPanel.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                new mainFrame(userName).setVisible(true);
            }
        });
        
        String data[][] = {{null, null, null},{null, null, null},
                           {null, null, null},{null, null, null},};
        String column[] = {"Words", "Type of word", "Translate"};
        
        tbTable = new JTable(data, column);
        JScrollPane bang = new JScrollPane(tbTable);
        nen1Panel.add(bang, BorderLayout.CENTER);
        nen1Panel.add(tsxPanel, BorderLayout.NORTH);
        
        DAO d = new DAO();
        d.show(Dictionary.this);
        
        mainFrame.setBounds(400, 150, 600, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainFrame.add(nen1Panel);
        mainFrame.setVisible(true);
    }
    
    public JLabel TuDonJL;   
    public JLabel LoaiTuJL;
    public JLabel NghiaJL;  
    
    public JTextField TuDonTF;
    public JTextField LoaiTuTF;
    public JTextField NghiaTF;
    public JPanel nen2Panel;
    
    public void setting(){
        JFrame main = new JFrame("Setting");
        main.setResizable(false);
        main.setBounds(400, 150, 600, 500);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        nen2Panel = new JPanel(new BorderLayout());
        
        TuDonJL = new JLabel("Word");
        LoaiTuJL = new JLabel("Type of word");
        NghiaJL = new JLabel("Translate");
              
        TuDonTF = new JTextField();
        LoaiTuTF = new JTextField();
        NghiaTF = new JTextField();
            
        JPanel nhapPanel = new JPanel();
        GridLayout gl = new GridLayout(3,2);
        gl.setVgap(10);
        gl.setHgap(10);
        nhapPanel.setLayout(gl);
        
        nhapPanel.add(TuDonJL);
        nhapPanel.add(TuDonTF);
        nhapPanel.add(LoaiTuJL);
        nhapPanel.add(LoaiTuTF);
        nhapPanel.add(NghiaJL);
        nhapPanel.add(NghiaTF);
              
        nen2Panel.add(nhapPanel, BorderLayout.NORTH);
        
        JButton back = new JButton("Back");
        JButton sua = new JButton("Alter");
        JButton xoa = new JButton("Delete");   
        JButton tim = new JButton("Search");
        
        JPanel buttonLaytout = new JPanel(new FlowLayout());
        buttonLaytout.add(sua);
        buttonLaytout.add(xoa);
        buttonLaytout.add(tim);
        buttonLaytout.add(back);
        nen2Panel.add(buttonLaytout, BorderLayout.CENTER);
        
        String data[][] = {{null, null, null},
        {null, null, null},
        {null, null, null}};
        String column[] = {"Words", "Type of word", "Translate"};
        tbTable = new JTable(data, column);
        JScrollPane bang = new JScrollPane(tbTable);
        
        main.add(nen2Panel, BorderLayout.NORTH);
        main.add(bang, BorderLayout.CENTER);
        
        DAO d = new DAO();    
        d.show(Dictionary.this);
        tbTable.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){
    //            int row=tbTable.rowAtPoint(e.getPoint());
    //            int col=tbTable.columnAtPoint(e.getPoint());
                int row = tbTable.getSelectedRow();
                String[] r = new String[tbTable.getColumnCount()];
                for (int i = 0; i < tbTable.getColumnCount(); i++) {
                    r[i] = tbTable.getModel().getValueAt(row, i).toString();
                }
                TuDonTF.setText(r[0]);
                LoaiTuTF.setText(r[1]);
                NghiaTF.setText(r[2]);
 
            }
        });
        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO d = new DAO();
                model_dictionary = getWord();
                d.Sua(model_dictionary, Dictionary.this, userName);
            }
        });
        
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO d = new DAO();
                model_dictionary = getWord();
                if(d.Xoa(Dictionary.this, model_dictionary)){
                    JOptionPane.showMessageDialog(nen1Panel, "Delete successfully");
                }else{
                    JOptionPane.showMessageDialog(nen1Panel, "Cant delete");
                }
            }
        });
        tim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO d = new DAO();
                model_dictionary = getWord();
                d.Tim(Dictionary.this, model_dictionary);
          }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                Dictionary.this.dictionary();
                mainFrame.setVisible(true);
            }
        });
        mainFrame.setVisible(false);
        main.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    
    public ModelDictionary getWord(){
        ModelDictionary md = new ModelDictionary(TuDonTF.getText(), LoaiTuTF.getText(), NghiaTF.getText());
        return md;
    }
}
