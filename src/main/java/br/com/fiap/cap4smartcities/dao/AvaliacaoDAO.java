package br.com.fiap.cap4smartcities.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Avaliacao;
import br.com.fiap.entity.AvaliacaoId;

public class AvaliacaoDAO extends GenericDAO<Avaliacao, AvaliacaoId>{

	public AvaliacaoDAO(EntityManager em) {
		super(em);
	}

}

//Avaliacao seria a classe da Entidade que ficará sob a responsabilidade da AvaliacaoDAO e que a classe da Chave Primária é do tipo AvaliacaoId (lembrando que essa é a classe que mapeia os atributos que formama chave composta da entidade).