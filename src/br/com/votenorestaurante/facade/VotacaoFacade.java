package br.com.votenorestaurante.facade;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.votenorestaurante.dao.DAO;
import br.com.votenorestaurante.modelo.Candidato;
import br.com.votenorestaurante.modelo.Confronto;

public abstract class VotacaoFacade<T extends Candidato> {

	protected Set<Confronto<T>> confrontos;
	protected DAO dao;
	protected Map<T, Integer> votos;
	protected Confronto<T> confrontoAtual;
	
	protected abstract void criaDAO();
	
	public VotacaoFacade() {
		criaDAO();
	}
	
	public void carregarCandidatos() {
		this.confrontos = new HashSet<Confronto<T>>();
		List<T> candidatos = dao.listarTodos();
		for (int i=0; i<candidatos.size(); i++) {
			T ci = candidatos.get(i);
			for (int j=i+1; j<candidatos.size(); j++) {
				T cj = candidatos.get(j);
				this.confrontos.add(new Confronto<T>(ci, cj));
			}
		}
		if (!confrontos.isEmpty()) {
			this.confrontoAtual = confrontos.iterator().next();
		}
	}
	
	public void votar(int id) {
		T c = (T) dao.buscarPorId(id);
		this.votos.put(c, this.votos.get(c)+1);
		this.confrontos.remove(confrontoAtual);
		if (!confrontos.isEmpty()) {
			this.confrontoAtual = confrontos.iterator().next();
		} else {
			this.confrontoAtual = null;
		}
	}

	public Set<Confronto<T>> getConfrontos() {
		return confrontos;
	}

	public void setConfrontos(Set<Confronto<T>> confrontos) {
		this.confrontos = confrontos;
	}

	public Map<T, Integer> getVotos() {
		return votos;
	}

	public void setVotos(Map<T, Integer> votos) {
		this.votos = votos;
	}


	public Confronto<T> getConfrontoAtual() {
		return confrontoAtual;
	}

	public void setConfrontoAtual(Confronto<T> confrontoAtual) {
		this.confrontoAtual = confrontoAtual;
	}
	
}
