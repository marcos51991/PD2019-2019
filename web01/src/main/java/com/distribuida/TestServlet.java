package com.distribuida;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.distribuida.servicios.HolaMundo;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		ServletContext sc = req.getServletContext(); 
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		PrintWriter pw = resp.getWriter();
		
		//---------------------------------------------------
		// iteracion tradicional
		//String[] nombres = context.getBeanDefinitionNames();
	
		//for( int i=0; i<nombres.length;i++ ) {
		//	pw.println( nombres[i] );
		//}
		
		//-- iteracion for-each
		//for( String s:nombres ) {
		//	pw.println( s );
		//}	
		
		//---------------------------------------------------
		//-- Strams: iteracion clase anonima
		//Stream.of(context.getBeanDefinitionNames())
		//	.forEach( new Consumer<String>() {
		//		@Override
		//		public void accept(String s) {
		//			pw.println(s);
		//		}
		//	});		

		//-- Strams: iteracion referencia a metodo
		Stream.of(context.getBeanDefinitionNames())
			.forEach( pw::println );		

		//-- Strams: iteracion lamda
		//Stream.of(context.getBeanDefinitionNames())
		//	.forEach( s->pw.println(s) );		
		
		HolaMundo servicio = context.getBean( HolaMundo.class );
	 
		pw.printf( servicio.hola("test") );
	}

	
}
