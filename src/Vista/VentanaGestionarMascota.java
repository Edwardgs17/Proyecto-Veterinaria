package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ClasesP.MascotasVO;
import ClasesP.PersonasVO;
import Controlador.Coordinador;
import Procesos.ProcesosMascota;
import Procesos.Utilidades;

public class VentanaGestionarMascota extends JDialog implements ActionListener {

	private PersonasVO miPersona;
	private MascotasVO miMascota;
	private JPanel miPanel;
	private JLabel etiTitulo;
	private JLabel etiDocumentoDueño;
	private JLabel etiRaza;
	private JLabel etiNombre;
	private JLabel etiSexo;
	private JSeparator etiseparador;
	private JTextField txtDocumentoDueño;
	private JTextField txtRaza;
	private JTextField txtNombre;
	private JTextField txtSexo;
	private JButton btnRegistrarMasc;
	private JButton btnConsultarMasc;
	private JSeparator sp2;
	private Coordinador miCoordinador;
	private JButton btnlimpiar;

	
	  public VentanaGestionarMascota(VentanaPrincipal miVentanaPrincipal, boolean modal) {
	     
		  super(miVentanaPrincipal, modal);
		  ConfigurarVentana();
		  configurarComponentes();
		  
	  }
	  
	private void ConfigurarVentana() {
		
		this.setTitle("Proceso De Mascotas");
		this.setSize(550, 330);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}

	private void configurarComponentes() {
		
      
		 miPanel= new JPanel();
		 etiTitulo= new JLabel();
		 etiDocumentoDueño= new JLabel();
		 etiRaza= new JLabel();
		 etiNombre= new JLabel();
		 etiSexo= new JLabel();
		 etiseparador= new JSeparator();
		 txtDocumentoDueño= new JTextField();
		 txtRaza= new JTextField();
		 txtNombre= new JTextField();
		 txtSexo= new JTextField();
		 btnRegistrarMasc= new JButton();
		 btnConsultarMasc= new JButton();
		 sp2= new JSeparator();
		 btnlimpiar= new JButton();
		 
		 
	     setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	     getContentPane().setLayout(null);
	     miPanel.setLayout(null);
	     miPanel.setBounds(0,0,550,330);

	     etiTitulo.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); 
	     etiTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	     etiTitulo.setText("Gestionar Mascotas");
	     etiTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	     etiTitulo.setBounds(150, 10, 210, 20);
	     etiseparador.setBounds(100,40,300,5);
	      
	     etiDocumentoDueño.setText("Documento :");
	     etiDocumentoDueño.setBounds(40,70,100,30);
	     txtDocumentoDueño.setBounds(120,70,120,30);
	     etiRaza.setText("Raza :");
	     etiRaza.setBounds(260,70,100,30);
	     txtRaza.setBounds(300,70,120,30);
	     etiNombre.setText("Nombre :");
	     etiNombre.setBounds(40,140,100,30);
	     txtNombre.setBounds(120,140,120,30);
	     etiSexo.setText("Sexo :");
	     etiSexo.setBounds(260,140,100,30);
	     txtSexo.setBounds(300,140,120,30);
	     sp2.setBounds(30, 250,460,10);
	  
	     btnRegistrarMasc.setText("Registrar");
	     btnRegistrarMasc.setBounds(120,210 ,120,30);
	     btnConsultarMasc.setText("Consultar");
	     btnConsultarMasc.setBounds(300,210 ,120,30);
	             
	     add(miPanel);
	     miPanel.add(etiTitulo);
	     miPanel.add(etiseparador);
	     miPanel.add(etiDocumentoDueño);
	     miPanel.add(txtDocumentoDueño);
	     miPanel.add(etiNombre);
	     miPanel.add(txtNombre);
	     miPanel.add(etiRaza);
	     miPanel.add(txtRaza);
	     miPanel.add(etiSexo);
	     miPanel.add(txtSexo);
	     miPanel.add(btnRegistrarMasc);
	     miPanel.add(btnConsultarMasc);
	     miPanel.add(sp2);
	    

		btnRegistrarMasc.addActionListener(this);
		btnConsultarMasc.addActionListener(this);
	
	}
		@Override
		public void actionPerformed(ActionEvent i){
	   try {
			try {
			if(i.getSource()==btnRegistrarMasc) {
				
				miPersona=miCoordinador.setDocumento(txtDocumentoDueño.getText());		
				
	            if (miPersona.getDocumento().equals(txtDocumentoDueño.getText())) {
	            	   
	            	   miMascota= new MascotasVO();
	            	   miMascota.setPropietario(miPersona);
	            	   miMascota.setNombre(txtNombre.getText());
		               miMascota.setRaza(txtRaza.getText());
		               miMascota.setSexo(txtSexo.getText());
		               
		               String resultado=miCoordinador.registrarMascota(miMascota);
		               
						
						txtNombre.setText("");
						txtDocumentoDueño.setText("");
						txtRaza.setText("");
						txtSexo.setText("");
	               
			}
		}
					if(i.getSource()==btnConsultarMasc) {
								
						miCoordinador.mostrarVentana(Utilidades.GUI_CONSULTA);
					}
				
					
			}
					catch(NullPointerException e) {
						JOptionPane.showMessageDialog(null,"la persona no existe");
					}
	   }
	   catch(Exception x) {
		   
		   JOptionPane.showMessageDialog(null,"No hay ningun Registro");
	   }
	}

			
		public void setCoordinador(Coordinador miCoordinador) {
						this.miCoordinador=miCoordinador;
	
		}
}
