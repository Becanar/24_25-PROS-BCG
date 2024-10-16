public class Actividad3 {
    public static void main(String[] args) {
        // create thread
        Hilo hilo = new Hilo();

        // show original name and priority
        System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // change name and priority
        hilo.setName("SUPER-HILO-DM2");
        hilo.setPriority(6);

        // show changed name and priority
        System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        //thread start
        hilo.start();

        System.out.println("Final programa");
    }
}
//thread class empty because we dont need to define nothing
class Hilo extends Thread {
}