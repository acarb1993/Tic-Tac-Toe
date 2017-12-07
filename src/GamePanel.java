import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {		
	private DashButton[] dashButtons;
	private int xAxis, yAxis;
	
	public GamePanel(int xAxis, int yAxis) {
		setLayout(new GridLayout(3, 3, 5, 5) ); // Rows, Columns, hgap, vgap
		
		setBorder(BorderFactory.createTitledBorder("Game") );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		dashButtons = new DashButton[9];
		
		for (int i = 0; i < 9; i++) {
			dashButtons[i] = new DashButton();
			add(dashButtons[i]);
		}
	}
}
