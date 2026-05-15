package com.krakedev.herencia.test;

import java.util.ArrayList;

import com.krakedev.herencia.Hija;

public class TestArrayList {

	public static void main(String[] args) {
		ArrayList<Hija> listaDeHijas = new ArrayList<Hija>();
		
		Hija hija1=new Hija();
		hija1.setDefectos(2);
		hija1.setVirtudes(4);
		
		listaDeHijas.add(hija1);
		
		Hija hija2=new Hija();
		hija2.setDefectos(6);
		hija2.setVirtudes(1);
		
		listaDeHijas.add(hija2);
		
		Hija hija3=new Hija();
		hija3.setDefectos(2);
		hija3.setVirtudes(4);
		
		listaDeHijas.add(hija3);
		
		System.err.println(listaDeHijas);

	}

}
