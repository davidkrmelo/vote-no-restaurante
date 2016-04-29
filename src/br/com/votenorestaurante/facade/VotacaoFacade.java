package br.com.votenorestaurante.facade;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.votenorestaurante.dao.DAO;
import br.com.votenorestaurante.dao.UsuarioDAO;
import br.com.votenorestaurante.dao.VotosDAO;
import br.com.votenorestaurante.modelo.Candidato;
import br.com.votenorestaurante.modelo.Confronto;
import br.com.votenorestaurante.modelo.Usuario;
import br.com.votenorestaurante.modelo.VotosUsuario;

public abstract class VotacaoFacade<T extends Candidato> {

	protected Set<Confronto<T>> confrontos;
	protected DAO dao;
	protected Map<T, Integer> votos;
	protected Confronto<T> confrontoAtual;
	protected UsuarioDAO usuarioDAO = new UsuarioDAO();
	protected VotosDAO votosDAO = new VotosDAO();
	
	protected abstract void criaDAO();
	
	public VotacaoFacade() {
		criaDAO();
	}
	
	public void carregarCandidatos() {
		this.confrontos = new HashSet<Confronto<T>>();
		this.votos = new HashMap<T, Integer>();
		List<T> candidatos = dao.listarTodos();
		for (int i=0; i<candidatos.size(); i++) {
			T ci = candidatos.get(i);
			for (int j=i+1; j<candidatos.size(); j++) {
				T cj = candidatos.get(j);
				this.confrontos.add(new Confronto<T>(ci, cj));
			}
			this.votos.put(ci, 0);
		}
		if (!this.confrontos.isEmpty()) {
			this.confrontoAtual = this.confrontos.iterator().next();
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
	
	public void salvarVotacao(Usuario usuario) {
		usuarioDAO.salvar(usuario);
		for (Map.Entry<T, Integer> entry: this.votos.entrySet()) {
			Candidato candidato = entry.getKey();
			int qtdVotos = entry.getValue();
			VotosUsuario votosUsuario = new VotosUsuario(usuario, candidato, qtdVotos);
			usuario.getVotos().add(votosUsuario);
			votosDAO.salvar(votosUsuario);
		}
	}
	
	public List<Map.Entry<String, Long>> buscarMaisVotados() {
		return votosDAO.buscarMaisVotados();
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
