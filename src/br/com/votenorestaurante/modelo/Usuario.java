package br.com.votenorestaurante.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Entidade {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="email", nullable=false, length=50)
	private String email;
	
	@Column(name="nome", nullable=false, length=50)
	private String nome;
	
	@OneToMany(mappedBy="usuario")
	private List<VotosUsuario> votos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<VotosUsuario> getVotos() {
		return votos;
	}

	public void setVotos(List<VotosUsuario> votos) {
		this.votos = votos;
	}
}
