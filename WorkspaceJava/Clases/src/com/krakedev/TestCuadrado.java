package com.krakedev;

public class TestCuadrado {

	public static void main(String[] args) {
		Cuadrado c1=new Cuadrado(4);
		Cuadrado c2=new Cuadrado(45);
		Cuadrado c3=new Cuadrado(12);
		
		double areaC1;
		double perimetroC1; 
		double areaC2;
		double perimetroC2;
		double areaC3;
		double perimetroC3;
		
		//c1.setLado(4);
		//c2.setLado(45);
		//c3.setLado(12);
		
		areaC1=c1.calcularArea();
		perimetroC1=c1.calcularPerimetro();
		
		areaC2=c2.calcularArea();
		perimetroC2=c2.calcularPerimetro();
		
		areaC3=c3.calcularArea();
		perimetroC3=c3.calcularPerimetro();
		
		System.out.println("Cuadrado 1");
		System.out.println("Area: "+areaC1);
		System.out.println("Perimetro: "+perimetroC1);
		
		System.out.println("\nCuadrado 2");
		System.out.println("Area: "+areaC2);
		System.out.println("Perimetro: "+perimetroC2);
		
		System.out.println("\nCuadrado 3");
		System.out.println("Area: "+areaC3);
		System.out.println("Perimetro: "+perimetroC3);

	}

}
