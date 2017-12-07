import javax.swing.*;
import java.awt.*; 

public class DashButton extends JButton {
	public DashButton() {
		super("-");
		setPreferredSize(new Dimension(5, 5) );
		setFont(new Font("Arial", Font.PLAIN, 50) );
	}
}
