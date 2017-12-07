import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 400; 
	private GamePanel gamePanel;
	private TextPanel textPanel;
	
	public MainFrame() {
		setTitle("Tic-Tac-Toe");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 1) );
		
		textPanel = new TextPanel(WIDTH / 2, HEIGHT / 2);
		add(textPanel);
		
		gamePanel = new GamePanel(WIDTH / 2, HEIGHT / 2);
		add(gamePanel);
		
		setLocationRelativeTo(null); 
		setVisible(true);
	}
}
