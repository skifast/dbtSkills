import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionHomeBundle {
	ArrayList<JButton> buttonAl = new ArrayList<>();
	ArrayList<JPanel> panelAl = new ArrayList<>();
	Container c;
	JLabel result1; 
	JLabel result2; 
	
	public OptionHomeBundle() {
		
	}
	
	public void assignValues(ArrayList<JButton> buttonAl, ArrayList<JPanel> panelAl, Container c, JLabel result1, JLabel result2) {
		this.buttonAl = buttonAl;
		this.panelAl = panelAl;
		this.c = c;
		this.result1 = result1;
		this.result2 = result2; 
	}
}