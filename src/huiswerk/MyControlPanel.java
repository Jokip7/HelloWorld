package huiswerk;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class MyControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JSlider red;
	private JSlider green;
	private JSlider blue;
	private JSlider[] sliders;
	private JTextField[] fields;

	public MyControlPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		sliders = new JSlider[3];
		JLabel[] labels = new JLabel[3];
		fields = new JTextField[3];

		// Add three sliders to an array which the user can use to control the
		// color
		sliders[0] = red;
		sliders[1] = green;
		sliders[2] = blue;

		// Create three labels to show which slider and textField belongs to
		// which color
		labels[0] = new JLabel("red");
		labels[1] = new JLabel("green");
		labels[2] = new JLabel("blue");

		// Create three textFields where the player can add a value of 0 to 255
		// to control the color
		fields[0] = new JTextField(2);
		fields[1] = new JTextField(2);
		fields[2] = new JTextField(2);

		// Make a hash table with the labels "0" and "255" at the beginning and
		// the end of the aforementioned sliders
		Hashtable<Integer, JLabel> labelHashTable = new Hashtable<Integer, JLabel>();
		labelHashTable.put(Integer.valueOf(0), new JLabel("0"));
		labelHashTable.put(Integer.valueOf(255), new JLabel("255"));

		for (int i = 0; i < 3; i++) {

			// Instantiate the slider, starting at 0 and ending at
			// 255, with the start location at 0
			sliders[i] = new JSlider(0, 255, 0);

			// Add a stripe every 15 points of value
			sliders[i].setMajorTickSpacing(15);

			// Make the stripes and labels visible
			sliders[i].setPaintTicks(true);
			sliders[i].setPaintLabels(true);

			// Add the aforementioned hash table to the slider
			sliders[i].setLabelTable(labelHashTable);

			// Center the labels
			labels[i].setAlignmentX(Component.CENTER_ALIGNMENT);

			fields[i].setMinimumSize(fields[i].getPreferredSize());
			fields[i].setMaximumSize(fields[i].getPreferredSize());
			fields[i].setText("0");

			// Add the components to the control panel
			this.add(labels[i]);
			this.add(sliders[i]);
			this.add(fields[i]);
		}

	}

	// Getters and setters for the sliders and fields

	// Set a slider's value to input (field's text) if input is a valid number,
	// else set the field's text to the slider's value
	public void setFieldRed(String input) {
		Integer sliderNumber = sliders[0].getValue();
		String sliderNumberString = sliderNumber.toString();
		if (numberCheck(input)) {
			sliders[0].setValue(Integer.valueOf(input));
		} else {
			fields[0].setText(sliderNumberString);
		}
	}

	public void setFieldGreen(String input) {
		Integer sliderNumber = sliders[1].getValue();
		String sliderNumberString = sliderNumber.toString();
		if (numberCheck(input)) {
			sliders[1].setValue(Integer.valueOf(input));
		} else {
			fields[1].setText(sliderNumberString);
		}
	}

	public void setFieldBlue(String input) {
		Integer sliderNumber = sliders[2].getValue();
		String sliderNumberString = sliderNumber.toString();
		if (numberCheck(input)) {
			sliders[2].setValue(Integer.valueOf(input));
		} else {
			fields[2].setText(sliderNumberString);
		}
	}

	// Getters for the sliders, return the slider matching the color
	public JSlider getSliderRed() {
		return sliders[0];
	}

	public JSlider getSliderGreen() {
		return sliders[1];
	}

	public JSlider getSliderBlue() {
		return sliders[2];
	}

	// Getters for the fields, return the field matching the color
	public JTextField getFieldRed() {
		return fields[0];
	}

	public JTextField getFieldGreen() {
		return fields[1];
	}

	public JTextField getFieldBlue() {
		return fields[2];
	}

	/**
	 * If a string consists of only numbers and is between 0 and 255 return
	 * true, else return false
	 * 
	 * @param numberArea
	 *            The number this method checks
	 **/
	private boolean numberCheck(String numberArea) {
		boolean validNumber = false;
		if (numberArea.matches("[0-9]+") && numberArea.length() <= 10) {
			int number = Integer.parseInt(numberArea);
			if (number >= 0 && number <= 255) {
				validNumber = true;
			}
		}
		return validNumber;
	}

}
