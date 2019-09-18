package Procesos;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import ClasesP.MascotasVO;
import Controlador.Coordinador;
import ClasesP.PersonasVO;

public class ProcesosMascota extends ProcesosGenerales{
	
	private Coordinador miCoordinador;
	private MascotasVO miMascota;
	private PersonasVO validar;
	private PersonasVO consulta;
	HashMap<String, PersonasVO>PersonasHash;
	

	public void setPer(HashMap<String, PersonasVO> mapa) {
		
		this.PersonasHash=mapa;
	}
	
	
	@Override
	public String Registrar() {
	

		String retorno="";
		JOptionPane.showMessageDialog(null,"Registro Exitoso");
		
		MascotasHash.put(miMascota.getPropietario().getDocumento(), miMascota);
		 retorno+="Nombre  :"+miMascota.getNombre()+"\n";
		 retorno+="Nombre Dueño: "+miMascota.getPropietario().getNombre()+"\n";
		 retorno+="Documento Dueño: "+miMascota.getPropietario().getDocumento()+"\n";
	     retorno+="Raza : "+miMascota.getRaza()+"\n";
	     retorno+="Sexo : "+miMascota.getSexo()+"\n";
	     
	     	return retorno;

	}

	@Override
	public String Consultar(int a, String b) {
		String retorn="";
		switch (a) {
		case 1:
			
			Iterator<String> iterador=MascotasHash.keySet().iterator();
		
			
			while(iterador.hasNext()){	
			String key=iterador.next();	
			
					retorn+="Nombre Dueño: "+MascotasHash.get(key).getPropietario().getNombre()+"\n";
					retorn+="Documento Dueño: "+MascotasHash.get(key).getPropietario().getDocumento()+"\n";
					retorn+="Nombre: "+MascotasHash.get(key).getNombre()+"\n";
					retorn+="raza : "+MascotasHash.get(key).getRaza()+"\n";
					retorn+="Sexo :"+MascotasHash.get(key).getSexo()+"\n\n";
			}
			
			break;
			
		case 2: 
			
			if(MascotasHash.containsKey(b)) {
				
				retorn+="Nombre Dueño: "+MascotasHash.get(b).getPropietario().getNombre()+"\n";
				retorn+="Documento Dueño: "+MascotasHash.get(b).getPropietario().getDocumento()+"\n";
				retorn+="Nombre: "+MascotasHash.get(b).getNombre()+"\n";
				retorn+="raza : "+MascotasHash.get(b).getRaza()+"\n";
				retorn+="Sexo :"+MascotasHash.get(b).getSexo()+"\n\n";
				
			}

		default:
			break;
		}
		
		return retorn;
				
		}
	
	public PersonasVO validarPersona(String documento) {
		if(PersonasHash.containsKey(documento)) { 
			 validar=PersonasHash.get(documento); 	
		}
		return validar;
	}
	
	public String ConsultaE(String documento) {
	
	
		Iterator<String> iterador=MascotasHash.keySet().iterator();
		String consulta="";
		
		while(iterador.hasNext()) {
			String key=iterador.next();
			
			consulta+="Nombre Dueño: "+MascotasHash.get(key).getPropietario().getNombre()+"\n";
			consulta+="Documento Dueño: "+MascotasHash.get(key).getPropietario().getDocumento()+"\n";
			consulta+="Nombre: "+MascotasHash.get(key).getNombre()+"\n";
			consulta+="raza : "+MascotasHash.get(key).getRaza()+"\n";
			consulta+="Sexo :"+MascotasHash.get(key).getSexo()+"\n\n";	
		}
		
				
	return consulta;
	}
	
	

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public void setMascotaVo(MascotasVO miMascotaVO) {
		this.miMascota=miMascotaVO;
		
	}

	
}
