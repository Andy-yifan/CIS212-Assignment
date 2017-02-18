import java.util.LinkedList;
import java.util.UUID;

public class Producer implements Runnable {

	public static boolean doneProducing = false;
	private static final int MAX_COUNT = 2000000;
	private static final int MAX_QUEUE = 100000;
	LinkedList<String> _queue;

	public Producer(LinkedList<String> queue) {
		_queue = queue;
	}

	@Override
	public void run() {
		for (int i = 1; i <= MAX_COUNT; ++i) {
			synchronized (_queue) {
				while (_queue.size() == MAX_QUEUE) {
					try {
						_queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				_queue.notifyAll();
				String uuid = UUID.randomUUID().toString();
				_queue.add(uuid);
			}
			if (i % 1000 == 0) {
				// Print progress here
				System.out.println("produced: " + i);
			}

		}
		doneProducing = true;
		System.out.println("producer finished!");
	}

}
