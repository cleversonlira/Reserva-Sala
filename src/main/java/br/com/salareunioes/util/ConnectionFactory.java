package br.com.salareunioes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 

	        /* Configura os parâmetros da conexão */
	        String url = "jdbc:sqlserver://192.168.92.105:1433;databaseName=Reunioes";
	        String username = "protheus"; 
	        String password = "12345678";
			
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
