import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JFrame {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200; 
			
	public MainPanel() {
		setTitle("Tic-Tac-Toe");
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout() );
		contentPane.add(new JLabel("Left"), BorderLayout.WEST);
		contentPane.add(new JLabel("Right"), BorderLayout.EAST);
		
		setVisible(true);
	}
}
