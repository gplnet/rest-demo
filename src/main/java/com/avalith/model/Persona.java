package com.avalith.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int per_cod;
	
	@Column(name = "per_nom", length = 60, nullable = false)
	private String per_nom;
	
	@Column(name = "per_ape", length= 90, nullable = false)
	private String per_ape;	
	
	@Column(name = "per_rep", length = 325, nullable = false)
	private String per_rep;
	
	@OneToMany( mappedBy = "persona",fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE}, orphanRemoval = true)
	private List<Tecnologia> tecnologias;
	
	@Transient
	private String nombreCompleto;
	
	
	
	public Persona() {
		this.tecnologias = new ArrayList<Tecnologia>();
	}


	public Persona(int per_cod, String per_nom, String per_ape, String per_rep, List<Tecnologia> tecnologias,
			String nombreCompleto) {
		super();
		this.per_cod = per_cod;
		this.per_nom = per_nom;
		this.per_ape = per_ape;
		this.per_rep = per_rep;
		this.tecnologias = tecnologias;
		this.nombreCompleto = nombreCompleto;
	}



	public String getNombreCompleto() {
		StringBuilder sb =new StringBuilder();
		sb.append(per_ape).append(", ").append(per_nom);
		return sb.toString();
	}
	
	
	
	public int getPer_cod() {
		return per_cod;
	}
	public void setPer_cod(int per_cod) {
		this.per_cod = per_cod;
	}
	public String getPer_nom() {
		return per_nom;
	}
	public void setPer_nom(String per_nom) {
		this.per_nom = per_nom;
	}
	public String getPer_rep() {
		return per_rep;
	}
	public void setPer_rep(String per_rep) {
		this.per_rep = per_rep;
	}
	public List<Tecnologia> getTecnologias() {
		return tecnologias;
	}
	public void setTecnologias(List<Tecnologia> tecnologias) {
		this.tecnologias = tecnologias;
	}


	public String getPer_ape() {
		return per_ape;
	}


	public void setPer_ape(String per_ape) {
		this.per_ape = per_ape;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + per_cod;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (per_cod != other.per_cod)
			return false;
		return true;
	}
	
	
	
	

}
