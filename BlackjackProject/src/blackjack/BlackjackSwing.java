package blackjack;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlackjackSwing extends JFrame {
	Gamestate currentState;
	Blackjack game;
	String userName;
	JPanel header;
	JPanel panelGetUserName;
	JPanel panelPlayerTurn;
	Label userNameLabel;
	Label moneyLabel;
	Label playerCountLabel;
	Label dealerCountLabel;

	public BlackjackSwing() {
		super("Blackjack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
	}

	// called at start of program
	public void init() {
		Gamestate.buildStates(); //initialize the gamestates
		currentState = Gamestate.gamestates.get("SelectUser");
		this.add(currentState);
		ActionListener a = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setGamestate("PlayerRound");
			}
		};
		currentState.setButtonAction("Continue", a);
		
		this.setSize(Card.WIDTH * 8, Card.HEIGHT * 4);
		this.setVisible(true);
	}
	
	public void setGamestate(String state){
		remove(currentState);
		currentState = Gamestate.gamestates.get("PlayerRound");
		add(currentState);
		repaint();		
	}

	public void initHeader() {
		header = new JPanel();
		Label headerText = new Label("Blackjack: The Game");
		headerText.setFont(new Font("Arial", Font.ITALIC, 24));
		header.add(headerText);
		this.add(header, BorderLayout.NORTH);
	}

	public void initUserName() {
		panelGetUserName = new JPanel();
		panelGetUserName.add(new Label("Enter your username: "), BorderLayout.CENTER);
		TextField getUserName = new TextField("Player 1");
		panelGetUserName.add(getUserName, BorderLayout.CENTER);
		JButton button = new JButton("Continue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = getUserName.getText();
				remove(panelGetUserName);
				game = new Blackjack();
				switchToPlayView();
			}
		});
		panelGetUserName.add(button);
		this.add(panelGetUserName, BorderLayout.CENTER);
	}

	public void switchToPlayView() {
		panelPlayerTurn = new JPanel();
		panelPlayerTurn.setLayout(new BoxLayout(panelPlayerTurn, BoxLayout.Y_AXIS));

		//dealerPanel
		JPanel dealerPanel = new JPanel();
		Label dealerLabel = new Label("Dealer: ");
		dealerPanel.add(dealerLabel);
		dealerPanel.add(game.dealer.get(0).back());
		dealerPanel.add(game.dealer.get(1).front());
		panelPlayerTurn.add(dealerPanel);
		//end dealerPanel

		//playerPanel
		JPanel playerPanel = new JPanel();
		{
			JPanel playerLabelPanel = new JPanel();
			userNameLabel = new Label(userName + ": ");
			playerCountLabel = new Label("(" + game.sumCards(game.player) + ")");
			playerLabelPanel.setLayout(new BoxLayout(playerLabelPanel, BoxLayout.Y_AXIS));
			playerLabelPanel.add(userNameLabel);
			playerLabelPanel.add(playerCountLabel);
			playerPanel.add(playerLabelPanel);
		}
		playerPanel.add(game.player.get(0).front());
		playerPanel.add(game.player.get(1).front());
		panelPlayerTurn.add(playerPanel);
		//end playerPanel
		
		//buttonPanel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JButton hit = new JButton("Hit");
		JButton stay = new JButton("Stay");
		hit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		stay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		

		this.add(panelPlayerTurn, BorderLayout.WEST);
		resetScreen();

	}

	public void resetScreen() {
		this.revalidate();
		this.repaint();
	}

	public static void main(String[] args) {
		new BlackjackSwing();
	}
}
