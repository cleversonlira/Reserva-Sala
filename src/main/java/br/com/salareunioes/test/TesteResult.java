package br.com.salareunioes.test;

import br.com.salareunioes.dao.RecursoDAO;
import br.com.salareunioes.model.Recurso;

public class TesteResult {

	public static void main(String[] args) {

		
		RecursoDAO dao = new RecursoDAO();
		  
		for(Recurso r : dao.listar()) { 
			System.out.println(r.toString()); 
		}
		 

		/*
		 * SalaDAO salaDAO = new SalaDAO();
		 * 
		 * int i=0; for(Sala sala : salaDAO.listar()) {
		 * System.out.println(sala.toString()); }
		 */

	}

}
