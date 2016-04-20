package radio;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyGui extends JFrame {
	public MyGui() {
		MyContentPane myContentPane = new MyContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(myContentPane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
