import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	private static final int PORT = 8000;
	private static final int pw = 7;

	public static void main(String[] args) {
		System.out.println("running client!");
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		try {
			InetAddress localInetAddress = InetAddress.getLocalHost();
			socket = new Socket(localInetAddress, PORT);
			System.out.println("connected.");

			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();

			inputStream = new ObjectInputStream(socket.getInputStream());

			System.out.println("created streams!");
			ArrayList<Integer> intXORlist = new ArrayList<Integer>();
			ArrayList<Integer> intlist = new ArrayList<Integer>();

			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("Enter an integer, blank line to quit:");
				String input = sc.nextLine();
				if (input.equals(""))
					break;
				else {
					int num;
					try {
						num = Integer.parseInt(input);
						int a = num ^ pw;
						intXORlist.add(a);
						intlist.add(num);
					} catch (Exception e) {
						System.out.println("Not an Integer! try again");
					}

				}
			}

			sc.close();
			outputStream.writeObject(intXORlist);
			outputStream.flush();

			ArrayList<Integer> primelist = (ArrayList<Integer>) inputStream.readObject();
			ArrayList<Integer> realprimelist = new ArrayList<Integer>();
			// decode form the server
			for (int i : primelist) {
				realprimelist.add(i ^ pw);
			}
			System.out.println("You sent XOR list: " + intXORlist + "to the server.");
			System.out.println("You entered: " + intlist);

			System.out.println("Received from server: " + primelist);
			System.out.println("The real prime list: " + realprimelist);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("client done!");
	}
}
