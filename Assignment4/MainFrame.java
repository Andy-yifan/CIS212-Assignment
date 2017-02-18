import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public MainFrame() {
		super("LET'S DRAW!");
		setLayout(new BorderLayout());

		PaintPanel _paintPanel = new PaintPanel();
		_paintPanel.setBackground(Color.WHITE);
		add(_paintPanel, BorderLayout.CENTER);

		////// buttons for color select
		
		JPanel colorbuttonPanel = new JPanel();
		colorbuttonPanel.setLayout(new GridLayout(1, 2));

		JButton _YellowButton = new JButton("Yellow");
		_YellowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.YELLOW);

			}
		});
		colorbuttonPanel.add(_YellowButton);
		JButton _GreenButton = new JButton("Green");
		_GreenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.GREEN);

			}
		});
		colorbuttonPanel.add(_GreenButton);
		JButton _PinkButton = new JButton("Pink");
		_PinkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.PINK);

			}
		});
		colorbuttonPanel.add(_PinkButton);
		JButton _RedButton = new JButton("Red");
		_RedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentColor(Color.RED);
			}
		});
		colorbuttonPanel.add(_RedButton);
		add(colorbuttonPanel, BorderLayout.NORTH);
		
		///////////// button for shape select
		
		JPanel shapePanel = new JPanel();
		shapePanel.setLayout(new GridLayout(1, 2));
		JButton _squareButton = new JButton("Square");
		_squareButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentShape(ShapePoint.SQUARE_TYPE);
			}
		});
		shapePanel.add(_squareButton);

		JButton _circleButton = new JButton("Circle");
		_circleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentShape(ShapePoint.CIRCLE_TYPE);
			}
		});
		shapePanel.add(_circleButton);
		
		JButton _MaxButton = new JButton("Max");
		_MaxButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentSsize(ShapePoint.MAX_SIZE);
			}
		});
		shapePanel.add(_MaxButton);
		
		JButton _MidButton = new JButton("Mid");
		_MidButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentSsize(ShapePoint.MID_SIZE);
			}
		});
		shapePanel.add(_MidButton);
		
		JButton _MinButton = new JButton("Min");
		_MinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.setCurrentSsize(ShapePoint.MIN_SIZE);
			}
		});
		shapePanel.add(_MinButton);
		
		JButton _ClearButton = new JButton("Clear");
		_ClearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_paintPanel.clear();
			}
		});
		shapePanel.add(_ClearButton);
		add(shapePanel, BorderLayout.SOUTH);
	}
}