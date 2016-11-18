package blackjack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlipCardTest extends JFrame {
	JPanel aceFront;
	JPanel aceBack;
	JPanel currentPanel;
	JButton button;

	public FlipCardTest() {
		super("Blackjack");
		Card ace = new Card(12, 0);
		aceFront = new JPanel();
		aceBack = new JPanel();
		button = new JButton("Flip card");
		aceFront.add(ace.front());
		aceBack.add(ace.back());
		currentPanel = aceBack;
		add(currentPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		setSize(Card.WIDTH * 4, Card.HEIGHT * 2);
		setVisible(true);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				remove(currentPanel);
				if (currentPanel.equals(aceBack)){
					currentPanel = aceFront;
				} else {
					currentPanel = aceBack;
				}
				add(currentPanel, BorderLayout.CENTER);
				
				revalidate();
				repaint();
			}
		});
	}

	public static void main(String[] args) {
		new FlipCardTest();
	}
}
