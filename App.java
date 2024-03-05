
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


public class App extends JFrame{
	//JFrames
	static acronymHome acronymHome; 
	static homeScreen homeScreen; 
	static definitionsHome definitionsHome; 
	static skillMatchHome skillMatchHome;
	static situationsHome situationsHome; 
	
	//button lists
	static ArrayList<JButton> acronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> skillMatchButtonLst = new ArrayList<>();
	//static ArrayList<JButton> situationsButtonLst = new ArrayList<>();
	static ArrayList<JButton> definitionsButtonLst = new ArrayList<>();
	static ArrayList<Button> buttonLst;
	
	public static void main(String[] args) {
		mainFrame();
	}
	
	public static void mainFrame() {
		homeScreen = new homeScreen();
		buttonLst = homeScreen.homescreenPanels();
		
		buttonLst.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeScreen.dispose();
				definitionsHomeFrame();
			}
		});
		buttonLst.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeScreen.dispose();
				acronymHomeFrame();
			}
		});
		buttonLst.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeScreen.dispose();
				skillMatchFrame();
			}
		});
		buttonLst.get(3).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				homeScreen.dispose();
				situationsFrame(); 
			}
		});
	}
	
	private static void definitionsHomeFrame() {
		definitionsHome = new definitionsHome();
		OptionHomeBundle bundle = definitionsHome.optionHomePanels("Definitions", "Enter into the text box the letter corresponding to the skill that matches the definition");
		ArrayList<JButton> buttonList = bundle.buttonAl;
		ArrayList<JPanel> panelList = bundle.panelAl;
		Container c = bundle.c;
		JLabel result1 = bundle.result1;
		JLabel result2 = bundle.result2;
		definitionsButtonLst = definitionsHome.definitionsscreenPanels(c, buttonList, panelList.get(1));
		definitionsHome.assembleStack();
		definitionsHome.getDefinitions(result1, result2);
		if(buttonList.size() > 0) {
			//previous button
			buttonList.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					definitionsHome.dispose();
					buttonLst = homeScreen.homescreenPanels();
				}
			});
			buttonList.get(1).addActionListener(new ActionListener() {
							
				@Override
				public void actionPerformed(ActionEvent e) {
					definitionsHome.checkAnswers(result1, result2);
				}
			});
			buttonList.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					definitionsHome.showSolutions(result1, result2);
				}
			});
			buttonList.get(3).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					definitionsHome.getDefinitions(result1, result2);
					definitionsHome.resetTextFields();
				}
			});
		}
	}
	
	private static void acronymHomeFrame() {
		acronymHome = new acronymHome(); 
		OptionHomeBundle bundle = acronymHome.optionHomePanels("Acronyms", "Choose an acronym to practice, then fill in the blanks");
		ArrayList<JButton> buttonList = bundle.buttonAl;
		//buttonList.get(0).getName();
		ArrayList<JPanel> panelList = bundle.panelAl;
		Container c = bundle.c;
		c.remove(panelList.get(3));
		acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
		
		if(acronymButtonLst.size() > 0) {
			acronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					buttonLst = homeScreen.homescreenPanels();
				}
			});
			acronymButtonLst.get(4).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					fastAcronymFrame();
				}
			});
			acronymButtonLst.get(5).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					giveAcronymFrame();
				}
			});
			acronymButtonLst.get(6).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					dearmanAcronymFrame();
				}
			});
			acronymButtonLst.get(7).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					abcpleaseAcronymFrame();
				}
			});
			acronymButtonLst.get(8).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					stopAcronymFrame();
				}
			});
			acronymButtonLst.get(9).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					tippAcronymFrame();
				}
			});
			acronymButtonLst.get(10).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					acceptsAcronymFrame();
				}
			});
			acronymButtonLst.get(11).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					improveAcronymFrame();
				}
			});
		}
	}
	
	private static void skillMatchFrame() {
		skillMatchHome = new skillMatchHome();
		OptionHomeBundle bundle = skillMatchHome.optionHomePanels("Skill Match", "Select the category in the drop down menu that fits the skill");
		ArrayList<JButton> skillMatchButtonLst = bundle.buttonAl;
		ArrayList<JPanel> panelLst = bundle.panelAl; 
		JLabel result1 = bundle.result1;
		JLabel result2 = bundle.result2;
		ALHMPair pair = skillMatchHome.skillMatchPanels(skillMatchButtonLst, panelLst.get(1), result1, result2);
		skillMatchButtonLst = pair.al;
		Map<String, String> skillMatchHashMap = pair.hm;
		skillMatchHome.randomSkill();
		
		if(skillMatchButtonLst.size() > 0) {
			//back button 
			skillMatchButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					skillMatchHome.dispose();
					mainFrame();
				}
			});
			//submit button 
			skillMatchButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String ans = skillMatchHome.getComboBox();
					String skill = skillMatchHome.getSkill();
					
					if(ans.equals(skillMatchHashMap.get(skill))) {
						skillMatchHome.resultSetVisible(true);
					}
					else {
						skillMatchHome.resultSetVisible(false);
					}
				}
			});
			skillMatchButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String skill = skillMatchHome.getSkill();
					String ans = skillMatchHashMap.get(skill);
					skillMatchHome.showSolution(skill, ans);
				}
			});
			//next button 
			skillMatchButtonLst.get(3).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					skillMatchHome.resultSetInvisible();
					skillMatchHome.randomSkill();
				}
			});
		}
	}
	
	private static void situationsFrame() {
		situationsHome = new situationsHome();
		OptionHomeBundle bundle = situationsHome.optionHomePanels("Situations", "Select the skill in the drop down menu that fits the situation");
		ArrayList<JButton> situationsButtonLst = bundle.buttonAl;
		ArrayList<JPanel> panelLst = bundle.panelAl; 
		JLabel result1 = bundle.result1;
		JLabel result2 = bundle.result2;
		situationsButtonLst = situationsHome.situationsPanels(situationsButtonLst, panelLst.get(1), result1, result2);
		//situationsHome.getSituation();

		if(situationsButtonLst.size() > 0) {
			situationsButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					situationsHome.dispose();
					mainFrame();
				}
			});
			//submit
			situationsButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					situationsHome.submitAnswer();
				}
			});
			//show solution
			situationsButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					situationsHome.showSolution();
				}
			});
			//next
			situationsButtonLst.get(3).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					situationsHome.getSituation();
					situationsHome.getNext();
				}
			});
		}
	}
	
	private static void fastAcronymFrame() {
		acronymFrameOutline fastAcronym = new acronymFrameOutline();
		String[] standsFor = {"fair", "apologies", "values", "truthful"};
		String[] extras = {"(be)", "(no)", "stick to your", "(be)"};
		someAcronymFrame(fastAcronym, "fast", standsFor, extras);
	}
	
	private static void giveAcronymFrame() {
		acronymFrameOutline giveAcronym = new acronymFrameOutline();
		String[] standsFor = {"gentle", "interested", "validate", "easy manner"};
		String[] extras = {"(be)", "(act)", "", "(use an)"};
		someAcronymFrame(giveAcronym, "give", standsFor, extras);
	}
	
	private static void dearmanAcronymFrame() {
		acronymFrameOutline dearmanAcronym = new acronymFrameOutline();
		String[] standsFor = {"describe", "express", "assert", "reinforce", "mindful", "appear confident", "negotiate" };
		String[] extras = {"", "", "", "", "(stay)", "", "", "", ""};
		someAcronymFrame(dearmanAcronym, "dearman", standsFor, extras);
	}
	
	private static void abcpleaseAcronymFrame() {
		acronymFrameOutline abcpleaseAcronym = new acronymFrameOutline();
		String[] standsFor = {"accumulate positive emotions", "build mastery", "cope ahead", "physical",
				"illness", "eating", "substances", "sleep", "exercise" };
		String[] extras = {"", "", "", "(treat)", "", "(balance)", "(avoid mood-alterning)", "(balance)", "(get)"};
		someAcronymFrame(abcpleaseAcronym, "abcplease", standsFor, extras);
	}
	
	private static void stopAcronymFrame() {
		acronymFrameOutline stopAcronym = new acronymFrameOutline();
		String[] standsFor = {"stop", "take a step back", "observe", "proceed mindfully"};
		String[] extras = {"", "", "", ""};
		someAcronymFrame(stopAcronym, "stop", standsFor, extras);
	}
	
	private static void tippAcronymFrame() {
		acronymFrameOutline tippAcronym = new acronymFrameOutline();
		String[] standsFor = {"temperature", "intense exercise", "paced breathing", "paired muscle relaxation"};
		String[] extras = {"tip the of your face with cold water", "", "", ""};
		someAcronymFrame(tippAcronym, "tipp", standsFor, extras);
	}
	
	private static void acceptsAcronymFrame() {
		acronymFrameOutline acceptsAcronym = new acronymFrameOutline();
		String[] standsFor = {"activities", "contributing", "comparisons",
				"emotions", "pushing away", "thoughts", "sensations"};
		String[] extras = {"(With)", "(With)", "(With)", "(With different)", "(With)", "(With other)", "(With other)"};
		someAcronymFrame(acceptsAcronym, "accepts", standsFor, extras);
	}
	
	private static void improveAcronymFrame() {
		acronymFrameOutline improveAcronym = new acronymFrameOutline();
		String[] standsFor = {"Imagery", "Meaning", "Prayer", "Relaxing actions", "One thing in the moment", "Vacation", "Encouragement and rethinking"};
		String[] extras = {"(With)", "(With)", "(With)", "(With)", "(With)", "(Wih a brief)", "(With) self-"};
		someAcronymFrame(improveAcronym, "improve", standsFor, extras);
	}
	
	private static void someAcronymFrame(final acronymFrameOutline acronym, String acronymName, String[] standsFor, String[] extras) {
		OptionHomeBundle bundle = acronym.optionHomePanels(acronymName.toUpperCase() + " Acronym", "Fill in the blanks, then press submit");
		Container c = bundle.c;
		JLabel result1 = bundle.result1;
		JLabel result2 = bundle.result2;
		ArrayList<JButton> buttonList = bundle.buttonAl;
		ArrayList<JPanel> panelList = bundle.panelAl;
		
		acronym.customizeOutline(acronymName, standsFor, extras);
		ArrayList<JButton> acronymButtonLst = acronym.acronymFramePanels(c, result1, result2, panelList.get(1));
		
		for(int i = 0; i < buttonList.size(); i++) {
			acronymButtonLst.add(buttonList.get(i));
		}
		if(acronymButtonLst.size() > 0) {
			//previous button
			acronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronym.dispose();
					acronymHomeFrame();
				}
			});
			//submit button
			acronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronym.printTextFields();
				}
			});
			//show solution button
			acronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronym.showSolution();
				}
			});
			//next button
			acronymButtonLst.get(3).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronym.dispose();
					if("fast".equals(acronymName)) {
						giveAcronymFrame();
					}
					else if("give".equals(acronymName)) {
						dearmanAcronymFrame();
					}
					else if("dearman".equals(acronymName)) {
						abcpleaseAcronymFrame();
					}
					else if("abcplease".equals(acronymName)) {
						stopAcronymFrame(); 
					}
					else if("stop".equals(acronymName)) {
						tippAcronymFrame(); 
					}
					else if("tipp".equals(acronymName)) {
						acceptsAcronymFrame(); 
					}
					else if("accepts".equals(acronymName)) {
						improveAcronymFrame(); 
					}
					else if("improve".equals(acronymName)) {
						fastAcronymFrame(); 
					}
				}
			});
		}
	}
	
}
