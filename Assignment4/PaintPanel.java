import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	private ArrayList<ShapePoint> _points;

	private Color _currentColor;
	private int _currentShape;
	private int _currentSize;

	public PaintPanel() {
		_points = new ArrayList<>();
		_currentColor = Color.BLACK;
		_currentShape = ShapePoint.SQUARE_TYPE;
		_currentSize = ShapePoint.SIZE;
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent ev) {
				_points.add(new ShapePoint(ev.getX(),ev.getY(), _currentShape, _currentSize,_currentColor));
				repaint();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		

		for (ShapePoint p : _points) {
			p.paint(g);
		}
	}

	public void setCurrentColor(Color currentColor) {
		_currentColor = currentColor;
		// In order to update the color for all points when this is called,
		// need to call repaint().
		repaint();
	}

	public void setCurrentShape(int currentShape) {
		_currentShape = currentShape;

	}

	public void setCurrentSsize(int currentSize) {
		_currentSize = currentSize;

	}
	public void clear(){
		_points = new ArrayList<>();
		repaint();
	}
}