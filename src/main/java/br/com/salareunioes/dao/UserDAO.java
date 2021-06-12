package br.com.salareunioes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.salareunioes.factory.ConnectionFactory;
import br.com.salareunioes.model.User;

public class UserDAO {

	public ArrayList<User> listar() {
		ArrayList<User> users = new ArrayList<User>();
		
		try
		(
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users");
			ResultSet rs = stmt.executeQuery();
		)
		{
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("id_user"));
				user.setNome(rs.getString("nome"));
				user.setSobrenome(rs.getString("sobreNome"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return users;
	}
	
	public void inserir(User user) {
		
		try 
		(
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO Users(nome, sobreNome, email, senha)"
			+ " VALUES(?,?,?,?)");		
		) 
		{
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getSobrenome());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getSenha());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public User compare(String email, String password) {
		User user = new User();
		
		try
		(
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM Users WHERE email = ? AND senha = ?");
		)
		{
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id_user"));
				user.setNome(rs.getString("nome"));
				user.setSobrenome(rs.getString("sobrenome"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				rs.close();
				return user;				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return null;
	}
	
}
