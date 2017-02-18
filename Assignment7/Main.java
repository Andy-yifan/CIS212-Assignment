import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>();
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue, 1);
		Consumer consumer2 = new Consumer(queue, 2);
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(producer);
		executor.execute(consumer);
		executor.execute(consumer2);
		executor.shutdown();

		System.out.println("main thread finished!");
	}
}
