package com.avalith.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avalith.dao.IPersonaDAO;

import com.avalith.model.Persona;

import com.avalith.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDAO daoPersona;
	
	
	
	@Transactional
	@Override
	public Persona registrar(Persona persona) {
		// TODO Auto-generated method stub		
		persona.getTecnologias().forEach(tec -> {			
			tec.setPersona(persona);
		});
		return daoPersona.save(persona);
	}
	
	@Transactional
	@Override
	public int modificar(Persona persona) {
		// TODO Auto-generated method stub
		int resp = 0;
		persona.getTecnologias().forEach(tec -> {			
			tec.setPersona(persona);
		});
		resp = daoPersona.save(persona) != null ? persona.getPer_cod() : 0;
		return resp > 0 ? 1 : 0;
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		daoPersona.deleteById(id);
	}

	@Override
	public Persona listarId(int id) {
		// TODO Auto-generated method stub
		return daoPersona.findById(id).get();
	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return daoPersona.findAll();
	}

}
