package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Action {	
	
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {				
		return "forward:login.jsp";		
		//return "redirect:login.jsp";
	}
}