package br.com.salareunioes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.salareunioes.factory.ConnectionFactory;
import br.com.salareunioes.model.Sala;

public class SalaDAO {

	public Map<Integer, String>  listar() {
		Map<Integer, String> salas = new HashMap<Integer, String>();		
		
		try (
				Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM Sala");
				java.sql.ResultSet rs = stmt.executeQuery();
			)	
			{
			while(rs.next()) {
				Sala sala = new Sala();
				sala.setNome(rs.getString("nomeSala"));
				sala.setId(rs.getInt("id_sala"));
				
				salas.put(sala.getId(), sala.getNome());
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return salas;		
	}
	
	
	public void insere(Sala sala) {
		
		try 
		(
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Sala(nomeSala) VALUES(?)");
		) 
		{
			stmt.setString(1, sala.getNome());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
		
}
