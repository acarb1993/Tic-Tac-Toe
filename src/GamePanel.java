import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel {		
	private DashButton[][] dashButtons;
	private int xAxis, yAxis, clicks;
	private TextPanel textPanel;
	private char play[][]; 
	private ActionListener l;
	private Random r;
	
	// Constructor
	public GamePanel(int xAxis, int yAxis, TextPanel textPanel) {
		setLayout(new GridLayout(3, 3, 5, 5) ); // Rows, Columns, hgap, vgap
		setBorder(BorderFactory.createTitledBorder("Game") );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		dashButtons = new DashButton[3][3];
		play = new char[3][3];
		this.textPanel = textPanel;
		
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
	
	// Sets the game to play against another person
	public void playHuman() {
		for (int i = 0; i < dashButtons.length; i++) 
			for (int j = 0; j < dashButtons[i].length; j++)
		    dashButtons[i][j].addActionListener(l = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Execute when button is pressed
                    for(int i = 0; i < dashButtons.length; i++) {
                	    for (int j = 0; j < dashButtons[i].length; j++) {
                	        if (dashButtons[i][j].getText().equals("X") ||
                		        dashButtons[i][j].getText().equals("O") ) { } // Do Nothing
                	
                	        else if (dashButtons[i][j] == e.getSource() && clicks % 2 == 0 ) {
                		        dashButtons[i][j].setText("X");
                		        clicks++;
                		        textPanel.setTurns(clicks);
                		        play[i][j] = 'X';
                		        
                		        if (checkWinCondition() ) { 
                		            textPanel.addConditionLabel("Player 1 Wins!");
                		            disableActionListeners();
                		        }
                		        
                		        else if(clicks == 9) { 
                		        	textPanel.addConditionLabel("Draw!");
                		        	disableActionListeners();
                		        }
                	        }
                	        
                	        else if (dashButtons[i][j] == e.getSource() && clicks % 2 != 0) {
                		        dashButtons[i][j].setText("O");
                		        clicks++;
                		        textPanel.setTurns(clicks);
                		        play[i][j] = 'O';
                		        
                		        if (checkWinCondition() ) { 
                		        	textPanel.addConditionLabel("Player 2 Wins!"); 
                		        	disableActionListeners();
                		       }
                	        }
                        }
                    }
                }
            }); // End addActionListener
	} // End playHuman
	
	// Sets the game to play against the CPU
	public void playComputer() {
		for (int i = 0; i < dashButtons.length; i++) 
			for (int j = 0; j < dashButtons[i].length; j++)
		    dashButtons[i][j].addActionListener(l = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Execute when button is pressed
                    for(int i = 0; i < dashButtons.length; i++) {
                	    for (int j = 0; j < dashButtons[i].length; j++) {
                	        if (dashButtons[i][j].getText().equals("X") ||
                		        dashButtons[i][j].getText().equals("O") ) { } // Do Nothing
                	
                	        else if (dashButtons[i][j] == e.getSource() && clicks % 2 == 0 ) {
                		        dashButtons[i][j].setText("X");
                		        clicks++;
                		        textPanel.setTurns(clicks);
                		        play[i][j] = 'X';
                		        
                		        if (checkWinCondition() ) { 
                		            textPanel.addConditionLabel("Player 1 Wins!");
                		            disableActionListeners();
                		        }
                		        
                		        else if(clicks == 9) { 
                		        	textPanel.addConditionLabel("Draw!");
                		        	disableActionListeners();
                		        }
                	        }
                	        
                	        else if (dashButtons[i][j] == e.getSource() && clicks % 2 != 0) {
                		        dashButtons[i][j].setText("O");
                		        clicks++;
                		        textPanel.setTurns(clicks);
                		        play[i][j] = 'O';
                		        
                		        if (checkWinCondition() ) { 
                		        	textPanel.addConditionLabel("Player 2 Wins!"); 
                		        	disableActionListeners();
                		       }
                	        }
                        }
                    }
                }
            }); // End addActionListener
	} // End playComputer
	
	// The logic behind the computers movement
	public void computerMoves() {
		r = new Random();
		int x = r.nextInt(2);
		int y = r.nextInt(2);
		if (play[x][y] == 'X' || play[x][y] == 'O') computerMoves();
		else {
			play[x][y] = 'O';
			dashButtons[x][y].setText("O");
		}
	}
	
	// Turns off the Action Listeners once the game is over
	public void disableActionListeners() {
		for (int i = 0; i < dashButtons.length; i++) {
			for (int j = 0; j < dashButtons[i].length; j++) {
				dashButtons[i][j].removeActionListener(l);
			}
		}
	}
	
	// Checks to see if there is a win in any direction
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
	
	// Resets the game to start a new one
	public void reset() {
		clicks = 0;
		int character = 32;
		for (int i = 0; i < dashButtons.length; i++) {
			for (int j = 0; j < dashButtons[i].length; j++) {
				dashButtons[i][j].setText("-");
				play[i][j] = (char)character;
				character++;
			}
		}
		textPanel.resetTextPanel();
		
	} // End reset
}// End class 
