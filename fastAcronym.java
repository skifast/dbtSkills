
import java.awt.BorderLayout;
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

public class fastAcronym extends JFrame{
	public static Map<Character, String> fastHM; 
	public fastAcronym() {
		fastHM = new HashMap<>();
		fastHM.put('f', "fair");
		fastHM.put('a', "apologies");
		fastHM.put('s', "stick to values");
		fastHM.put('t', "truthful");
		
		setTitle("DBT Skills Quizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,500);
        
        setVisible(true);
	}
	
	public ArrayList<JButton> fastAcronymPanels() {
		ArrayList<JButton> buttonLst = new ArrayList<>();
		
        Container c=getContentPane();
        
        JPanel panel1=new JPanel();
        //setting the panel layout as null
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBackground(Color.blue);
        panel1.setBounds(0,0,600, 100);
        
        
        JLabel acronyms = new JLabel();
		acronyms.setText("Fast Acronym");
		panel1.add(acronyms);
        
        JButton previous = new JButton(); 
		previous.setText("Back");
		panel1.add(previous);
		previous.setPreferredSize(new Dimension(50, 150));
		buttonLst.add(previous);
		
		//Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        //setting the panel layout as null
        panel2.setLayout(new GridLayout(6, 1));
	
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		JLabel f = new JLabel();
		f.setText("F");
		panel2.add(f);
		JTextField fText = new JTextField();
		panel2.add(fText);
		JLabel a = new JLabel();
		a.setText("A");
		panel2.add(a);
		JTextField aText = new JTextField();
		panel2.add(aText);
		JLabel s = new JLabel();
		s.setText("S");
		panel2.add(s);
		JTextField sText = new JTextField();
		panel2.add(sText);
		JLabel t = new JLabel();
		t.setText("T");
		panel2.add(t);
		JTextField tText = new JTextField();
		panel2.add(tText);
		
		panel2.setBackground(Color.green.darker());
		panel2.setBounds(0,100,600, 500);
		
		//adding the panel to the Container of the JFrame
		JPanel panel3 = new JPanel();
		//panel3.setLayout(null);
        panel3.setBackground(Color.blue);
        panel3.setBounds(0, 450, 600, 500);

        JButton submit = new JButton(); 
        submit.setText("Submit");
		panel3.add(submit);
		//submit.setBounds(0, 320, 50, 350);
		buttonLst.add(submit);
		
		
		c.add(panel1);
	    c.add(panel2);
	    c.add(panel3);
		
	    return buttonLst;
	}
}
