/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DAO;
import Model.SubAns;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Admin
 */
public class test extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnSub;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
        SubAns sub;
        
	// create jFrame with radioButton and JButton
	public test(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnSub = new JButton("Submit");
		btnNext.addActionListener((ActionListener) this);
		btnSub.addActionListener((ActionListener) this);
		add(btnNext);
		add(btnSub);
		set();
		label.setBounds(30, 40, 900, 50);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(270, 240, 100, 30);
		btnSub.setBounds(100, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(500, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			//if (check())
				//count = count + 1; 
                                //System.out.println(bg.getSelection().getActionCommand());
			current++;
			set();
			if (current == 24) {
				btnNext.setText("Result");
			}
		}
                if (e.getSource() == btnSub) {
                        btnSubmit_actionperformed();
                }
                
		if (e.getActionCommand().equals("Result")) {
			/*if (check())
				count = count + 1;*/
                        DAO d = new DAO();
                        int score = d.checkAns();
			JOptionPane.showMessageDialog(this, "correct answers= " + score);
                        btnResult_reset();
                        System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
                radioButton[4].setSelected(true);
                                 
		if (current == 0) {
			label.setText("Que1. Malaysia is divided.....................two regions.");
			radioButton[0].setText("to");
			radioButton[1].setText("on");
			radioButton[2].setText("in");
			radioButton[3].setText("into");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("to");
                        radioButton[1].setActionCommand("on");
                        radioButton[2].setActionCommand("in");
                        radioButton[3].setActionCommand("into");
		}
		if (current == 1) {
			label.setText("Que2. She often goes to the..........to pray because her regions is Islam.");
			radioButton[0].setText("church");
			radioButton[1].setText("pagoda");
			radioButton[2].setText("temple");
			radioButton[3].setText("mosque");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("church");
                        radioButton[1].setActionCommand("pagoda");
                        radioButton[2].setActionCommand("temple");
                        radioButton[3].setActionCommand("mosque");
		}
		if (current == 2) { 
			label.setText("Que3. Mary was really.............by the beauty of Hanoi.");
			radioButton[0].setText("impress");
			radioButton[1].setText("impression");
			radioButton[2].setText("impressive");
			radioButton[3].setText("impressed");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("impress");
                        radioButton[1].setActionCommand("impression");
                        radioButton[2].setActionCommand("impressive");
                        radioButton[3].setActionCommand("impressed");
		}
		if (current == 3) { 
			label.setText("Que4. The United State has a..............of around 250 million.");
			radioButton[0].setText("population");
			radioButton[1].setText("separation");
			radioButton[2].setText("addition");
			radioButton[3].setText("introduction");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("population");
                        radioButton[1].setActionCommand("separation");
                        radioButton[2].setActionCommand("addition");
                        radioButton[3].setActionCommand("introduction");
		}
		if (current == 4) {
			label.setText("Que5. It’s very kind..............you to say so!");
			radioButton[0].setText("in");
			radioButton[1].setText("to");
			radioButton[2].setText("for");
			radioButton[3].setText("of");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("in");
                        radioButton[1].setActionCommand("to");
                        radioButton[2].setActionCommand("for");
                        radioButton[3].setActionCommand("of");
		}
		if (current == 5) {
			label.setText("Que6. I wish Susan...............harder for her examination.");
			radioButton[0].setText("will work");
			radioButton[1].setText("worked");
			radioButton[2].setText("has worked");
			radioButton[3].setText("works");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("will work");
                        radioButton[1].setActionCommand("worked");
                        radioButton[2].setActionCommand("has worked");
                        radioButton[3].setActionCommand("works");
		}
		if (current == 6) {
			label.setText("Que7. The ‘ao dai’ is the...............dress of Vietnamese women.");
			radioButton[0].setText("beautiful");
			radioButton[1].setText("traditional");
			radioButton[2].setText("casual");
			radioButton[3].setText("baggy");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("beautiful");
                        radioButton[1].setActionCommand("traditional");
                        radioButton[2].setActionCommand("casual");
                        radioButton[3].setActionCommand("baggy");
		}
		if (current == 7) {
			label.setText("Que8:  He...............with friends in apartment in HCMC since last week.");
			radioButton[0].setText("living");
			radioButton[1].setText("has lived");
			radioButton[2].setText("lived");
			radioButton[3].setText("live");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("living");
                        radioButton[1].setActionCommand("has lived");
                        radioButton[2].setActionCommand("lived");
                        radioButton[3].setActionCommand("live");
		}
		if (current == 8) {
			label.setText("Que9: They often go to that...............to pray.");
			radioButton[0].setText("market");
			radioButton[1].setText("hotel");
			radioButton[2].setText("hostel");
			radioButton[3].setText("shrine");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("market");
                        radioButton[1].setActionCommand("hotel");
                        radioButton[2].setActionCommand("hostel");
                        radioButton[3].setActionCommand("shrine");
		}
		if (current == 9) {
			label.setText("Que10: There is a small bamboo...............at the entrance to the village.");
			radioButton[0].setText("forest");
			radioButton[1].setText("forestation");
			radioButton[2].setText("forest ranger");
			radioButton[3].setText("forestry");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("forest");
                        radioButton[1].setActionCommand("forestation");
                        radioButton[2].setActionCommand("forest ranger");
                        radioButton[3].setActionCommand("forestry");
		}
                if (current == 10) {
			label.setText("Que11: There is a meeting..................9 AM and 2 PM.");
			radioButton[0].setText("on");
			radioButton[1].setText("between");
			radioButton[2].setText("till");
			radioButton[3].setText("at");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("on");
                        radioButton[1].setActionCommand("between");
                        radioButton[2].setActionCommand("till");
                        radioButton[3].setActionCommand("at");
		}
                if (current == 11) {
			label.setText("Que12: He was born..............15th, January.");
			radioButton[0].setText("in");
			radioButton[1].setText("of");
			radioButton[2].setText("at");
			radioButton[3].setText("on");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("in");
                        radioButton[1].setActionCommand("of");
                        radioButton[2].setActionCommand("at");
                        radioButton[3].setActionCommand("on");
		}
                if (current == 12) {
			label.setText("Que13: We have lived in Hanoi............... 4 years.");
			radioButton[0].setText("in");
			radioButton[1].setText("since");
			radioButton[2].setText("for");
			radioButton[3].setText("at");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("in");
                        radioButton[1].setActionCommand("since");
                        radioButton[2].setActionCommand("for");
                        radioButton[3].setActionCommand("at");
		}
                if (current == 13) {
			label.setText("Que14: We have many well.............. teachers here.");
			radioButton[0].setText("qualify");
			radioButton[1].setText("quality");
			radioButton[2].setText("qualified");
			radioButton[3].setText("qualification");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("qualify");
                        radioButton[1].setActionCommand("quality");
                        radioButton[2].setActionCommand("qualified");
                        radioButton[3].setActionCommand("qualification");
		}
                if (current == 14) {
			label.setText("Que15: She asked me where I.............. from.");
			radioButton[0].setText("come");
			radioButton[1].setText("came");
			radioButton[2].setText("to come");
			radioButton[3].setText("coming");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("come");
                        radioButton[1].setActionCommand("came");
                        radioButton[2].setActionCommand("to come");
                        radioButton[3].setActionCommand("coming");
		}
                if (current == 15) {
			label.setText("Que16: What aspect of................ English do you find difficult?");
			radioButton[0].setText("study");
			radioButton[1].setText("studied");
			radioButton[2].setText("learn");
			radioButton[3].setText("learning");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("study");
                        radioButton[1].setActionCommand("studied");
                        radioButton[2].setActionCommand("learn");
                        radioButton[3].setActionCommand("learning");
		}
                if (current == 16) {
			label.setText("Que17: Who told you of the news? The.............. may not be correct.");
			radioButton[0].setText("inform");
			radioButton[1].setText("information");
			radioButton[2].setText("informational");
			radioButton[3].setText("informative");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("inform");
                        radioButton[1].setActionCommand("information");
                        radioButton[2].setActionCommand("informational");
                        radioButton[3].setActionCommand("informative");
		}
                if (current == 17) {
			label.setText("Que18: She thinks chatting on the Internet is time.............");
			radioButton[0].setText("consume");
			radioButton[1].setText("consumer");
			radioButton[2].setText("consuming");
			radioButton[3].setText("consumption");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("consume");
                        radioButton[1].setActionCommand("consumer");
                        radioButton[2].setActionCommand("consuming");
                        radioButton[3].setActionCommand("consumption");
		}
                if (current == 18) {
			label.setText("Que19: Can you tell me who ...............this kind of machine?");
			radioButton[0].setText("invented");
			radioButton[1].setText("invention");
			radioButton[2].setText("inventor");
			radioButton[3].setText("inventive");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("invented");
                        radioButton[1].setActionCommand("invention");
                        radioButton[2].setActionCommand("inventor");
                        radioButton[3].setActionCommand("inventive");
		}
                if (current == 19) {
			label.setText("Que20: Your teacher writes poems or stories,...............she?");
			radioButton[0].setText("don’t");
			radioButton[1].setText("won’t");
			radioButton[2].setText("didn’t");
			radioButton[3].setText("doesn’t");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("don’t");
                        radioButton[1].setActionCommand("won’t");
                        radioButton[2].setActionCommand("didn’t");
                        radioButton[3].setActionCommand("doesn’t");
		}
                if (current == 20) {
			label.setText("Que21: Excuse me. Can I................in this area?");
			radioButton[0].setText("smoke");
			radioButton[1].setText("smoking");
			radioButton[2].setText("smoked");
			radioButton[3].setText("to smoke");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("smoke");
                        radioButton[1].setActionCommand("smoking");
                        radioButton[2].setActionCommand("smoked");
                        radioButton[3].setActionCommand("to smoke");
		}
                if (current == 21) {
			label.setText("Que22: If he...............a student, he will get a discount.");
			radioButton[0].setText("is");
			radioButton[1].setText("was");
			radioButton[2].setText("were");
			radioButton[3].setText("will be");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("is");
                        radioButton[1].setActionCommand("was");
                        radioButton[2].setActionCommand("were");
                        radioButton[3].setActionCommand("will be");
		}
                if (current == 22) {
			label.setText("Que23: Can you turn..............the light? It’s too dark.");
			radioButton[0].setText("on");
			radioButton[1].setText("off");
			radioButton[2].setText("in");
			radioButton[3].setText("for");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("on");
                        radioButton[1].setActionCommand("off");
                        radioButton[2].setActionCommand("in");
                        radioButton[3].setActionCommand("for");
		}
                if (current == 23) {
			label.setText("Que24: We can..............easily in the daylight.");
			radioButton[0].setText("to read");
			radioButton[1].setText("reading");
			radioButton[2].setText("reads");
			radioButton[3].setText("read");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("to read");
                        radioButton[1].setActionCommand("reading");
                        radioButton[2].setActionCommand("reads");
                        radioButton[3].setActionCommand("read");
		}
                if (current == 24) {
			label.setText("Que25: What can we do to spend less...............lighting?");
			radioButton[0].setText("in");
			radioButton[1].setText("on");
			radioButton[2].setText("about");
			radioButton[3].setText("of");
                        
                        // set action command for radiobutton
                        radioButton[0].setActionCommand("in");
                        radioButton[1].setActionCommand("on");
                        radioButton[2].setActionCommand("about");
                        radioButton[3].setActionCommand("of");
		}
                
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}
         /*
	// declare right answers.
	boolean check() {      
            DAO dao = new DAO();
		if (current == 0)
			return (radioButton[3].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[3].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
                if (current == 10)
			return (radioButton[1].isSelected());
                if (current == 11)
			return (radioButton[3].isSelected());
                if (current == 12)
			return (radioButton[2].isSelected());
                if (current == 13)
			return (radioButton[2].isSelected());
                if (current == 14)
			return (radioButton[1].isSelected());
                if (current == 15)
			return (radioButton[3].isSelected());
                if (current == 16)
			return (radioButton[1].isSelected());
                if (current == 17)
			return (radioButton[2].isSelected());
                if (current == 18)
			return (radioButton[0].isSelected());
                if (current == 19)
			return (radioButton[3].isSelected());
                if (current == 20)
			return (radioButton[0].isSelected());
                if (current == 21)
			return (radioButton[2].isSelected());
                if (current == 22)
			return (radioButton[0].isSelected());
                if (current == 23)
			return (radioButton[3].isSelected());
                if (current == 24)
			return (radioButton[2].isSelected());                
		return false;
	}
        
       */

	public static void main(String s[]) {
		new test("Online Test App");
	}
        
        // get submit answers
        public SubAns getUserSubmit(){
            sub = new SubAns(current + 1, bg.getSelection().getActionCommand());
            return sub;
        }
        
        public void btnSubmit_actionperformed(){
            sub = getUserSubmit();
            DAO d = new DAO();
            if(d.sumbitAns(sub)){
                JOptionPane.showMessageDialog(this, "your answer has been submitted");
            }else{
                JOptionPane.showMessageDialog(this, "Error!!");
            }   
        }
        
        public void btnResult_reset(){
            DAO d = new DAO();
            for(int i = 1; i <= 25; i++){
                 d.reset(i);
            }       
        }
}
