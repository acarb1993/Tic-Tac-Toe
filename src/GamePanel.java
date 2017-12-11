import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {		
	private DashButton[][] dashButtons;
	private int xAxis, yAxis, clicks;
	private TieFrame tieFrame;
	private WinFrame winFrame;
	private char play[][]; 
	
	// Constructor
	public GamePanel(int xAxis, int yAxis) {
		setLayout(new GridLayout(3, 3, 5, 5) ); // Rows, Columns, hgap, vgap
		setBorder(BorderFactory.createTitledBorder("Game") );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		dashButtons = new DashButton[3][3];
		play = new char[3][3];
		
		int character = 32;
		for (int i = 0; i < play.length; i++)
			for (int j = 0; j < play[i].length; j++) {
				play[i][j] = (char)character;
				character++;
			}
		
		for (int i = 0; i < dashButtons.length; i++) {
			for (int j = 0; j < dashButtons[i].length; j++) {
			    dashButtons[i][j] = new DashButton();
			    add(dashButtons[i][j]);
			}
		}	          
	} // End Constructor
	
	// Getter Methods
	public int getClicks() { return clicks; }
	
	// Class Methods
	public void gameLogic() {
		for (int i = 0; i < dashButtons.length; i++) 
			for (int j = 0; j < dashButtons[i].length; j++)
		    dashButtons[i][j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Execute when button is pressed
                    for(int i = 0; i < dashButtons.length; i++) {
                	    for (int j = 0; j < dashButtons[i].length; j++) {
                	        if (dashButtons[i][j].getText().equals("X") ||
                		        dashButtons[i][j].getText().equals("O") ) { } // Do Nothing
                	
                	        else if (dashButtons[i][j] == e.getSource() && clicks % 2 == 0 ) {
                		        dashButtons[i][j].setText("X");
                		        clicks++;
                		        play[i][j] = 'X';
                		        if (checkWinCondition() ) winFrame = new WinFrame("Player 1");
                		        if(clicks == 9) { tieFrame = new TieFrame(); }
                	        }
                	        
                	        else if (dashButtons[i][j] == e.getSource() && clicks % 2 != 0) {
                		        dashButtons[i][j].setText("O");
                		        clicks++;
                		        play[i][j] = 'O';
                		        if (checkWinCondition() ) winFrame = new WinFrame("Player 2");
                	        }
                        }
                    }
                }
            }); // End addActionListener
	} // End gameLogic
	
	public boolean checkWinCondition() {
		// Tests to see if there is a win across
		for (int i = 0; i < play.length; i++) 
			for (int j = 0; j < 1; j++) 
				if (play[i][j] == play[i][j + 1] &&
					play[i][j] == play[i][j + 2] ) 
					return true;
		
		// Tests to see if there is a win downward
		for (int i = 0; i < 1; i++) 
			for (int j = 0; j < play[i].length; j++) 
				if (play[i][j] == play[i + 1][j] &&
					play[i][j] == play[i + 2][j] ) 
					return true;
		
		// Tests to see if there is a left diagonal win
		for(int i = 0; i < 1; i++) 
			for (int j = 0; j < 1; j++)
				if (play[i][j] == play[i + 1][j + 1] &&
					play[i][j] == play[i + 2][j + 2])
					return true;
		
		// Tests to see if there is a right diagonal win
		for(int i = 2; i > 1; i--) 
			for (int j = 0; j < 1; j++)
				if (play[i][j] == play[i - 1][j + 1] &&
					play[i][j] == play[i - 2][j + 2])
					return true;
		
		return false;
	}// End checkWinCondition
}// End class 
