package apuestas;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		equipo Equipo=new equipo("", 0, 0, 0, 0);
		
		 
				Ventanaequipo frame = new Ventanaequipo(Equipo);
				frame.setVisible(true);
	}

}
