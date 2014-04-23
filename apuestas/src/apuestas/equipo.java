package apuestas;

import java.io.Serializable;

public class equipo implements Serializable{
	// atributos de equipo
	private String nombreEquipo;
	private int golesfavor;
	private int golesEncontra;
	private int partidosGanados;
	private int partidosPerdidos;
	
	public equipo(String nom, int golesF, int golesC, int partidosG, int partidosP) {
		// TODO Auto-generated constructor stub
		// damos valor a as clases que hemos pasado por el constructor
		nombreEquipo=nom;
		golesfavor=golesF;
		golesEncontra=golesC;
		partidosGanados=partidosG;
		partidosPerdidos=partidosP;
	}
	public equipo(){
		// este constructor lo iniciamos con unas variables y pasara por principal en el segundo objeto
		nombreEquipo="";
		golesfavor=0;
		golesEncontra=0;
		partidosGanados=0;
		partidosPerdidos=0;
		
	}

	public void setnombre(String nom) {
		nombreEquipo=nom;
	}

	public String getnombre() {
		return nombreEquipo;
	}

	public void setGolesFavor(int golesF) {
		golesfavor=golesF;
	}
	public int getGolesFavor(){
		return golesfavor;
	}
	public void setGolesContra(int golesC){
		golesEncontra=golesC;
	}
	public int getGolesContra(){
		return golesEncontra;
	}
	public void setPartidosGanados(int partidosG){
		partidosGanados=partidosG;
	}
	public int getPartidosGanados(){
		return partidosGanados;
	}
	public void setPartidosPerdidos(int partidosP){
		partidosPerdidos=partidosP;
	}
	public int getPartidosPerdidos(int partidosP){
		return partidosPerdidos;
	}
	//este metodo devuelve a traves del jcombobox el nombre del equipo
	public String ToString(){
		return nombreEquipo;
	}
	
}
