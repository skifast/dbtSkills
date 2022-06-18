
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ALHMPair {
	Map<String, String> hm = new HashMap<>();
	ArrayList<JButton> al = new ArrayList<>();
	
	public ALHMPair(Map<String, String> hm, ArrayList<JButton> al) {
		this.hm = hm;
		this.al = al; 
	}
}
