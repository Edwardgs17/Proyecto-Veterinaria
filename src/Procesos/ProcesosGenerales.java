package Procesos;

import java.util.HashMap;

import ClasesP.MascotasVO;
import ClasesP.PersonasVO;

public abstract class ProcesosGenerales {
	
	public abstract String Registrar();
	public abstract String Consultar(int a,String b);
	
    HashMap<String,PersonasVO> PersonasHash= new HashMap<String, PersonasVO>();
	HashMap<String,MascotasVO> MascotasHash= new HashMap<String, MascotasVO>();
}
