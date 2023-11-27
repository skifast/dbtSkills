import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class acronymFrameOutline extends optionHomeFrame {
	public static Map<String, ArrayList<String>> acronymHM;
	public static String acronym;
	public static JLabel result1;
	public static JLabel result2;
	
	public static JLabel[] labels;
	public static JTextField[] textFields;
	public static String[] standsFor; 
	public static String[] extras; 
	
	public acronymFrameOutline() {
		setTitle("DBT Skills Quizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setting the bounds for the JFrame
        setBounds(0,0,600,575);
        
        setVisible(true);
	}
	
	public void customizeOutline(String acronym, String[] standsFor, String[] extras) {
		
		acronymFrameOutline.acronym = acronym; 
		acronymFrameOutline.standsFor = standsFor;
		acronymFrameOutline.acronymHM = new HashMap<String, ArrayList<String>>();
		acronymFrameOutline.extras = extras; 
		
		
		for(int i = 0; i < acronym.length(); i++) {
			String curLetter = "" + acronym.charAt(i);
			if(acronymHM.containsKey(curLetter)) {
				ArrayList<String> putThis = acronymHM.get(curLetter);
				putThis.add(standsFor[i]);
				acronymHM.put(curLetter, putThis);
			}
			
		}
		
		labels = new JLabel[9];
		labels[0] = new JLabel();
		labels[1] = new JLabel();
		labels[2] = new JLabel();
		labels[3] = new JLabel();
		labels[4] = new JLabel();
		labels[5] = new JLabel();
		labels[6] = new JLabel();
		labels[7] = new JLabel();
		labels[8] = new JLabel();
		
		textFields = new JTextField[9];
		textFields[0] = new JTextField();
		textFields[1] = new JTextField();
		textFields[2] = new JTextField();
		textFields[3] = new JTextField();
		textFields[4] = new JTextField();
		textFields[5] = new JTextField();
		textFields[6] = new JTextField();
		textFields[7] = new JTextField();
		textFields[8] = new JTextField();
	}
	
	public ArrayList<JButton> acronymFramePanels(Container c, JLabel result1, JLabel result2, JPanel panel2){
		ArrayList<JButton> buttonLst = new ArrayList<>();
		acronymFrameOutline.result1 = result1; 
		acronymFrameOutline.result2 = result2; 
		
        //Container c=getContentPane();
        
		/*
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.blue);
        panel1.setBounds(0,0,600,75);*/
        
        /*
        JLabel acronyms = new JLabel();
		acronyms.setText(acronym.toUpperCase() + " Acronym");
		panel1.add(acronyms);
		acronyms.setBounds(275, 20, 200, 50);
		acronyms.setForeground(Color.white);
		
		JButton previous = new JButton(); 
		previous.setText("Back");
		panel1.add(previous);
		buttonLst.add(previous);
		previous.setBounds(30, 20, 100, 50);*/
		
        //JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(acronym.length(), 1));
	
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
        for(int i = 0; i < acronym.length(); i++) {
        	labels[i].setText("" + acronym.charAt(i));
        	panel2.add(labels[i]);
        	panel2.add(textFields[i]);
        }
        
        panel2.setBackground(Color.green.darker());
        //panel2.setBounds(0,75, 600, 300);
		
        /*
		JPanel panel3 = new JPanel();
        panel3.setBackground(Color.blue);
        panel3.setBounds(0, 375, 600, 200);
        panel3.setLayout(null);
        
        JButton submit = new JButton(); 
        submit.setText("Submit");
        submit.setBounds(200, 10, 75, 50);
		panel3.add(submit);
		buttonLst.add(submit);
		
		JButton showSolution = new JButton(); 
		showSolution.setText("Show Solution");
		showSolution.setBounds(300, 10, 100, 50);
		panel3.add(showSolution);
		buttonLst.add(showSolution);*/
        
        /*
        result1 = new JLabel();
        result2 = new JLabel();
        result1.setBounds(10, 50, 590, 50);
        result2.setBounds(10, 80, 590, 50);
        result1.setForeground(Color.white);
        result2.setForeground(Color.white);
		panel3.add(result1);
		panel3.add(result2);
		*/
		result1.setVisible(false);
		result2.setVisible(false);
	
		//c.add(panel1);
	    //c.add(panel2);
	    //c.add(panel3);
		
	    return buttonLst;
	}
	
	public void printTextFields() {
		boolean correctAnswer = true; 
		for(int i = 0; i < acronym.length(); i++) {
			String curTextField = textFields[i].getText().toLowerCase(); 
			if("".equals(curTextField)) {
				result2.setVisible(false);
				result1.setVisible(true);
				correctAnswer = false; 
				result1.setText("One or more of the text fields has been left blank");
			}
			else {
				if(!curTextField.toLowerCase().contains(standsFor[i].toLowerCase()))
					correctAnswer = false; 
					result2.setVisible(false);
					result1.setVisible(true);
					result1.setText("That's incorrect, try again or press 'Show Solution'");
		
			}
		}
		if(correctAnswer) {
			result2.setVisible(false);
			result1.setVisible(true);
			result1.setText("That's correct!");
		}
	}
	
	public void showSolution() {
		int solutionStringValue = 90;
		String solution = "";
		for(int i = 0; i < acronym.length(); i++) {
			String extra = extras[i];
			String solutionWord = standsFor[i];
			if(i == acronym.length() - 1)
				solution += extra + " " + solutionWord;
			else if(i == 0 && "tipp".equals(acronym)) {
				solution += extra.substring(0, 7) + " " + solutionWord + " " + extra.substring(7, extra.length()) + ", ";
			}
			else if(i == 3 && "abcplease".equals(acronym))
				solution += extra + " " + solutionWord;
			else
				solution += extra + " " + solutionWord + ", ";
			
		}
		
		result1.setVisible(true);

		if(solution.length() > solutionStringValue) {
			result2.setVisible(true);
			result1.setText(solution.substring(0, getProperSubsequence(solutionStringValue, solution)));
			result2.setText(solution.substring(getProperSubsequence(solutionStringValue, solution), solution.length()));
		}
		else {
			result2.setVisible(false);
			result1.setText(solution.substring(0, solution.length()));
			result2.setText("");
		}
	}
	
	public int getProperSubsequence(int end, String curDef) {
		int resultEnd = end; 
		while(curDef.charAt(resultEnd) != ' ') {
			resultEnd -= 1;
		}
		return resultEnd; 
	}
	
}








