package apuestas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class liga implements Serializable {
	private int numequipos;
	private String nombreLiga;
	private ArrayList<equipo> Equipo = new ArrayList<equipo>();

	public liga() {
		numequipos = 0;
		nombreLiga = "Premier";

	}

	public liga(int numero, String nombre) {
		numequipos = numero;
		nombreLiga = nombre;
		// iniciamos cada equipo para poder almacenar despues
		for (int i = 0; i < numequipos; i++) {
			Equipo.add(new equipo());
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

	// nos devuelve la posicion en la tabla de clasificacion
	public equipo getequipo(int situaciontabla) {
		return Equipo.get(situaciontabla);

	}

	// creamos un nuevo equipo para que lo capture con el jcombobox en
	// ventanaliga
	public void newequipo() {

		Equipo.add(new equipo());
		numequipos++;
    }
	//para borrar un equipo de una posicion
	public  void deletequipo(int posicio){
		Equipo.remove(posicio);
	}
}
