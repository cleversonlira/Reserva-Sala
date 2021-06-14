package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

public class ListReuniao implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reuniao reuniao = new ReuniaoDAO().selectById(Integer.parseInt(req.getParameter("id")));
		
		req.setAttribute("id", reuniao.getId());
		req.setAttribute("titulo", reuniao.getTitulo());
		req.setAttribute("solicitante", reuniao.getSolicitante());
		req.setAttribute("inicio", reuniao.getInicio());
		req.setAttribute("fim", reuniao.getFim());
		req.setAttribute("data", reuniao.getData());
		req.setAttribute("sala", reuniao.getSala());
		req.setAttribute("observacoes", reuniao.getObservacoes());
		
		return "forward:editar.jsp";
	}

}
