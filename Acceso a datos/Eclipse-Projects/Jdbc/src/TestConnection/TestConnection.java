package TestConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/dam?characterEncoding=utf8";
			
			try {
				Connection con = DriverManager.getConnection(url,"root","Infor2022");
				
				Statement st = con.createStatement();
				String query = "select * from alumnos";
				
				ResultSet sr = st.executeQuery(query);
				
				while (sr.next()) {
					System.out.println("Id : " + sr.getInt(1)+ " Nombre : "+ sr.getString(2)+ " Edad :" + sr.getString(3));
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
