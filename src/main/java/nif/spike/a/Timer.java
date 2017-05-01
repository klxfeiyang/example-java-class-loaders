package nif.spike.a;

public class Timer {

	private static final int MAX_COUNT = 100;
	private static Boolean lock = false;

	private static Integer count = 0;

	public Timer(final String name) {
		Runnable runnable = new Runnable() {
			public void run() {
				while (count < MAX_COUNT) {
					synchronized (lock) {
						count++;
						System.out.println(name + ": " + count);
					}
					sleep();
				}
			}

		};
		Thread thread = new Thread(runnable, name);
		thread.start();
	}

	private void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
