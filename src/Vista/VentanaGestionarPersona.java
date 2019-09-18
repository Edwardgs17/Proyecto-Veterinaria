package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ClasesP.PersonasVO;
import Controlador.Coordinador;
import Procesos.ProcesosPersona;
import Procesos.Utilidades;


public class VentanaGestionarPersona extends JDialog implements ActionListener {

	PersonasVO miPersona;
	ProcesosPersona pP;
	private JDialog p2;
	private JPanel miPanel;
	private JLabel etiTitulo;
	private JLabel etiDocumento;
	private JLabel etinTelefono;
	private JLabel etiNombre;
	private JSeparator etiseparador;
	private JTextField txtDocumento;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JButton btnRegistrar;
	private JButton btnConsultar;
	private JButton btnlimpiar;
	private Coordinador miCoordinador;

	
	public VentanaGestionarPersona(VentanaPrincipal miVentanaPrincipal, boolean modal) {
		
		super(miVentanaPrincipal, modal);
		ConfigurarVentana();
		ConfigurarComponentes();
	}

	private void ConfigurarVentana() {

		this.setTitle("Proceso De Personas");
		this.setSize(500, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	private void ConfigurarComponentes() {
		
		miPanel= new JPanel();
		etiTitulo=new JLabel();
		etiDocumento= new JLabel();
		etinTelefono= new JLabel();
		etiNombre= new JLabel();
		etiseparador= new JSeparator();
		txtDocumento= new JTextField();
		txtTelefono= new JTextField();
		txtNombre= new JTextField();
		btnRegistrar= new JButton();
		btnConsultar= new JButton();
		btnlimpiar= new JButton();
		
		 
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    getContentPane().setLayout(null);
		getContentPane().add(miPanel);
        miPanel.setBounds(0, 0,  500, 300);
		miPanel.setLayout(null);
		etiTitulo.setText("Bienvenido al sistema de personas");
		etiTitulo.setBounds(170,10,200,30);
		etiseparador.setBounds(105,40,300,5);
		etiNombre.setText("Nombre:");
		etiNombre.setBounds(40,60,80,20);
		txtNombre.setBounds(100,60,120,20);
		etinTelefono.setText("Telefono:");
		etinTelefono.setBounds(250,60,80,20);
		txtTelefono.setBounds(310,60,120,20);
		etiDocumento.setText("Documento:");
		etiDocumento.setBounds(40,100,80,20);
		txtDocumento.setBounds(110,100,180,20);
		btnRegistrar.setText("Registrar");
		btnRegistrar.setBounds(150, 170, 100,30);
		btnConsultar.setText("Consultar");
		btnConsultar.setBounds(270, 170, 100,30);
   
	
		btnConsultar.addActionListener(this);
		btnRegistrar.addActionListener(this);
		
		
		add(miPanel);
		miPanel.add(etiTitulo);
		miPanel.add(etiseparador);
		miPanel.add(etiNombre);
		miPanel.add(etinTelefono);
		miPanel.add(etiDocumento);
		miPanel.add(txtNombre);
		miPanel.add(txtTelefono);
	    miPanel.add(txtDocumento);
	    miPanel.add(btnRegistrar);
	    miPanel.add(btnConsultar);
	    miPanel.add(btnlimpiar);
	   
	}

		@Override
		public void actionPerformed(ActionEvent i) {
			
			if(i.getSource()==btnRegistrar) {
				
				PersonasVO miPersonaVO=new PersonasVO();
				miPersonaVO.setDocumento(txtDocumento.getText());
				miPersonaVO.setNombre(txtNombre.getText());
				miPersonaVO.setTelefono(txtTelefono.getText());
				
				String registro=miCoordinador.registrarPersona(miPersonaVO);

				
				txtNombre.setText("");
				txtTelefono.setText("");
				txtDocumento.setText("");
			}
			
			if(i.getSource()==btnConsultar) {
				
				miCoordinador.mostrarVentana(Utilidades.GUI_CONSULTAP);
				
			}
			
			
		}
		
		public void setCoordinador(Coordinador miCoordinador) {
			this.miCoordinador=miCoordinador;
			
		}
}


