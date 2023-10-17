package TestConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	private String usuario;
	private String contraseña;
	private String url = "jdbc:mysql://localhost:3306/mitienda?characterEncoding=utf8";
	
	public Conexion(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void establecerConexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con = DriverManager.getConnection(url,usuario,contraseña);
				
				Statement st = con.createStatement();
				String query = "select * from clientes";
				
				ResultSet sr = st.executeQuery(query);
				
				while (sr.next()) {
					System.out.println("Id : " + sr.getInt(1)+ " Nombre : "+ sr.getString(2)+ " Edad :" + sr.getString(3));
				}
				
				cerrarConexion(con);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error 1");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error 2");
			e.printStackTrace();
		}


		}
	
	public void cerrarConexion(Connection con) {
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		}
		
}
