package br.com.salareunioes.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.salareunioes.dao.ReuniaoDAO;
import br.com.salareunioes.model.Reuniao;

/**
 * Servlet implementation class ReunioesService
 */
@WebServlet("/reunioes")
public class ReunioesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Reuniao> reunioes = new ReuniaoDAO().list();
		
		String type = request.getParameter("type");
		
		
		XStream xstream = new XStream();
		xstream.alias("reuniao", Reuniao.class);
		String xml = xstream.toXML(reunioes);		
		
		Gson gson = new Gson();
		String json = gson.toJson(reunioes);
		
		
		if (type.equals("xml")) {
			response.setContentType("aplication/xml");
			response.getWriter().print(xml);
		} else if (type.equals("json")) {
			response.setContentType("aplication/json");
			response.getWriter().print(json);
		}
	}

}
