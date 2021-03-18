package br.com.fiap.cap4smartcities.dao;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> {

	//imita o construtor da superclasse
	public UsuarioDAO(EntityManager em) {
		super(em);
	}

}
