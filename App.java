
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import dbtSkills.acronymHome;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox; 


public class App extends JFrame{
	static JFrame frame;
	static JFrame frame2;
	static JFrame frame3;
	static JFrame skillMatch; 
	static JFrame giveAcronym; 
	static JFrame dearmanAcronym;
	
	//JFrames
	static acronymHome acronymHome; 
	static homeScreen homeScreen; 
	static skillMatchHome skillMatchHome;
	static situationsHome situationsHome; 
	static fastAcronym fastAcronym;
	
	static ArrayList<JButton> acronymButtonLst = new ArrayList<>();
	static ArrayList<JButton> skillMatchButtonLst = new ArrayList<>();
	static ArrayList<JButton> situationsButtonLst = new ArrayList<>();
	static ArrayList<JButton> fastAcronymButtonLst = new ArrayList<>();
	static ArrayList<Button> buttonLst;
	
	public static void main(String[] args) {
		//frame = new JFrame();
		//frame.setPreferredSize(new Dimension(600, 450));
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setBackground(Color.green.darker());
		
		homeScreen = new homeScreen();
		buttonLst = homeScreen.homescreenPanels();
		
		
		buttonLst.get(0).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				acronymFrame();
			}
		});
		buttonLst.get(1).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				skillMatchFrame();
			}
		});
		buttonLst.get(2).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				situationsFrame(); 
			}
		});
		 
	}
	private static void acronymFrame() {
		//JFrame acronymFrame = new acronymHome();
		homeScreen.dispose(); 
		acronymHome = new acronymHome(); 
		acronymButtonLst = acronymHome.acronymscreenPanels();
		
		if(acronymButtonLst.size() > 0) {
			acronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
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
		

		if(situationsButtonLst.size() > 0) {
			situationsButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					buttonLst = homeScreen.homescreenPanels();
				}
			});
		}
	}
	
	private static void fastAcronymFrame() {
		acronymHome.dispose();
		fastAcronym = new fastAcronym();
		fastAcronymButtonLst = fastAcronym.fastAcronymPanels();
		
		if(fastAcronymButtonLst.size() > 0) {
			fastAcronymButtonLst.get(0).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					acronymButtonLst = acronymHome.acronymscreenPanels();
				}
			});
			fastAcronymButtonLst.get(1).addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("submit");
				}
			});
		}
	}
	
	/*
	private static void mainScreen() {
		
		Button btn_1 = new Button("Acronyms");
		btn_1.setBackground(Color.green.darker());
		btn_1.setPreferredSize(new Dimension(400, 100)); 

		Button btn_2 = new Button("Skill Match");
		btn_2.setBackground(Color.green.darker());
		btn_2.setPreferredSize(new Dimension(400, 100)); 

		Button btn_3 = new Button("Situation");
		btn_3.setBackground(Color.green.darker());
		btn_3.setPreferredSize(new Dimension(400, 100));    

		GridLayout layout = new GridLayout(3, 1);
		
		JPanel players = new JPanel(layout);
		
		JPanel cell1 = new JPanel();
		cell1.add(btn_1);
		cell1.setBackground(Color.green.darker());
		players.add(cell1);
		JPanel cell2 = new JPanel();
		cell2.add(btn_2);
		cell2.setBackground(Color.green.darker());
		players.add(cell2);
		JPanel cell3 = new JPanel();
		cell3.add(btn_3);
		cell3.setBackground(Color.green.darker());
		players.add(cell3);
		players.setBackground(Color.green.darker());
		players.setPreferredSize(new Dimension(450, 350));
		

		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		btn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				secondScreen();
			}
		});
		btn_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				skillMatch();
			}
		});
		btn_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cell3.setBackground(Color.pink.darker());
			}
		});
		
		frame.setContentPane(content);
		content.add(players);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void secondScreen() {
		frame.dispose();
		frame2 = new panelx(frame);
		
		frame2.setPreferredSize(new Dimension(600, 450));
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel previousPanel = new JPanel();
		panelx next = new panelx(frame); 
		JPanel players = new JPanel();
		
		
		JLabel acronyms = new JLabel();
		acronyms.setText("Acronyms");
		players.add(acronyms);
		
		JButton fast = new JButton();
		fast.setText("FAST");
		players.add(fast);
		fast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fastAcronym();
			}
		});
		
		JButton give = new JButton();
		give.setText("GIVE");
		players.add(give);
		give.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				giveAcronym();
			}
		});
		
		JButton dearman = new JButton();
		dearman.setText("DEARMAN");
		players.add(dearman);
		dearman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dearmanAcronym();
			}
		});
		
		
		previousPanel.setBackground(Color.magenta);
		previousPanel.setLayout(null);
		previousPanel.setBounds(100, 50, 300, 200);
		//previousPanel.setPreferredSize(new Dimension(450, 150));
		players.setBackground(Color.green.darker());
		//players.setPreferredSize(new Dimension(450, 250));
		

		//JPanel content = new JPanel();
		//content.setLayout(new BorderLayout());
		//frame2.setContentPane(content);
		//content.add(players);
		//content.add(previousPanel);
		//content.add(next); 
		//
		frame2.pack();
		frame2.setVisible(true);
	}
	*/
	/*
	private static void skillMatch() {
		frame.dispose();
		skillMatch = new JFrame(); 
		skillMatch.setPreferredSize(new Dimension(600, 450));
		skillMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//GridLayout layout = new GridLayout(3, 0);
		
		JPanel players = new JPanel();
		
		JLabel skill1 = new JLabel();
		skill1.setBounds(40, 40, 40, 20);
		skill1.setText("skill1");
		players.add(skill1);
		
		String[] optionsToChoose = {"Mindfulness", "Interpersonal Effectiveness", "Emotional Regulation", "Distress tolerance"};

		JComboBox<String> category1 = new JComboBox<>(optionsToChoose);
		category1.setBounds(80, 50, 160, 20);
        players.add(category1);
		
        /*
        JLabel skill2 = new JLabel();
        
		skill2.setText("skill2");
		players.add(skill2);
		
		
		JComboBox<String> category2 = new JComboBox<>(optionsToChoose);
		//category2.setBounds(80, 50, 140, 20);
        players.add(category2);
        
        
        
        JLabel skill3 = new JLabel();
		skill3.setText("skill3");
		players.add(skill2);
		
		JComboBox<String> category3 = new JComboBox<>(optionsToChoose);
		//category3.setBounds(80, 50, 140, 20);
        players.add(category3);
		*/
		/*
		JLabel skill3 = new JLabel();
		skill2.setText("skill3");
		players.add(skill3);
		
		JLabel skill4 = new JLabel();
		skill4.setText("skill4");
		players.add(skill4);
		
		JLabel skill5 = new JLabel();
		skill2.setText("skill5");
		players.add(skill5);
		
		
		JLabel skill6 = new JLabel();
		skill2.setText("skill6");
		players.add(skill6);
		
		//get rid of the JPanel's layout
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		skillMatch.setContentPane(content);
		content.add(players);
		
		//skillMatch.add(players);
		skillMatch.pack();
		skillMatch.setVisible(true);
		
	}
*/
	/*
	private static void fastAcronym() {
		Map<Character, String> fastHM = new HashMap<>();
		fastHM.put('f', "fair");
		fastHM.put('a', "apologies");
		fastHM.put('s', "stick to values");
		fastHM.put('t', "truthful");
		
		frame2.dispose();
		frame3 = new JFrame();
		frame3.setPreferredSize(new Dimension(600, 450));
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		GridLayout layout = new GridLayout(4, 1);
		JPanel players = new JPanel(layout);
		players.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		/*
		Dimension size = f.getPreferredSize();
		f.setBounds(30, 30, size.width, size.height);
		*/
		
		/*
		JButton previous = new JButton("Previous");
		players.add(previous);
		previous.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				secondScreen();
			}
		});
		
		
		JLabel f = new JLabel();
		f.setText("F");
		players.add(f);
		JTextField fText = new JTextField();
		players.add(fText);
		JLabel a = new JLabel();
		a.setText("A");
		players.add(a);
		JTextField aText = new JTextField();
		players.add(aText);
		JLabel s = new JLabel();
		s.setText("S");
		players.add(s);
		JTextField sText = new JTextField();
		players.add(sText);
		JLabel t = new JLabel();
		t.setText("T");
		players.add(t);
		JTextField tText = new JTextField();
		players.add(tText);
		
		players.setBackground(Color.green.darker());
		players.setPreferredSize(new Dimension(450, 350));
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		frame3.setContentPane(content);
		content.add(players);
		frame3.pack();
		frame3.setVisible(true);
		
	}
*/
	
	private static void giveAcronym() {
		frame2.dispose();
		giveAcronym = new JFrame();
		giveAcronym.setPreferredSize(new Dimension(600, 450));
		giveAcronym.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		GridLayout layout = new GridLayout(4, 1);
		JPanel players = new JPanel(layout);
		players.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		/*
		Dimension size = f.getPreferredSize();
		f.setBounds(30, 30, size.width, size.height);
		*/
		JLabel g = new JLabel();
		g.setText("G");
		players.add(g);
		JLabel i = new JLabel();
		i.setText("I");
		players.add(i);
		JLabel v = new JLabel();
		v.setText("V");
		players.add(v);
		JLabel e = new JLabel();
		e.setText("E");
		players.add(e);
		
		players.setBackground(Color.green.darker());
		players.setPreferredSize(new Dimension(450, 350));
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		giveAcronym.setContentPane(content);
		content.add(players);
		giveAcronym.pack();
		giveAcronym.setVisible(true);
		
	}
	
	private static void dearmanAcronym() {
		frame2.dispose();
		dearmanAcronym = new JFrame();
		dearmanAcronym.setPreferredSize(new Dimension(600, 450));
		dearmanAcronym.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		GridLayout layout = new GridLayout(4, 1);
		JPanel players = new JPanel(layout);
		players.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//JLabel f = new JLabel();
		/*
		Dimension size = f.getPreferredSize();
		f.setBounds(30, 30, size.width, size.height);
		*/
		JLabel d = new JLabel();
		d.setText("D");
		players.add(d);
		JLabel e = new JLabel();
		e.setText("E");
		players.add(e);
		JLabel a = new JLabel();
		a.setText("A");
		players.add(a);
		JLabel r = new JLabel();
		r.setText("R");
		players.add(r);
		JLabel m = new JLabel();
		m.setText("M");
		players.add(m);
		JLabel a2 = new JLabel();
		a2.setText("A");
		players.add(a2);
		JLabel n = new JLabel();
		n.setText("N");
		players.add(n);
		
		players.setBackground(Color.green.darker());
		players.setPreferredSize(new Dimension(450, 350));
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		dearmanAcronym.setContentPane(content);
		content.add(players);
		dearmanAcronym.pack();
		dearmanAcronym.setVisible(true);
		
	}
}
