package br.com.salareunioes.action;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.model.User;

public class Logout implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("userLogged");
		req.getSession().invalidate();
		return "redirect:LoginForm";
	}
	
}
