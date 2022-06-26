
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class skillMatchHome extends optionHomeFrame{
	Map<String, String> dbtSkillsCategories; 
	JComboBox<String> category1;
	JLabel skill1;
	ArrayList<String> dbtSkills; 
	static JLabel result1; 
	Stack<String> skillStack;
	
	public skillMatchHome() {
		skillStack = new Stack<>(); 
        assembleMap();
        assembleAL();
        assembleStack();
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
	
	public ALHMPair skillMatchPanels(ArrayList<JButton> buttonLst, JPanel panel2, JLabel result1, JLabel result2) {
		skillMatchHome.result1 = result1; 
		
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
        panel2.setLayout(null);
		skill1 = new JLabel();
		skill1.setBounds(75, 150, 225, 20);
		skill1.setText("skill1");
		panel2.add(skill1);
		
		String[] optionsToChoose = {"Mindfulness", "Interpersonal Effectiveness", "Emotional Regulation", "Distress tolerance"};

		category1 = new JComboBox<>(optionsToChoose);
		category1.setBounds(300, 150, 180, 20);
		panel2.add(category1);
		
		result1.setVisible(false);
	        
		setVisible(true);
		
		ALHMPair pair = new ALHMPair(dbtSkillsCategories, buttonLst);
		
		return pair; 
	}
	
	public void assembleStack() {
		Random rand = new Random();
		int nextInt;
		for(int i = 0; i < dbtSkills.size(); i++) {
			nextInt = rand.nextInt(dbtSkills.size());
			while(skillStack.size() > 0 && skillStack.contains(dbtSkills.get(nextInt))) {
				nextInt = rand.nextInt(dbtSkills.size());
			}
			skillStack.add(dbtSkills.get(nextInt));
		}
	}
	
	public void randomSkill() {
		if(skillStack.size() == 0) {
			assembleStack();
		}
		String skill = skillStack.pop();
		skill1.setText(skill);
	}
	
	public String getComboBox() {
		return ((String)category1.getSelectedItem());
	}
	
	public String getSkill() {
		return skill1.getText();
	}
	
	public void resultSetVisible(boolean answerResult) {
		result1.setVisible(true);
		if(answerResult == true)
			result1.setText("That's correct!");
		else
			result1.setText("Incorrect, try again or press 'Show Solution'");
	}
	
	public void resultSetInvisible() {
		result1.setVisible(false);
	}
	
	public void showSolution(String skill, String ans) {
		result1.setVisible(true);
		result1.setText(skill + " is a " + ans + " skill");
	}
}
