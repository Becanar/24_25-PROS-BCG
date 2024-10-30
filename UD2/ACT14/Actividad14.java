package Actividad14;

public class Actividad14 extends Thread { 
    public static void main(String args[]) {
        Recurso a = new Recurso(); 
        Recurso b = new Recurso(); 
        Hilo h1 = new Hilo(a, b, "uno"); 
        Hilo h2 = new Hilo(a, b, "dos"); // changed order
        h1.start(); 
        h2.start(); 
    }
}

// thread class
class Hilo extends Thread { 
    Recurso a; 
    Recurso b; 

    public Hilo(Recurso a, Recurso b, String nombre) { 
        super(nombre); 
        this.a = a; 
        this.b = b; 
    } 

    public void run() { 
        System.out.println("Hilo " + this.getName() + " comienza"); 
        
        // avoid deadlock
        synchronized (a) { 
            try { 
                Thread.sleep(100); // simulate work with 'a' locked
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 

            synchronized (b) { 
                //ensuring 'b' is also locked
            } 
        } 
        
        System.out.println("Hilo " + this.getName() + " ha terminado"); 
    } 
}

class Recurso { 
    // empty  as a placeholder
}
