package br.com.salareunioes.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

/**
 * Servlet implementation class AgendamentoServlet
 */
@WebServlet(urlPatterns = { "/agendamento", "/edit", "/apply-editing", "/delete" })
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Metodo service sobrescrito. Recebo todos os tipos de requisicoes (POST, GET, DELET, PUT...) 
	//e conforme a action do form, eu trato a requisicao
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//pega o action do form
		String action = req.getServletPath();
		//verifica a acao a ser tomada e chama o metodo.
		if (action.equals("/agendamento")) {
			agendarReuniao(req, resp);
			resp.sendRedirect("agendamento.jsp");
		} else if (action.equals("/edit")) {
			listReuniao(req, resp);
		} else if (action.equals("/apply-editing")) {
			applyEditing(req, resp);
			resp.sendRedirect("agendamento.jsp");
		} else if (action.equals("/delete")) {
			delete(req, resp);
			resp.sendRedirect("agendamento.jsp");
		}
	}

	//Crio uma reuniao, seto o id nesta reuniao, e chamo o delete() da ReuniaoDAO para deletar esta reuniao.
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		Reuniao reuniao = new Reuniao();

		reuniao.setId(Integer.parseInt(req.getParameter("id")));
		
		new ReuniaoDAO().delete(reuniao);
	}

	//Pega os dados da requisicao de Agendamento, cria uma nova reuniao com os dados que vieram do form e insere no banco.
	private void agendarReuniao(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		//Resolve o problema de caracteres especiais
		req.setCharacterEncoding("UTF-8");
		
		Reuniao reuniao = new Reuniao();

		reuniao.setData(LocalDate.now().parse(req.getParameter("data")));
		reuniao.setInicio(req.getParameter("inicio"));
		reuniao.setFim(req.getParameter("fim"));
		reuniao.setOrganizador(req.getParameter("organizador"));
		reuniao.setSala(Integer.parseInt(req.getParameter("sala")));
		reuniao.setSolicitante(req.getParameter("solicitante"));
		reuniao.setTitulo(req.getParameter("titulo"));
		reuniao.setObservacoes(req.getParameter("observacoes"));
		
		new ReuniaoDAO().insert(reuniao);
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
		
		RequestDispatcher rd = req.getRequestDispatcher("editar.jsp");
		rd.forward(req, resp);
	}
	
	//Aplica a edicao da Reuniao no banco usando o ID, após criar uma Reuniao com os atributos atualizados.
	private void applyEditing(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		Reuniao reuniao = new Reuniao();

		reuniao.setId(Integer.parseInt(req.getParameter("id")));
		reuniao.setData(LocalDate.now().parse(req.getParameter("data")));
		reuniao.setInicio(req.getParameter("inicio"));
		reuniao.setFim(req.getParameter("fim"));
		reuniao.setOrganizador(req.getParameter("organizador"));
		reuniao.setSala(Integer.parseInt(req.getParameter("sala")));
		reuniao.setSolicitante(req.getParameter("solicitante"));
		reuniao.setTitulo(req.getParameter("titulo"));
		reuniao.setObservacoes(req.getParameter("observacoes"));
		
		new ReuniaoDAO().update(reuniao);
		System.out.println("E não é que atualizou? ^^");
	}
}
