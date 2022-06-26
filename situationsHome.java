
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class situationsHome extends JFrame{
	String[] optionsToChoose;
	JLabel situation; 
	ArrayList<String> situations;
	Map<Integer, List<String>> possibleRightAnswers; 
	ArrayList<String> allSkills;
	JComboBox<String> category1;
	int situationNumber; 
	JLabel result; 
	ArrayList<String> JComboItems;
	public situationsHome() {
		
		setTitle("DBT Skills Quizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(0,0,600,575);
        setVisible(true);
        
        situations = new ArrayList<>();
        possibleRightAnswers = new HashMap<>();
        allSkills = new ArrayList<>(); 
        
        situations.add("Person A is getting urges to use a drug of choice");
        List<String> zero = new ArrayList<>(Arrays.asList("STOP", "Adaptive Denial", "Turning the Mind"));
        possibleRightAnswers.put(0, zero);
        
        situations.add("Person B is feeling depressed and wants to sleep all day");
        List<String> one = new ArrayList<>(Arrays.asList("Opposite Action", "Accumulate the Positives"));
        possibleRightAnswers.put(1, one);
        
        situations.add("Person C wants something from someone");
        List<String> two = new ArrayList<>(Arrays.asList("DEARMAN"));
        possibleRightAnswers.put(2, two);
        
        situations.add("Person D feels a panic attack coming on");
        List<String> three = new ArrayList<>(Arrays.asList("TIPP", "What Skill", "How Skill", "Check the Facts"));
        possibleRightAnswers.put(3, three);
        
        situations.add("Person E starts feeling suicidal urges");
        List<String> four = new ArrayList<>(Arrays.asList("STOP", "Opposite Action"));
        possibleRightAnswers.put(4, four);
        
        situations.add("Person F sets a hard boundary that Person G finds difficult");
        List<String> five = new ArrayList<>(Arrays.asList("Radical Acceptance", "Half-Smiling", "Willing Hands"));
        possibleRightAnswers.put(5, five);
        
        situations.add("Person H is rumminating excessively");
        List<String> six = new ArrayList<>(Arrays.asList("Check the Facts", "Opposite Action", "Wise Mind"));
        possibleRightAnswers.put(6, six);
        
        situations.add("Person I is presenting something meaningful to a room full of people and feels anxious");
        List<String> seven = new ArrayList<>(Arrays.asList("What Skill", "How Skill"));
        possibleRightAnswers.put(7, seven);
        
        
        allSkills.add("Wise Mind");
        allSkills.add("What Skill");
        allSkills.add("How Skill");
        allSkills.add("Dearman");
        allSkills.add("GIVE");
        allSkills.add("FAST");
        allSkills.add("Check the Facts");
        allSkills.add("Opposite Action");
        allSkills.add("Problem Solving");
        allSkills.add("ABC PLEASE");
        allSkills.add("STOP");
        allSkills.add("TIPP");
        allSkills.add("Distract with Accepts");
        allSkills.add("Self-Soothing");
        allSkills.add("Improve the Moment");
        allSkills.add("Radical Acceptance");
        allSkills.add("Turning the Mind");
        allSkills.add("Willingness");
        allSkills.add("Half-Smiling and Willing Hands");
        allSkills.add("Mindfulness of Current Thoughts");
        
        
	}
	
	public ArrayList<JButton> situationsPanels() {
		ArrayList<JButton> buttonLst = new ArrayList<>();
		
		Container c=getContentPane();
        
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.blue);
        panel1.setBounds(0,0,600, 100);
        
        JLabel situations = new JLabel();
        situations.setText("Situations");
		panel1.add(situations);
        
        JButton previous = new JButton(); 
		previous.setText("Back");
		panel1.add(previous);
		previous.setBounds(30, 20, 100, 50);
		buttonLst.add(previous);
        
        
	      //Creating a JPanel for the JFrame
        JPanel panel2=new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.green.darker());
        panel2.setBounds(0,100, 600, 350);
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel panel2childa = new JPanel();
        panel2childa.setBackground(Color.green.darker());
        panel2childa.setBounds(0, 0, 600, 125);
        panel2childa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.add(panel2childa);
        
        JLabel instructionsa = new JLabel();
        JLabel instructionsb = new JLabel();
        instructionsa.setText("Select the DBT skill that may be useful in the");
        instructionsb.setText("given situation. Note that there may be more than one correct answer.");
		panel2childa.add(instructionsa);
		panel2childa.add(instructionsb);
        
        JPanel panel2childb = new JPanel();
        panel2childb.setBackground(Color.green.darker());
        panel2childb.setBounds(0, 125, 600, 60);
        panel2childb.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.add(panel2childb);
        
        situation = new JLabel();
		panel2childb.add(situation);
		addSituation();
		
        JPanel panel2childc = new JPanel();
        panel2childc.setBackground(Color.green.darker());
        panel2childc.setBounds(0,185, 600, 75);
        panel2childc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.add(panel2childc);
        
		optionsToChoose = getOptionsToChoose(); 
		category1 = new JComboBox<>(optionsToChoose);
		category1.setBounds(80, 150, 160, 20);
		panel2childc.add(category1);
		
		result = new JLabel(); 
		result.setBounds(80, 200, 160, 20);
		panel2childc.add(result);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
        panel3.setBackground(Color.blue);
        panel3.setBounds(0, 450, 600, 175);
        panel3.setLayout(null);
        
        JButton submit = new JButton(); 
        submit.setText("Submit");
		panel3.add(submit);
		submit.setBounds(150, 20, 75, 50);
		buttonLst.add(submit);
		
		JButton showSolution = new JButton(); 
		showSolution.setText("Show Solution");
		panel3.add(showSolution);
		showSolution.setBounds(225, 20, 125, 50);
		buttonLst.add(showSolution);
		
		JButton next = new JButton(); 
		next.setText("Next");
		panel3.add(next);
		next.setBounds(350, 20, 75, 50);
		buttonLst.add(next);
		
		c.add(panel1);
		c.add(panel2);
		c.add(panel3);
		
		setVisible(true);
		return buttonLst; 
	}
	
	public void showSolution() {
		String showThisString = "";
		List<String> rightAnswers = possibleRightAnswers.get(situationNumber);
		for(String ans: rightAnswers)
			showThisString = showThisString + ans + ", ";
			//showThisString += " ";
		result.setText("Possible answers are: " + showThisString);
	}
	
	public void getNext() {
		addSituation();
		result.setText("");
		//clear JComboBox
		category1.removeAllItems();
		//add next items to JComboBox
		optionsToChoose = getOptionsToChoose();
		for(int i = 0; i < optionsToChoose.length; i++) {
			category1.insertItemAt(optionsToChoose[i], category1.getItemCount());
		}
		
	}
	
	public void addSituation() {
		Random rand = new Random();
		int randomInt = rand.nextInt(situations.size());
		situation.setVisible(true);
		situation.setText(situations.get(randomInt));
		situationNumber = randomInt; 
	}
	
	public String[] addSituationOptions(int value) {
		List<String> options = possibleRightAnswers.get(value);
		String[] result = new String[options.size()];
		for(int i = 0; i < options.size(); i++) {
			result[i] = options.get(i);
		}
		return result;
	}
	
	public List<Integer> selectRandomSkills() {
		Random rand = new Random();
		int randomInt;
		List<Integer> randomlySelectedSkills = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			randomInt = rand.nextInt(allSkills.size());
			while(randomlySelectedSkills.contains(randomInt)) {
				randomInt = rand.nextInt(allSkills.size());
			}
			randomlySelectedSkills.add(randomInt);
		}
		
		return randomlySelectedSkills; 
	}
	
	
	public void submitAnswer() {
		String answer = ((String)category1.getSelectedItem());
		List<String> rightAnswers = possibleRightAnswers.get(situationNumber);
		if(rightAnswers.contains(answer)){
			result.setText("Correct");
		}
		else {
			result.setText("Incorrect, try again or press 'Show Solution'");
		}
	}
	
	public String getComboBox() {
		return ((String)category1.getSelectedItem());
	}
	
	public String[] getOptionsToChoose() {
		
		String[] result = new String[5];
		Random rand = new Random();
		
		List<String> rightAnswers = possibleRightAnswers.get(situationNumber); 
		String randomRightAnswer = possibleRightAnswers.get(situationNumber).get(rand.nextInt(rightAnswers.size()));
		
		int rightAnswerIndex = rand.nextInt(result.length);
		result[rightAnswerIndex] = randomRightAnswer; 
		List<Integer> randomSkills = selectRandomSkills();
		
		List<Integer> occupiedIndices = new ArrayList<Integer>();
		rand = new Random();
		int count = 0; 
		while(count < 4) {
			int nextIndex = rand.nextInt(5);
			while(nextIndex == rightAnswerIndex || occupiedIndices.contains(nextIndex)) {
				nextIndex = rand.nextInt(5);
			}
			occupiedIndices.add(nextIndex);
			result[nextIndex] = allSkills.get(randomSkills.get(count));
			
			count += 1; 
			
		}
		return result;
		
	}
}
