import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class TieFrame extends JFrame {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;
	private JLabel drawLabel, playAgainLabel;
	
	private JButton resetButton, exitButton;
	
	private GridBagConstraints gbc;
	
	public TieFrame() {
	    setTitle("TieFrame");
	    setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setLayout(new GridBagLayout() );
	    
	    gbc = new GridBagConstraints();
	    
	    // drawLabel settings and add
	    drawLabel = new JLabel("Draw!");
	    drawLabel.setFont(new Font("Centruy", Font.PLAIN, 30) );
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(drawLabel, gbc);
	    
	    // playAgainLabel settings and add
	    playAgainLabel = new JLabel("Play Again?");
	    playAgainLabel.setFont(new Font("Centruy", Font.PLAIN, 30) );
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(playAgainLabel, gbc);
	    
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
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(resetButton, gbc);
	    
	    // exitButton settings and add
	    exitButton = new JButton("Exit");
	    exitButton.setFont(new Font("Centruy", Font.PLAIN, 30) );
	    
	    exitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(0);
	    	}
	    });
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    add(exitButton, gbc);
	    
	    
	    setResizable(false);
		setLocationRelativeTo(null); 
		setVisible(true);
	}
}
