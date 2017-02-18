import java.util.Scanner;

public class Assignment1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		while (true) {
			int num = getInt(sc);
			if (num < 0) {
				if (num == -1) {// enter -1 to display the sum
					System.out.println("sum: " + sum);
				}
				if (num == -2) {// enter -2 to restart
					sum = 0;

				}
				if (num == -3) {// enter-3 to close ,display the last sum & quit
					System.out.println("sum:" + sum);
					break;

				}
				if (num < -3) {
					// if lower than -3, nothing will add
					System.out.println("This is not an possitive integer!");
				}
			} else {
				sum += num;
			}
		}
		sc.close();

	}

	private static int getInt(Scanner sc) {// make sure to enter the integer
		int input = 0;
		System.out.println("Enter a positive interger(-1 to print, -2 to reset, -3 to quit): ");
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.println("That's not an integer,retry:");
		}
		input = sc.nextInt();
		return input;
	}
}
