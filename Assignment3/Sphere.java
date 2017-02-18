
public class Sphere extends Circle {
	public Sphere(double R) {
		Radius = R;
	}

	@Override
	public double getArea() {
		return Math.PI * Radius * Radius * 4;
	}
}
