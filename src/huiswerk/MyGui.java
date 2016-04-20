package huiswerk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private MyContentPane contentPane;

	public void create() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setTitle("Color Slider Gradient");

		contentPane = new MyContentPane();
		this.setContentPane(contentPane);
		this.setResizable(false);

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenu shape = new JMenu("Shape");
		JMenu tools = new JMenu("Tools");

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		JMenuItem rectangle = new JMenuItem("Rectangle");
		rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.getDrawPanel().setShape("rect");
			}
		});
		JMenuItem roundRect = new JMenuItem("Rounded Rectangle");
		roundRect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.getDrawPanel().setShape("roundRect");
			}
		});
		JMenuItem circle = new JMenuItem("Circle");
		circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.getDrawPanel().setShape("circle");
			}
		});
		JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				contentPane.reset();
			}
		});
		JMenuItem random = new JMenuItem("Random");
		random.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setRandom();
			}
		});

		file.add(exit);
		shape.add(rectangle);
		shape.add(roundRect);
		shape.add(circle);
		tools.add(reset);
		tools.add(random);

		menuBar.add(file);
		menuBar.add(shape);
		menuBar.add(tools);

		this.setJMenuBar(menuBar);

		this.pack();
		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

}
