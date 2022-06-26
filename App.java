
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
	
	static acronymFrameOutline fastAcronym;
	static acronymFrameOutline giveAcronym;
	static acronymFrameOutline dearmanAcronym;
	static acronymFrameOutline abcpleaseAcronym;
	
	static stopAcronym stopAcronym; 
	static tippAcronym tippAcronym; 
	static acceptsAcronym acceptsAcronym; 
	
	//button lists
	static ArrayList<JButton> acronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> skillMatchButtonLst = new ArrayList<>();
	static ArrayList<JButton> situationsButtonLst = new ArrayList<>();
	static ArrayList<JButton> fastAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> giveAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> dearmanAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> abcpleaseAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> stopAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> tippAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> acceptsAcronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> definitionsButtonLst = new ArrayList<>();
	static ArrayList<Button> buttonLst;
	
	public static void main(String[] args) {
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
		definitionsHome.getDefinitions();
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
		}
	}
	
	private static void acronymHomeFrame() {
		acronymHome = new acronymHome(); 
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
		
		if(acronymButtonLst.size() > 0) {
			acronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					buttonLst = homeScreen.homescreenPanels();
				}
			});
			acronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					fastAcronymFrame();
				}
			});
			acronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					giveAcronymFrame();
				}
			});
			acronymButtonLst.get(3).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					dearmanAcronymFrame();
				}
			});
			acronymButtonLst.get(4).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					abcpleaseAcronymFrame();
				}
			});
			acronymButtonLst.get(5).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					stopAcronymFrame();
				}
			});
			acronymButtonLst.get(6).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					tippAcronymFrame();
				}
			});
			acronymButtonLst.get(7).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymHome.dispose();
					acceptsAcronymFrame();
				}
			});
		}
	}
	
	private static void skillMatchFrame() {
		homeScreen.dispose();
		skillMatchHome = new skillMatchHome();
		ALHMPair pair = skillMatchHome.skillMatchPanels();
		skillMatchButtonLst = pair.al;
		Map<String, String> skillMatchHashMap = pair.hm;
		skillMatchHome.randomSkill();
		
		if(skillMatchButtonLst.size() > 0) {
			//back button 
			skillMatchButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					skillMatchHome.dispose();
					buttonLst = homeScreen.homescreenPanels();
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
			//next button 
			skillMatchButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					skillMatchHome.resultSetInvisible();
					skillMatchHome.randomSkill();
				}
			});
		}
	}
	
	private static void situationsFrame() {
		homeScreen.dispose();
		situationsHome = new situationsHome();
		situationsButtonLst = situationsHome.situationsPanels();
		//situationsHome.addSituation();

		if(situationsButtonLst.size() > 0) {
			situationsButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					situationsHome.dispose();
					buttonLst = homeScreen.homescreenPanels();
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
					situationsHome.getNext();
				}
			});
		}
	}
	
	private static void fastAcronymFrame() {
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		
		fastAcronym = new acronymFrameOutline();
		String[] standsFor = {"fair", "apologies", "stick to your values", "truthful"};
		String[] extras = {"(be)", "(no)", "", "(be)"};
		fastAcronym.customizeOutline("fast", standsFor, extras);
		fastAcronymButtonLst = fastAcronym.acronymFramePanels();
		
		if(fastAcronymButtonLst.size() > 0) {
			//previous button
			fastAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fastAcronym.dispose();
					acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
				}
			});
			//submit button
			fastAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fastAcronym.printTextFields();
				}
			});
			//show solution button
			fastAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					fastAcronym.showSolution();
				}
			});
		}
	}
	
	private static void giveAcronymFrame() {
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		
		giveAcronym = new acronymFrameOutline();
		String[] standsFor = {"gentle", "interested", "validate", "easy manner"};
		String[] extras = {"(be)", "(act)", "", "(use an)"};
		giveAcronym.customizeOutline("give", standsFor, extras);
		giveAcronymButtonLst = giveAcronym.acronymFramePanels();
		
		
		if(giveAcronymButtonLst.size() > 0) {
			//previous button
			giveAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					giveAcronym.dispose();
					acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
				}
			});
			//submit button
			giveAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					giveAcronym.printTextFields();
				}
			});
			//show solution button
			giveAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					giveAcronym.showSolution();
				}
			});
		}
	}
	
	private static void dearmanAcronymFrame() {
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		
		dearmanAcronym = new acronymFrameOutline();
		String[] standsFor = {"describe", "express", "assert", "reinforce", "mindful", "appear confident", "negotiate" };
		String[] extras = {"", "", "", "", "(stay)", "", "", "", ""};
		dearmanAcronym.customizeOutline("dearman", standsFor, extras);
		dearmanAcronymButtonLst = dearmanAcronym.acronymFramePanels();
		
		
		if(dearmanAcronymButtonLst.size() > 0) {
			//previous button
			dearmanAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dearmanAcronym.dispose();
					acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
				}
			});
			//submit button
			dearmanAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dearmanAcronym.printTextFields();
				}
			});
			//show solution button
			dearmanAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dearmanAcronym.showSolution();
				}
			});
		}
	}
	
	private static void abcpleaseAcronymFrame() {
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		
		abcpleaseAcronym = new acronymFrameOutline();
		String[] standsFor = {"accumulate positive emotions", "build mastery", "cope ahead", "physical",
				"illness", "eating", "substances", "sleep", "exercise" };
		String[] extras = {"", "", "", "(treat)", "", "(balance)", "(avoid mood-alterning)", "(balance)", "(get)"};
		abcpleaseAcronym.customizeOutline("abcplease", standsFor, extras);
		abcpleaseAcronymButtonLst = abcpleaseAcronym.acronymFramePanels();
		
		if(abcpleaseAcronymButtonLst.size() > 0) {
			//previous button
			abcpleaseAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					abcpleaseAcronym.dispose();
					acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
				}
			});
			//submit button
			abcpleaseAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					abcpleaseAcronym.printTextFields();
				}
			});
			//show solution button
			abcpleaseAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					abcpleaseAcronym.showSolution();
				}
			});
		}
	}
	
	private static void stopAcronymFrame() {
		stopAcronym = new stopAcronym("stop");
		stopAcronymButtonLst = stopAcronym.stopAcronymPanels();
		
		if(stopAcronymButtonLst.size() > 0) {
			//previous button
			stopAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					stopAcronym.dispose();
					stopAcronymButtonLst = stopAcronym.stopAcronymPanels();
				}
			});
			//submit button
			stopAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					stopAcronym.printTextFields();
				}
			});
			//show solution button
			stopAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					stopAcronym.showSolution();
				}
			});
		}
	}
	
	private static void tippAcronymFrame() {
		tippAcronym = new tippAcronym("tipp");
		tippAcronymButtonLst =tippAcronym.tippAcronymPanels();
		
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		
		
		if(tippAcronymButtonLst.size() > 0) {
			//previous button
			tippAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tippAcronym.dispose();
					acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
				}
			});
			//submit button
			tippAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tippAcronym.printTextFields();
				}
			});
			//show solution button
			tippAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tippAcronym.showSolution();
				}
			});
		}
	}
	
	private static void acceptsAcronymFrame() {
		acceptsAcronym = new acceptsAcronym("accepts");
		acceptsAcronymButtonLst = acceptsAcronym.acceptsAcronymPanels();
		
		ButtonALPanelALPair buttonsNPanels = acronymHome.optionHomePanels("Acronyms");
		ArrayList<JButton> buttonList = buttonsNPanels.buttonAl;
		ArrayList<JPanel> panelList = buttonsNPanels.panelAl;
		
		if(acceptsAcronymButtonLst.size() > 0) {
			//previous button
			acceptsAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acceptsAcronym.dispose();
					acronymButtonLst = acronymHome.acronymscreenPanels(buttonList, panelList.get(1));
				}
			});
			//submit button
			acceptsAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acceptsAcronym.printTextFields();
				}
			});
			//show solution button
			acceptsAcronymButtonLst.get(2).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acceptsAcronym.showSolution();
				}
			});
		}
	}
 	
	private static void improveAcronymFrame() {
		
	}
}
