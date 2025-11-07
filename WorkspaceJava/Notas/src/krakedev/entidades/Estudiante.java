package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private int cedula;
	private ArrayList<Nota> nota=new ArrayList<Nota>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNota() {
		return nota;
	}

	public void setNota(ArrayList<Nota> nota) {
		this.nota = nota;
	}

	public Estudiante(int cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void agregarNota(Nota nuevaNota) {
		Nota elementoNota;
		boolean codigoRepetido = false;

		// encontrar nota repetida
		if(nota.size()==0) {
			if (nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10) {
				nota.add(nuevaNota);
			} else {
				System.out.println("La nota debe ser 0-10");
			}
		}else {
			for (int i = 0; i < nota.size(); i++) {
				elementoNota = nota.get(i);

				if (nuevaNota.getMateria().getCodigo().equals(elementoNota.getMateria().getCodigo())) {
					codigoRepetido = true;
					break;
				}
			}
			
			// verificar nota entre 0-10
			if (codigoRepetido == false) {
				if (nuevaNota.getCalificacion() >= 0 && nuevaNota.getCalificacion() <= 10) {
					nota.add(nuevaNota);
				} else {
					System.out.println("La nota debe ser 0-10");
				}
			} else {
				System.out.println("Codigo de materia repetido");
			}
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {
		Nota elementoNota;
		boolean codigoEncontrado = true;

		for (int i = 0; i < nota.size(); i++) {
			elementoNota = nota.get(i);

			if (codigo.equals(elementoNota.getMateria().getCodigo())) {
				if (nuevaNota >= 0 && nuevaNota <= 10) {
					elementoNota.setCalificacion(nuevaNota);
				} else {
					System.out.println("La nota debe ser 0-10");
				}
				break;
			}else {
				codigoEncontrado=false;
			}
		}
		
		if(codigoEncontrado==false) {
			System.out.println("No se encontro el codigo de la materia");
		}

	}

	public double calcularPromedioNotasEstudiante() {
		Nota elementoNota;
		double sumaNotas = 0;
		double promedio = 0;

		for (int i = 0; i < nota.size(); i++) {
			elementoNota = nota.get(i);

			sumaNotas += elementoNota.getCalificacion();
		}

		promedio = sumaNotas / nota.size();

		return promedio;
	}

	public void mostrar() {
		Nota elementoNota;

		for (int i = 0; i < nota.size(); i++) {
			elementoNota = nota.get(i);

			System.out.println("Nombre: " + nombre + " Apellido: " + apellido + " Cedula: " + cedula + " Materia: "
					+ elementoNota.getMateria().getNombre() + " Calificacion: " + elementoNota.getCalificacion());
		}

	}
}
