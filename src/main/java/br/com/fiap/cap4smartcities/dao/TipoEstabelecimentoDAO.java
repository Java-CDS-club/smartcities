package br.com.fiap.cap4smartcities.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.TipoEstabelecimento;

public class TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {

	public TipoEstabelecimentoDAO(EntityManager em) {
		super(em);
	}

	@Override
	public List<TipoEstabelecimento> listar() {
		return this.em.createQuery("from TipoEstabelecimento").getResultList();
	}

	public List<TipoEstabelecimento> listarOrdenadoNome() {
		return this.em.createQuery("from TipoEstabelecimento order by nome").getResultList();
	}

	public List<TipoEstabelecimento> listarTresUltimos() {
		return this.em.createQuery("from TipoEstabelecimento order by id desc").setMaxResults(3).getResultList();
	}

	public List<TipoEstabelecimento> listarPaginado(int itensPorPagina, int pagina) {
		int primeiro = (pagina - 1) * itensPorPagina;

		return this.em.createQuery("from TipoEstabelecimento order by nome").setMaxResults(itensPorPagina)
				.setFirstResult(primeiro).getResultList();
	}

	public TipoEstabelecimento recuperar(Integer idPesquisa) {
		// TODO Auto-generated method stub
		return null;
	}
}
