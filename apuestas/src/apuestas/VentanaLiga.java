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
	private equipo Equipo;
	private liga Liga;
	protected JTextComponent textField_1;
	private JComboBox<equipo> comboBox;
	private Ventanaequipo frameequipo;
	private VentanaLiga vliga;

	public VentanaLiga(liga ligamodificar) {
		// pasamos liga por el constructor
		Liga = ligamodificar;
		vliga = this;

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
		textField_2.setText(String.valueOf(Liga.getNumEquipo()));
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
		// boton modificar con accio de escuchar
		JButton Botonmodificar = new JButton("Modificar");
		Botonmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Liga.newequipo();
				openequipowindow(Liga.getequipo(Liga.getNumEquipo() - 1), false);

				Ventanaequipo frameequipo = new Ventanaequipo(Liga
						.getequipo(Integer.valueOf(textField_1.getText())));
				frameequipo.setVisible(true);

			}
		});
		Botonmodificar.setBounds(128, 192, 89, 23);
		contentPane.add(Botonmodificar);

		JComboBox<equipo> comboBox = new JComboBox<equipo>();
		comboBox.setBounds(10, 148, 207, 20);
		contentPane.add(comboBox);
		// Como añadir equipos
		comboBox.addItem(new equipo("", 0, 0, 0, 0));
		contentPane.add(comboBox);

		// Como saber que equipo se ha seleccionado
		equipo elegido = (equipo) comboBox.getItemAt(0);

		// Como cambiar el nombre del equipo
		System.out.println(elegido.getnombre());
		elegido.setnombre("");

		// Eliminar
		comboBox.removeItemAt(0);

		// boton mas
		JButton botonmas = new JButton("+");
		botonmas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// con esto creamos un nuevo equipo
				Liga.newequipo();
				//Esto no dice que es un nuevo equipo y nos redirige al  al metodo openequipowindow
				openequipowindow(Liga.getequipo(Liga.getNumEquipo() - 1), false);
			}
		});
		botonmas.setBounds(10, 192, 41, 23);
		contentPane.add(botonmas);
		// boton menos
		JButton botonmenos = new JButton("-");
		botonmenos.setBounds(72, 192, 41, 23);
		contentPane.add(botonmenos);

	}
	//definimos que es un nuevo equipo 
	private void openequipowindow(equipo Equipo, boolean modificar) {
		Ventanaequipo frameequipo = new Ventanaequipo(Equipo, this.comboBox,
				modificar);
		frameequipo.setVisible(true);
		frameequipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}
