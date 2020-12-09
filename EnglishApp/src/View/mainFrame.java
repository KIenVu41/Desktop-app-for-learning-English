/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class mainFrame extends JFrame implements ActionListener{
  
    JMenu home;
    JMenu voca;
    JMenu grammar;
    JMenu listen;
    JMenu test;
    JMenu exit;
 
    
    public mainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(30,200,500,200);
        setTitle("EnglishApp");
        setVisible(true);
        setResizable(false);
        
        JMenuBar menu = new JMenuBar();
        home = new JMenu("Home");
        voca = new JMenu("Dictionary");
        grammar = new JMenu("Grammar");
        listen = new JMenu("Listen");
        test = new JMenu("Test");
        exit = new JMenu("Exit");
        
        menu.add(home);
        menu.add(voca);
        menu.add(grammar);
        menu.add(listen);
        menu.add(test);
        menu.add(exit);
     
        add(menu, BorderLayout.NORTH);

        test.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {     
                   test t = new test("eng");
                   t.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                 //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new Signin().setVisible(true);
            }   

            @Override
            public void mousePressed(MouseEvent e) {    
            }

            @Override
            public void mouseReleased(MouseEvent e) {     
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      
    }
    		
}
