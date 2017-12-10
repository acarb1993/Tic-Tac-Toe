import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TieFrame extends JFrame {
	private static final int WIDTH = 600;
	private static final int HEIGHT = 300;
	private JLabel drawLabel;
	private JLabel playAgainLabel;
	
	private JButton playAgainButton;
	private JButton exitButton;
	
	private JPanel topPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	
	public TieFrame() {
	    setTitle("TieFrame");
	    setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout() );
	    
	    topPanel = new JPanel();
	    topPanel.setLayout(new GridLayout(1, 1) );
	    
	    leftPanel = new JPanel();
	    rightPanel = new JPanel();
	    
	    drawLabel = new JLabel("Draw!", SwingConstants.CENTER);
	    drawLabel.setFont(new Font("Centruy", Font.PLAIN, 20) );
	    add(topPanel, BorderLayout.NORTH);
	    topPanel.add(drawLabel);
	    
	    playAgainLabel = new JLabel("Play Again?", SwingConstants.CENTER);
	    playAgainLabel.setFont(new Font("Centruy", Font.PLAIN, 20) );
	    topPanel.add(playAgainLabel, SwingConstants.CENTER);
	    
	    playAgainButton = new JButton("Play Again");
	    playAgainButton.setFont(new Font("Centruy", Font.PLAIN, 20));
	    playAgainButton.setBackground(Color.WHITE);
	    playAgainButton.setBounds(new Rectangle(10, 10) );
	    add(leftPanel, BorderLayout.WEST);
	    leftPanel.add(playAgainButton, SwingConstants.CENTER);
	    
	    exitButton = new JButton("Exit");
	    exitButton.setFont(new Font("Centruy", Font.PLAIN, 20));
	    exitButton.setBackground(Color.WHITE);
	    exitButton.setBounds(new Rectangle(10, 10) );
	    add(rightPanel, BorderLayout.EAST);
	    rightPanel.add(exitButton, SwingConstants.CENTER);

	    setResizable(false);
		setLocationRelativeTo(null); 
		setVisible(true);
	}
}
