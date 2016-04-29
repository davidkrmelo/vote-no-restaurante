package br.com.votenorestaurante.dao;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import br.com.votenorestaurante.modelo.Candidato;
import br.com.votenorestaurante.modelo.VotosUsuario;

public class VotosDAO extends DAO<VotosUsuario> {

	public VotosDAO() {
		super(VotosUsuario.class);
	}

	public List<Map.Entry<String, Long>> buscarMaisVotados() {
		List<Map.Entry<String, Long>> resultado = new ArrayList<Map.Entry<String, Long>>();
		Query q = em.createQuery("SELECT v.candidato.nome, SUM(v.qtdVotos) FROM VotosUsuario v GROUP BY v.candidato.nome ORDER BY SUM(v.qtdVotos) DESC");
		List<Object[]> lista = q.getResultList();
		for (Object[] linha: lista) {
			Map.Entry<String, Long> par = new AbstractMap.SimpleEntry<String, Long>((String)linha[0], (Long)linha[1]);
			resultado.add(par);
		}
		return resultado;
	}
}
