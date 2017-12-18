import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextPanel extends JPanel {
	private int xAxis, yAxis;
	private int turns;
	private GridBagConstraints gbc;
	private GamePanel gamePanel;
	
	private JLabel turnLabel;
	private JLabel conditionLabel;

	private JButton playHuman;
	private JButton playComputerEasy;
	private JButton reset;
	
	public TextPanel(int xAxis, int yAxis) {
		turns = 0;
		setBorder(BorderFactory.createTitledBorder("Game Info") );
		gbc = new GridBagConstraints();
		
		setLayout(new GridBagLayout() );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		conditionLabel = new JLabel("Welcome to Tic-Tac-Toe");
		conditionLabel.setFont(new Font("Centruy", Font.PLAIN, 35) );
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 5, 0);
		add(conditionLabel, gbc);
		
		playHuman = new JButton("Play Human");
		playHuman.setFont(new Font("Centruy", Font.PLAIN, 30) );
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(playHuman, gbc);
		
		playComputerEasy = new JButton("Play Comuter <Easy>");
		playComputerEasy.setFont(new Font("Centruy", Font.PLAIN, 30) );
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(playComputerEasy, gbc);
		
		
		turnLabel = new JLabel("Turn Number: " + Integer.toString(turns) );
		turnLabel.setFont(new Font("Centruy", Font.PLAIN, 30) );
		
		reset = new JButton("Reset");
		reset.setFont(new Font("Centruy", Font.PLAIN, 30) );
				
		reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	gamePanel.reset();
            }
		}); //END ActionListener
		
		// Play Human Action Listener
		playHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(playHuman);
				remove(playComputerEasy);
				remove(conditionLabel);
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				add(turnLabel, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 1;
				add(reset, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 2;
				add(playComputerEasy, gbc);
				
				validate();
				repaint();
				
				gamePanel.reset();
				gamePanel.playHuman();
			}
		});//END ActionListener
		
		// Computer Easy Action Listener
		playComputerEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(playHuman);
				remove(playComputerEasy);
				remove(conditionLabel);
				
				gbc.gridx = 0;
				gbc.gridy = 0;
				add(turnLabel, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 1;
				add(reset, gbc);
				
				gbc.gridx = 0;
				gbc.gridy = 2;
				add(playHuman, gbc);
				
				validate();
				repaint();
				
				gamePanel.reset();
				gamePanel.playComputerEasy();
			}
		});//END ActionListener
		
		
	}// END Constructor
	
	// Setters
	public void setTurns(int turn) {
		turns = turn; 
		turnLabel.setText("Turn Number " + Integer.toString(turns) );
	}
	
	// Getters
	public int getTurns() { return turns; }
	
	// Methods
	public void giveGamePanel(GamePanel gamePanel) { this.gamePanel = gamePanel; }
	
	// Adds the condition label after a win or a draw
	public void addConditionLabel(String str) {
		conditionLabel = new JLabel(str);
		conditionLabel.setFont(new Font("Centruy", Font.PLAIN, 40) );
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(5, 0, 5, 0);
		add(conditionLabel, gbc);	
	}
	
	// Resets the game once the user clicks the reset button
	public void resetTextPanel() {
		remove(conditionLabel);
		turnLabel.setText("Turn Number 0" );
		gamePanel.setButtonActive(true);
		
		validate();
		repaint();
	}
}
