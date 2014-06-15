package apuestas;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;


public class liga implements Serializable {
	private int numequipos;
	private String nombreLiga;
	private ArrayList<equipo> Equipo = new ArrayList<equipo>();
	private int idLiga;
	
	//bd
	private Connection conexion=null;
	Statement instruccion=null;
	ResultSet conjuntoresultados=null;
	
	//clase liga y se le pasa la conexion de BD por el constructor
	public liga(Connection conexion) {
		idLiga=0;
		numequipos = 0;
		nombreLiga = "";
		this.conexion=conexion;
		leerliga();
	}
	
	//clase liga y se le pasa la conexion de BD por el constructor el numero y nombre 
	public liga(Connection conexion,int numero, String nombre,int idliga) {
		idliga=idLiga;
		numequipos = numero;
		nombreLiga = nombre;
		this.conexion=conexion;
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
	
	public void BDnewequipo(equipo Equipo){
		try{
			//consultar base de datos
			instruccion=(Statement) conexion.createStatement();
			//insercion en base de datos
			String sql_inst="INSERT INTO equipos (idLiga, nombreEquipo, golesFavor, golesEnContra, partidosGanados, partidosPerdidos)";
			sql_inst=sql_inst+ "VALUES("+idLiga+",'"+Equipo.getnombre()+"',"+Equipo.getGolesFavor()+","+Equipo.getGolesContra()+","+Equipo.getPartidosGanados()+","+Equipo.getPartidosPerdidos()+")";
		 
			instruccion.executeUpdate(sql_inst);
		  
			//obtener el ID que le acaba de asignar la BD
			instruccion=(Statement) conexion.createStatement();
			ResultSet rs=instruccion.executeQuery("SELECT LAST_INSERT_ID()");
			int id=rs.getInt(0);
			Equipo.setId(id);
		  }
		catch(SQLException excepcionSql){
			excepcionSql.printStackTrace();
			
		}
		
		
	}
	
	public void BDupdate(equipo e){
		
		try{
			//consultar base de datos
			instruccion=(Statement) conexion.createStatement();
			//insercion en base de datos
			String sql_inst="UPDATE equipo SET nombreEquipo='"+e.getnombre()+"', golesfavor="+e.getGolesFavor()+", golesEnContra="+e.getGolesContra()+" WHERE idEquipo="+e.getId();
		 
		  instruccion.executeUpdate(sql_inst);
		  }
		catch(SQLException excepcionSql){
			excepcionSql.printStackTrace();
			
		}		
	}
	
	//para borrar un equipo de una posicion
	public  void deletequipo(int posicion){
		Equipo.remove(posicion);
	}
	public void leerliga(){
		try{
		instruccion=(Statement) conexion.createStatement();
		//la consulta en la base de datos
		conjuntoresultados= instruccion.executeQuery("SELECT idLiga , nombre , numEquipos FROM ligas LIMIT 1");
		//coje el resultado y dame el siguiente
		if(conjuntoresultados!=null){
		conjuntoresultados.next();
		//Almacenar en liga el nombre y numequipos
		this.idLiga=(int)conjuntoresultados.getObject("idLiga");
		this.nombreLiga=(String)conjuntoresultados.getObject("nombre");
		this.numequipos=(int)conjuntoresultados.getObject("numequipos");
		}
	}catch(SQLException exceptionSql){
		exceptionSql.printStackTrace();
	}
		
	}
}
