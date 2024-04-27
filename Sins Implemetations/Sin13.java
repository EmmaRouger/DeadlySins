public class Sin13 {
    private int c = 0;

    // Add 1 to the counter
    // Use "synchronized" to protect the method against race conditions
    public synchronized void add() {
        c++;
    }

    // Read the value of the counter
    // Also synchronized
    public synchronized int getCounter() {
        return c;
    }

    public static void main(String[] args) throws InterruptedException {
        Sin13 counter = new Sin13();

        // Example function to be used with the threads (counts to 666)
        Runnable count = new Runnable() {
            public void run() {
                for (int i = 0; i < 666; i++) {
                    counter.add();
                }
            }
        };

        // Create and start two threads to demonstrate the sin
        Thread t1 = new Thread(count);
        Thread t2 = new Thread(count);
        t1.start();
        t2.start();

        // Use "join" to force one thread to wait when it finishes before the other (executes proper timing to avoid race conditions)
        t1.join();
        t2.join();

        System.out.println("c is: " + counter.getCounter());
    }
}
