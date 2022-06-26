
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class acronymHome extends optionHomeFrame{
	public JFrame mainFrame; 
	public JFrame acronymHome; 
	public int frameNumber; 
	
	public acronymHome() {
		
	}
	
	public ArrayList<JButton> acronymscreenPanels(ArrayList<JButton> buttonLst, JPanel panel2) {
        panel2.setLayout(new GridLayout(4, 2));
        
        //create acronym buttons
        JButton fast = new JButton();
		fast.setText("FAST");
		panel2.add(fast);
		JButton give = new JButton();
		give.setText("GIVE");
		panel2.add(give);
		JButton dearman = new JButton();
		dearman.setText("DEARMAN");
		panel2.add(dearman);
		JButton abcplease = new JButton();
		abcplease.setText("ABC PLEASE");
		panel2.add(abcplease);
		JButton stop = new JButton();
		stop.setText("STOP");
		panel2.add(stop);
		JButton tipp = new JButton();
		tipp.setText("TIPP");
		panel2.add(tipp);
		JButton accepts = new JButton();
		accepts.setText("ACCEPTS");
		panel2.add(accepts);
		JButton improve = new JButton();
		improve.setText("IMPROVE");
		panel2.add(improve);
		
		//add acronym buttons to list
		buttonLst.add(fast);
		buttonLst.add(give);
		buttonLst.add(dearman);
		buttonLst.add(abcplease);
		buttonLst.add(stop);
		buttonLst.add(tipp);
		buttonLst.add(accepts);
		buttonLst.add(improve);
       
		JPanel cell1 = new JPanel();
		cell1.add(fast);
		cell1.setBackground(Color.green.darker());
		cell1.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		panel2.add(cell1);
		JPanel cell2 = new JPanel();
		cell2.add(give);
		cell2.setBackground(Color.green.darker());
		cell2.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));
		panel2.add(cell2);
		JPanel cell3 = new JPanel();
		cell3.add(dearman);
		cell3.setBackground(Color.green.darker());
		cell3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel2.add(cell3);
		JPanel cell4 = new JPanel();
		cell4.add(abcplease);
		cell4.setBackground(Color.green.darker());
		cell4.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel2.add(cell4);
		JPanel cell5 = new JPanel();
		cell5.add(stop);
		cell5.setBackground(Color.green.darker());
		cell5.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel2.add(cell5);
		JPanel cell6 = new JPanel();
		cell6.add(tipp);
		cell6.setBackground(Color.green.darker());
		cell6.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel2.add(cell6);
		JPanel cell7 = new JPanel();
		cell7.add(accepts);
		cell7.setBackground(Color.green.darker());
		cell7.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel2.add(cell7);
		JPanel cell8 = new JPanel();
		cell8.add(improve);
		cell8.setBackground(Color.green.darker());
		cell8.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		panel2.add(cell8);
		
		panel2.setBounds(0,75, 600, 500);

        setVisible(true);
        
        return buttonLst;
	}
	
}