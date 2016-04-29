package br.com.votenorestaurante.testes;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import br.com.votenorestaurante.dao.RestauranteDAO;
import br.com.votenorestaurante.facade.VotacaoRestauranteFacade;
import br.com.votenorestaurante.modelo.Restaurante;

public class VotacaoRestauranteFacadeTest {

	@Test
	public void testCarregarCandidatos() {
		VotacaoRestauranteFacade facade = new VotacaoRestauranteFacade();
		facade.carregarCandidatos();
		assertEquals(100, facade.getConfrontos().size());
		
		List<Restaurante> restaurantes = new RestauranteDAO().listarTodos();
		for (Map.Entry<Restaurante, Integer> voto: facade.getVotos().entrySet()) {
			assertTrue(restaurantes.contains(voto.getKey()));
			assertEquals(new Integer(0), voto.getValue());
		}
		
	}

}
