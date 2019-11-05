package org.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBasico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");// cogemos el conector correspondiente
			//System.out.println("Conexión con exito");
			String url = "jdbc:mysql://localhost:3306/primera";// 
			String user = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url, user, password);//Ralizamos un Connection de sql y utilizamos el DriverManager con un getConnection 
			//para poder hacer la conexion mediante la URL que es la ruta de la base de datos  con el localhost
			//System.out.println("La conexion es "+con.toString());
			String consulta = "select * from clientes"; // creamos una variable para poder trabajar mejor con ella  y creamos la Query
			Statement ST = con.createStatement(); // Con el Statement  mediante la varaible de la conexion  se crea un Statemenet.
			ResultSet resultado = ST.executeQuery(consulta); // Se hace unResultSet con la que  ejecutamos la QUERY.
		//	System.out.println("el resultado es :"+resultado);
			while(resultado.next()) { //realizamos un while porque el método next es un boolean.
				System.out.println(resultado.getString("nombre"));//mediante el el "resultado" y un getString  ya te pinta lo que hayas puesto en la Query
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
