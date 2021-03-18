package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;//mapeia coluna
import javax.persistence.Entity;//classe será mapeada em tabela
import javax.persistence.GeneratedValue;//automatiza valor da chave primária
import javax.persistence.GenerationType;
import javax.persistence.Id;//indica chave primária
import javax.persistence.SequenceGenerator;//acesso ao sequence BD
import javax.persistence.Table;//info da tabela (nome)
import javax.persistence.Temporal;//datas
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;//data e hora
import org.hibernate.annotations.Formula;//campos calculados
import org.hibernate.annotations.UpdateTimestamp;//automatiza data e hora

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

	@Id
	@Column(name = "id_estabelecimento")
	@SequenceGenerator(name="estabelecimento",sequenceName="sq_tb_estabelecimento",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="estabelecimento")
	private Integer id;

	@Column(name = "nome_estabelecimento",nullable=false, length = 50)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp//publica o momento do insert automaticamente
	@Column(name = "dh_criacao")
	private Calendar dataCriacao;

	@ManyToMany(mappedBy="estabelecimentos")
	private List<Cliente> clientes;
	
	@UpdateTimestamp
	@Column(name = "dh_modificacao")
	private Calendar dataModificacao;
	
	@OneToOne(mappedBy="estabelecimento")
	private ContratoAluguel contrato;
	
	@Column (name="qt_metros")
	private double	quantidadeMetros;

	@Formula("qt_metros * 4900.0")
	private Double	valorTotal;
	
	@JoinColumn(name = "id_tipo_estabelecimento")
	@ManyToOne
	private TipoEstabelecimento tipo;
	
	//constructor
	public Estabelecimento() {
		super();
	}

	public Estabelecimento(Integer id, String nome, Calendar dataCriacao, Calendar dataModificacao,
			Double quantidadeMetros) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.quantidadeMetros = quantidadeMetros;
	}
	//getters e setters
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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public Double getquantidadeMetros() {
		return quantidadeMetros;
	}

	public void setquantidadeMetros(Double quantidadeMetros) {
		this.quantidadeMetros = quantidadeMetros;
	}
}
	
	

