package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Table(name = "tipo_estabelecimento")
public class TipoEstabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_estabelecimento")
	private Integer id;

	@Column(name = "nome_tipo_estabelecimento", length=25, nullable=false)
	private String nome;
	
	 @OneToMany(mappedBy = "tipo")
	   private Collection<Estabelecimento> estabelecimentos;

	 public TipoEstabelecimento() {
		 
	 }
	 
	public TipoEstabelecimento(Integer id, String nome, Collection<Estabelecimento> estabelecimentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.estabelecimentos = estabelecimentos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Estabelecimento> getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(Collection<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}	 
}




  

