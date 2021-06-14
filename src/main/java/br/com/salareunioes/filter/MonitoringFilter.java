package br.com.salareunioes.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Monitoring
 */
//@WebFilter("/reserva")
public class MonitoringFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("----------MonitoringFilter----------");
		long antes = System.currentTimeMillis();		
		
		String action = request.getParameter("action");
		
		//executa acao
		chain.doFilter(request, response);
		
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução da ação " + action + " -> " + (depois - antes));
	}
}
