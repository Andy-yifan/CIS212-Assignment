import java.util.LinkedList;
import java.util.Random;

class Consumer implements Runnable {
	private static boolean _Next = true;
	private String max = "a";
	private String n;
	private int counter;
	LinkedList<String> _queue;
	private Integer id;

	public Consumer(LinkedList<String> queue, Integer ID) {
		this.id = ID;
		_queue = queue;
	}

	@Override
	public void run() {

		while (_Next || _queue.size() > 0) {
			synchronized (_queue) {
				while (_queue.size() == 0 && !Producer.doneProducing) {
					try {
						long sleepDelay = (long) (10 * Math.random());
						Thread.sleep(sleepDelay);

					} catch (InterruptedException ex) {
						System.out.println("Consumer InterruptedException");

					}
				}
				n = _queue.poll();
				_queue.notifyAll();
			}
			try {
				if (n != null) {
					counter++;
					if (max.compareTo(n) < 0) {
						max = n;
					}
					if (counter % 1000 == 0) {
						System.out.println("Consume " + this.id + " consumed: " + counter);

					}
				}
				long sleepDelay2 = (long) (10 * Math.random());
				Thread.sleep(sleepDelay2);
			} catch (InterruptedException ex) {
				System.out.println("InterruptedException!!!");
			}
			if (Producer.doneProducing) {
				_Next = false;
			}
		}
		System.out.println("Done consuming" + this.id + ", total is : " + counter);

		System.out.println("The max string for " + this.id + " is: " + max);

	}

}