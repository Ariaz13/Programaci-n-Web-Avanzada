package com.zaira.alumno.modelo;

public class alumnos {
	private int noControl, semestre;
	private String nombre, curso;
	
	public alumnos(int noControl, String nombre, String curso, int semestre) {
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
	
	public int getsemestre() {
		return semestre;
	}
	
	public void setsemestre (int semestre) {
		this.semestre = semestre;
	}
}
