package br.com.fiap.cap4smartcities.rmi.server;

import java.rmi.RemoteException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.cap4smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.entity.TipoEstabelecimento;

public class TipoEstabelecimentoServiceImpl implements TipoEstabelecimentoService {

	protected TipoEstabelecimentoServiceImpl() throws RemoteException {
		super();
	}

	public String pesquisar(Integer idPesquisa) throws RemoteException {

		EntityManager em = Persistence.createEntityManagerFactory("cap4smartcities").createEntityManager();

		TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);

		TipoEstabelecimento tipoEstabelecimento = dao.recuperar(idPesquisa);

		if (tipoEstabelecimento != null) {
			return tipoEstabelecimento.getNome();
		} else {
			return null;
		}
	}
}