package com.avalith.service;

import java.util.List;

import com.avalith.model.Tecnologia;



public interface ITecnologiaService {
	
	Tecnologia registrar(Tecnologia tecno);
	
	int modificar(Tecnologia tecno);
	
	void eliminar(int id);
	
	Tecnologia listarId(int id);
	
	List<Tecnologia> listar();

}
