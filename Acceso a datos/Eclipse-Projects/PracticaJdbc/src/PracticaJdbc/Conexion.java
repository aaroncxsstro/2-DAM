package PracticaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda?characterEncoding=utf8";
        String user = "root";
        String password = "Infor2022";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            insertarProducto(connection, "Ratón inalámbrico", 23.00, 1);
            insertarProducto(connection, "USB", 40.50, 5);
            insertarProducto(connection, "RAM", 33.00, 2);

            recuperarProductosPorFabricante(connection, "Asus");

            recuperarProductosMasBaratos(connection, 5);

            editarPrecioProducto(connection, 1, 101.00);

            eliminarProducto(connection, 2);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private static void insertarProducto(Connection connection, String nombre, double precio, int codigoFabricante) throws SQLException {
        String query = "INSERT INTO producto (nombre, precio, codigo_fabricante) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setDouble(2, precio);
            preparedStatement.setInt(3, codigoFabricante);
            preparedStatement.executeUpdate();
        }
    }


    private static void recuperarProductosPorFabricante(Connection connection, String fabricante) throws SQLException {
        String query = "SELECT nombre FROM producto WHERE codigo_fabricante IN (SELECT codigo FROM fabricante WHERE nombre = ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, fabricante);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("Producto del fabricante " + fabricante + ": " + resultSet.getString("nombre"));
                }
            }
        }
    }

    private static void recuperarProductosMasBaratos(Connection connection, int cantidad) throws SQLException {
        String query = "SELECT nombre, precio FROM producto ORDER BY precio ASC LIMIT ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, cantidad);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("Producto más barato: " + resultSet.getString("nombre") + ", Precio: " + resultSet.getDouble("precio"));
                }
            }
        }
    }


    private static void editarPrecioProducto(Connection connection, int codigoProducto, double nuevoPrecio) throws SQLException {
        String query = "UPDATE producto SET precio = ? WHERE codigo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, nuevoPrecio);
            preparedStatement.setInt(2, codigoProducto);
            preparedStatement.executeUpdate();
        }
    }


    private static void eliminarProducto(Connection connection, int codigoProducto) throws SQLException {
        String query = "DELETE FROM producto WHERE codigo = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codigoProducto);
            preparedStatement.executeUpdate();
        }
    }
}

