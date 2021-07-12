package br.com.salareunioes.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); 

	        /* Configura os parâmetros da conexão */
	        String url = "jdbc:mysql://127.0.0.1:3306/Reserva";
	        String username = "root"; 
	        String password = "";
			
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {            
	        System.out.println("O driver expecificado nao foi encontrado.");
	        return null;
	        
	    } catch (SQLException e) {
	        System.out.println("Nao foi possivel conectar ao banco de dados.");
	        return null;
	    }
	}
		
}
