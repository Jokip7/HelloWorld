package text;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

	private DrawPanel drawPanel;
	private JSlider slider;
	private JTextField myTextField;

	public ControlPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		myTextField = new JTextField(10);
		myTextField.setMaximumSize(myTextField.getPreferredSize());

		myTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (myTextField.getText().toLowerCase()) {
				case "blue":
					setDrawPanelColor(Color.BLUE);
					break;
				case "red":
					setDrawPanelColor(Color.RED);
					break;
				case "yellow":
					setDrawPanelColor(Color.YELLOW);
					break;
				case "black":
					setDrawPanelColor(Color.BLACK);
					break;
				case "orange":
					setDrawPanelColor(Color.ORANGE);
					break;
				case "pink":
					setDrawPanelColor(Color.PINK);
					break;
				case "green":
					setDrawPanelColor(Color.GREEN);
					break;
				case "quit":
				case "exit":
					System.exit(0);
					break;
				}

				myTextField.setText("");
			}
		});

		this.add(myTextField);

		JLabel sizeSliderText = new JLabel("Size Slider");
		sizeSliderText.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(sizeSliderText);

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