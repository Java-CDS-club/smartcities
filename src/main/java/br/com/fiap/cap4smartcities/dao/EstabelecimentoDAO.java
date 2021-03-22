package br.com.fiap.cap4smartcities.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Estabelecimento;
import br.com.fiap.entity.TipoEstabelecimento;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer> {

	public EstabelecimentoDAO(EntityManager em) {
		super(em);
	}

	public List<Estabelecimento> listarPorNome(String nome) {
		return this.em.createQuery("select e from Estabelecimento e " + "where e.nome = :n").setParameter("n", nome)
				.getResultList();
	}

	public List<Estabelecimento> listarPorNomeCriacaoApos(String nome, Calendar criacaoApos) {
		return this.em
				.createQuery("select e from Estabelecimento e " + "where e.nome = :nome and "
						+ "where e.dataCricao > :criacao ")
				.setParameter("nome", nome).setParameter("cricao", criacaoApos).getResultList();
	}

	public List<Estabelecimento> listarPorTipo(TipoEstabelecimento tipo) {
		return this.em.createQuery("select e from Estabelecimento e " + "where e.tipo = :t").setParameter("t", tipo)
				.getResultList();
	}

	public Estabelecimento listarPorLocalizacao(double latitude, double longitude) {
		return (Estabelecimento) this.em
				.createQuery("select e from Estabelecimento e where " + "e.latitude = :latitude and"
						+ "e.longitude = :longitude")
				.setParameter("latitude", latitude).setParameter("longitude", longitude).getSingleResult();
	}
}
