package apuestas;

public class liga {
	private int numequipos;
	private String nombreLiga;
	private equipo Equipo[];
	private String[] nombreEquipo = new String[20];

	public liga() {
		numequipos = 20;
		nombreLiga = "Premier";
		Equipo = new equipo[numequipos];
	}

	public liga(int numero, String nombre) {
		numequipos = numero;
		nombreLiga = nombre;
	}

	public void setnombreliga(String nombre) {
		nombreLiga = nombre;
	}

	public String getnombreliga() {
		return nombreLiga;
	}

	public int getNumEquipo() {
		return numequipos;
	}

	public equipo getequipo(int situaciontabla) {
		return Equipo[situaciontabla];

	}

	public void setEquipo(equipo nombre ,int numero ){

		numequipos=numero;		 
	}
}
