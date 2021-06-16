package br.com.salareunioes.action;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

public class ApplyEditing implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
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
		
		return "forward:agendamento.jsp";		
	}

		
	
}
