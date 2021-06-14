package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.salareunioes.dao.UserDAO;
import br.com.salareunioes.model.User;

public class Login implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User userLogged = new UserDAO().compare(req.getParameter("email"), req.getParameter("senha"));		
		HttpSession session = req.getSession();
		
		if (userLogged != null) {
			session.setAttribute("userLogged", userLogged);
			return "forward:agendamento.jsp";
		} else {
			boolean valid = false;
			req.setAttribute("valid", valid);
			session.invalidate();			
			return "redirect:LoginForm";
		}
	}
	
	
}
