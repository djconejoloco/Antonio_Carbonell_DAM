package apuestas;

import java.util.ArrayList;

public class liga {
	private int numequipos;
	private String nombreLiga;
	private equipo Equipo[];
	private String[] nombreEquipo = new String[20];

	public liga() {
		numequipos = 20;
		nombreLiga = "Premier";
		ArrayList <String> Equipo = new ArrayList<String>();
		
		//iniciamos cada equipo para poder almacenar despues
		for (int i = 0; i < numequipos; i++)
		{
		
		}
	}

	public liga(int numero, String nombre) {
		numequipos = numero;
		nombreLiga = nombre;
		for (int i = 0; i < numequipos; i++)
		{
			Equipo[i] = new equipo();
		}
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

	public void setEquipo(equipo nombre, int numero) {

		numequipos = numero;
	}
}
