
public class Circle implements Measurable {
	protected static double Radius = 0;

	public Circle() {

	}

	public Circle(double R) {
		Radius = R;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Radius * Radius;
	}

}
