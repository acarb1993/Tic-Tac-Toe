import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
	private int xAxis, yAxis;
	public TextPanel(int xAxis, int yAxis) {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS) );
		setPreferredSize(new Dimension(xAxis, yAxis) );
		
		setBorder(BorderFactory.createTitledBorder("Actions") );
	}
}
