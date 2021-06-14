package br.com.salareunioes.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.action.AgendarReuniao;
import br.com.salareunioes.action.ApplyEditing;
import br.com.salareunioes.action.DeletarReuniao;
import br.com.salareunioes.action.ListReuniao;
import br.com.salareunioes.action.Login;
import br.com.salareunioes.action.LoginForm;
import br.com.salareunioes.action.Logout;

/**
 * Servlet implementation class AgendamentoServlet
 */
//@WebServlet(urlPatterns = { "/login", "/logout", "/agendar", "/agendamento", "/edit", "/apply-editing", "/delete", "/redirect"}) Acoes
@WebServlet(urlPatterns = { "/reserva"})
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Metodo service sobrescrito. Recebo todos os tipos de requisicoes (POST, GET, DELET, PUT...) 
	//e conforme a action do form, eu trato a requisicao
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//pega o action do form
		//String action = req.getServletPath(); Acoes
		String action = req.getParameter("action");
		System.out.println("Action: " + action);
		
		switch (action) {
		case "login":
			action = Login.executa(req, resp);
			break;
		case "LoginForm":
			action = LoginForm.executa(req, resp);
			break;
		case "logout":
			action = Logout.executa(req, resp);
			break;	
		case "agendar":
			action = AgendarReuniao.executa(req, resp);
			break;
		case "agendamento":
			action = "forward:agendamento.jsp";
			break;
		case "edit":
			action = ListReuniao.executa(req, resp);
			break;
		case "apply-editing":
			action = ApplyEditing.executa(req, resp);
			break;
		case "delete":
			action = DeletarReuniao.executa(req, resp);
			break;
		default:
			break;
		}
		
		String[] typeAction = action.split(":");
		
		if(typeAction[1].equals("loginMessageError")) {//erro de login			
			System.out.println("Caiu no if de loginError" + action);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		} else if(typeAction[0].equals("forward")) {			
			System.out.println("caiu no if de forward " + action);			
			req.getRequestDispatcher("WEB-INF/view/" + typeAction[1]).forward(req, resp);
			
		} else if(typeAction[0].equals("redirect")) {			
			System.out.println("Caiu no if de redirect " + action);
			resp.sendRedirect("reserva?action=" + typeAction[1]);
			
		}
		
	}
}
