package br.com.salareunioes.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

public class Delete implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Reuniao reuniao = new Reuniao();
		boolean deleted;

		reuniao.setId(Integer.parseInt(req.getParameter("id")));
		
		if (new ReuniaoDAO().delete(reuniao)) {
			deleted = true;
		} else {
			deleted = false;
		}
		req.setAttribute("deleted", deleted);
		
		return "forward:agendamento.jsp";
	}

}
