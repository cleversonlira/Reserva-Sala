package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout {

	public static String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();		
		System.out.println("deslogou");
		return "redirect:login.jsp";
	}
	
}