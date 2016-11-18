package blackjack;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gamestate extends JPanel {
	//STATIC
	public static HashMap<String, Gamestate> gamestates;
	public static JPanel header; // store a header common to all states
	
	public static void buildStates(){
		buildHeader();
		gamestates = new HashMap<>();
		gamestates.put("SelectUser", buildSelectUser());
		gamestates.put("PlayerRound", buildPlayerRound());
		gamestates.put("DealerRound", buildDealerRound());
		gamestates.put("RoundResolution", buildRoundResolution());
	}
	
	public static void buildHeader(){
		header = new JPanel();
		Label headerText = new Label("Blackjack: The Game");
		headerText.setFont(new Font("Arial", Font.ITALIC, 24));
		header.add(headerText);
	}
	
	public static Gamestate buildSelectUser(){
		Gamestate g = new Gamestate();
		g.panels[1] = header;
		g.panels[4].setLayout(new BoxLayout(g.panels[4], BoxLayout.X_AXIS));
		g.panels[4].add(new Label("Enter your username: "));
		JTextField playerName = new JTextField("Anonymous", 40);
		playerName.setMaximumSize(playerName.getPreferredSize());
		g.panels[4].add(playerName);
		String buttonName = "Continue";
		JButton button = new JButton(buttonName);
		g.panels[7].add(button);
		g.buttons.put(buttonName, button);
		g.addPanels();
		return g;
	}
	
	public static Gamestate buildPlayerRound(){
		Gamestate g = new Gamestate();
		g.panels[1] = header;
		g.addPanels();
		return g;
	} 
	public static Gamestate buildDealerRound(){
		Gamestate g = new Gamestate();
		return g;
	}
	public static Gamestate buildRoundResolution(){
		Gamestate g = new Gamestate();
		return g;
	}
	
	//INSTANCE
	private JPanel[] panels;
	private HashMap<String, JButton> buttons;
	
	public Gamestate(){
		super();
		panels = new JPanel[9];
		buttons = new HashMap<>();
		for (int i = 0; i < panels.length; i++){
			panels[i] = new JPanel();
		}
		this.setLayout(new GridLayout(3, 3));
	}
	
	public void setButtonAction(String name, ActionListener a){
		JButton b = buttons.get(name);
		if (b != null){
			b.addActionListener(a);
		}
	}
	
	public void addPanels(){
		for (int i = 0; i < panels.length; i++){
			this.add(panels[i]);
		}
	}
}
