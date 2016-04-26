package br.com.votenorestaurante.dao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.votenorestaurante.modelo.Restaurante;

public class BancoUtil {

	private boolean bancoCriado = false;
	
	public void criarBanco() throws IOException {
		if (!bancoCriado) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("VoteNoRestaurantePU");
			EntityManager em = emf.createEntityManager();
			
			//RestauranteDAO dao = new RestauranteDAO();
			
			//outback
			Restaurante r1 = new Restaurante();
			r1.setNome("Outback");
			r1.setSite("https://www.outback.com.br/");
			r1.setLogo(converterParaByte("C:\\Users\\Flávia\\workspace\\restaurantes\\outback\\logo-outback.jpg"));
			
			
			//temakeria
			Restaurante r2 = new Restaurante();
			r2.setNome("Temakeria e Cia.");
			r2.setSite("http://www.temakeria-ecia.com/");
			r2.setLogo(converterParaByte("C:\\Users\\Flávia\\workspace\\restaurantes\\temakeria\\logo-da-Temakeria-e-Cia.jpg"));
			
			
			//spoleto
			Restaurante r3 = new Restaurante();
			r3.setNome("Spoleto");
			r3.setSite("http://www.spoleto.com.br/");
			r3.setLogo(converterParaByte("C:\\Users\\Flávia\\workspace\\restaurantes\\spoleto\\Spoleto_logo.png"));
			
			//Viena
			Restaurante r4 = new Restaurante();
			r4.setNome("Viena");
			r4.setSite("http://www.viena.com.br/");
			r4.setLogo(converterParaByte("C:\\Users\\Flávia\\workspace\\restaurantes\\viena\\viena.png"));
			
			//Ponto Chic
			Restaurante r5 = new Restaurante();
			r5.setNome("Ponto Chic");
			r5.setSite("http://www.pontochic.com.br/");
			r5.setLogo(converterParaByte("C:\\Users\\Flávia\\workspace\\restaurantes\\ponto chic\\ponto-chic-branding-041.jpg"));
			
			try {
				em.getTransaction().begin();
				em.persist(r1);
				em.persist(r2);
				em.persist(r3);
				em.persist(r4);
				em.persist(r5);
				em.getTransaction().commit();
				bancoCriado = true;
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
			
//			List<Restaurante> lista = dao.listarTodos();
//			System.out.println("QTD::: " + lista.size());
//			for (Restaurante r: lista) {
//				System.out.println(r.getNome());
//			}
		}
	}
	
	private static byte[] converterParaByte(String caminho) throws IOException {
    	FileInputStream fileInputStream=null;
        
        File file = new File(caminho);
        
        byte[] bFile = new byte[(int) file.length()];
        
        //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();
	    return bFile;
	}
}
