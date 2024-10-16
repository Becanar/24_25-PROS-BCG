public class Actividad5 {
    public static void main(String[] args) {
        //create threads
        Primero p = new Primero();
        Segundo s = new Segundo();
        //start threads
        p.start();
        s.start();
        //wait to end
        try {
            p.join();
            s.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fin programa");
    }
}
//Primero thread class
class Primero extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Primero " + i);
            try {
                Thread.sleep(100);//sleep configuration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//Segundo thread class
class Segundo extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Segundo " + i);
            try {
                Thread.sleep(200); //sleep configuration
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
