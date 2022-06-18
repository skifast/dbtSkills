
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class situationsHome extends JFrame{
	public situationsHome() {
		setTitle("DBT Skills Quizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,500);
        
        setVisible(true);
	}
	
	public ArrayList<JButton> situationsPanels() {
		ArrayList<JButton> buttonLst = new ArrayList<>();
		
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
		buttonLst.add(previous);
		//previous.setPreferredSize(new Dimension(200, 50));
        
        
        //Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        
		JLabel skill1 = new JLabel();
		skill1.setBounds(40, 40, 40, 20);
		skill1.setText("skill1");
		panel2.add(skill1);
		
		String[] optionsToChoose = {"Mindfulness", "Interpersonal Effectiveness", "Emotional Regulation", "Distress tolerance"};

		JComboBox<String> category1 = new JComboBox<>(optionsToChoose);
		category1.setBounds(80, 150, 160, 20);
		panel2.add(category1);
		
		 c.add(panel1);
	     c.add(panel2);
	        
		setVisible(true);
		return buttonLst; 
	}
}
