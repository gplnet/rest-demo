package com.avalith.service;

import java.util.List;

import com.avalith.model.Persona;



public interface IPersonaService {
	
	Persona registrar(Persona persona);
	
	int modificar(Persona persona);
	
	void eliminar(int id);
	
	Persona listarId(int id);
	
	List<Persona> listar();

}
