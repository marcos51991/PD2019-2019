package com.distribuida.app01.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.distribuida.app01.dto.PersonaDto;
import com.distribuida.app01.dto.TipoDireccionDto;

@RestController
@RequestMapping(path="/personas")
public class PersonasRest {

	@Value("${gateway.url}") private String GATEWAY;
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	private RestTemplate restTemplate;
	
	@PostConstruct
	protected void inicializar( ) {
		restTemplate = new RestTemplate( );
	}
	
	@GetMapping
	public List<PersonaDto> listar( ) {
		
		// obtener los tipos de direcciones
		Map<Integer, TipoDireccionDto> cache = new HashMap<>( );

		Stream.of( restTemplate.getForObject( GATEWAY + "/EXA-APP02/tipodireccion", TipoDireccionDto[].class ) )
			.forEach( s->{
				cache.put( s.getId(), s );
			});
		
		return jdbcTemplate.queryForList( "select * from persona" )
			.stream()
			.map( PersonaDto::fromMap )
			.map( s->{
				s.setTipoDireccionNombre( cache.get(s.getId() ).getDescripcion() );
				
				return s;
			})
			.collect( Collectors.toList() );
		
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Object> listar( @PathVariable("id") Integer id ) {
		
		try {
			Map<String, Object> obj = jdbcTemplate.queryForMap( "select * from persona where id=?", id );
		
			return ResponseEntity.ok().body( PersonaDto.fromMap( obj ) );
		}
		catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}
	}
}
