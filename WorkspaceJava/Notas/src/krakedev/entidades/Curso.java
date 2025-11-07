package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	ArrayList<Estudiante> estudiante = new ArrayList<Estudiante>();

	public ArrayList<Estudiante> getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(ArrayList<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}

	public String buscarEstudiantePorCedula(Estudiante estudiante) {
		Estudiante elementoEstudiante;
		String estudianteEncontrado = null;

		if (this.estudiante.size() != 0) {
			for (int i = 0; i < this.estudiante.size(); i++) {
				elementoEstudiante = this.estudiante.get(i);

				if (estudiante.getCedula() == elementoEstudiante.getCedula()) {
					System.out.println("Estudiante encontrado");
					estudianteEncontrado = "encontrado";
				}
			}
		}

		return estudianteEncontrado;
	}

	public void matricularEstudiante(Estudiante estudiante) {
		String cedulaEncontrada;

		cedulaEncontrada = buscarEstudiantePorCedula(estudiante);

		if (cedulaEncontrada == null) {
			this.estudiante.add(estudiante);
		}
	}

	public double calcularPromedioCurso() {
		double promedio = 0;
		Estudiante elementoEncontrado;

		for (int i = 0; i < estudiante.size(); i++) {
			elementoEncontrado = estudiante.get(i);

			promedio += elementoEncontrado.calcularPromedioNotasEstudiante();
		}

		promedio = promedio / estudiante.size();

		return promedio;
	}

	public void mostrar() {
		Estudiante elementoEstudiante;

		for (int i = 0; i < estudiante.size(); i++) {
			elementoEstudiante = estudiante.get(i);

			for (int j = 0; j < elementoEstudiante.getNota().size(); j++) {
				System.out.println("Nombre: " + elementoEstudiante.getNombre() + " Apellido: "
						+ elementoEstudiante.getApellido() + " Cedula: " + elementoEstudiante.getCedula() + " Materia: "
						+ elementoEstudiante.getNota().get(j).getMateria().getNombre() + " Calificacion: "
						+ elementoEstudiante.getNota().get(j).getCalificacion());
			}
		}

	}
}
