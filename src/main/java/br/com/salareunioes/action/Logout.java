package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.model.User;

public class Logout {

	public static String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("userLogged");
		req.getSession().invalidate();		
		System.out.println("deslogou");
		return "redirect:LoginForm";
	}
	
}
