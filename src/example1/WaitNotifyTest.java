package example1;

public class WaitNotifyTest {

    public static void main(String[] args) {
        // Create a Message(), two Waiters(msg), and a Notifier(msg)
        Message message = new Message("This is my message");

        //Start Waiters and Notifier
        Waiter wait1 = new Waiter(message);
        Thread t1 = new Thread(wait1, "wait1");
        t1.start();

        Waiter wait2 = new Waiter(message);
        Thread t2 = new Thread(wait2, "wait2");
        t2.start();

        // Print message "All the threads are started"
        Notifier notifier = new Notifier(message);
        Thread t3 = new Thread(notifier, "notifier");
        t3.start();

        System.out.println("All the threads are started");


    }

}