package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.ScrollPaneConstants;

import ClasesP.MascotasVO;
import ClasesP.PersonasVO;
import Controlador.Coordinador;
import Vista.VentanaPrincipal;



public class VentanaConsulta extends JDialog implements ActionListener{

	
	private PersonasVO miPersona;
	private MascotasVO miMascota;
	private JPanel miPanel;
	private JLabel etiTitulo;
	private JSeparator separador;
	private JLabel etiConsultaE;
	private JLabel txtDocumento;
	private JTextField txtConsultaE;
	private JButton btnConsultaE;
	private JButton btnConsultaG;
	private JSeparator separ;
	private JTextArea txtArea;
	private JScrollPane scrool;
	private Coordinador miCoordinador;
	private boolean x=false;
	
	  public VentanaConsulta(VentanaGestionarMascota miventanaGestionarMascota, boolean modal) {
		     
		  super(miventanaGestionarMascota, modal);
		  ConfigurarVentana();
		  configurarComponentes(); 
	  }
	  
	  public VentanaConsulta(VentanaGestionarPersona miventanaGestionarPersona, boolean modal) {
		     
		  super(miventanaGestionarPersona, modal);
		  ConfigurarVentana();
		  configurarComponentes();
		  x=true;
	  }
	private void ConfigurarVentana() {
		// TODO Auto-generated method stub
		
		this.setTitle("Ventana Consulta");
		this.setSize(400,500);
		//this.setLayout(null);
		
		this.setLocationRelativeTo(null);
		
	}
	private void configurarComponentes() {
		
		miPanel= new JPanel();
		etiTitulo= new JLabel();
		separador= new JSeparator();
		etiConsultaE= new JLabel();
		txtConsultaE= new JTextField();
		btnConsultaE= new JButton();
		btnConsultaG= new JButton();
		separ= new JSeparator();
		txtArea= new JTextArea();
		txtDocumento= new JLabel();
		scrool= new JScrollPane();
		
		
	   
		miPanel.setLayout(null);
		miPanel.setPreferredSize(new Dimension(400,500));
		scrool.setBounds(5,10,450,550);
		etiTitulo.setText("Consultar Registros");
		etiTitulo.setBounds(120,20,120,20);
		separador.setBounds(50, 60, 300, 20);
	    etiConsultaE.setText("Consulta Especifica");
	    etiConsultaE.setBounds(40,80,120,60);
	    txtConsultaE.setBounds(160,140,130,30);
	    txtDocumento.setText("Documento");
	    txtDocumento.setBounds(80,140,100,30);
	    btnConsultaE.setText("Consultar");
	    btnConsultaE.setBounds(160,180,100,25);
	    
	    separ.setBounds(40,220,300,20);
	    btnConsultaG.setText("Consulta General");
	    btnConsultaG.setBounds(120, 250,150,30);
	    btnConsultaG.setBackground(Color.green);
	    txtArea.setBounds(40,290,300,200);
		
		
		
		
		scrool.setViewportView(miPanel);
		add(scrool);
		miPanel.add(etiTitulo);
		miPanel.add(separador);
		miPanel.add(etiConsultaE);
		miPanel.add(txtConsultaE);
		miPanel.add(txtDocumento);
		miPanel.add(separ);
		miPanel.add(btnConsultaE);
		miPanel.add(btnConsultaG);
		miPanel.add(txtArea);
		
		btnConsultaE.addActionListener(this);
		btnConsultaG.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent i) {

	
	if(x==false) {
		
		if(i.getSource()==btnConsultaE) {
			
			String consu=miCoordinador.consultarMascota(2,txtConsultaE.getText());
			txtArea.setText(consu);
		}
		
		if(i.getSource()==btnConsultaG) {
		
			String cs=miCoordinador.consultarMascota(1,null);
			txtArea.setText(cs);
			
			}
		}
	else 
		
	  if(x==true){
		  
		JOptionPane.showMessageDialog(null,"Entro a consultar Persona");
		
		if(i.getSource()==btnConsultaE) {
			
			String consu=miCoordinador.consultarPersona(2,txtConsultaE.getText());
			txtArea.setText(consu);
		}
		
		if(i.getSource()==btnConsultaG) {
			
			String consulta=miCoordinador.consultarPersona(1,null);
			txtArea.setText(consulta);
			
			}
		}
}

public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}
}
