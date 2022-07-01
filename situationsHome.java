
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class situationsHome extends optionHomeFrame{
	String[] optionsToChoose;
	JLabel situationPart1; 
	JLabel situationPart2; 
	JLabel situationPart3; 
	ArrayList<String> situations;
	Map<String, List<String>> possibleRightAnswers; 
	ArrayList<String> allSkills;
	JComboBox<String> category1;
	int situationNumber; 
	JLabel result; 
	ArrayList<String> JComboItems;
	Stack<String> situationStack;
	String curSituation; 
	String lastSituation;
	public situationsHome() {	
        situationStack = new Stack<String>();
        situations = new ArrayList<>();
        possibleRightAnswers = new HashMap<>();
        allSkills = new ArrayList<>(); 
        curSituation = "";
        lastSituation = "";
        
        
        addSituation("Person A is getting urges to use a drug of choice", Arrays.asList ("STOP", "Adaptive Denial", "Turning the Mind", "Alternate Rebellion"));
        
        addSituation("Person B is feeling depressed and wants to sleep all day", Arrays.asList("Opposite Action", "Accumulate the Positives"));
        
        addSituation("Person C wants something from someone", Arrays.asList("DEARMAN"));
        
        addSituation("Person D feels a panic attack coming on", Arrays.asList("TIPP", "What Skills", "How Skills", "Check the Facts"));
        
        addSituation("You've been working at a company for 2 years and have not gotten a raise even though your performance reviews have"
        		+ " been very positive", Arrays.asList("DEARMAN"));
        
        addSituation("Person E starts feeling suicidal urges", Arrays.asList("STOP", "Opposite Action"));
        
        addSituation("this is the third time this week someone has asked you for a ride home from work", Arrays.asList("DEARMAN", "FAST"));
        
        addSituation("Person F sets a hard boundary that Person G finds difficult", Arrays.asList("Radical Acceptance", "Half-Smiling", "Willing Hands"));
        
        addSituation("If you cry and throw a tantrum when your friend forgets your birthday, they will remember it in the future, but may remember"
        		+ " it with bitterness instead of love and affection. Use this skill instead", Arrays.asList("GIVE"));
        
        addSituation("Person H is rumminating excessively", Arrays.asList("Check the Facts", "Opposite Action", "Wise Mind"));
        
        addSituation("In social interactions, Some people lose respect for themselves if they cry and/or get extremely emotional. Others lose self-respect if they give"
        		+ " in and act passively", Arrays.asList("FAST"));
        
        addSituation("Thinking 'I have enought gas in the car to get to where I am going' when the fueld gauge is on empty", Arrays.asList("Check the Facts"));
        
        addSituation("'Your not inviting me to the party means that you do not like me'", Arrays.asList("Check the Facts"));
        
        addSituation("Knowing somthing is not dangerous but still being very afraid of it", Arrays.asList("Opposite Action"));
        
        addSituation("The person you love actively harms you, such as in a violent or otherwise abusive relationship", Arrays.asList("Opposite Action"));
        
        addSituation("Working in a job I hate is a big factor in my not having a life I want to live", Arrays.asList("Problem Solving"));
        
        addSituation("I hate my job more each day", Arrays.asList("Problem Solving"));
        
        addSituation("If your highest value is contributing to the larger community, goals that could get you closer to that value would be to get a part time "
        		+ "volunteer job or donate time to a neighborhood spring cleanup", Arrays.asList("Accumulating Positive Emotions"));
        
        addSituation("Whem I was learning how to go camping I started by setting up a tent in the front yard; then I started sleeping in a sleeping bag in the bedroom;"
        		+ " then I tried doing both at a car camping site", Arrays.asList("Build Mastery"));
        
        addSituation("There is a situation coming up where there is a threat or you feel afraid", Arrays.asList("Cope Ahead"));
        
        addSituation("Someone says something that provokes your anger, you migh have the urge to attack the person physically or verbally", Arrays.asList("STOP"));
        
        addSituation("My alarm goes off on a workday. I am tired and I want to stay in bed", Arrays.asList("Pros and Cons"));
        
        addSituation("You are in a crisis -- that is, a high urge to engege in destructive behavior hits and you can't distract yourself", Arrays.asList("TIPP"));
        
        addSituation("Your emotional pain or upset becomes so great that you are in danger of being overwhelmed by it at work, at school, or in public", Arrays.asList("Distract with Accepts"));
        
        addSituation("You are vulnerable to emotion mind and/or acting impulsively", Arrays.asList("Self Soothe"));
        
        addSituation("You are feeling overwhelmed in a stressful situation that may be long-lasting or in which distracting "
        		+ "activities and self-soothing are not working", Arrays.asList("Improve the Moment"));
        		
		addSituation("A man is in prison with a life sentence for a crime he did not commit. He has used up his appeals, has no money or "
				+ "resources to hire a lawyer, and he cannot get the Innocence Project to take up his cause", Arrays.asList("Radical Acceptance"));
		
		addSituation("Accepting that you did not get into the school you wanted to attend", Arrays.asList("Turning the Mind"));
		
		addSituation("Accepting that you are disabled after a car accident", Arrays.asList("Turning the Mind"));
		
		addSituation("Thinking about someone you dislike", Arrays.asList("Half-Smiling"));
		
		addSituation("Person I is presenting something meaningful to a room full of people and feels anxious", Arrays.asList("What Skills", "How Skills")); 
        
		addSituation("You wake up in emotion mind and immediately start worrying about work", Arrays.asList("Wise Mind"));
        
		addSituation("A task-focused person attending only to what can be done next, and ignoring even"
        		+ " loved ones",Arrays.asList("Wise Mind"));
		
		addSituation("You evaluate someone's behavior as 'good' or 'bad'", Arrays.asList("How Skills"));
		
		addSituation("The front desk clerk at a hotel says you don't have a reservation, you have the urge to "
        		+ "start yelling at them, but you want a room", Arrays.asList("How Skills"));
        
		addSituation("You are walking in the forest, if you don't use this set of skills, you may end up far away "
        		+ "from where you were originally going", Arrays.asList("What Skills")); 
        
        		
        
        assembleStack();
        
        allSkills.add("Wise Mind");
        allSkills.add("What Skills");
        allSkills.add("How Skills");
        allSkills.add("DEARMAN");
        allSkills.add("GIVE");
        allSkills.add("FAST");
        allSkills.add("Check the Facts");
        allSkills.add("Opposite Action");
        allSkills.add("Problem Solving");
        allSkills.add("ABC PLEASE");
        allSkills.add("Accumulating Positive Emotions");
        allSkills.add("Build Mastery");
        allSkills.add("Cope Ahead");
        allSkills.add("STOP");
        allSkills.add("TIPP");
        allSkills.add("Distract with Accepts");
        allSkills.add("Self-Soothing");
        allSkills.add("Improve the Moment");
        allSkills.add("Radical Acceptance");
        allSkills.add("Turning the Mind");
        allSkills.add("Willingness");
        allSkills.add("Half-Smiling");
        allSkills.add("Willing Hands");
        allSkills.add("Mindfulness of Current Thoughts");
        
        
	}
	
	public void addSituation(String sit, List<String> sitSkills) {
        situations.add(sit);
        List<String> sitList = new ArrayList<>(sitSkills);
        possibleRightAnswers.put(sit, sitList);
	}
	
	public ArrayList<JButton> situationsPanels(ArrayList<JButton> buttonLst, JPanel panel2, JLabel result1, JLabel result2) {
        int situationLength = 80; 
        panel2.setLayout(null);
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
        panel2childb.setBounds(0, 125, 600, 90);
        panel2childb.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2childb.setLayout(null);
        panel2.add(panel2childb);
        
        situationPart1 = new JLabel();
		panel2childb.add(situationPart1);
		situationPart1.setBounds(20, 10, 600, 20);
		situationPart2 = new JLabel();
		panel2childb.add(situationPart2);
		situationPart2.setBounds(20, 30, 600, 20);
		situationPart3 = new JLabel();
		panel2childb.add(situationPart3);
		situationPart3.setBounds(20, 50, 600, 20);
		
	
		if(curSituation.length() > situationLength * 2) {
			situationPart1.setVisible(true);
			situationPart2.setVisible(true);
			situationPart3.setVisible(true);
			situationPart1.setText((String) curSituation.subSequence(0, getProperSubsequence(situationLength, curSituation)));
			situationPart2.setText((String) curSituation.subSequence(getProperSubsequence(situationLength, curSituation), getProperSubsequence(situationLength * 2, curSituation)));
			situationPart3.setText((String) curSituation.subSequence(getProperSubsequence(situationLength * 2, curSituation), curSituation.length()));
		}
		else if(curSituation.length() > situationLength) {
			situationPart1.setVisible(true);
			situationPart2.setVisible(true);
			situationPart3.setVisible(false);
			situationPart1.setText((String) curSituation.subSequence(0, getProperSubsequence(situationLength, curSituation)));
			situationPart2.setText((String) curSituation.subSequence(getProperSubsequence(situationLength, curSituation), curSituation.length()));
		}
		else {
			situationPart1.setVisible(true);
			situationPart2.setVisible(false);
			situationPart3.setVisible(false);
			situationPart1.setText(curSituation);
		}
		
		//addSituation();
		getSituation();
		
        JPanel panel2childc = new JPanel();
        panel2childc.setBackground(Color.green.darker());
        panel2childc.setBounds(0,200, 600, 75);
        panel2childc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.add(panel2childc);
        
		optionsToChoose = getOptionsToChoose(); 
		category1 = new JComboBox<>(optionsToChoose);
		//category1.setBounds(90, 180, 160, 20);
		panel2childc.add(category1);
		
		result = new JLabel(); 
		result.setBounds(80, 200, 160, 20);
		panel2childc.add(result);
	
		return buttonLst; 
	}
	
	public void assembleStack() {
		Random rand = new Random();
		for(int i = 0; i < situations.size(); i++) {
			int randomInt = rand.nextInt(situations.size());
			while(situationStack.contains(situations.get(randomInt))) {
				randomInt = rand.nextInt(situations.size());
			}
			situationStack.add(situations.get(randomInt));
		}
	}
	
	public void getSituation() {
		int situationLength = 80; 
		if(situationStack.size() == 0) {
			assembleStack();
		}
		curSituation = situationStack.pop();
		if(curSituation == lastSituation)
			curSituation = situationStack.pop();
		lastSituation = curSituation;
		
		
		if(curSituation.length() > situationLength * 2) {
			situationPart1.setVisible(true);
			situationPart2.setVisible(true);
			situationPart3.setVisible(true);
			situationPart1.setText((String) curSituation.subSequence(0, getProperSubsequence(situationLength, curSituation)));
			situationPart2.setText((String) curSituation.subSequence(getProperSubsequence(situationLength, curSituation), getProperSubsequence(situationLength * 2, curSituation)));
			situationPart3.setText((String) curSituation.subSequence(getProperSubsequence(situationLength * 2, curSituation), curSituation.length()));
		}
		else if(curSituation.length() > situationLength) {
			situationPart1.setVisible(true);
			situationPart2.setVisible(true);
			situationPart3.setVisible(false);
			situationPart1.setText((String) curSituation.subSequence(0, getProperSubsequence(situationLength, curSituation)));
			situationPart2.setText((String) curSituation.subSequence(getProperSubsequence(situationLength, curSituation), curSituation.length()));
		}
		else {
			situationPart1.setVisible(true);
			situationPart2.setVisible(false);
			situationPart3.setVisible(false);
			situationPart1.setText(curSituation);
		}
	}
	
	
	
	public void showSolution() {
		String showThisString = "";
		List<String> rightAnswers = possibleRightAnswers.get(curSituation);
		for(String ans: rightAnswers)
			showThisString = showThisString + ans + ", ";
			//showThisString += " ";
		result.setText("Possible answers are: " + showThisString);
	}
	

	
	public void getNext() {
		//addSituation();
		result.setText("");
		//clear JComboBox
		category1.removeAllItems();
		//add next items to JComboBox
		optionsToChoose = getOptionsToChoose();
		for(int i = 0; i < optionsToChoose.length; i++) {
			category1.insertItemAt(optionsToChoose[i], category1.getItemCount());
		}
		
	}
	
	/*
	public void addSituation() {
		Random rand = new Random();
		int randomInt = rand.nextInt(situations.size());
		situation.setVisible(true);
		situation.setText(situations.get(randomInt));
		situationNumber = randomInt; 
	}*/
	
	public String[] addSituationOptions(int value) {
		List<String> options = possibleRightAnswers.get(curSituation);
		String[] result = new String[options.size()];
		for(int i = 0; i < options.size(); i++) {
			result[i] = options.get(i);
		}
		return result;
	}
	
	public List<String> selectRandomSkills(String randomRightAnswer) {
		Random rand = new Random();
		int randomInt;
		List<String> randomlySelectedSkills = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			randomInt = rand.nextInt(allSkills.size());
			while(randomlySelectedSkills.contains(allSkills.get(randomInt)) || allSkills.get(randomInt).equals(randomRightAnswer)) {
				randomInt = rand.nextInt(allSkills.size());
			}
			randomlySelectedSkills.add(allSkills.get(randomInt));
		}
		
		return randomlySelectedSkills; 
	}
	
	
	public void submitAnswer() {
		String answer = ((String)category1.getSelectedItem());
		List<String> rightAnswers = possibleRightAnswers.get(curSituation);
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
		
		List<String> rightAnswers = possibleRightAnswers.get(curSituation); 
		int rightAnswerIndex = rand.nextInt(rightAnswers.size());
		String randomRightAnswer = rightAnswers.get(rightAnswerIndex);
		
		for(int i = 0; i < 5; i++)
			result[i] = "";
		
		int resultRightAnswerIndex = rand.nextInt(result.length);
		result[resultRightAnswerIndex] = randomRightAnswer; 
		
		List<String> randomSkills = selectRandomSkills(randomRightAnswer);

		List<Integer> occupiedIndices = new ArrayList<Integer>();
		rand = new Random();
		int count = 0; 
		while(count < 4) {
			int nextIndex = rand.nextInt(5);
			while(nextIndex == resultRightAnswerIndex || occupiedIndices.contains(nextIndex)) {
				nextIndex = rand.nextInt(5);
			}
			occupiedIndices.add(nextIndex);
			result[nextIndex] = randomSkills.get(count);
			
			count += 1; 
			
		}
		return result;
		
	}
	
	public int getProperSubsequence(int end, String curDef) {
		int resultEnd = end; 
		while(curDef.charAt(resultEnd) != ' ') {
			resultEnd -= 1;
		}
		return resultEnd; 
	}
}
