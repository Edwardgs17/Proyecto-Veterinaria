package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.Coordinador;
import Procesos.Utilidades;



public class VentanaPrincipal extends JFrame implements ActionListener {


	JPanel miPanel;
	private JLabel txtTitulo;
	private JButton btn1;
	private JButton btn2;
    private Coordinador miCoordinador;
	public VentanaPrincipal() {
		
		super();
		ConfigurarVentana();
		ConfigurarComponentes();
	}

	private void ConfigurarVentana() {

		this.setTitle("Principal");
		this.setSize(500, 200);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
	}
	private void ConfigurarComponentes() {
		
        miPanel=new JPanel();
		txtTitulo=new JLabel();
		btn1=new JButton();
		btn2=new JButton();
		
		miPanel.setLayout(null);

		miPanel.setBounds(0,0,500,200);
        

		txtTitulo.setText("Bienvenido A Veterinaria");
		txtTitulo.setBounds(160,20,140,30);
		
		btn1.setText("Personas");
		btn1.setBounds(110, 90, 100, 30);
		btn2.setText("Mascotas");
		btn2.setBounds(250, 90, 100, 30);
		
		add(miPanel);
		miPanel.add(txtTitulo);
		miPanel.add(btn1);
		miPanel.add(btn2);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	    if(btn1==e.getSource()) {

	    	miCoordinador.mostrarVentana(Utilidades.GUI_PERSONA);
	    	  
	    }
	    if(btn2==e.getSource()) {
	    	
	    	miCoordinador.mostrarVentana(Utilidades.GUI_MASCOTA);
	    	  
	    }
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
		
	
	}

