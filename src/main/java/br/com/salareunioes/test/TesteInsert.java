package br.com.salareunioes.test;

import java.time.LocalDate;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.dao.UserDAO;
import br.com.salareunioes.model.Reuniao;
import br.com.salareunioes.model.User;

public class TesteInsert {

	public static void main(String[] args) {
		
		
		/* Inserindo novo Recurso
		 * Recurso recurso = new Recurso(); recurso.setId(3);
		 * recurso.setTipo("Logitech");
		 * 
		 * new RecursoDAO().iserir(recurso);
		 */
		/*
		 * for(int i=2;i < 9; i++) { Sala sala = new Sala(); sala.setNome("RJ"+i+"");
		 * new SalaDAO().insere(sala); }
		 */
		UserDAO userDAO = new UserDAO();
		User user = new User();
		/*
		 * user.setNome("Alex"); user.setSobrenome("Brito");
		 * user.setEmail("alex.brito@gmail.com"); user.setSenha("12345678");
		 * userDAO.inserir(user );
		 */
		/*
		 * ArrayList<User> users = userDAO.listar(); for(User u : users) {
		 * System.out.println(u.toString()); }
		 */
		Reuniao reuniao = new Reuniao();
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		
//		reuniao.setHoraInicio("13:00");
//		reuniao.setHoraFim("16:00");
		reuniao.setSolicitante("Kaique Pujol");
		reuniao.setData(LocalDate.parse("2021-05-07"));
		reuniao.setSala(5);
		reuniao.setTitulo("Teste LocalDate");
		reuniao.setOrganizador("stefany");
		
		//reuniaoDAO.insere(reuniao);
		System.out.println("inseriu");
		
		for(Reuniao r : reuniaoDAO.list()) {
			System.out.println(r.toString());
		}
	
	}
	
}