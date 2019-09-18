package Procesos;

import java.util.Iterator;

import javax.swing.JOptionPane;

import ClasesP.PersonasVO;
import Controlador.Coordinador;

public class ProcesosPersona extends ProcesosGenerales{

	private Coordinador miCoordinador;
	private PersonasVO miPersona;

	
	@Override
	public String Registrar() {
		
		String retorno="";
		
		 
	     if(PersonasHash.containsKey(miPersona.getDocumento())) {
	    	
	    	 JOptionPane.showMessageDialog(null, "El documento ya existe");
	     }     
		    else {  
		    	
		     PersonasHash.put(miPersona.getDocumento(), miPersona); 
		     miCoordinador.getPer(PersonasHash);
			 JOptionPane.showMessageDialog(null, "Registro Exitoso!");
		    
				  retorno+="Documento: "+miPersona.getDocumento()+"\n";
				  retorno+="Nombre: "+miPersona.getNombre()+"\n";
				  retorno+="telefono: "+miPersona.getTelefono()+"\n";
				 
		    }
		return retorno;
	}

	@Override
	public String Consultar(int a,String b) {
		String retorn="";
		switch (a) {
		case 1:
			Iterator<String> iterador=PersonasHash.keySet().iterator();
			
			while(iterador.hasNext()){	
			String key=iterador.next();	
					retorn+="Documento: "+PersonasHash.get(key).getDocumento()+"\n";
					retorn+="Nombre: "+PersonasHash.get(key).getNombre()+"\n";
					retorn+="Telefono: "+PersonasHash.get(key).getTelefono()+"\n\n";
			}
			break;
		case 2: 
			if(PersonasHash.containsKey(b)) {
				
				retorn+="Documento: "+PersonasHash.get(b).getDocumento()+"\n";
				retorn+="Nombre: "+PersonasHash.get(b).getNombre()+"\n";
				retorn+="Telefono: "+PersonasHash.get(b).getTelefono()+"\n\n";
			}
			else {
				JOptionPane.showMessageDialog(null, "La persona no existe");
			}
			break;
		default:
		
		}
			
		return retorn;
	
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
	
	public void setPersonaVo(PersonasVO persona){
		this.miPersona=persona;
	}


}
