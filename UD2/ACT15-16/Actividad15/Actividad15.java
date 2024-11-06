import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class MessagePrinter implements Runnable {
    private String threadName;
    private static final int MESSAGE_COUNT = 5;
    private static final int DELAY_MS = 1000;

    public MessagePrinter(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            // prin the thread information
            System.out.println(threadName + " - " + LocalTime.now().format(timeFormatter));
            try {
                // wait 1 secons
                Thread.sleep(DELAY_MS);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
    }
}

public class Actividad15 {
    public static void main(String[] args) {
        // create and start 3 threads
        Thread thread1 = new Thread(new MessagePrinter("Hilo 1"));
        Thread thread2 = new Thread(new MessagePrinter("Hilo 2"));
        Thread thread3 = new Thread(new MessagePrinter("Hilo 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
