package br.com.fiap.cap4smartcities.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.TipoEstabelecimento;

public class TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {

	public TipoEstabelecimentoDAO(EntityManager em) {
		super(em);
	}

	
}