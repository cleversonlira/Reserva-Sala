package br.com.salareunioes.filter;

import java.io.IOException;
import java.util.Locale;

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

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		
		long antes = System.currentTimeMillis();		
		
		String action = request.getParameter("action");
		
		//executa acao
		chain.doFilter(request, response);
		
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execu��o da a��o " + action + " -> " + (depois - antes));
	}
}
