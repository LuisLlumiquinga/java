package com.krakedev.test;

import com.krakedev.Calculadora;

public class TestCalculadora {

	public static void main(String[] args) {
		Calculadora calcu;
		int resultadoSuma; 
		int resultadoResta;
		double resultadoMultiplicacion;
		double resultadoDivision;
		double resultadoPromedio;
				
		calcu = new Calculadora();
		resultadoSuma=calcu.sumar(5, 3);
		resultadoResta=calcu.restar(10, 3);
		
		System.out.println("RESULTADO SUMA: "+resultadoSuma);
		System.out.println("RESULTADO RESTA: "+resultadoResta);
		
		resultadoMultiplicacion=calcu.multiplicar(10, 5);
		resultadoDivision=calcu.dividir(10, 2);
		resultadoPromedio=calcu.promediar(10, 8, 9);
		calcu.mostrarResultado();
		
		System.out.println("\nRESULTADO MULTIPLICACION: "+resultadoMultiplicacion);
		System.out.println("\nRESULTADO DIVISION: "+resultadoDivision);
		System.out.println("\nRESULTADO PROMEDIO: "+resultadoPromedio);
	}
}