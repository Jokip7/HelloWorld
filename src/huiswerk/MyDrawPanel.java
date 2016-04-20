package huiswerk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	private Color leftColor;
	private Color rightColor;
	private String shape;

	public MyDrawPanel() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		leftColor = new Color(0, 0, 0);
		rightColor = new Color(0, 0, 0);
		shape = "rect";
	}

	public void setLeftColor(Color leftColor) {
		this.leftColor = leftColor;
		this.repaint();
	}

	public void setRightColor(Color rightColor) {
		this.rightColor = rightColor;
		this.repaint();
	}

	public void setShape(String shape) {
		if (this.shape != shape) {
			switch (shape) {
			case "rect":
			case "circle":
			case "roundRect":
				this.shape = shape;
				break;
			}
			this.repaint();
		}
	}

	public void paint(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		GradientPaint gradient = new GradientPaint(0, 0, leftColor, this.getWidth(), this.getHeight(), rightColor);
		g2.setPaint(gradient);
		switch (shape) {
		case "rect":
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			break;
		case "circle":
			g.fillOval(0, 0, this.getWidth(), this.getHeight());
			break;
		case "roundRect":
			g.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), 100, 100);
		}

	}

}
