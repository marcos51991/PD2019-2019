package com.distribuida.app01.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class PersonaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Integer id;
    private String cedula;
    private String direccion;
    private Integer tipoDireccion;
    private String nombre;
    
    // para obtener el nombre del tipo direccion
    private String tipoDireccionNombre;
    
    public static PersonaDto fromMap( Map<String, Object> obj ) {
		PersonaDto p = new PersonaDto( );
		
		p.setId( (Integer )obj.get("id") );
		p.setCedula( (String )obj.get("cedula"));
		p.setDireccion( (String )obj.get("direccion"));
		p.setTipoDireccion( (Integer )obj.get("tipo_direccion") );
		p.setNombre( (String )obj.get("nombre") );
		
		return p;
	}

}
