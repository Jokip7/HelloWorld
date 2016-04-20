package list;

import java.awt.Color;
import java.awt.Component;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

	private DrawPanel drawPanel;
	private JSlider slider;
	private JList<String> colorList;
	private JScrollPane myScroller;

	public ControlPanel(DrawPanel drawPanel) {
		this.drawPanel = drawPanel;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		String[] colors = { "black", "blue", "green", "orange", "pink", "red", "yellow" };
		colorList = new JList<String>(colors);
		colorList.setVisibleRowCount(4);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		colorList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!colorList.getValueIsAdjusting()) {
					switch (colorList.getSelectedValue()) {
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
					}
				}
			}
		});

		myScroller = new JScrollPane(colorList);
		myScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		myScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		myScroller.setMinimumSize(myScroller.getPreferredSize());
		myScroller.setMaximumSize(myScroller.getPreferredSize());

		this.add(myScroller);

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