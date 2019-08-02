package com.distribuida.app02.servicios;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distribuida.app02.dto.TipoDireccionDto;

@RestController
@RequestMapping(path="/tipodireccion")
public class TipoDireccionRest {

	@Value("${gateway.url}") private String GATEWAY;
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@GetMapping
	public List<TipoDireccionDto> listar( ) {
		
		return jdbcTemplate.queryForList( "select * from tipo_direccion" )
			.stream()
			.map( TipoDireccionDto::fromMap )
			.collect( Collectors.toList() );
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Object> listar( @PathVariable("id") Integer id ) {
		
		try {
			Map<String, Object> obj = jdbcTemplate.queryForMap( "select * from tipo_direccion where id=?", id );
		
			return ResponseEntity.ok().body( TipoDireccionDto.fromMap( obj ) );
		}
		catch( Exception ex ) {
			return ResponseEntity.notFound().build();
		}
	}
}
