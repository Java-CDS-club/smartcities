package br.com.fiap.cap4smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import br.com.fiap.entity.Estabelecimento;

public class JPATeste {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("cap4smartcities").createEntityManager();
			Estabelecimento est = new Estabelecimento();
			est.setId(1);
			est.setNome("Bar do Joao");
			em.merge(est);
			em.getTransaction().begin();
			em.getTransaction().commit();
			Estabelecimento recuperado = em.find(Estabelecimento.class, 1);
			recuperado.setNome("Escola Magic");
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally{
			if (em != null) {
				em.close();
			}
			System.exit(0);
		}
	}
}
//meio de campo entre BD e Java