package apuestas;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		equipo equipo=new equipo("", 0, 0, 0, 0);
		// coje la informacion del segundo constructor
		equipo equipo2=new equipo();
		 // para ver  la ventana equipo
				Ventanaequipo frame = new Ventanaequipo(equipo);
				frame.setVisible(true);
	}

}
