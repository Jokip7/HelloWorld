package list;

import java.awt.BorderLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyContentPane extends JPanel {
	public MyContentPane() {
		DrawPanel myDrawPanel = new DrawPanel();
		ControlPanel myRBPanel = new ControlPanel(myDrawPanel);
		this.setLayout(new BorderLayout());
		this.add(myDrawPanel, BorderLayout.CENTER);
		this.add(myRBPanel, BorderLayout.LINE_END);
	}
}
