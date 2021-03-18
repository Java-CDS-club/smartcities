package br.com.fiap.cap4smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.cap4smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.entity.TipoEstabelecimento;

public class DAOTeste {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
			TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
			
			//Implementações que utilizam os métodos do DAO
			
			TipoEstabelecimento tipo = new TipoEstabelecimento();
			tipo.setNome("Bar e Restaurante");
			dao.cadastrar(tipo);
			dao.commit();			
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}

	}
}