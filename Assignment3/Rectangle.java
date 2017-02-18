
public class Rectangle implements Measurable {

	protected static double Hight;
	protected static double Width;

	public Rectangle() {

	}

	public Rectangle(double h, double w) {
		Hight = h;
		Width = w;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double Area = Hight * Width;
		return Area;
	}

}
