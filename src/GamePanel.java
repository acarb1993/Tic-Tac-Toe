import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {		
	private DashButton[] dashButtons;
	private int xAxis, yAxis, clicks;
	private TieFrame tieFrame;
	private char play[][]; 
	
	// Constructor
	public GamePanel(int xAxis, int yAxis) {
		play = new char[3][3];
		setLayout(new GridLayout(3, 3, 5, 5) ); // Rows, Columns, hgap, vgap
		setBorder(BorderFactory.createTitledBorder("Game") );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		dashButtons = new DashButton[9];
		
		for (int i = 0; i < dashButtons.length; i++) {
			dashButtons[i] = new DashButton();
			add(dashButtons[i]);
		}	          
	} // End Constructor
	
	// Setter Methods
	public int getClicks() { return clicks; }
	
	// Class Methods
	public void gameLogic() {
		for (int i = 0; i < dashButtons.length; i++) {
		    dashButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Execute when button is pressed
                    for(int i = 0; i < dashButtons.length; i++) {
                	    for (int j = 0; j < dashButtons.length; j++) {
                	        if (dashButtons[i].getText().equals("X") ||
                		        dashButtons[i].getText().equals("O") ) { } // Do Nothing
                	
                	        else if (dashButtons[i] == e.getSource() && clicks % 2 == 0 ) {
                		        dashButtons[i].setText("X");
                		        clicks++;
                		        play[i / 3][i / 3] = 'X';
                		        if(clicks == 9) tieFrame = new TieFrame();
                	        }
                	        else if (dashButtons[i] == e.getSource() && clicks % 2 != 0) {
                		        dashButtons[i].setText("O");
                		        clicks++;
                		        play[i / 3][j / 3] = 'O';
                	        }
                        }
                    }
                }
            }); // End addActionListener
	    } // End for loop
	}
}
