package apuestas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaLiga extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private equipo equipo;
	private liga liga;



	
	public VentanaLiga(liga ligamodificar) {
		// pasamos liga  por el constructor 
		liga=ligamodificar;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 53, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 132, 152, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(232, 53, 152, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Nombre de la liga");
		lblNewLabel.setBounds(10, 28, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel EquipoAModificar = new JLabel("Equipo a modificar");
		EquipoAModificar.setBounds(10, 104, 152, 14);
		contentPane.add(EquipoAModificar);
		
		JLabel NumeroDeEquipos = new JLabel("Numero de equipos");
		NumeroDeEquipos.setBounds(232, 28, 152, 14);
		contentPane.add(NumeroDeEquipos);
		
		JButton Butonmodificar = new JButton("Modificar");
		Butonmodificar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Ventanaequipo frameequipo = new Ventanaequipo(liga.getequipo(Integer.valueOf(textField_1.getText())));
			frameequipo.setVisible(true);
			
			}});
		Butonmodificar.setBounds(38, 192, 89, 23);
		contentPane.add(Butonmodificar);
	}
		
}
