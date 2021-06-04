package br.com.salareunioes.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

public class TesteResult {

	public static void main(String[] args) {

		
		ReuniaoDAO dao = new ReuniaoDAO();
		  
//		for(Reuniao r : dao.list()) { 
//			System.out.println(r.toString()); 
//		}
		 
		//dao.list().forEach(System.out::println);
				
		Map<Boolean, List<Reuniao>> reunioes = dao.list().stream().collect(Collectors.groupingBy(rd -> rd.getData().isAfter(LocalDate.now())));
				
		System.out.println(reunioes);
		
				//.collect(Collectors.toList())); Lista de Boolean
				
				
		/*
		 * SalaDAO salaDAO = new SalaDAO();
		 * 
		 * int i=0; for(Sala sala : salaDAO.listar()) {
		 * System.out.println(sala.toString()); }
		 */

	}

}
