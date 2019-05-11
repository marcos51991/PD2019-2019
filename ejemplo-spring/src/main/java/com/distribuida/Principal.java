package com.distribuida;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.distribuida.config.ConfiguracionContenedor;
import com.distribuida.servicios.HolaMundo;

public class Principal {

	public static void main(String[] args) {

		ApplicationContext context = 
				new AnnotationConfigApplicationContext( ConfiguracionContenedor.class );
		
		//HolaMundo servicio =  (HolaMundo )context.getBean( "hola" );
		HolaMundo servicio =  context.getBean( "hola", HolaMundo.class );
		HolaMundo servicio2 =  context.getBean( "holaMundoImpl", HolaMundo.class );
	
		System.out.println( servicio.hola("test") );
		System.out.println( servicio2.hola("test") );
		
		Arrays.stream( context.getBeanDefinitionNames() )
			.forEach( System.out::println );
	}

}
