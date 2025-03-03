package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import factory.*;
import imodel.IFactura;

public class FacturaDAO implements IFactura{

	//Atributo de clase
	private Connection conn;

	//Constructor
	public FacturaDAO() throws SQLException {
		this.createTable();
	}
	
	//Implementa el m�todo insert para insertar los datos que vienen por parametro en la tabla Factura
	@Override
	public void insertCSV(CSVParser parser) throws SQLException {
		this.conn = MySQLDAOFactory.createConnection();
		for(CSVRecord row: parser) { 
			int id_factura = Integer.parseInt(row.get("idFactura"));
			int id_cliente = Integer.parseInt(row.get("idCliente"));
			
			String insert = "INSERT INTO Factura (idFactura, idCliente_FK) VALUES (?, ?)";
			PreparedStatement ps = this.conn.prepareStatement(insert);
			ps.setInt(1, id_factura);
			ps.setInt(2, id_cliente);
			ps.executeUpdate();
			this.conn.commit();
			ps.close();
		}
		this.conn.close();
	}
	
	//Implementa el m�todo createTable crear la tabla Factura si todavia no existe
	@Override
	public void createTable() throws SQLException {
		this.conn = MySQLDAOFactory.createConnection();
		String tablaFactura = "CREATE TABLE IF NOT EXISTS Factura("
				+ "idFactura INT,"
				+ "idCliente_FK INT,"
				+ "PRIMARY KEY(idFactura),"
				+ "FOREIGN KEY(idCliente_FK) references Cliente(idCliente))";

		this.conn.prepareStatement(tablaFactura).execute();
		this.conn.commit();
		this.conn.close();
	}

}
