package br.com.salareunioes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.salareunioes.model.Recurso;
import br.com.salareunioes.util.ConnectionFactory;

public class RecursoDAO {

	private Connection con;
	
	//Construtor que já inicia a conexao
	public RecursoDAO() {
		con = new ConnectionFactory().getConnection();
	}
	
	//select
	public ArrayList<Recurso> listar() {
		ArrayList<Recurso> recursos = new ArrayList<Recurso>();		
		
		try (				
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM Recursos");
				ResultSet rs = stmt.executeQuery();
			)	
			{
			while(rs.next()) {
				Recurso recurso = new Recurso();
				recurso.setId(rs.getInt("id_recursos"));
				recurso.setTipo(rs.getString("tipo"));			
				
				recursos.add(recurso);
			}
			con.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return recursos;		
	}
	
	//insert
	public void iserir(Recurso recurso) {		
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Recursos(tipo, id_sala)VALUES(?,?)")) {			
			stmt.setString(1, recurso.getTipo());
			stmt.setInt(2, recurso.getId());
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
