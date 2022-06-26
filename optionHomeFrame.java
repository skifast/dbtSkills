import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class optionHomeFrame extends JFrame{
	public optionHomeFrame() {
		setTitle("DBT Skills Quizers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,575);
        
        setVisible(true);
	}
	
	public OptionHomeBundle optionHomePanels(String titleText, String directionText) {
		ArrayList<JButton> buttonLst = new ArrayList<>();
		ArrayList<JPanel> panelLst = new ArrayList<>(); 
		Container c=getContentPane();
		c.setLayout(null);
        
		
        JPanel titlePanel =new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBackground(Color.blue);
        titlePanel.setBounds(0,0,600, 75);
        
        JLabel title = new JLabel(titleText);
        title.setForeground(Color.white);
        title.setBounds(250, 20, 150, 50);
        titlePanel.add(title);
        
        JButton previous = new JButton(); 
		previous.setText("Back");
		titlePanel.add(previous);
		previous.setBounds(30, 20, 100, 30);
		buttonLst.add(previous);
		
		
		JPanel directionsPanel = new JPanel();
		directionsPanel.setBounds(0, 75, 600, 30);
		directionsPanel.setBackground(Color.green.darker());
		
		JLabel directions = new JLabel();
		directions.setText(directionText);
		directions.setBounds(optionHomeFrame.WIDTH/2 - directionText.length() / 2, 10, directionText.length(), 30);
		directionsPanel.add(directions);
		
		JPanel panel2=new JPanel();
		
		panel2.setBounds(0, 105, 600, 350);
		panel2.setBackground(Color.green.darker());
		
		JPanel submissionPanel = new JPanel();
		submissionPanel.setLayout(null);
		submissionPanel.setBackground(Color.blue);
		submissionPanel.setBounds(0, 455, 600, 95);
		
		JButton submit = new JButton(); 
		submit.setText("Submit");
		submit.setBounds(125, 10, 100, 30);
		submissionPanel.add(submit);
		buttonLst.add(submit);
		
		JButton showAnswer = new JButton(); 
		showAnswer.setText("Show Solution");
		showAnswer.setBounds(225, 10, 150, 30);
		submissionPanel.add(showAnswer);
		buttonLst.add(showAnswer);
		
		JButton next = new JButton(); 
		next.setText("Next");
		next.setBounds(375, 10, 100, 30);
		submissionPanel.add(next);
		buttonLst.add(next);
		
		//result1 and result2 will display correct or 
		//incorrect and the solution
		JLabel result1 = new JLabel(); 
		result1.setBounds(10, 40, 580, 20);
		result1.setForeground(Color.white);
		result1.setVisible(false);
		submissionPanel.add(result1);
		
		JLabel result2 = new JLabel(); 
		result2.setBounds(10, 70, 580, 20);
		result2.setForeground(Color.white);
		result2.setVisible(false);
		submissionPanel.add(result2);
		
		//adding the panels to the Container of the JFrame
        c.add(titlePanel);
        c.add(directionsPanel);
        c.add(panel2);
        c.add(submissionPanel);
        
        //adding the panels to a panel list
        panelLst.add(titlePanel);
        panelLst.add(panel2);
        panelLst.add(directionsPanel);
        panelLst.add(submissionPanel);
        
		OptionHomeBundle returnThis = new OptionHomeBundle(); 
		returnThis.assignValues(buttonLst, panelLst, c, result1, result2);
        setVisible(true);
        
        return returnThis;
	}
	

}
