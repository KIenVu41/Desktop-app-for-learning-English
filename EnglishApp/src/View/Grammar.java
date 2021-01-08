/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.GrammarModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 *
 * @author dell
 */
public class Grammar extends JFrame implements ActionListener{
    private JMenu nguphap1;
    private JMenu nguphap2;
    private JMenu nguphap3;
    private JMenu nguphap4;
    private JMenu nguphap5;
    private JMenu nguphap6;
    private JMenu exit;
    private JTextArea jta;
    private JScrollPane jsp;
    String userName;
    GrammarModel gm;
    @Override
    public void actionPerformed(ActionEvent e) {
        
     }
    public Grammar(String name) {
        userName = name;
        setSize(660,700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        JMenuBar mngr = new JMenuBar();
 
        nguphap1 = new JMenu("Tense");
        nguphap2 = new JMenu("Passive Voice");
        nguphap3 = new JMenu("Gerund and infinitive");
        nguphap4 = new JMenu("Conditional sentences");
        nguphap5= new JMenu("Comparison");
        nguphap6=new JMenu("Clause");
        exit = new JMenu("Exit");
        
      
        mngr.add(nguphap1);
        mngr.add(nguphap2);
        mngr.add(nguphap3);
        mngr.add(nguphap4);
        mngr.add(nguphap5);
        mngr.add(nguphap6);
        mngr.add(exit);
        add(mngr,BorderLayout.NORTH);
        
       
        jta=new JTextArea();
        jsp=new JScrollPane(jta);
        add(jsp,BorderLayout.CENTER);
        
      
        nguphap1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {   
                gm = new GrammarModel();
                gm.setSubjects(nguphap1.getText());
                getTextGrammar();
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
         nguphap2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gm = new GrammarModel();
                gm.setSubjects(nguphap2.getText());
                getTextGrammar();
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
          nguphap3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gm = new GrammarModel();
                gm.setSubjects(nguphap3.getText());
                getTextGrammar();
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
          nguphap4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gm = new GrammarModel();
                 gm.setSubjects(nguphap4.getText());
                getTextGrammar();
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
          nguphap5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gm = new GrammarModel();
               gm.setSubjects(nguphap5.getText());
                getTextGrammar();
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
          nguphap6.addMouseListener((new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gm = new GrammarModel();
               gm.setSubjects(nguphap6.getText());
               getTextGrammar();
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
            
        }));
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new mainFrame(userName).setVisible(true);
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
        
         jta.setBackground(new Color(57, 75, 160));
         jta.setForeground(new Color(255, 240, 0));
    }
    
    public void getTextGrammar(){
       DAO d = new DAO();
       d.getGrammar(jta, gm);
    }
            
}
