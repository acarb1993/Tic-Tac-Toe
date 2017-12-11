import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WinFrame extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;
	
	private JPanel northPanel, centerPanel, southPanel;
	
	private JLabel playerLabel;
	
	private JButton resetButton, exitButton;
	
	public WinFrame(String playerWin) {
		setTitle("Win Frame");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout() );
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();
		
		playerLabel = new JLabel(playerWin + " wins!", SwingConstants.CENTER);
	    playerLabel.setFont(new Font("Centruy", Font.PLAIN, 20) );
	    add(northPanel, BorderLayout.NORTH);
	    northPanel.add(playerLabel);
	    
	    // resetButton settings and add
	    resetButton = new JButton("Reset");
	    resetButton.setFont(new Font("Centruy", Font.PLAIN, 30) );
	    
	    resetButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		MainFrame frame = new MainFrame();
	    		frame.playGame();
	    		dispose();
	    	}
	    });
	    
	    add(centerPanel, BorderLayout.CENTER);
	    centerPanel.add(resetButton);
	    
	    // exitButton settings and add
	    exitButton = new JButton("Exit");
	    exitButton.setFont(new Font("Centruy", Font.PLAIN, 30) );
	    
	    exitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    	}
	    });
	    
	    add(southPanel, BorderLayout.SOUTH);
	    southPanel.add(exitButton);
		
		setResizable(false);
		setLocationRelativeTo(null); 
		setVisible(true);
		
	}
}
