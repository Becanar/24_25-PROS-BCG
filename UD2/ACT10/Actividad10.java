public class Actividad10 {

    public static void main(String[] args) {
        //main thread priority
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " tiene la prioridad " + mainThread.getPriority());

        // create two threads
        Hilo hiloPrioridad3 = new Hilo("Hilo-prioridad 3");
        Hilo hiloPrioridad7 = new Hilo("Hilo-prioridad 7");

        // set threads priorities
        hiloPrioridad3.setPriority(3);
        hiloPrioridad7.setPriority(7);

        System.out.println(hiloPrioridad3.getName() + " tiene la prioridad " + hiloPrioridad3.getPriority());
        System.out.println(hiloPrioridad7.getName() + " tiene la prioridad " + hiloPrioridad7.getPriority());

        try {
            // start the thread
            hiloPrioridad7.start();
            hiloPrioridad7.join();  // wait hiloPrioridad7 to finish

            // start the other thread
            hiloPrioridad3.start();
            System.out.println("Final programa");//print final
            hiloPrioridad3.join();  // wait hiloPrioridad3 to finish

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

// thread class
class Hilo extends Thread {
    private String message;

    public Hilo(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Ejecutando " + message);
    }
}
