
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class skillMatchHome extends JFrame{
	Map<String, String> dbtSkillsCategories; 
	JComboBox<String> category1;
	JLabel skill1;
	ArrayList<String> dbtSkills; 
	JLabel result; 
	
	public skillMatchHome() {
		setTitle("DBT Skills Quizers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,500);
      
        assembleMap();
        assembleAL();
        
        setVisible(true);
	}
	
	public void assembleMap() {
		dbtSkillsCategories = new HashMap<>();
		dbtSkillsCategories.put("Wise Mind", "Mindfulness");
		dbtSkillsCategories.put("What Skill", "Mindfulness");
		dbtSkillsCategories.put("How Skill", "Mindfulness");
		
		dbtSkillsCategories.put("Dearman", "Interpersonal Effectiveness");
		dbtSkillsCategories.put("GIVE", "Interpersonal Effectiveness");
		dbtSkillsCategories.put("FAST", "Interpersonal Effectiveness");
		
		dbtSkillsCategories.put("Check the Facts", "Emotional Regulation");
		dbtSkillsCategories.put("Opposite Action", "Emotional Regulation");
		dbtSkillsCategories.put("Problem Solving", "Emotional Regulation");
		dbtSkillsCategories.put("ABC PLEASE", "Emotional Regulation");
		
		dbtSkillsCategories.put("STOP", "Distress tolerance");
		dbtSkillsCategories.put("TIPP", "Distress tolerance");
		dbtSkillsCategories.put("Distract with Accepts", "Distress tolerance");
		dbtSkillsCategories.put("Self-Soothing", "Distress tolerance");
		dbtSkillsCategories.put("Improve the Moment", "Distress tolerance");
		dbtSkillsCategories.put("Radical Acceptance", "Distress tolerance");
		dbtSkillsCategories.put("Turning the Mind", "Distress tolerance");
		dbtSkillsCategories.put("Willingness", "Distress tolerance");
		dbtSkillsCategories.put("Half-Smiling and Willing Hands", "Distress tolerance");
		dbtSkillsCategories.put("Mindfulness of Current Thoughts", "Distress tolerance");
	}
	
	public void assembleAL() {
		dbtSkills = new ArrayList<String> (dbtSkillsCategories.keySet());
	}
	
	public ALHMPair skillMatchPanels() {
		
		ArrayList<JButton> buttonLst = new ArrayList<>();
		
		Container c=getContentPane();
        
        JPanel panel1=new JPanel();
        //setting the panel layout as null
        panel1.setLayout(null);
        panel1.setBackground(Color.blue);
        panel1.setBounds(0,0,600, 100);
        
        
        JLabel skillMatch = new JLabel();
		skillMatch.setText("Skill Match");
		panel1.add(skillMatch);
        
        JButton previous = new JButton(); 
		previous.setText("Back");
		panel1.add(previous);
		previous.setBounds(30, 20, 100, 50);
		buttonLst.add(previous);
		//previous.setPreferredSize(new Dimension(200, 50));
        
        
        //Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(1, 1));
        panel2.setBackground(Color.green.darker());
        panel2.setBounds(0,100, 600, 250);
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
        
		skill1 = new JLabel();
		//skill1.setBounds(80, 40, 40, 20);
		skill1.setText("skill1");
		panel2.add(skill1);
		
		String[] optionsToChoose = {"Mindfulness", "Interpersonal Effectiveness", "Emotional Regulation", "Distress tolerance"};

		category1 = new JComboBox<>(optionsToChoose);
		category1.setBounds(80, 150, 160, 20);
		panel2.add(category1);
		
		result = new JLabel();
		panel2.add(result);
		result.setVisible(false);
		
		JPanel panel3 = new JPanel();
		//panel3.setLayout(null);
        panel3.setBackground(Color.blue);
        panel3.setBounds(0, 350, 600, 500);

        JButton submit = new JButton(); 
        submit.setText("Submit");
		panel3.add(submit);
		//submit.setBounds(0, 320, 50, 350);
		buttonLst.add(submit);
		
        JButton next = new JButton(); 
        next.setText("Next");
		panel3.add(next);
		//next.setBounds(0, 320, 50, 350);
		buttonLst.add(next);
		
		c.add(panel1);
	    c.add(panel2);
	    c.add(panel3);
	        
		setVisible(true);
		
		ALHMPair pair = new ALHMPair(dbtSkillsCategories, buttonLst);
		
		return pair; 
	}
	
	public void randomSkill() {
		Random rand = new Random();
		skill1.setText(dbtSkills.get(rand.nextInt(dbtSkills.size())));
	}
	
	public String getComboBox() {
		return ((String)category1.getSelectedItem());
	}
	
	public String getSkill() {
		return skill1.getText();
	}
	
	public void resultSetVisible(boolean answerResult) {
		result.setVisible(true);
		if(answerResult == true)
			result.setText("That's correct!");
		else
			result.setText("Incorrect, try again!");
	}
	
	public void resultSetInvisible() {
		result.setVisible(false);
	}
}
