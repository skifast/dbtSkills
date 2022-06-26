import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class definitionsHome extends optionHomeFrame {
	Map<String, String> skillsNDefs;
	Stack<String> skillsStack;
	JLabel[] definitionLabels;
	JLabel[] skillLabels1;
	JLabel[] skillLabels2;
	JTextField[] textFields;
	Map<Integer, Character> answers; 
	
	public definitionsHome(){
		skillsStack = new Stack<>();
		skillsNDefs = new HashMap<>();
		answers = new HashMap<>();
		
		skillsNDefs.put("What Skills", "What we do when practicing mindfulness");
		skillsNDefs.put("How Skills", "How we practice mindfulness");
		skillsNDefs.put("Wise Mind", "The inner wisdom that each person has");
		
		skillsNDefs.put("DEARMAN", "Used to effectively obtain your objective or goal");
		skillsNDefs.put("GIVE", "Used to create or maintain a poisitive relationship while "
				+ "you also try to obtain your objective");
		skillsNDefs.put("FAST", "Used to maintain or increase your sense of self-respect"
				+ "while at the same time trying to obtain your objective");
		skillsNDefs.put("Check the Facts", "Used to change our beliefs assumptions and "
				+ "interpretations of events to fit the facts and in turn change our "
				+ "emotional reactions");
		
		skillsNDefs.put("Opposite Action", "Used when emotions do not fit the facts of a"
				+ " situation or do not lead to effective behavior. Will change the emotions"
				+ " if done repeatedly and all the way");
		skillsNDefs.put("Problem Solving", "Used when an unwanted emotion fits the facts"
				+ " and the facts are the problem");
		skillsNDefs.put("Accumulating Positive Emotions", "Used to increase positive events "
				+ "which can accumulate into a happier life and reduce vulnerability to "
				+ " painful emotions.");
		skillsNDefs.put("Build Mastery", "Used to feel competent and adequately prepared for "
				+ "difficult situations and reduce vulnerability to emotion mind");
		skillsNDefs.put("PLEASE", "Used to take care of the body and increase emotional"
				+ "resilience");

		skillsNDefs.put("STOP", "Used to help one refrain from acting impulsively on their"
				+ " emotions and from making a difficult situation worse");
		skillsNDefs.put("Pros and Cons", "Used to help one realize that accepting reality and "
				+ "tolerating distress lead to better outcomes than do rejecting reality and "
				+ "refusing to tolerate distress");
		skillsNDefs.put("TIPP", "Used to rapidly reduce emotion arousal");
		skillsNDefs.put("Distract with accepts", "Used to reduce contact with whatever set "
				+ " off the distress or its most painful aspects ");
		skillsNDefs.put("Self-soothing", "Doing things that feel pleasant, comforting and "
				+ "provide relief from stress or pain");
		skillsNDefs.put("Improving the moment", "Strategies that can be helpful in improving "
				+ "the quality of the present moment");
		skillsNDefs.put("Radical Acceptance", "Complete and total openness to the facts of "
				+ "reality as they are");
		skillsNDefs.put("Turning the mind", "Convincing oneself to accept a reality that feels unacceptable over"
				+ " and over");
		skillsNDefs.put("Half-Smiling + Willing Hands", "Ways of Accepting reality with the body");
		skillsNDefs.put("Mindfulness of Current Thoughts", "Observing thoughts as thoughts rather than "
				+ "as facts about the world");
		skillsNDefs.put("Alternate Rebellion", "Used to satisfy the wish to rebel without destroying "
				+ "yourself or blocking your way to achieving important goals");
		skillsNDefs.put("Adaptive Denial", "Adamantly convincing yourself that you don't want to engage in the"
				+ " maladaptive behavior when the urge hits");
				


	}
	
	public ArrayList<JButton> definitionsscreenPanels(Container c, ArrayList<JButton> buttonLst, JPanel panel2) {
		panel2.setLayout(new GridLayout(4, 2));
		
		skillLabels1 = new JLabel[4];
		skillLabels2 = new JLabel[4];
		definitionLabels = new JLabel[20];
		textFields = new JTextField[4];
		
		for(int i = 0; i < 4; i++) {
			JPanel skillNtext = new JPanel();
			skillNtext.setBackground(Color.green.darker());
			skillNtext.setLayout(new GridLayout(1, 2));
			
			JPanel skillPanel = new JPanel(); 
			skillPanel.setBackground(Color.green.darker());
			skillPanel.setLayout(new GridLayout(2, 1));
			skillNtext.add(skillPanel);
			
			JLabel skill1 = new JLabel("skill1");
			skillPanel.add(skill1);
			//skill1.setBounds(0, 0, 600, 20);
			skillLabels1[i] = skill1;
			
			JLabel skill2 = new JLabel("skill2");
			skillPanel.add(skill2);
			skillLabels2[i] = skill2; 
			
			JPanel makeTextSmaller = new JPanel();
			makeTextSmaller.setLayout(new GridLayout(1, 2));
			makeTextSmaller.setBackground(Color.green.darker());
			skillNtext.add(makeTextSmaller);
			
			JPanel makeTextSmaller2 = new JPanel();
			makeTextSmaller.add(makeTextSmaller2);
			makeTextSmaller2.setBackground(Color.green.darker());
			
			JTextField text = new JTextField();
			makeTextSmaller.add(text);
			textFields[i] = text;
			
			panel2.add(skillNtext);
			
			JPanel definitionPanel = new JPanel();
			definitionPanel.setBackground(Color.green.darker());
			definitionPanel.setLayout(new GridLayout(5, 1));
			
			int increase = i * 5;
			for(int j = 0; j < 5; j++) {
				JLabel label = new JLabel();
				label.setText("hello there");
				definitionPanel.add(label);
				definitionLabels[increase + j] = label;
			}
			panel2.add(definitionPanel);
		}
	
		
	
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel2.setBackground(Color.green.darker());
		
		
		return buttonLst;
	}
	
	public void assembleStack() {
		while(skillsStack.size() > 0) {
			skillsStack.pop();
		}
		Random rand = new Random();
		Object[] skills = skillsNDefs.keySet().toArray();
		int randomNum = rand.nextInt(skills.length);
		
		for(int i = 0; i < skills.length; i++) {
			while(skillsStack.contains(skills[randomNum])) {
				randomNum = rand.nextInt(skills.length);
			}
			skillsStack.add((String) skills[randomNum]);
		}
		
	}
	
	public void getDefinitions(JLabel result1, JLabel result2) {
		result1.setVisible(false);
		result2.setVisible(false);
		int definitionLineLength = 30; 
		int skillLength = 15; 
		if(skillsStack.size() < 4) {
			assembleStack();
		}
		Random rand = new Random();
		ArrayList<Integer> pickedNumbers = new ArrayList<>();
		
		for(int i = 0; i < 4; i++) {
			String curSkill = skillsStack.pop();
			
			int skillInt = rand.nextInt(4);
			while(pickedNumbers.contains(skillInt) ) {
				skillInt = rand.nextInt(4);
			}
			pickedNumbers.add(skillInt);
			
			String setTextThis = curSkill;
			
			if(skillInt == 0) {
				setTextThis = "A: " + setTextThis;
				answers.put(i, 'A');
			}
			else if(skillInt == 1) {
				setTextThis = "B: " + setTextThis;
				answers.put(i, 'B');
			}
			else if(skillInt == 2) {
				setTextThis = "C: " + setTextThis;
				answers.put(i, 'C');
			}
			else if(skillInt == 3) {
				setTextThis = "D: " + setTextThis;
				answers.put(i, 'D');
			}
				
			
			//skillLabels[skillInt].setText(setTextThis);
			if(curSkill.length() > skillLength) {
				//skillLabels[skillInt].setFont(new Font("Serif", Font.PLAIN, 9));
				skillLabels2[skillInt].setVisible(true);
				skillLabels2[skillInt].setVisible(true);
				skillLabels1[skillInt].setText((String) setTextThis.subSequence(0, getProperSubsequence(skillLength, setTextThis)));
				skillLabels2[skillInt].setText((String) setTextThis.subSequence((getProperSubsequence(skillLength, setTextThis)), setTextThis.length()));
			}
			else {
				skillLabels2[skillInt].setVisible(true);
				skillLabels1[skillInt].setText(setTextThis);
				skillLabels2[skillInt].setVisible(false);
			}
			
			String curDef = skillsNDefs.get(curSkill);
			
			int increase2 = 5 * i; 
			int j1 = increase2;
			int j2 = increase2 + 1; 
			int j3 = increase2 + 2; 
			int j4 = increase2 + 3; 
			int j5 = increase2 + 4;
			
			if(curDef.length() > 4 * definitionLineLength) {
				//use all four labels
				definitionLabels[j1].setText((String) curDef.subSequence(0, getProperSubsequence(definitionLineLength, curDef)));
				definitionLabels[j2].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength, curDef), getProperSubsequence(definitionLineLength * 2, curDef)));
				definitionLabels[j3].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength * 2, curDef), getProperSubsequence(definitionLineLength * 3, curDef)));
				definitionLabels[j4].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength * 3, curDef), getProperSubsequence(definitionLineLength * 4, curDef)));
				definitionLabels[j5].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength * 4, curDef), curDef.length()));
				
			}
			if(curDef.length() > 3 * definitionLineLength) {
				definitionLabels[j1].setText((String) curDef.subSequence(0, getProperSubsequence(definitionLineLength, curDef)));
				definitionLabels[j2].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength, curDef), getProperSubsequence(definitionLineLength * 2, curDef)));
				definitionLabels[j3].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength * 2, curDef), getProperSubsequence(definitionLineLength * 3, curDef)));
				definitionLabels[j4].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength * 3, curDef), curDef.length()));
				definitionLabels[j5].setText("");
			}
			else if(curDef.length() > 2 * definitionLineLength) {
				definitionLabels[j1].setText("");
				definitionLabels[j2].setText((String) curDef.subSequence(0, getProperSubsequence(definitionLineLength, curDef)));
				definitionLabels[j3].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength, curDef), getProperSubsequence(definitionLineLength * 2, curDef)));
				definitionLabels[j4].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength * 2, curDef), curDef.length()));
				definitionLabels[j5].setText("");
			}
			else if(curDef.length() > definitionLineLength) {
				definitionLabels[j1].setText("");
				definitionLabels[j2].setText((String) curDef.subSequence(0, getProperSubsequence(definitionLineLength, curDef)));
				definitionLabels[j3].setText((String) curDef.subSequence(getProperSubsequence(definitionLineLength, curDef), curDef.length()));
				definitionLabels[j4].setText("");
				definitionLabels[j5].setText("");
			}
			else {
				definitionLabels[j1].setText("");
				definitionLabels[j2].setText("");
				definitionLabels[j3].setText((String) curDef.subSequence(0, curDef.length()));
				definitionLabels[j4].setText("");
				definitionLabels[j5].setText("");
			}
			
		}
	}
	
	public int getProperSubsequence(int end, String curDef) {
		int resultEnd = end; 
		while(curDef.charAt(resultEnd) != ' ') {
			resultEnd -= 1;
		}
		return resultEnd; 
	}
	
	public void showSolutions(JLabel result1, JLabel result2) {
		result1.setVisible(true);
		result2.setVisible(true);
		int cutOff = 80; 
		String postThis = ""; 
		
		postThis += "The first text box is " + answers.get(0);
		postThis += ", The second text box is " + answers.get(1);
		postThis += ", The third text box is " + answers.get(2);
		postThis += ", The fourth text box is " + answers.get(3);
		
		result1.setText((String) postThis.subSequence(0, getProperSubsequence(cutOff, postThis)));
		result2.setText((String) postThis.subSequence(getProperSubsequence(cutOff, postThis), postThis.length()));
	}
	
	public void checkAnswers(JLabel result1, JLabel result2) {
		boolean correct =  true; 
		result1.setVisible(true);
		result2.setVisible(false);
		for(Integer i : answers.keySet()) {
			if(!(answers.get(i).toString().equals(textFields[i].getText().toUpperCase())))
				correct = false; 
		}
		if(correct)
			result1.setText("Correct!");
		else
			result1.setText("Incorrect. Try again or press 'Show Solution' !");
	}
	
}


