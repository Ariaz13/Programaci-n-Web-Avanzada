package Modelo;

public class alumnos {
	private int noControl;
	private String nombre, curso, semestre;
	
	public alumnos(int noControl, String nombre, String curso, String semestre) {
		this.noControl = noControl;
		this.nombre = nombre;
		this.curso = curso;
		this.semestre = semestre;
	}
	
	public int getnoControl() {
		return noControl;
	}
	
	public void setnoControl(int noControl) {
		this.noControl = noControl;
	}
	
	public String getnombre() {
		return nombre;
	}
	
	public void setnombre (String nombre) {
		this.nombre = nombre;
	}
	
	public String getcurso() {
		return curso;
	}
	
	public void setcurso (String curso) {
		this.curso = curso;
	}
	
	public String getsemestre() {
		return semestre;
	}
	
	public void setsemestre (String semestre) {
		this.semestre = semestre;
	}
}
