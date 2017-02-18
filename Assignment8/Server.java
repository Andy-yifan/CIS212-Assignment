import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static final int PORT = 8000;
	private static final int pw = 7;

	public static void main(String[] args) {
		System.out.println("running server!");

		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectOutputStream outputStream = null;
		ObjectInputStream inputStream = null;
		try {
			serverSocket = new ServerSocket(PORT);

			System.out.println("bound server socket!");
			Boolean loop = true;
			while (loop) {
				socket = serverSocket.accept();
				System.out.println("connected");

				// Create and flush output stream first to prevent
				// input stream from blocking.
				outputStream = new ObjectOutputStream(socket.getOutputStream());
				outputStream.flush();
				inputStream = new ObjectInputStream(socket.getInputStream());

				System.out.println("created streams!");
				ArrayList<Integer> primelist = new ArrayList<Integer>();
				ArrayList<Integer> message = (ArrayList<Integer>) inputStream.readObject();
				ArrayList<Integer> realmessage = new ArrayList<Integer>();
				if (message.size() != 0) {
					for (int j : message) {
						realmessage.add(j ^ pw);
					}
					for (int d : realmessage) {

						if (d > 1) {
							boolean flag = true;
							for (int j = 2; j <= Math.sqrt(d); j++) {

								if (d % j == 0) {
									flag = false;
									break;
								}

							}
							if (flag == true) {
								// XOR for save
								primelist.add(d ^ pw);
							}
						}
						loop = false;
					}
				} else {
					// if client don't input anything, just see as close the
					// server
					loop = false;
				}
				// send arraylist to client
				outputStream.writeObject(primelist);
				outputStream.flush();
				System.out.println("client says: " + realmessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
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

		System.out.println("server done!");
	}
}
