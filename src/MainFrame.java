import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 550; 
	private GamePanel gamePanel;
	private TextPanel textPanel;
	
	public MainFrame() {
		setTitle("Tic-Tac-Toe");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 1) );
		
		gamePanel = new GamePanel(WIDTH / 2, HEIGHT / 2);
		add(gamePanel);
		
		textPanel = new TextPanel(WIDTH / 2, HEIGHT / 2);
		add(textPanel);
		
		setResizable(false);
		setLocationRelativeTo(null); 
		setVisible(true);
	}
	
	public void playGame() { 
		gamePanel.gameLogic();
	}
}
