/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.VocabularyModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Vocabulary extends JFrame implements ActionListener{
    private JTable tbl;
    private JScrollPane jsp;
    private JComboBox cb;
    String[] chude = {"people","animal","plants", "colors", "jobs", "Locations"};
    String[] TuMoi = {"Id","Subjects","MeansEng","MeansVN"};
    DefaultTableModel model = new DefaultTableModel(TuMoi,0);
    private JButton tk, back;
    private JLabel cd;
    private JLabel ta;
    private JLabel tv;
    private JLabel them;
    private JTextField cdtf;
    private JTextField tatf;
    private JTextField tvtf;
    private JButton btnthem;
    private VocabularyModel md;
    private String userName;
    
    public Vocabulary(String name) {
        userName = name;
        getContentPane().setBackground(new Color(57, 75, 160));
        setSize(1120, 600);
        setTitle("Vocabulary");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setForeground(new Color(255, 240, 0));
        setResizable(false);
        
        tk = new JButton("Tim Kiem");
        tk.addActionListener(this);
        tk.setBounds(10,10,100,50);
        add(tk);
       
        cb = new JComboBox(chude);
        cb.setBounds(200,10,100,50);
        add(cb);
           
        tbl = new JTable();
        jsp = new JScrollPane(tbl);
        jsp.setViewportView(tbl);
        tbl.setModel(model);
        jsp.setBounds(500,10,600,500);
        add(jsp);
        
        them =new JLabel("ADD WORDS?");
        them.setForeground(new Color(255, 240, 0));
        them.setFont(new Font("Tahoma", Font.PLAIN, 24));
        them.setBounds(10, 100, 200,50);
        add(them);
        
        cd= new JLabel("Subject");
        cd.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cd.setForeground(new Color(255, 240, 0));
        cd.setBounds(10, 200, 100, 50);
        add(cd);
        
        cdtf= new JTextField();
        cdtf.setBounds(150,200, 200, 50);
        add(cdtf);
        
        ta= new JLabel("English");
        ta.setForeground(new Color(255, 240, 0));
        ta.setFont(new Font("Tahoma", Font.PLAIN, 18));
        ta.setBounds(10, 280, 100, 50);
        add(ta);
        
        tatf = new JTextField();
        tatf.setBounds(150,280, 200, 50);
        add(tatf);
        
        tv= new JLabel("VN");
        tv.setForeground(new Color(255, 240, 0));
        tv.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tv.setBounds(10, 360, 100, 50);
        add(tv);
        
        tvtf=new JTextField();
        tvtf.setBounds(150,360, 200, 50);
        add(tvtf);
        
        btnthem = new JButton("Add");
        btnthem.setBounds(10, 440, 100, 50);
        add(btnthem);
        
        back = new JButton("Back");
        back.setBounds(250, 440, 100, 50);
        add(back);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new mainFrame(userName).setVisible(true);
                setVisible(false);
                //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                md = thongtin();
                DAO ctrl = new DAO();
                if(ctrl.addWord(md, userName, model)){
                    JOptionPane.showMessageDialog(rootPane, "Add succesfully");
                }else{
                     JOptionPane.showMessageDialog(rootPane, "Cant add");
                }             
                //ctrl.getWord(model, String.valueOf(cb.getSelectedItem()));
            }
        });
        
        
    }
    public void remove(){
        for(int i = model.getRowCount() - 1; i >= 0; i-- ){
            model.removeRow(i);
        }
    }
    
    public VocabularyModel thongtin(){
        DAO ctrl = new DAO();
        VocabularyModel m = new VocabularyModel(ctrl.maxid()+1,cdtf.getText(),tatf.getText(),tvtf.getText());
        return m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tk){
          DAO dao = new DAO();
          String cd = String.valueOf(cb.getSelectedItem());
          remove();
          dao.getWord(model ,cd);        
        } 
    }
    
}
