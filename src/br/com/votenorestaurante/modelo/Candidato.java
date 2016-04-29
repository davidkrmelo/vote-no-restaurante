package br.com.votenorestaurante.modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="candidato_votacao")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "tipo_candidato")
public abstract class Candidato implements Entidade {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="nome", nullable=false, length=50)
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
