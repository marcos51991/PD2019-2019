package com.distribuida.app02.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class TipoDireccionDto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private String descripcion;
    
    public static TipoDireccionDto fromMap( Map<String, Object> obj ) {
    	TipoDireccionDto p = new TipoDireccionDto( );
    	
    	p.setId( (Integer )obj.get("id") );
    	p.setDescripcion( (String )obj.get("descripcion") );
		
		return p;
	}
}
