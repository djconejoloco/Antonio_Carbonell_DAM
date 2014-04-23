package apuestas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventanaequipo extends JFrame {

	private JPanel contentPane;
	private equipo equipo;
	private JTextField Nequipo;
	private JTextField Gfavor;
	private JTextField Gcontra;
	private JTextField Pganados;
	private JTextField Pperdidos;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private JComboBox jliga;
	private VentanaLiga vliga;
	private boolean modificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}
	public Ventanaequipo(equipo equipomodificar,JComboBox jliga,boolean modifica) {
		equipo=equipomodificar;
		this.jliga=jliga;
		this.modificar=modificar;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lavel_1 = new JLabel("Nombre Equipo");
		lavel_1.setBounds(10, 25, 126, 14);
		panel.add(lavel_1);
		
		JLabel label_2 = new JLabel("Goles a Favor");
		label_2.setBounds(10, 64, 126, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Goles en Contra");
		label_3.setBounds(10, 101, 126, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Partidos Ganados");
		label_4.setBounds(10, 137, 126, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Partidos Perdidos");
		label_5.setBounds(10, 175, 126, 14);
		panel.add(label_5);
		
		Nequipo = new JTextField();
		Nequipo.setBounds(143, 22, 86, 20);
		panel.add(Nequipo);
		Nequipo.setColumns(10);
		
		Gfavor = new JTextField();
		Gfavor.setColumns(10);
		Gfavor.setBounds(143, 61, 86, 20);
		panel.add(Gfavor);
		
		Gcontra = new JTextField();
		Gcontra.setColumns(10);
		Gcontra.setBounds(143, 98, 86, 20);
		panel.add(Gcontra);
		
		Pganados = new JTextField();
		Pganados.setColumns(10);
		Pganados.setBounds(143, 134, 86, 20);
		panel.add(Pganados);
		
		Pperdidos = new JTextField();
		Pperdidos.setColumns(10);
		Pperdidos.setBounds(143, 172, 86, 20);
		panel.add(Pperdidos);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				guardarequipo();
			}
			});
		botonGuardar.setBounds(299, 97, 89, 23);
		panel.add(botonGuardar);
		
	}
		//metodo para guardar equipo en un fichero
		public void guardarequipo(){
				equipo.setGolesContra(Integer.valueOf(Gcontra.getText()));
				equipo.setGolesFavor(Integer.valueOf(Gfavor.getText()));
				equipo.setnombre(Nequipo.getText());
				equipo.setPartidosGanados(Integer.valueOf(Pganados.getText()));
				equipo.setPartidosPerdidos(Integer.valueOf(Pperdidos.getText()));
				guardarenfichero();
			
			
		
		
		//boton guardar en disco
		JButton GuardasrenDisco = new JButton("Guardar en disco");
		GuardasrenDisco.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			guardarequipo();
			guardarenfichero();
			
		}});	
		GuardasrenDisco.setBounds(10, 249, 140, 23);
		Container panel = null;
		panel.add(GuardasrenDisco);
		
		JButton LeerEnDisco = new JButton("Leer en disco");
		LeerEnDisco.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent arg0){
		recufichero();
		Nequipo.setText(equipo.getnombre());
		Gcontra.setText(String.valueOf(equipo.getGolesContra()));
		
		
		
			
		}

			private void recufichero() {
				
				
				
			}});	
		LeerEnDisco.setBounds(178, 249, 140, 23);
		panel.add(LeerEnDisco);
		
		
		
	}
	public Ventanaequipo(apuestas.equipo getequipo) {
		
	}
	private void guardarenfichero(){
		
		try
		{
		salida=new ObjectOutputStream(new FileOutputStream("equipo.ser"));
		salida.writeObject(equipo);
		if(salida !=null)
			salida.close();
		}
		catch(IOException ioException)
		{
			System.err.println("Error al abrir archivo");
			
	}
	}}

	