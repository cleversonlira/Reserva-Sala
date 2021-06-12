package br.com.salareunioes.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.salareunioes.action.AgendarReuniao;
import br.com.salareunioes.action.ApplyEditing;
import br.com.salareunioes.action.DeletarReuniao;
import br.com.salareunioes.action.ListReuniao;
import br.com.salareunioes.action.Login;
import br.com.salareunioes.action.Logout;
import br.com.salareunioes.action.RedirectServerSide;
import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.dao.UserDAO;
import br.com.salareunioes.model.Reuniao;
import br.com.salareunioes.model.User;

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
		case "logout":
			action = Logout.executa(req, resp);
			break;	
		case "agendar":
			action = AgendarReuniao.executa(req, resp);
			break;
		case "agendamento":
			action = RedirectServerSide.executa(req, resp);
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
			
			System.out.println("caiu no if de redirecionamento " + action);			
			req.getRequestDispatcher("WEB-INF/view/" + typeAction[1]).forward(req, resp);
			
		} else if(typeAction[0].equals("redirect")) {
			
			System.out.println("Caiu no if de redirect " + action);
			//req.getRequestDispatcher(typeAction[1]).forward(req, resp);
			resp.sendRedirect(typeAction[1]);
			
		}
		
	}

	//Crio uma reuniao, seto o id nesta reuniao, e chamo o delete() da ReuniaoDAO para deletar esta reuniao.
/*	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reuniao reuniao = new Reuniao();
		boolean deleted;

		reuniao.setId(Integer.parseInt(req.getParameter("id")));
		
		if (new ReuniaoDAO().delete(reuniao)) {
			deleted = true;
		} else {
			deleted = false;
		}
		
		req.setAttribute("deleted", deleted);
		req.getRequestDispatcher("agendamento.jsp").forward(req, resp);
		System.out.println(deleted);
	}

	//Pega os dados da requisicao de Agendamento, cria uma nova reuniao com os dados que vieram do form e insere no banco.
	private void agendarReuniao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Resolve o problema de caracteres especiais
		req.setCharacterEncoding("UTF-8");
		
		Reuniao reuniao = new Reuniao();
		boolean created;

		reuniao.setData(LocalDate.now().parse(req.getParameter("data")));
		reuniao.setInicio(req.getParameter("inicio"));
		reuniao.setFim(req.getParameter("fim"));
		reuniao.setOrganizador(req.getParameter("organizador"));
		reuniao.setSala(Integer.parseInt(req.getParameter("sala")));
		reuniao.setSolicitante(req.getParameter("solicitante"));
		reuniao.setTitulo(req.getParameter("titulo"));
		reuniao.setObservacoes(req.getParameter("observacoes"));
		
		if (new ReuniaoDAO().insert(reuniao)) {
			created = true;
		} else {
			created = false;
		}
		
		req.setAttribute("created", created);
		req.getRequestDispatcher("agendamento.jsp").forward(req, resp);
		System.out.println(created);
		
	}

	//Metodo responsavel por buscar uma reuniao especifica ao ser acionado o Editar. 
	//Busca a reuniao no banco, cria uma nova Reuniao, e passa os dados dessa reuniao para a requisicao via req.setAttribute
	//Depois despacha a requisicao para a pagina de edicao (edicao.jsp) 
	private void listReuniao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reuniao reuniao = new ReuniaoDAO().selectById(Integer.parseInt(req.getParameter("id")));
		
		req.setAttribute("id", reuniao.getId());
		req.setAttribute("titulo", reuniao.getTitulo());
		req.setAttribute("solicitante", reuniao.getSolicitante());
		req.setAttribute("inicio", reuniao.getInicio());
		req.setAttribute("fim", reuniao.getFim());
		req.setAttribute("data", reuniao.getData());
		req.setAttribute("sala", reuniao.getSala());
		req.setAttribute("observacoes", reuniao.getObservacoes());
		
		req.getRequestDispatcher("editar.jsp").forward(req, resp);
	}
	
	// Aplica a edicao da Reuniao no banco usando o ID, após criar uma Reuniao com
	// os atributos atualizados.
	private void applyEditing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Reuniao reuniao = new Reuniao();
		boolean updated;

		reuniao.setId(Integer.parseInt(req.getParameter("id")));
		reuniao.setData(LocalDate.now().parse(req.getParameter("data")));
		reuniao.setInicio(req.getParameter("inicio"));
		reuniao.setFim(req.getParameter("fim"));
		reuniao.setOrganizador(req.getParameter("organizador"));
		reuniao.setSala(Integer.parseInt(req.getParameter("sala")));
		reuniao.setSolicitante(req.getParameter("solicitante"));
		reuniao.setTitulo(req.getParameter("titulo"));
		reuniao.setObservacoes(req.getParameter("observacoes"));		

		if (new ReuniaoDAO().update(reuniao)) {
			updated = true;
		} else {
			updated = false;
		}
		
		req.setAttribute("updated", updated);
		req.getRequestDispatcher("agendamento.jsp").forward(req, resp);
		System.out.println(updated);
	}
*/
}
