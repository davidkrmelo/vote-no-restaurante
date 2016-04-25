package br.com.votenorestaurante.facade;

import br.com.votenorestaurante.dao.RestauranteDAO;
import br.com.votenorestaurante.modelo.Restaurante;

public class VotacaoRestauranteFacade extends VotacaoFacade<Restaurante> {

	@Override
	protected void criaDAO() {
		this.dao = new RestauranteDAO();
	}
}
