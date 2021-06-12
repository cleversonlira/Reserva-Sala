package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.salareunioes.dao.UserDAO;
import br.com.salareunioes.model.User;

public class Login {

	public static String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession sessao = req.getSession();
		User userLogged = new UserDAO().compare(req.getParameter("email"), req.getParameter("senha"));		
		
		if (!(userLogged == null)) {
			sessao.setAttribute("userLogged", userLogged);
			System.out.println("logou");
			return "forward:agendamento.jsp";
		} else {
			sessao.invalidate();
			boolean valid = false;
			req.setAttribute("valid", valid);
			return "forward:loginMessageError";
		}
	}
	
	
}
