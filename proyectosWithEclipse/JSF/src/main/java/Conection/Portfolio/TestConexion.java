package Conection.Portfolio;

import java.sql.Statement;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import java.io.Serializable;

@Named
@ApplicationScoped
public class TestConexion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String bases = "";
	String prueba = "enero";
	private static int count = 0;
	boolean salida = false;
	
	public void getData() {
		try {
			Statement statement = Conexion.getConexion().createStatement(); //Con este objeto puedo hacer una consulta
			String query = "select name from project";
			ResultSet resultSet = statement.executeQuery(query);
			
				while(resultSet.next()) {
					bases += resultSet.getString(1) +"\n" ;
				}
			JOptionPane.showMessageDialog(null, bases);
			
			salida = true;
			
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, ex.toString());
				salida = false;
			}
	}
	
	public void aumentar() {
		this.count++;
		System.out.println("aumenta" + this.count);
	}
	
	public void disminuir() {
		this.count--;
		System.out.println("Disminuye " + this.count);
	}

	public String getPrueba() {return prueba;}
	public void setPrueba(String prueba) {this.prueba = prueba;}

	public boolean isSalida() {return salida;}
	public void setSalida(boolean salida) {this.salida = salida;}

	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}
	
	/*
	public static void main(String[] args) {
		System.out.println("prueba");
		
		TestConexion testConexion = new TestConexion();
		
		testConexion.getData();
	}*/
}
