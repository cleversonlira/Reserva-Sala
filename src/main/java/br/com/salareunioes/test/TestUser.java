package br.com.salareunioes.test;

import br.com.salareunioes.dao.UserDAO;

public class TestUser {

	public static void main(String[] args) {
		
		UserDAO uDao = new UserDAO();
		//boolean bool = new UserDAO().compara("clira@siqueiracastro.com.br", "72745472");
		
		System.out.println(new UserDAO().compare("alex.brito@gmail.com", "12345678"));
		
		
	}

}
