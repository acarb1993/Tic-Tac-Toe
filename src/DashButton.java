import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class DashButton extends JButton {
	public DashButton() {
		super("-");
		setPreferredSize(new Dimension(5, 5) );
		setFont(new Font("Centruy", Font.PLAIN, 100) );
		setBackground(Color.WHITE);
	}
}
