import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
	static ArrayList<Context> copylist = new ArrayList<Context>();

	public static void main(String[] atgs) throws IOException {
		readFile();
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 100);
		frame.setVisible(true);
	}

	public static void readFile() throws IOException {
		String line = null;
		try {
			FileReader file = new FileReader("phonebook.txt");
			BufferedReader Reader = new BufferedReader(file);
			while ((line = Reader.readLine()) != null) {
				Context c = new Context(line.split(" ", 2)[0], line.split(" ", 2)[1]);
				copylist.add(c);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}

	}

	public static boolean test(ArrayList<Context> copy) {
		for (int i = 0; i < copy.size() - 1; i++) {
			if (copy.get(i).Name.compareTo(copy.get(i + 1).Name) <= 0) {
				continue;
			} else {
				System.out.println("Error:The list has not sort.");
				return false;
			}

		}
		return true;
	}

}
