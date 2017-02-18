import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class ShapePoint {
	public static final int CIRCLE_TYPE = 0;
	public static final int SQUARE_TYPE = 1;
	public static final int MAX_SIZE = 40;
	public static final int MID_SIZE = 20;
	public static final int MIN_SIZE = 5;
	public static final int SIZE = 15;
	private Color _color = Color.BLACK;
	private final int _x;
	private final int _y;
	private final int _shapeType;// JUST INTERESTED IN, ADD EXTRA FUNCTION TO CHANGE THE SHAPE
	private final int _size;
	public ShapePoint(int x, int y, int shapeType, int size, Color color) {
		_x= x;
		_y = y;
		_shapeType = shapeType;
		_size = size;
		_color = color;
	}
	
	public int getX() {
		return _x;
	}

	public int getY() {
		return _y;
	}
	public void paint(Graphics g) {
		g.setColor(_color);
		if (_shapeType == CIRCLE_TYPE) {
			if(_size == MAX_SIZE){
				g.fillOval(_x, _y, MAX_SIZE, MAX_SIZE);
			}else if(_size == MID_SIZE){
				g.fillOval(_x, _y, MID_SIZE, MID_SIZE);
			}else if(_size == MIN_SIZE){
				g.fillOval(_x, _y, MIN_SIZE, MIN_SIZE);
			}else{
				g.fillOval(_x, _y, SIZE, SIZE);
			}
		} else if (_shapeType == SQUARE_TYPE) {
			if(_size == MAX_SIZE){
				g.fillRect(_x, _y, MAX_SIZE, MAX_SIZE);
			}else if(_size == MID_SIZE){
				g.fillRect(_x, _y, MID_SIZE, MID_SIZE);
			}else if(_size == MIN_SIZE){
				g.fillRect(_x, _y, MIN_SIZE, MIN_SIZE);
			}else{
				g.fillRect(_x, _y, SIZE, SIZE);
			}
		}
		
	}
	
}