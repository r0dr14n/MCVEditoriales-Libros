package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Editorial;
import modelo.Libro;

public class LibroDAO {
	
private ConexionBD conexion;
	
    public LibroDAO() {
        this.conexion = new ConexionBD();
    }
    
    public ArrayList<Libro> obtenerLibros() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from libros");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				String isbn = resultado.getString("isbn");
				String titulo = resultado.getString("titulo");
				int codEditorial = resultado.getInt("codEditorial");
				int anio = resultado.getInt("anio");
				int numPag = resultado.getInt("num_pags");
				double precio = resultado.getDouble("precio");
				int cantidad = resultado.getInt("cantidad");
				double precioCD = resultado.getDouble("precioCD");
				
				Libro lib = new Libro(isbn, titulo, codEditorial, anio, numPag, precio, cantidad, precioCD);
				lista.add(lib);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }
    
    
    public Libro obtenerLibro(String isbn) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Libro lib=null;
		
		try {
			consulta = con.prepareStatement("select * from libros "
					+ "where isbn = ?");
			consulta.setString(1, isbn);
			resultado = consulta.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String titulo = resultado.getString("titulo");
				int codEditorial = resultado.getInt("codEditorial");
				int anio = resultado.getInt("anio");
				int numPag = resultado.getInt("num_pags");
				double precio = resultado.getDouble("precio");
				int cantidad = resultado.getInt("cantidad");
				double precioCD = resultado.getDouble("precioCD");
				
				lib = new Libro(isbn, titulo, codEditorial, anio, numPag, precio, cantidad, precioCD);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lib;
    }
    
    
    public int insertarLibro(Libro libro) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO libros (titulo,isbn,codEditorial,anio,num_pags,precio,cantidad,precioCD) "
					+ " VALUES (?,?,?,?,?,?,?,?) ");
			
			consulta.setString(1, libro.getTitulo());
			consulta.setString(2, libro.getIsbn());
			consulta.setInt(3, libro.getCodEditorial());
			consulta.setInt(4, libro.getAnio());
			consulta.setInt(5, libro.getNumPag());
			consulta.setDouble(6, libro.getPrecio());
			consulta.setInt(7, libro.getCantidad());
			consulta.setDouble(8, libro.getPrecioCD());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
    
    
    public int actualizarLibro(Libro libro) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("UPDATE `biblioteca`.`libros` SET `titulo` = ?,  "
					+ "`codEditorial`=?,`anio`=?, `numPag` = ?,`precio`= ?, `cantidad`= ?,  "
					+ "`precioCD`= ? WHERE `isbn` = ?;");
			
			consulta.setString(1, libro.getTitulo());
			consulta.setInt(2, libro.getCodEditorial());
			consulta.setInt(3, libro.getAnio());
			consulta.setInt(4, libro.getNumPag());
			consulta.setDouble(5, libro.getPrecio());
			consulta.setInt(6, libro.getCantidad());
			consulta.setDouble(7, libro.getPrecioCD());
			consulta.setString(8, libro.getIsbn());
			
			resultado=consulta.executeUpdate();
			
			System.out.println(consulta);

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
    
    
    public int eliminarLibro(String isbn) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("DELETE FROM `biblioteca`.`libros`\r\n"
					+ "WHERE isbn = ?");
			
			consulta.setString(1, isbn);
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
    
    
	
}
