package ejemplo.cdi.servicios;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value="hola")
@ApplicationScoped
public class HolaMundoImpl implements HolaMundo {

	@Override
	public String hola(String nombre) {
		
		return String.format( "hola %s", nombre );
	}

}
