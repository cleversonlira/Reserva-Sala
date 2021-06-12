package br.com.salareunioes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import br.com.salareunioes.factory.ConnectionFactory;
import br.com.salareunioes.model.Reuniao;

public class ReuniaoDAO {

	// Metodo que busca todas as reunioes no banco e retorna uma lista de reunioes
	public ArrayList<Reuniao> list() {
		ArrayList<Reuniao> reunioes = new ArrayList<Reuniao>();

		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM Reuniao WHERE excluido IS NULL");
				ResultSet rs = stmt.executeQuery();) {
			
			while (rs.next()) {
				Reuniao reuniao = new Reuniao();
				reuniao.setId(rs.getInt("id_reuniao"));
				reuniao.setInicio(rs.getString("horaInicio").replaceAll(":00.0000000", ""));
				reuniao.setFim(rs.getString("horaFim").replaceAll(":00.0000000", ""));
				reuniao.setTitulo(rs.getString("titulo"));
				reuniao.setSala(rs.getInt("id_sala"));
				reuniao.setSolicitante(rs.getString("solicitante"));
				reuniao.setObservacoes(rs.getString("observacoes"));

				LocalDate data = LocalDate.parse(rs.getString("dataReuniao"));

				if (!data.isBefore(LocalDate.now())) {
					reuniao.setData(data);
					reunioes.add(reuniao);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reunioes;
	}

	//Metodo sem retorno, que insere uma Reuniao no banco.
	public boolean insert(Reuniao reuniao) {
		boolean insert = false;
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement("INSERT INTO "
						+ "Reuniao(titulo, solicitante, dataReuniao, horaInicio, horaFim, organizador, id_sala, observacoes)"
						+ "VALUES(?,?,?,?,?,?,?,?)");
		) {
			stmt.setString(1, reuniao.getTitulo());
			stmt.setString(2, reuniao.getSolicitante());
			stmt.setDate(3, Date.valueOf(reuniao.getData()));
			stmt.setString(4, reuniao.getInicio());
			stmt.setString(5, reuniao.getFim());
			stmt.setString(6, reuniao.getOrganizador());
			stmt.setInt(7, reuniao.getSala());
			stmt.setString(8, reuniao.getObservacoes());
			
			stmt.execute();
			insert = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insert;
	}

	//Falta implementar
	public boolean delete(Reuniao reuniao) {
		reuniao.setExcluido(true);
		boolean delete = false;
		try 
		(Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con
						.prepareStatement("UPDATE Reuniao " + "SET excluido=? " + "WHERE id_reuniao = ?");
		) 
		{
			stmt.setBoolean(1, reuniao.isExcluido());
			stmt.setInt(2, reuniao.getId());
			stmt.executeUpdate();
			
			delete = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delete;
	}

	//Metodo de edicao de Reuniao, recebeo parametro Reuniao e atualiza a reuniao que contém o mesmo ID lá no banco.
	public boolean update(Reuniao reuniao) {
		boolean updated = false;
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement("UPDATE Reuniao "
						+ "SET titulo = ?, solicitante = ?, dataReuniao = ?, horaInicio = ?, horaFim = ?, "
						+ "organizador = ?, id_sala = ?, observacoes = ? "
						+ "WHERE id_reuniao = ?");
			) 
		{
			stmt.setString(1, reuniao.getTitulo());
			stmt.setString(2, reuniao.getSolicitante());
			stmt.setDate(3, Date.valueOf(reuniao.getData()));
			stmt.setString(4, reuniao.getInicio());
			stmt.setString(5, reuniao.getFim());
			stmt.setString(6, reuniao.getOrganizador());
			stmt.setInt(7, reuniao.getSala());
			stmt.setString(8, reuniao.getObservacoes());
			stmt.setInt(9, reuniao.getId());
			
			stmt.executeUpdate();
			
			updated = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	//Metodo que seleciona apenas uma reuniao pelo ID, para que possa ser editada. E retorna a reuniao encontrada.
	public Reuniao selectById(Integer id) {
		Reuniao reuniao = new Reuniao();
		try (Connection con = new ConnectionFactory().getConnection();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM Reuniao WHERE id_reuniao = ?");				
			)
		{			
			stmt.setInt(1, id);
			 ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				reuniao.setId(rs.getInt("id_reuniao"));
				reuniao.setTitulo(rs.getString("titulo"));
				reuniao.setSolicitante(rs.getString("solicitante"));
				reuniao.setData(LocalDate.parse(rs.getString("dataReuniao")));
				reuniao.setInicio(rs.getString("horaInicio").replaceAll(":00.0000000", ""));
				reuniao.setFim(rs.getString("horaFim").replaceAll(":00.0000000", ""));
				reuniao.setSala(rs.getInt("id_sala"));
				reuniao.setObservacoes(rs.getString("observacoes"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reuniao;
	}
}
