package text;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyGui extends JFrame {
	public MyGui() {
		MyContentPane myContentPane = new MyContentPane();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(myContentPane);
		this.pack();
		this.setVisible(true);
	}
}
