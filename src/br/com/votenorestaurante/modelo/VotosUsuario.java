package br.com.votenorestaurante.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="votosusuario")
public class VotosUsuario implements Entidade {

	@Id
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="candidato_id")
	private Candidato candidato;
	
	@Column(name="qtdVotos", nullable=false)
	private int qtdVotos;
	
	public VotosUsuario() {
		
	}
	
	public VotosUsuario(Usuario u, Candidato c, int qtd) {
		this.usuario = u;
		this.candidato = c;
		this.qtdVotos = qtd;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public int getQtdVotos() {
		return qtdVotos;
	}

	public void setQtdVotos(int qtdVotos) {
		this.qtdVotos = qtdVotos;
	}
}
