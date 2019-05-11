package com.distribuida.servicios;

import org.springframework.stereotype.Component;

@Component
public class HolaMundoImpl implements HolaMundo {

	@Override
	public String hola(String nombre) {
		
		return String.format( "hola %s", nombre );
	}

}
