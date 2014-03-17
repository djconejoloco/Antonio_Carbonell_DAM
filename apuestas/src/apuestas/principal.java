package apuestas;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		equipo equipo=new equipo("", 0, 0, 0, 0);
		equipo equipo2=new equipo();
		 
				Ventanaequipo frame = new Ventanaequipo(equipo);
				frame.setVisible(true);
	}

}
