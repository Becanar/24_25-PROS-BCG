package Actividad10;
import java.io.Serializable;

// Tenista class
public class Tenista implements Serializable {
    private String apellido;
    private int altura;

    // constructor
    public Tenista(String apellido, int altura) {
        this.apellido = apellido;
        this.altura = altura;
    }
    //getters and setters
    public String getApellido() {
        return apellido;
    }

    public int getAltura() {
        return altura;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
