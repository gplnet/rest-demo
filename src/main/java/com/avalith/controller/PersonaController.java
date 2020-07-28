package com.avalith.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalith.model.Persona;
import com.avalith.service.IPersonaService;




@RestController
@RequestMapping("/developers")
public class PersonaController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IPersonaService sPersona;
	
	
	@GetMapping( value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar(){
		logger.info("Listo");
		List<Persona> person = new ArrayList<>();
		try {
			person = sPersona.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
			new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Persona>>(person, HttpStatus.OK);
	}
	
	@PostMapping(value = "/registry", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> registry(@RequestBody Persona persona ){	
		
		Persona prs = new Persona();
		try {
			prs = sPersona.registrar(persona);
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Listo"+ e);
			return new ResponseEntity<Persona>(prs, HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		return new ResponseEntity<Persona>(prs, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getDeveloper/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> listarId (@PathVariable("id") Integer id){
		
		Persona prs = new Persona();
		try {
			prs = sPersona.listarId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Persona>(prs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(prs, HttpStatus.OK);	
		
	}
	
	
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> update(@PathVariable Integer id, @RequestBody Persona pres) {
		int resultado = 0;
		try {
			pres.setPer_cod(id);
			resultado = sPersona.modificar(pres);
			resultado = 1;
		} catch (Exception e) {
			logger.info("==>error"+e);
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> delete(@PathVariable Integer id) {
		int resultado = 0;
		try {
			sPersona.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	

}
