package apuestas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Apuestas extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("New label");
	private JTextField nliga;
	private liga Liga;
	//DB
	Connection conexion = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apuestas frame = new Apuestas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
				
			
		}
	/**
	 * Create the frame.
	 */
	public Apuestas() {
		// introducimos el codigo en el metodo para conectarnos a la base de datos
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//establece conexion con msql
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","formula2962");
		}
			catch(SQLException exceptionSql){
				exceptionSql.printStackTrace(); 
					
				}
				catch(ClassNotFoundException noEncontroClase)
				{
					noEncontroClase.printStackTrace();
				}
					
		Liga=new liga(conexion);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdministracionDeLigas = new JLabel("Administracion de ligas");
		lblAdministracionDeLigas.setBounds(144, 11, 176, 14);
		contentPane.add(lblAdministracionDeLigas);
		
		JLabel lblNombreDeLiga = new JLabel("Nombre de Liga");
		lblNombreDeLiga.setBounds(10, 38, 165, 14);
		contentPane.add(lblNombreDeLiga);
		
		nliga = new JTextField();
		nliga.setText(Liga.getnombreliga());
		nliga.setBounds(10, 70, 206, 20);
		contentPane.add(nliga);
		nliga.setColumns(10);
		
		JButton btnAdministrar = new JButton("Administrar");
		btnAdministrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaLiga JFrame =new VentanaLiga(Liga);
				JFrame.setVisible(true);
				
				
				
			}});		
		btnAdministrar.setBounds(10, 107, 113, 23);
		contentPane.add(btnAdministrar);
		
		JButton btnGenerarApuesta = new JButton("Generar apuesta");
		btnGenerarApuesta.setBounds(10, 152, 141, 23);
		contentPane.add(btnGenerarApuesta);
		
		JButton btnSeguimientoDeApuestas = new JButton("Seguimiento de Apuestas");
		btnSeguimientoDeApuestas.setBounds(10, 199, 195, 23);
		contentPane.add(btnSeguimientoDeApuestas);
	}
}
