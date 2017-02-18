
public class Box extends Rectangle {
	private double Length;

	public Box(double h, double w, double l) {
		Hight = h;
		Width = w;
		Length = l;

	}

	public double getArea() {
		// TODO Auto-generated method stub
		double Area = 2 * Hight * Width + 2 * Hight * Length + 2 * Length * Width;
		return Area;
	}
}
