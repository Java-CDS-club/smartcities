package br.com.fiap.cap4smartcities.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.cap4smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.entity.TipoEstabelecimento;

public class DAOTeste {

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			em = Persistence.createEntityManagerFactory("cap4smartcities").createEntityManager();
			TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);
			
			salvaTipoEstabelecimento(dao);
			TipoEstabelecimento tipoEstabelecimento = buscaTipoEstabelecimento(dao);			
			
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
	
	private static void salvaTipoEstabelecimento(TipoEstabelecimentoDAO dao) throws Exception {
		TipoEstabelecimento tipo = new TipoEstabelecimento();
		tipo.setNome("Bar e Restaurante");

		dao.cadastrar(tipo);
		dao.commit();			
	}

	private static TipoEstabelecimento buscaTipoEstabelecimento(TipoEstabelecimentoDAO dao) {
		TipoEstabelecimento entidade = dao.buscar(1);
		
		if (entidade == null) {
			System.out.println("Não existe estabelecimento de chave 1");
		}else {
			System.out.println(" > " + entidade.getId() + " - " + entidade.getNome());
		}
		return entidade;
	}
}