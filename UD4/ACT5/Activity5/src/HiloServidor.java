import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidor extends Thread{
    Socket socket;
    ObjectOutputStream outObjeto; //stream de salida
    ObjectInputStream inObjeto;   //stream de entrada
    EstructuraFicheros NF;

    // Constructor
    public HiloServidor(Socket s, EstructuraFicheros nF) throws IOException {
        socket = s;
        NF = nF;
        inObjeto = new ObjectInputStream (socket.getInputStream());
        outObjeto = new ObjectOutputStream (socket.getOutputStream());

    }

    public void start() {

    }
}
