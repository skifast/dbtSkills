package workoutCalendar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class userInput extends JFrame{
	private int partialWidth = 600;
	private int partialHeight = 575; 
	private int fullWidth = 1600;
	private int fullHeight = 1000;
	private int width;
	private int height; 
	
	private Color barbiePink = new Color(233, 65, 150);
	private Color lightPink = new Color(250, 209, 230);
	private Color powderblue = new Color(168, 234, 255);
	
	public userInput() {
		width = partialWidth;
		height = partialHeight;
		  
        setTitle("Record Your Workout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //userInput.setLayout(new GridLayout());
	      //setting the bounds for the JFrame
        setPreferredSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
	}
	
	public void userInputPanels(String number) {
		Container c = this.getContentPane();
		assembleWindowPanes(c, number);
        
	}
	
	private void assembleWindowPanes(Container c, String number) {
		int borderThickness = 4; 
		JPanel[] panels = renderBasePanels(c); 
		JPanel lowerRight = panels[3];
		JPanel upperPanel = panels[1];
		Font copperplateH1 = new Font("Copperplate", Font.PLAIN, 54);
		Font copperplateH2 = new Font("Copperplate", Font.PLAIN, 24);
		
		
		JPanel titlePanel = new JPanel(); 
		titlePanel.setBackground(Color.white);
		titlePanel.setPreferredSize(new Dimension(width - borderThickness * 8, 55));
		//titlePanel.setLayout(new GridLayout(2, 1));
		upperPanel.add(titlePanel);
		
		JLabel title = new JLabel();
		title.setText("Valerie's Workout");
		title.setBounds(width/2 - title.getWidth()/2, 20, title.getWidth(), title.getHeight());
		title.setFont(copperplateH1);
		title.setForeground(barbiePink);
		titlePanel.add(title);
		
		
		JPanel datePanel = new JPanel(); 
		datePanel.setBackground(powderblue);
		datePanel.setPreferredSize(new Dimension(width/2, 30));
		datePanel.setLayout(new FlowLayout());
		upperPanel.add(datePanel);
		
		
		JLabel date = new JLabel(); 
		date.setText("July " + number);
		date.setBounds(width/2 - title.getWidth()/2, 50, title.getWidth(), title.getHeight());
		date.setFont(copperplateH2);
		date.setForeground(Color.white);
		datePanel.add(date);
		
		 
		JPanel exerciseCategoryPanel = new JPanel(); 
		exerciseCategoryPanel.setBackground(powderblue);
		exerciseCategoryPanel.setPreferredSize(new Dimension(width/2, 30));
		exerciseCategoryPanel.setLayout(new FlowLayout());
		upperPanel.add(exerciseCategoryPanel);
		
		JLabel exerciseCategories = new JLabel();
		exerciseCategories.setBounds(width/2 - title.getWidth()/2, 200, title.getWidth(), title.getHeight());
		exerciseCategories.setFont(copperplateH2);
		exerciseCategories.setForeground(Color.white);
		exerciseCategoryPanel.add(exerciseCategories);
		
		JPanel exercisesPanel = new JPanel(); 
		exercisesPanel.setBackground(Color.white);
		exercisesPanel.setPreferredSize(new Dimension(width - borderThickness * 8, 110));
		//exercisesPanel.setBounds(50, 50, 100, 100);
		//exercisesPanel.setPreferredSize(new Dimension(width - borderThickness * 8, 75));
		upperPanel.add(exercisesPanel);
		
        String[] exerciseGroup = {"Strength", "Cardio", "Stretching"};
        JComboBox<String> exerciseType = new JComboBox<>(exerciseGroup);
        renderComboBox(exerciseType, true, lowerRight);
        
        JButton selectType = new JButton();
        renderButton(selectType, "Submit Exercise Type", true, lowerRight);
        
        JButton selectStrength = new JButton();
        renderButton(selectStrength, "Submit Strength Type", false, lowerRight);
        
        JButton selectCardio = new JButton();
        renderButton(selectCardio, "Submit Cardio Type", false, lowerRight); 
        
        
        String[] strengthCategories = getStrengthCategories();
        JComboBox<String> strengthType = new JComboBox<>(strengthCategories);
        renderComboBox(strengthType, false, lowerRight);
        
        String[] cardioCategories = getCardioCategories();
        JComboBox<String> cardioType = new JComboBox<>(cardioCategories);
        renderComboBox(cardioType, false, lowerRight);
        
        selectType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exerciseType.setVisible(false);
				selectType.setVisible(false);
				
				String type = (String) exerciseType.getSelectedItem();
				if("Strength".equals(type)) {
					//lowerRight.remove(selectType);
					//lowerRight.remove(exerciseType);
					lowerRight.add(strengthType);
					lowerRight.add(selectStrength);
					
				}
				else if("Cardio".equals(type)) {
					//lowerRight.remove(selectType);
					//lowerRight.remove(exerciseType);
					lowerRight.add(cardioType);
					lowerRight.add(selectCardio);
				}
				exerciseCategories.setText(type);
			}
		});
        
        selectStrength.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectStrength.setVisible(false);
				strengthType.setVisible(false);
				System.out.println("submit strength category");
				String type = (String) strengthType.getSelectedItem();
				lowerRight.remove(selectStrength);
				lowerRight.remove(strengthType);
				if("Squat".equals(type)) {
					lowerRight.remove(selectStrength);
					lowerRight.remove(strengthType);
					//lowerRight.add(strengthType);
					//lowerRight.add(selectStrength);
				}
			}
		});
        
        cardioType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				exerciseType.setVisible(false);
				selectType.setVisible(false);
				
				String type = (String) exerciseType.getSelectedItem();
				if("Cardio".equals(type)) {
					lowerRight.remove(selectType);
					lowerRight.remove(exerciseType);
					lowerRight.add(cardioType);
					lowerRight.add(selectCardio);
				}
			}
		});
        
        
        /*
        
        String[] stretchingCategories = {}; */
       
        
        /*
        JButton next = new JButton();
        next.setText("Next");
        next.setForeground(barbiePink);
        next.setBackground(powderblue);
        next.setPreferredSize(new Dimension(200, 50));
        //set border to empty
        next.setBorder(emptyBorder);
        next.setOpaque(true);
        lowerRight.add(next);*/
       
	}
	
	private JPanel[] renderBasePanels(Container c) {
		int borderThickness = 4; 
		JPanel[] panels = new JPanel[5];
		
		JPanel userPanel = new JPanel(); 
        userPanel.setBackground(Color.white);
        userPanel.setPreferredSize(new Dimension(width, height));
        userPanel.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, borderThickness, borderThickness, barbiePink));
        c.add(userPanel);
        panels[0] = userPanel;
        
        JPanel upperPanel = new JPanel(); 
        upperPanel.setBackground(lightPink);
        upperPanel.setPreferredSize(new Dimension(width - borderThickness*4, height/2 - borderThickness*6));
        upperPanel.setBorder(BorderFactory.createMatteBorder(borderThickness, borderThickness, 0, borderThickness, Color.white));
        userPanel.add(upperPanel);
        userPanel.setLayout(new GridLayout(2, 1));
        panels[1] = upperPanel;
        
        JPanel lowerPanel = new JPanel(); 
        lowerPanel.setBackground(Color.white);
        lowerPanel.setPreferredSize(new Dimension(width - borderThickness * 4, height/2 - borderThickness * 4));
        lowerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        userPanel.add(lowerPanel);
        panels[2] = lowerPanel;
        
        
        JPanel lowerRight = new JPanel();
        lowerRight.setBackground(lightPink);
        lowerRight.setPreferredSize(new Dimension(width/2 - borderThickness*4, height/2 - borderThickness*6));
        lowerRight.setBorder(BorderFactory.createMatteBorder(0, 0, borderThickness, borderThickness/2, Color.white));
        lowerPanel.add(lowerRight);
        panels[3] = lowerRight;
        
        JPanel lowerLeft = new JPanel(); 
        lowerLeft.setBackground(lightPink);
        lowerLeft.setPreferredSize(new Dimension(width/2 - borderThickness*4, height/2 - borderThickness*6));
        lowerLeft.setBorder(BorderFactory.createMatteBorder(0, borderThickness/2, borderThickness, 0, Color.white));
        lowerPanel.add(lowerLeft);
        panels[4] = lowerLeft;
        
        return panels;
	}
	
	private String[] getStrengthCategories() {
		String[] strengthCategories = {"Shoulders", "Back", "Quads", "Hamstrings", "Biceps", "Glutes"};
		return strengthCategories;
	}
	
	private String[] getCardioCategories() {
		String[] strengthCategories = {"Walk", "Run", "Bike", "Ski", "Golf"};
		return strengthCategories;
	}
	
	private void renderButton(JButton button, String buttonText, boolean addToPage, JPanel addToPanel) {
		button.setText(buttonText);
        button.setForeground(barbiePink);
        button.setBackground(powderblue);
        button.setPreferredSize(new Dimension(200, 50));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        //set border to empty
        button.setBorder(emptyBorder);
        button.setOpaque(true);
        //selectType.setContentAreaFilled(false);
        if(addToPage)
        	addToPanel.add(button);
	}
	
	private void renderComboBox(JComboBox comboBox, boolean addToPage, JPanel addToPanel) {
		comboBox.setBackground(powderblue);
		comboBox.setForeground(barbiePink);
		//comboBox.setBounds(80, 50, 140, 20);
		comboBox.setPreferredSize(new Dimension(200, 50));
		if(addToPage)
			addToPanel.add(comboBox);
	}
}
