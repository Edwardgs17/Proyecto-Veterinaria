package ClasesP;


public class MascotasVO extends AnimalesVO{

	private PersonasVO propietario;
	private String nombre;
	
	
	public PersonasVO getPropietario() {
		return propietario;
	}
	public void setPropietario(PersonasVO personasVO) {
		this.propietario = personasVO;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
