package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {
	public void metodo1() {
		String a = null;
		a.substring(0);
		// NPE	UNCHECKED
	}

	public void metodo2() {
		File f = new File("archivo1.txt");
		try {
			f.createNewFile();	//IoException - CHECKED
		}catch(IOException ex){
			System.out.println("Error");
		}
		
	}
	
	public void metodo3() throws IOException{
		File f = new File("archivo1.txt");
		f.createNewFile();	//IoException - CHECKED
	}
	
	public void metodo4() {
		//metodo3();
	}
}
