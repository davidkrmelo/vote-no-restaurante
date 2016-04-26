package br.com.votenorestaurante.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.votenorestaurante.dao.util.BancoUtil;
import br.com.votenorestaurante.modelo.Entidade;

public abstract class DAO<T extends Entidade> {

	private EntityManager em;
	private EntityManagerFactory emf;
	private Class<T> classe;
	//private BancoUtil bUtil;
	
	DAO(Class<T> classe) {
//		if (bUtil == null) {
//			bUtil = new BancoUtil();
//			try {
//				bUtil.criarBanco();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		this.classe = classe;
		this.emf = Persistence.createEntityManagerFactory("VoteNoRestaurantePU");
		carregarEm();
	}
	
	private void carregarEm() {
		if (this.em == null) {
			this.em = emf.createEntityManager();
		}
	}
	
	public void iniciaTransacao() {
		this.em.getTransaction().begin();
	}
	
	public void commitTransacao() {
		this.em.getTransaction().commit();
	}
	
	public void rollbackTransacao() {
		this.em.getTransaction().rollback();
	}
	
	public void salvar(T entidade) {
		carregarEm();
		boolean operacaoUnitaria = false;
		if (!this.em.getTransaction().isActive()) {
			operacaoUnitaria = true;
			iniciaTransacao();
		}
		this.em.merge(entidade);
		if (operacaoUnitaria) {
			commitTransacao();
		}
	}
	
	public void excluir(T entidade) {
		carregarEm();
		boolean operacaoUnitaria = false;
		if (!this.em.getTransaction().isActive()) {
			operacaoUnitaria = true;
			iniciaTransacao();
		}
		this.em.remove(entidade);
		if (operacaoUnitaria) {
			commitTransacao();
		}
	}
	
	public T buscarPorId(int id) {
		carregarEm();
		return this.em.find(classe, id);
	}
	
	public List<T> listarTodos() {
		carregarEm();
		Query q = em.createQuery("SELECT t FROM " + classe.getSimpleName() + " t");
		return q.getResultList();
	}
}
