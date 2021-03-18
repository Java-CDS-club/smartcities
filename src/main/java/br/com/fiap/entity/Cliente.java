package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Inheritance;

@Entity
@Table(name="cliente")
@Inheritance
public class Cliente {

	@Id
	@Column(name="id_cliente")
	@SequenceGenerator(name="cliente",sequenceName="sq_cliente",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="cliente")
	private int id;
	
	@Column(name="nome_cliente",nullable=false, length = 50)
	private String nome;
	
	 @ManyToMany
	 @JoinTable(joinColumns = @JoinColumn(name = "id_cliente"), inverseJoinColumns = @JoinColumn(name = "id_estabelecimento"), name = "cliente_estabelecimento")
	 private List<Estabelecimento> estabelecimentos;
	  ;
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

  
   
