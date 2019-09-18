package Controlador;

import Procesos.ProcesosMascota;
import Procesos.ProcesosPersona;
import Vista.VentanaConsulta;

import Vista.VentanaGestionarMascota;
import Vista.VentanaGestionarPersona;
import Vista.VentanaPrincipal;

public class Relaciones {

	public Relaciones(){
		iniciar();
	}
	
	public void iniciar() {
	
		VentanaPrincipal miVentanaPrincipal;
		VentanaGestionarPersona miVentanaGestionarPersona;
		VentanaGestionarMascota miVentanaGestionarMascota;
		VentanaConsulta miVentanaConsulta;
		VentanaConsulta miVentanaConsultap;
		Coordinador miCoordinador;
		ProcesosPersona miProcesosPersona;
		ProcesosMascota miProcesosMascota;

		
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaGestionarPersona=new VentanaGestionarPersona(miVentanaPrincipal,true);
		miVentanaGestionarMascota=new VentanaGestionarMascota(miVentanaPrincipal, true);
		miVentanaConsulta=new VentanaConsulta(miVentanaGestionarMascota, true);
		miVentanaConsultap=new VentanaConsulta(miVentanaGestionarPersona, true);
		miProcesosPersona=new ProcesosPersona();
		miProcesosMascota=new ProcesosMascota();
		miCoordinador=new Coordinador();
		

		miVentanaPrincipal.setCoordinador(miCoordinador);
		miVentanaGestionarPersona.setCoordinador(miCoordinador);
		miVentanaGestionarMascota.setCoordinador(miCoordinador);
		miVentanaConsulta.setCoordinador(miCoordinador);
		miVentanaConsultap.setCoordinador(miCoordinador);
		miProcesosPersona.setCoordinador(miCoordinador);
		miProcesosMascota.setCoordinador(miCoordinador);
		

		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setVentanaGestionarPersona(miVentanaGestionarPersona);
		miCoordinador.setVentanaGestionarMascota(miVentanaGestionarMascota);
		miCoordinador.setVentanaConsulta(miVentanaConsulta);
		miCoordinador.setVentanaConsultap(miVentanaConsultap);
		miCoordinador.setProcesosPersona(miProcesosPersona);
		miCoordinador.setProcesosMascota(miProcesosMascota);
		
		miVentanaPrincipal.setVisible(true);
		
	}
}
