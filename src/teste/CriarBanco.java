package teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.votenorestaurante.dao.RestauranteDAO;
import br.com.votenorestaurante.modelo.Restaurante;

public class CriarBanco {

	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VoteNoRestaurantePU");
		EntityManager em = emf.createEntityManager();
		
		RestauranteDAO dao = new RestauranteDAO();
		
		//outback
		Restaurante r1 = new Restaurante();
		r1.setNome("Outback");
		r1.setSite("https://www.outback.com.br/");
		r1.setDescricao("O Outback Steakhouse � um restaurante informal, constru�do e decorado em estilo que remete ao interior da Austr�lia. S�o mais de 800 restaurantes nos Estados Unidos, onde foi inaugurado em 1988, e cerca de 120 unidades em outros 22 pa�ses.");
		r1.setLogo(converterParaByte("C:\\restaurantes\\outback\\logo-outback.jpg"));
		
		
		//temakeria
		Restaurante r2 = new Restaurante();
		r2.setNome("Temakeria e Cia.");
		r2.setSite("http://www.temakeria-ecia.com/");
		r2.setDescricao("A primeira Temakeria e Cia foi inaugurada em 2006. Hoje conta com mais de 20 franquias em diversas cidades brasileiras. Conquistou uma clientela fiel ao propor temakis fartamente recheados a pre�os moderados.");
		r2.setLogo(converterParaByte("C:\\restaurantes\\temakeria\\logo-da-Temakeria-e-Cia.jpg"));
		
		
		//spoleto
		Restaurante r3 = new Restaurante();
		r3.setNome("Spoleto");
		r3.setSite("http://www.spoleto.com.br/");
		r3.setDescricao("Spoleto � uma rede de restaurantes brasileira que une o conceito de fast-food com a culin�ria italiana. O nome do restaurante � uma homenagem � localidade de Spoleto, na It�lia.");
		r3.setLogo(converterParaByte("C:\\restaurantes\\spoleto\\Spoleto_logo.png"));
		
		//Viena
		Restaurante r4 = new Restaurante();
		r4.setNome("Viena");
		r4.setSite("http://www.viena.com.br/");
		r4.setDescricao("Tradicional rede de comida r�pida, com sandu�ches, doces e refei��es. No almo�o serve um concorrido buf� com op��es triviais, inclusive pasteizinhos, arroz e feij�o.");
		r4.setLogo(converterParaByte("C:\\restaurantes\\viena\\viena.png"));
		
		//Ponto Chic
		Restaurante r5 = new Restaurante();
		r5.setNome("Ponto Chic");
		r5.setSite("http://www.pontochic.com.br/");
		r5.setDescricao("O Ponto Chic � um dos bares mais tradicionais de S�o Paulo, com mais de 90 anos de exist�ncia e hist�ria. As lojas possuem um card�pio variado com lanches, por��es e pratos tradicionais da cultura paulista. ");
		r5.setLogo(converterParaByte("C:\\restaurantes\\ponto chic\\ponto-chic-branding-041.jpg"));
		
		try {
			em.getTransaction().begin();
			em.persist(r1);
			em.persist(r2);
			em.persist(r3);
			em.persist(r4);
			em.persist(r5);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		List<Restaurante> lista = dao.listarTodos();
		System.out.println("QTD::: " + lista.size());
		for (Restaurante r: lista) {
			System.out.println(r.getNome());
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
