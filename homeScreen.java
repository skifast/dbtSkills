
import java.awt.BorderLayout;
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

//import dbtSkills.acronymHome;;

public class homeScreen extends JFrame{
	
	public homeScreen(){
		setTitle("DBT Skills Quizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,575);
        
        setVisible(true);
	}
	
	public ArrayList<Button> homescreenPanels() {
		ArrayList<Button> buttonLst = new ArrayList<>();
        
        Container c=getContentPane();
        
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0, 600, 75);
        JLabel welcome = new JLabel();
        welcome.setText("Welcome to the DBT Skills Quizer");
        panel1.add(welcome);
        panel1.setBackground(Color.green.darker());
        panel1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
        //Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        //setting the panel layout as null
        panel2.setLayout(new GridLayout(4, 1));
        
        Button btn_0 = new Button("Definitions");
		btn_0.setBackground(Color.green.darker());
		btn_0.setPreferredSize(new Dimension(400, 75)); 
        
		Button btn_1 = new Button("Acronyms");
		btn_1.setBackground(Color.green.darker());
		btn_1.setPreferredSize(new Dimension(400, 75)); 

		Button btn_2 = new Button("Skill Match");
		btn_2.setBackground(Color.green.darker());
		btn_2.setPreferredSize(new Dimension(400, 75)); 

		Button btn_3 = new Button("Situations");
		btn_3.setBackground(Color.green.darker());
		btn_3.setPreferredSize(new Dimension(400, 75));    

		buttonLst.add(btn_0);
		buttonLst.add(btn_1);
		buttonLst.add(btn_2);
		buttonLst.add(btn_3);
		

		JPanel cell0 = new JPanel();
		cell0.add(btn_0);
		cell0.setBackground(Color.green.darker());
		panel2.add(cell0);
		JPanel cell1 = new JPanel();
		cell1.add(btn_1);
		cell1.setBackground(Color.green.darker());
		panel2.add(cell1);
		JPanel cell2 = new JPanel();
		cell2.add(btn_2);
		cell2.setBackground(Color.green.darker());
		panel2.add(cell2);
		JPanel cell3 = new JPanel();
		cell3.add(btn_3);
		cell3.setBackground(Color.green.darker());
		panel2.add(cell3);
		
		panel2.setBounds(0,75,600, 500);
		
		//adding the panel to the Container of the JFrame
		c.add(panel1);
		c.add(panel2);
        setVisible(true);
        
        return buttonLst;
	}
	
	public void acronymscreenPanels() {
		//mainFrame = frame; 
		//frame.dispose();
		
		//setTitle("DBT Skills Quizers");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(null);
        //setting the bounds for the JFrame
        //setBounds(0,0,600,575);
        
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
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame2 = new homeScreen();
			}
		});
        
        
        //Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        //setting the panel layout as null
        panel2.setLayout(new GridLayout(6, 1));
        
        JButton fast = new JButton();
		fast.setText("FAST");
		panel2.add(fast);
		fast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("hello stupid");
				//fastAcronym();
			}
		});
		
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
