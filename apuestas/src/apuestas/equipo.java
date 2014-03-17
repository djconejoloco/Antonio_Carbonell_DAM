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
}
