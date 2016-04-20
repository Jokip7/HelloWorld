package list;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel {
	private Color myColor = Color.WHITE;
	private double scaling = 1.0;

	public DrawPanel() {
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.WHITE);
	}

	public void setColor(Color c) {
		myColor = c;
	}

	public void setScaling(int scale) {
		scaling = 1.0 + ((double) scale) / 100;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int rect = (int) (180 * scaling);
		int x = this.getWidth() / 2 - rect / 2;
		int y = this.getHeight() / 2 - rect / 2;

		g.setColor(myColor);
		g.fillRect(x, y, rect, rect);

		g.setColor(Color.BLACK);
		g.drawRect(x, y, rect, rect);
	}
}
