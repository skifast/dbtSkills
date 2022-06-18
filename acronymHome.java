
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

public class acronymHome extends JFrame{
	public JFrame mainFrame; 
	public JFrame acronymHome; 
	public int frameNumber; 
	
	public acronymHome() {
		setTitle("DBT Skills Quizers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,500);
        
        setVisible(true);
	}
	
	public ArrayList<JButton> acronymscreenPanels() {
		ArrayList<JButton> buttonLst = new ArrayList<>();
		//mainFrame = frame; 
		//frame.dispose();
		
		setTitle("DBT Skills Quizers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,575);
        
        Container c=getContentPane();
        
        JPanel panel1=new JPanel();
        //setting the panel layout as null
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBackground(Color.blue);
        panel1.setBounds(0,0,600, 100);
        
        
        JLabel acronyms = new JLabel();
		acronyms.setText("Acronyms");
		panel1.add(acronyms);
        
        JButton previous = new JButton(); 
		previous.setText("Back");
		panel1.add(previous);
		previous.setBounds(50, 0, 100, 50);
		//previous.setPreferredSize(new Dimension(200, 50));
        
        
        //Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        //setting the panel layout as null
        panel2.setLayout(new GridLayout(6, 1));
        
        JButton fast = new JButton();
		fast.setText("FAST");
		panel2.add(fast);
		
		JButton give = new JButton();
		give.setText("GIVE");
		panel2.add(give);
		give.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//giveAcronym();
			}
		});
		
		JButton dearman = new JButton();
		dearman.setText("DEARMAN");
		panel2.add(dearman);
		dearman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//dearmanAcronym();
			}
		});
		
		JButton abcplease = new JButton();
		abcplease.setText("ABC PLEASE");
		panel2.add(abcplease);
		abcplease.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//abcpleaseAcronym();
			}
		});
		
		JButton stop = new JButton();
		stop.setText("STOP");
		panel2.add(stop);
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//stopAcronym();
			}
		});
		
		JButton tipp = new JButton();
		tipp.setText("TIPP");
		panel2.add(tipp);
		tipp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//tippAcronym();
			}
		});
		
		buttonLst.add(previous);
		buttonLst.add(fast);
		buttonLst.add(give);
		buttonLst.add(dearman);
		buttonLst.add(abcplease);
		buttonLst.add(tipp);
		
       
		JPanel cell1 = new JPanel();
		cell1.add(fast);
		cell1.setBackground(Color.green.darker());
		panel2.add(cell1);
		JPanel cell2 = new JPanel();
		cell2.add(give);
		cell2.setBackground(Color.green.darker());
		panel2.add(cell2);
		JPanel cell3 = new JPanel();
		cell3.add(dearman);
		cell3.setBackground(Color.green.darker());
		panel2.add(cell3);
		JPanel cell4 = new JPanel();
		cell4.add(abcplease);
		cell4.setBackground(Color.green.darker());
		panel2.add(cell4);
		JPanel cell5 = new JPanel();
		cell5.add(stop);
		cell5.setBackground(Color.green.darker());
		panel2.add(cell5);
		JPanel cell6 = new JPanel();
		cell6.add(tipp);
		cell6.setBackground(Color.green.darker());
		panel2.add(cell6);
		
		panel2.setBackground(Color.magenta);
		panel2.setBounds(0,100,600, 500);
		
		//adding the panel to the Container of the JFrame
        c.add(panel1);
        c.add(panel2);

        setVisible(true);
        
        return buttonLst;
	}
	
	public void fastAcronym() {

		setTitle("DBT Skills Quizers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,575);
        
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
		//previous.setPreferredSize(new Dimension(200, 50));
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new acronymHome();
			}
		});
        
        
		Map<Character, String> fastHM = new HashMap<>();
		fastHM.put('f', "fair");
		fastHM.put('a', "apologies");
		fastHM.put('s', "stick to values");
		fastHM.put('t', "truthful");
		
		
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
        c.add(panel1);
        c.add(panel2);
        
        setVisible(true);
	}
}
