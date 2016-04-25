package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.votenorestaurante.dao.RestauranteDAO;
import br.com.votenorestaurante.modelo.Restaurante;

public class Teste {

	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VoteNoRestaurantePU");
//		EntityManager em = emf.createEntityManager();
//		
//		Restaurante r = em.find(Restaurante.class, 1);
//		
//		System.out.println(r);
		RestauranteDAO dao = new RestauranteDAO();
		List<Restaurante> lista = dao.listarTodos();
		System.out.println("QTD::: " + lista.size());
		for (Restaurante r: lista) {
			System.out.println(r.getNome());
		}
		
	}
	
//	Connection conn;
//	
//	  public static void main(String[] args) throws SQLException {
//		    Teste app = new Teste();
//		 
//		    app.connectionToDerby();
//		    app.normalDbUsage();
//		  }
//		 
//		  public void connectionToDerby() throws SQLException {
//		    // -------------------------------------------
//		    // URL format is
//		    // jdbc:derby:<local directory to save data>
//		    // -------------------------------------------
//		    String dbUrl = "jdbc:derby:demo;create=true";
//		    conn = DriverManager.getConnection(dbUrl);
//		  }
//		 
//		  public void normalDbUsage() throws SQLException {
//		    Statement stmt = conn.createStatement();
//		 
//		    // drop table
//		    // stmt.executeUpdate("Drop Table users");
//		 
//		    // create table
//		    stmt.executeUpdate("Create table users (id int primary key, name varchar(30))");
//		 
//		    // insert 2 rows
//		    stmt.executeUpdate("insert into users values (1,'tom')");
//		    stmt.executeUpdate("insert into users values (2,'peter')");
//		 
//		    // query
//		    ResultSet rs = stmt.executeQuery("SELECT * FROM users");
//		 
//		    // print out query result
//		    while (rs.next()) { 
//		      System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
//		    }
//		  }
	
}
