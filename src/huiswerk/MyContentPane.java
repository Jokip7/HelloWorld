package huiswerk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyContentPane extends JPanel {

	private static final long serialVersionUID = 1L;

	// The drawPanel where a gradient color will be displayed, based on the left
	// and right color
	private MyDrawPanel drawPanel;

	// The controlPanels on the left and the right, containing the sliders and
	// text fields
	private MyControlPanel left;
	private MyControlPanel right;

	Random random;

	public MyContentPane() {
		this.setLayout(new BorderLayout());

		drawPanel = new MyDrawPanel();
		random = new Random();

		left = new MyControlPanel();
		right = new MyControlPanel();

		// Adding action listeners to make the sliders and text fields work on
		// the left control panel
		left.getSliderRed().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setLeftColor();
				setTextAreaText(left.getFieldRed(), left.getSliderRed());
			}
		});
		left.getFieldRed().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				left.setFieldRed(left.getFieldRed().getText());
			}
		});
		left.getSliderGreen().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setLeftColor();
				setTextAreaText(left.getFieldGreen(), left.getSliderGreen());
			}
		});
		left.getFieldGreen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				left.setFieldGreen(left.getFieldGreen().getText());
			}
		});
		left.getSliderBlue().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setLeftColor();
				setTextAreaText(left.getFieldBlue(), left.getSliderBlue());
			}
		});
		left.getFieldBlue().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				left.setFieldBlue(left.getFieldBlue().getText());
			}
		});

		// Adding action listeners to make the sliders and text fields work on
		// the right control panel
		right.getSliderRed().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setRightColor();
				setTextAreaText(right.getFieldRed(), right.getSliderRed());
			}
		});
		right.getFieldRed().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				right.setFieldRed(right.getFieldRed().getText());
			}
		});
		right.getSliderGreen().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setRightColor();
				setTextAreaText(right.getFieldGreen(), right.getSliderGreen());
			}
		});
		right.getFieldGreen().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				right.setFieldGreen(right.getFieldGreen().getText());
			}
		});
		right.getSliderBlue().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				setRightColor();
				setTextAreaText(right.getFieldBlue(), right.getSliderBlue());
			}
		});
		right.getFieldBlue().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				right.setFieldBlue(right.getFieldBlue().getText());
			}
		});

		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
		this.add(drawPanel, BorderLayout.CENTER);
	}

	public void reset() {
		left.setFieldRed("0");
		left.setFieldBlue("0");
		left.setFieldGreen("0");
		right.setFieldRed("0");
		right.setFieldBlue("0");
		right.setFieldGreen("0");
		drawPanel.setShape("rect");
	}

	public void setRandom() {
		left.setFieldRed(Integer.toString(random.nextInt(255)));
		left.setFieldBlue(Integer.toString(random.nextInt(255)));
		left.setFieldGreen(Integer.toString(random.nextInt(255)));
		right.setFieldRed(Integer.toString(random.nextInt(255)));
		right.setFieldBlue(Integer.toString(random.nextInt(255)));
		right.setFieldGreen(Integer.toString(random.nextInt(255)));

		int randomNumber = random.nextInt(100);
		String shape = "";

		if (randomNumber <= 33) {
			shape = "rect";
		} else if (randomNumber <= 66) {
			shape = "circle";
		} else {
			shape = "roundRect";
		}

		drawPanel.setShape(shape);
	}

	public MyDrawPanel getDrawPanel() {
		return drawPanel;
	}

	// Sets the left color in the draw panel based on the value of the sliders
	// of the left panel
	private void setLeftColor() {
		drawPanel.setLeftColor(new Color(left.getSliderRed().getValue(), left.getSliderGreen().getValue(),
				left.getSliderBlue().getValue()));
	}

	// Sets the right color in the draw panel based on the value of the sliders
	// of the right panel
	private void setRightColor() {
		drawPanel.setRightColor(new Color(right.getSliderRed().getValue(), right.getSliderGreen().getValue(),
				right.getSliderBlue().getValue()));
	}

	// Sets the 'text' (number) displayed in the given textField, based on the
	// value of the given slider's value
	private void setTextAreaText(JTextField textField, JSlider slider) {
		textField.setText(Integer.toString(slider.getValue()));
	}

}
