package apuestas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.util.ArrayList;

public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField Nombreliga;
	private JTextField textField_2;
	private equipo equipo;
	private liga liga;
	protected JTextComponent textField_1;
	



	
	public VentanaLiga(liga ligamodificar) {
		// pasamos liga  por el constructor 
		liga=ligamodificar;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Nombreliga = new JTextField();
		Nombreliga.setBounds(10, 53, 152, 20);
		contentPane.add(Nombreliga);
		Nombreliga.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(232, 53, 152, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Nombre de la liga");
		lblNewLabel.setBounds(10, 28, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel EquipoAModificar = new JLabel("Equipos");
		EquipoAModificar.setBounds(10, 104, 152, 14);
		contentPane.add(EquipoAModificar);
		
		JLabel NumeroDeEquipos = new JLabel("Numero de equipos");
		NumeroDeEquipos.setBounds(232, 28, 152, 14);
		contentPane.add(NumeroDeEquipos);
		// boton modificar  con accio de escuchar 
		JButton Botonmodificar = new JButton("Modificar");
		Botonmodificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Ventanaequipo frameequipo = new Ventanaequipo(liga.getequipo(Integer.valueOf(textField_1.getText())));
			frameequipo.setVisible(true);
			
			}});
		Botonmodificar.setBounds(128, 192, 89, 23);
		contentPane.add(Botonmodificar);
		JButton botonmenos = new JButton("-");
		botonmenos.setBounds(72, 192, 41, 23);
		contentPane.add(botonmenos);
		
		JComboBox <equipo> comboBox = new JComboBox<equipo>();
		comboBox.setBounds(10, 148, 207, 20);
		contentPane.add(comboBox);
		//Como añadir equipos
				comboBox.addItem(new equipo("vlc",0,0,0,0));
				comboBox.addItem(new equipo("bcn",0,0,0,0));
				contentPane.add(comboBox);

				//Como saber que equipo se ha seleccionado
				equipo elegido=(equipo) comboBox.getItemAt(0);

				//Como cambiar el nombre del equipo
				System.out.println(elegido.getnombre());
				elegido.setnombre("bcn2");

				//Eliminar
				comboBox.removeItemAt(0);

			
		JButton botonmas = new JButton("+");
		botonmas.setBounds(10, 192, 41, 23);
		contentPane.add(botonmas);
		
		botonmas.addActionListener(new ActionListener() {

			private JComboBox comboBox;



			public void actionPerformed(ActionEvent arg0) {
				liga.newequipo();
				openequipowindow(liga.getequipo(liga.getNumEquipo()-1),false);
				

			}
			
			

			private void openequipowindow(equipo equipo, boolean modificar) {
				Ventanaequipo frameequipo = new Ventanaequipo(equipo,this.comboBox,modificar);
				frameequipo.setVisible(true);
				frameequipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
			
		});
		

	}}

