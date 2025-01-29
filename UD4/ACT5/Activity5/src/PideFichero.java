package org.example;

import java.io.Serializable;

public class PideFichero implements Serializable{

	//Declaracion atributo con el nombre del fichero
	String nombreFichero;
	
	//Constructor
	public PideFichero (String nombreFichero) {
		this.nombreFichero=nombreFichero;
	}
	
	//Metodo para obetener el nombre del fichero
	public String getNombreFichero() {return nombreFichero;}
}
