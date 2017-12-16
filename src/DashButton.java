import javax.swing.*;
import java.awt.*; 

public class DashButton extends JButton {
	public DashButton() {
		super("-");
		setFont(new Font("Centruy", Font.PLAIN, 100) );
		setBackground(Color.WHITE);
		setFocusPainted(false);
	}
}
