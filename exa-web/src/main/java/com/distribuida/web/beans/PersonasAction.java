package com.distribuida.web.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.jsf.FacesContextUtils;

import com.distribuida.web.dto.PersonaDto;

import lombok.Getter;

@SessionScoped @ManagedBean(value="personasAction")
public class PersonasAction {
	
	private String GATEWAY;
	
	private RestTemplate restTemplate;
	
	@Getter private List<PersonaDto> personas;
	
	@PostConstruct
	protected void inicializar( ) {
		ApplicationContext springCtx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		
		Environment env = springCtx.getBean( Environment.class );
		
		GATEWAY = env.getProperty( "gateway.url" );
		
		restTemplate = new RestTemplate( );
		
		personas = new ArrayList<>();
	}
	
	public String listar( ) {
		
		PersonaDto[] datos = restTemplate.getForObject( GATEWAY + "/EXA-APP01/personas", PersonaDto[].class );
		
		personas = Stream.of( datos )
			.collect( Collectors.toList() );
		
		
		return "";
	}

}
