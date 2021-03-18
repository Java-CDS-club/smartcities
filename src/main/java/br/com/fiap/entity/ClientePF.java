package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cliente_pf")
public class ClientePF extends Cliente {
	
	@Column(name="estado_civil", length = 20)
	private String estadoCivil;
	
	@Column(length = 20)
	private String escolaridade;

	public ClientePF(){
		
	}
	
	public ClientePF(String estadoCivil, String escolaridade) {
		super();
		this.estadoCivil = estadoCivil;
		this.escolaridade = escolaridade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

     
}
