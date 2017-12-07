import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {		
	private DashButton[] dashButtons;
	private int xAxis, yAxis, clicks;
	
	public GamePanel(int xAxis, int yAxis) {
		setLayout(new GridLayout(3, 3, 5, 5) ); // Rows, Columns, hgap, vgap
		setBorder(BorderFactory.createTitledBorder("Game") );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		dashButtons = new DashButton[9];
		
		for (int i = 0; i < dashButtons.length; i++) {
			dashButtons[i] = new DashButton();
			add(dashButtons[i]);
			dashButtons[i].addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //Execute when button is pressed
	                for(int i = 0; i < dashButtons.length; i++)
	                	if (dashButtons[i] == e.getSource() && clicks % 2 == 0 ) {
	                		if (dashButtons[i].getText().equals("X") ||
	                			dashButtons[i].getText().equals("O")) {
	                			// Do nothing
	                		}
	                		else {
	                		    dashButtons[i].setText("X");
	                		    clicks++;
	                		}
	                	}
	                	else if (dashButtons[i] == e.getSource() && clicks % 2 != 0) {
	                		if (dashButtons[i].getText().equals("X") ||
		                			dashButtons[i].getText().equals("O")) {
		                			// Do nothing
		                		}
	                		else {
	                		    dashButtons[i].setText("O");
	                		    clicks++;
	                		}
	                	}
	            }
	        }); // End addActionListener
		} // End for loop
	} // End Constructor
	
	public int getClicks() { return clicks; };
}
