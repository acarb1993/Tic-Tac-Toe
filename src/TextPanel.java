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
	
	private JButton reset;
	
	public TextPanel(int xAxis, int yAxis) {
		turns = 0;
		setBorder(BorderFactory.createTitledBorder("Game Info") );
		gbc = new GridBagConstraints();
		
		setLayout(new GridBagLayout() );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		turnLabel = new JLabel("Turn Number: " + Integer.toString(turns) );
		turnLabel.setFont(new Font("Centruy", Font.PLAIN, 30) );
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 0, 5, 0);
		add(turnLabel, gbc);
		
		reset = new JButton("Reset");
		reset.setFont(new Font("Centruy", Font.PLAIN, 30) );
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(reset, gbc);
				
		reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	gamePanel.reset();
            }
		}); // End ActionListener
	}
	// Setters
	public void setTurns(int turn) {
		turns = turn; 
		turnLabel.setText("Turn Number " + Integer.toString(turns) );
	}
	
	// Getters
	public int getTurns() { return turns; }
	
	// Methods
	public void giveGamePanel(GamePanel gamePanel) { this.gamePanel = gamePanel; }
	
	public void addConditionLabel(String str) {
		conditionLabel = new JLabel(str);
		conditionLabel.setFont(new Font("Centruy", Font.PLAIN, 40) );
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 5, 0);
		add(conditionLabel, gbc);	
	}
	
	public void resetTextPanel() {
		turnLabel.setText("Turn Number 0" );
		remove(conditionLabel);
		validate();
		repaint();
	}
	
}
