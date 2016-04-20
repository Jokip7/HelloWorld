package radio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

	private DrawPanel drawPanel;
	private JSlider slider;

	public ControlPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		String red = "Red";
		String yellow = "Yellow";
		String blue = "Blue";

		JRadioButton rb_red = new JRadioButton(red);
		rb_red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setDrawPanelColor(Color.RED);
			}
		});

		JRadioButton rb_yellow = new JRadioButton(yellow);
		rb_yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setDrawPanelColor(Color.YELLOW);
			}
		});

		JRadioButton rb_blue = new JRadioButton(blue);
		rb_blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setDrawPanelColor(Color.BLUE);
			}
		});

		this.add(rb_red);
		this.add(rb_yellow);
		this.add(rb_blue);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rb_red);
		buttonGroup.add(rb_yellow);
		buttonGroup.add(rb_blue);

		rb_red.doClick();

		slider = new JSlider(JSlider.VERTICAL, -50, 50, 0);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);

		Hashtable<Integer, JLabel> labelHashTable = new Hashtable<Integer, JLabel>();
		labelHashTable.put(Integer.valueOf(-50), new JLabel("-50"));
		labelHashTable.put(Integer.valueOf(0), new JLabel("0"));
		labelHashTable.put(Integer.valueOf(50), new JLabel("50"));
		slider.setLabelTable(labelHashTable);

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setDrawPanelScaling(slider.getValue());
			}
		});

		this.add(slider);
	}

	private void setDrawPanelColor(Color color) {
		drawPanel.setColor(color);
		drawPanel.repaint();
	}

	private void setDrawPanelScaling(int size) {
		drawPanel.setScaling(size);
		drawPanel.repaint();
	}
}