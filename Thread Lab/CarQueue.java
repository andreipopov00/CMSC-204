import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Maintains a queue of random directions a car can go
 * 
 * @author Rose Griffin
 *
 */
public class CarQueue {
	
	private Queue<Integer> queue;
	private Random rand = new Random();
	
	public CarQueue() {
		queue = new LinkedList<Integer>();
		
		//Add to queue a random direction six times
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
		queue.add(rand.nextInt(4));
	}
	
	/**
	 * Adds a random direction to the queue
	 * 0 = up
	 * 1 = down
	 * 2 = right
	 * 3 = left
	 */
	public void addToQueue() {
		
		class addRunnable implements Runnable {
			@Override
			public void run() {
				try {
					while(true) {
						queue.add(rand.nextInt(4));
						Thread.sleep(1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		addRunnable run = new addRunnable();
		Thread thread = new Thread(run);
		thread.start();
	}

	public int deleteQueue() {
		return queue.remove();
	}

}