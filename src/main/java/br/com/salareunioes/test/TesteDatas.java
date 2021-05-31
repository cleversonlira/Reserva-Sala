package br.com.salareunioes.test;

import java.time.LocalDate;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

public class TesteDatas {

	public static void main(String[] args) {

//		LocalDate localDate = LocalDate.now();
//		LocalDate ld = LocalDate.now();
//		
//		ReuniaoDAO dao = new ReuniaoDAO();
//		
//		Reuniao reuniao = new Reuniao();
//		
//		
//		reuniao = dao.listar().get(0);
//		
//		System.out.println(reuniao.getDataReuniao());		
//		System.out.println(localDate);
//		
//		if(reuniao.getDataReuniao().equals(localDate)) {
//			System.out.println("é igual!");
//		} else {
//			System.out.println("Não é igual! Implemente o hashcode and equals");
//		}
		
//		localDate = localDate.parse("2019-09-09");
//		System.out.println(localDate);
//		
//		
//		
//		
//		
//		String dataRecebida = "23/11/2015";
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
//		Date data;
//		try {			
//			data = formato.parse(dataRecebida);
//			System.out.println(data);
//			System.out.println(formato.format(data));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String argumentos = "25:00:00:0000000";
		System.out.println(argumentos.replaceAll(":00:0000000", ""));
				
	}

}
