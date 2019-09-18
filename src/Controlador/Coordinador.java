package Controlador;

import java.util.HashMap;

import ClasesP.MascotasVO;
import ClasesP.PersonasVO;
import Procesos.ProcesosMascota;
import Procesos.ProcesosPersona;
import Procesos.Utilidades;
import Vista.VentanaConsulta;
import Vista.VentanaGestionarMascota;
import Vista.VentanaGestionarPersona;
import Vista.VentanaPrincipal;

public class Coordinador {


	
	VentanaPrincipal miVentanaPrincipal;
	VentanaGestionarPersona miVentanaGestionarPersona;
	VentanaGestionarMascota miVentanaGestionarMascota;
	VentanaConsulta miVentanaConsulta;
	VentanaConsulta miVentanaConsultap;
	ProcesosPersona miProcesosPersona;
	ProcesosMascota miProcesosMascota;
	
	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal=miVentanaPrincipal;
	}

	public void setVentanaGestionarPersona(VentanaGestionarPersona miVentanaGestionarPersona) {
		this.miVentanaGestionarPersona=miVentanaGestionarPersona;
	}

	public void setVentanaGestionarMascota(VentanaGestionarMascota miVentanaGestionarMascota) {
		this.miVentanaGestionarMascota=miVentanaGestionarMascota;
	}

	public void setProcesosPersona(ProcesosPersona miProcesosPersona) {
		this.miProcesosPersona=miProcesosPersona;
	}

	public void setProcesosMascota(ProcesosMascota miProcesosMascota) {
		this.miProcesosMascota=miProcesosMascota;
	}
	
	public void setVentanaConsulta(VentanaConsulta miVentanaConsulta) {
		this.miVentanaConsulta=miVentanaConsulta;
	}
	public void setVentanaConsultap(VentanaConsulta miVentanaConsultap) {
		
		this.miVentanaConsultap=miVentanaConsultap;
	}

	 public PersonasVO setDocumento(String Documento) {
		return miProcesosMascota.validarPersona(Documento);
		
	 }
	 public String setDoc(String Documento) {
		 
		 return miProcesosMascota.ConsultaE(Documento);
	 }
	 
	 
	public void mostrarVentanaGestionPersona() {
		miVentanaGestionarPersona.setVisible(true);
	}

	public void mostrarVentana(int ventana) {
		switch (ventana) {
		case Utilidades.GUI_PERSONA:
				miVentanaGestionarPersona.setVisible(true);
			break;
			
		case Utilidades.GUI_MASCOTA: miVentanaGestionarMascota.setVisible(true);
			break;
			
		case Utilidades.GUI_CONSULTA: miVentanaConsulta.setVisible(true);
		break;
		
		case Utilidades.GUI_CONSULTAP: miVentanaConsultap.setVisible(true);
		break;
		}
	}

	public String registrarPersona(PersonasVO miPersonaVO) {
		miProcesosPersona.setPersonaVo(miPersonaVO);
		return miProcesosPersona.Registrar();
	}

	public String consultarPersona(int i,String a) { 
		return miProcesosPersona.Consultar(i,a);
	}
	
	public String registrarMascota(MascotasVO miMascotaVO) {
		miProcesosMascota.setMascotaVo(miMascotaVO);
		return miProcesosMascota.Registrar();
		
	}
	public String consultarMascota(int i, String a) { 
		
		return miProcesosMascota.Consultar(i,a);
	}
	public void getPer(HashMap<String,PersonasVO> mapa) {
		miProcesosMascota.setPer(mapa);
	}

}
