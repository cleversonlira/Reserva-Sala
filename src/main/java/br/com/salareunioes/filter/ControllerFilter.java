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

import br.com.salareunioes.action.Action;
import br.com.salareunioes.action.Agendar;
import br.com.salareunioes.action.ApplyEditing;
import br.com.salareunioes.action.Delete;
import br.com.salareunioes.action.ListReuniao;
import br.com.salareunioes.action.Login;
import br.com.salareunioes.action.LoginForm;
import br.com.salareunioes.action.Logout;

/**
 * Servlet Filter implementation class AutenticFilter
 */
//@WebFilter("/reserva")
public class ControllerFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String nameAction = request.getParameter("action");
		String className = "br.com.salareunioes.action." + nameAction;
		
		System.out.println("----------ControllerFilter---------- Acão: " + className);
		
		
		String action = "";
		try {
			System.out.println("\n1 - Entrou no try");
			Class actionClass = Class.forName(className);
			Action actionInterface = (Action) actionClass.newInstance();
			action = actionInterface.executa(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		String[] typeAction = action.split(":");
		System.out.println("2 - passou pelo split = " + typeAction[0] + " " + typeAction[1]);
		if(typeAction[1].equals("loginMessageError")) {//erro de login			
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			System.out.println("3 - if Error login");
		} else if(typeAction[0].equals("forward")) {			
			System.out.println("3 - if forward " + typeAction[1]);
			req.getRequestDispatcher("WEB-INF/view/" + typeAction[1]).forward(req, resp);
		} else if(typeAction[0].equals("redirect")) {			
			System.out.println("3 - if redirect " + typeAction[1]);
			resp.sendRedirect("reserva?action=" + typeAction[1]);
			
		}
		
	}

}
