package com.avalith.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tecnologia")
public class Tecnologia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tec_cod;
	
	@Column(name = "tec_des", length = 60, nullable = false)
	private String tec_des;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="per_cod", nullable = false)
	private Persona persona;
	
	

	public int getTec_cod() {
		return tec_cod;
	}

	public void setTec_cod(int tec_cod) {
		this.tec_cod = tec_cod;
	}

	public String getTec_des() {
		return tec_des;
	}

	public void setTec_des(String tec_des) {
		this.tec_des = tec_des;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
	

}
