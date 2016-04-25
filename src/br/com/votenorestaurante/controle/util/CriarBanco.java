package br.com.votenorestaurante.controle.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.votenorestaurante.dao.RestauranteDAO;
import br.com.votenorestaurante.modelo.Restaurante;

public class CriarBanco {

	private static boolean bancoCriado = false;
	
	public static void criarBanco() throws IOException {
		if (!bancoCriado) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("VoteNoRestaurantePU");
			EntityManager em = emf.createEntityManager();
			
			RestauranteDAO dao = new RestauranteDAO();
			
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
				dao.iniciaTransacao();
				dao.salvar(r1);
				dao.salvar(r2);
				dao.salvar(r3);
				dao.salvar(r4);
				dao.salvar(r5);
				dao.commitTransacao();
				bancoCriado = true;
			} catch (Exception e) {
				dao.rollbackTransacao();
				e.printStackTrace();
			}
			
			List<Restaurante> lista = dao.listarTodos();
			System.out.println("QTD::: " + lista.size());
			for (Restaurante r: lista) {
				System.out.println(r.getNome());
			}
		}
	}
	
	public static byte[] converterParaByte(String caminho) throws IOException {
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
