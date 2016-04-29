package br.com.votenorestaurante.modelo;

public class Confronto<T extends Candidato> {
	
	
	private T c1;
	
	private T c2;
	
	public Confronto(T c1, T c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public T getC1() {
		return this.c1;
	}
	
	public T getC2() {
		return this.c2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass())
			return false;
		Confronto c = (Confronto)obj;
		if (this.c1.equals(c.getC1())) {
			if (this.c2.equals(c.getC2())) {
				return true;
			}
		}
		if (this.c2.equals(c.getC1())) {
			if (this.c1.equals(c.getC2())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c1 == null) ? 0 : c1.hashCode());
		result += prime * result + ((c2 == null) ? 0 : c2.hashCode());
		return result;
	}
	
	
}
