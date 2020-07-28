package com.avalith.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalith.dao.ITecnologiaDAO;
import com.avalith.model.Tecnologia;
import com.avalith.service.ITecnologiaService;

@Service
public class TecnologiaServiceImpl implements ITecnologiaService {

	@Autowired
	private ITecnologiaDAO daoTecno;
	
	@Override
	public Tecnologia registrar(Tecnologia tecno) {
		// TODO Auto-generated method stub
		Tecnologia tecnology = new Tecnologia();
		tecnology = daoTecno.save(tecno);
		return tecnology;
	}

	@Override
	public int modificar(Tecnologia tecno) {
		// TODO Auto-generated method stub
		int resp = 0;
		resp = daoTecno.save(tecno) != null ? tecno.getTec_cod() : 0;
		return resp > 0 ? 1 : 0;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		daoTecno.deleteById(id);
	}

	@Override
	public Tecnologia listarId(int id) {
		// TODO Auto-generated method stub
		return daoTecno.findById(id).get();
	}

	@Override
	public List<Tecnologia> listar() {
		// TODO Auto-generated method stub
		return daoTecno.findAll();
	}

}
