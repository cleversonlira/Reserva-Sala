package br.com.salareunioes.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServerSide {

	
	public static String executa(HttpServletRequest req, HttpServletResponse resp) {
		return "forward:agendamento.jsp";
	}
	
}
