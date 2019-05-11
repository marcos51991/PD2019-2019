package ejemplo.cdi;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import ejemplo.cdi.servicios.HolaMundo;

public class PrincipalCdi {

	public static void main( String args[] ) {
		
		SeContainerInitializer init = SeContainerInitializer.newInstance();
		
		SeContainer container = init.initialize();
		
		Instance<HolaMundo> obj = container.select( HolaMundo.class );
		
		HolaMundo servicio = obj.get();
		
		String ret = servicio.hola( "test" );
		
		System.out.println( servicio.getClass().getName() );
		System.out.println( ret );
		
	}
}
