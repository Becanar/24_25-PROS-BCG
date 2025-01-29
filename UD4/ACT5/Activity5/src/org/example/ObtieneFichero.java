package org.example;

import java.io.Serializable;

public class ObtieneFichero implements Serializable{

	//Declaracion atributo con el contenido en bytes del fichero a descargar
	byte[] contenidoFichero;
	
	//constructor
	public ObtieneFichero(byte[] contenidoFichero) {
		this.contenidoFichero=contenidoFichero;
	}
	
	//Metodo para obetner el fichero a descargar
	public byte[] getContenidoFichero() {return contenidoFichero;}
}
