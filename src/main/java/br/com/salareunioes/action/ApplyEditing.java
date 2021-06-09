package br.com.salareunioes.action;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

public class ApplyEditing {

	public static String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		//req.getRequestDispatcher("agendamento.jsp").forward(req, resp);
		System.out.println(updated);
		
		return "forward:agendamento.jsp";		
	}

		
	
}
