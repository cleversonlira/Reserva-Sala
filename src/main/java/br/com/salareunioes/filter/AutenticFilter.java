package br.com.salareunioes.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutenticFilter
 */
//@WebFilter("/reserva")
public class AutenticFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String action = req.getParameter("action");
		
		HttpSession session = req.getSession();
		
		boolean protectedAction = !(req.getParameter("action").equals("LoginForm")
				|| req.getParameter("action").equals("Login") || req.getParameter("action").equals("Logout"));	
		
		boolean userLogged = session.getAttribute("userLogged") != null;
		
		System.out.println("----------AutenticFilter----------userLogged: " + userLogged);
		
		if ((!userLogged) && protectedAction) {
			System.out.println("entrou aqui");
			resp.sendRedirect("reserva?action=LoginForm");
			return;
		} 
		
		chain.doFilter(request, response);	
	}

}
