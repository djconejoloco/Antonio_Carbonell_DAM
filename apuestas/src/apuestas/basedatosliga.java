package apuestas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class basedatosliga {

	public static void main(String[] args) {
		Connection conexion = null;
		Statement instruccion=null;
		ResultSet conjuntoresultados=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//establece conexion con msql
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/apuestas","root","formula2962");
			//crea un objeto statement para la consulata de  para la consulta bd 
			instruccion=(Statement) conexion.createStatement();
			//la consulta en la base de datos
			conjuntoresultados= instruccion.executeQuery("SELECT idLiga,Nombre FROM liga");
			//mostrar por pantalla
			
			//while (conjuntoresultados.next()){
			//System.out.println("id="+ conjuntoresultados.getObject("idLiga")+ ", Nombre=" +conjuntoresultados.getObject("nombre"));}
			
		
	}catch(SQLException exceptionSql){
		exceptionSql.printStackTrace(); 
			
		}
		catch(ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
