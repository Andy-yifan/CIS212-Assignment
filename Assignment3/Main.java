import java.util.ArrayList;
import java.util.Random;

public class Main {
	private static double sum;
	static Random rand = new Random();
	static int _rectangle = 0;
	static int _box = 0;
	static int _circle = 0;
	static int _sphere = 0;

	public static void main(String[] args) {
		ArrayList<Measurable> list = new ArrayList<>();

		for (int i = 1; i <= 1000; i++) {
			int a = rand.nextInt(4);

			if (a == 0) {
				Rectangle r = new Rectangle(nextDouble(), nextDouble());
				list.add(r);
				_rectangle++;
			} else if (a == 1) {
				Box b = new Box(nextDouble(), nextDouble(), nextDouble());
				list.add(b);
				_box++;
			} else if (a == 2) {
				Circle c = new Circle(nextDouble());
				list.add(c);
				_circle++;
			} else {

				Sphere s = new Sphere(nextDouble());
				list.add(s);
				_sphere++;
			}
		}

		System.out.println(
				"rectangles: " + _rectangle + " boxes: " + _box + " circles: " + _circle + " spheres: " + _sphere);
		System.out.println("Sum: " + calculateSum(list));
	}

	private static double nextDouble() {
		Random ran = new Random();
		return ran.nextDouble() + Double.MIN_VALUE;
	}

	private static double calculateSum(ArrayList<Measurable> list) {

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getArea();
		}
		return sum;
	}
}
