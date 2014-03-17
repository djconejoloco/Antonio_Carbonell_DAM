package apuestas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Ventanaequipo extends JFrame {

	private JPanel contentPane;
	private equipo Equipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}
	public Ventanaequipo(equipo modificar) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(10, 42, 89, 23);
		panel.add(botonGuardar);
		
		Equipo=modificar;
	}
	private void guardarenfichero(){
		ObjectInputStream salida;
		try
		{
		salida=new ObjectInputStream(new FileOutputStream("clientes.ser"));
		salida.writeObject(equipo);
		if(salida !=null)
			salida.close();
		}
		catch(IOException ioException)
		{
			System.err.println("Error al abrir archivo");
	}
	}
	}

	