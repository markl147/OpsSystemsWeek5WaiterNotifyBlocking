package example1;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                //Set message and notify

                msg.setMsg(name + " Notifier done!");
                msg.notifyAll();
                System.out.println(name + " waiting to be notified at time: " + System.currentTimeMillis());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}