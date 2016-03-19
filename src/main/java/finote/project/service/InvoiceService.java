package finote.project.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import finote.project.dao.InvoiceDao;
import finote.project.dao.InvoiceDaoImpl;
import finote.project.model.Invoice;

public class InvoiceService {
	private InvoiceDao invoiceDao;
	private Connection connection;

	public void SetDataSource(DataSource dataSource) {
		try {
			connection = dataSource.getConnection();
			invoiceDao = new InvoiceDaoImpl();
			((InvoiceDaoImpl) invoiceDao).Connection((com.mysql.jdbc.Connection) connection);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Invoice SaveOrUpdate(Invoice invoice, boolean isUpdate) throws SQLException {
		try {
			connection.setAutoCommit(false);
			invoiceDao.SaveOrUpdate(invoice, isUpdate);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return invoice;

	}
	public Invoice Delete(Invoice invoice)throws SQLException{
		try{
			connection.setAutoCommit(false);
			invoiceDao.delete(invoice);
			connection.commit();
			connection.setAutoCommit(true);
		}catch(SQLException ex){
			try{
				connection.rollback();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return invoice;
	}
	public Invoice getPerson(String nomorFaktur)throws SQLException{
		Invoice invoice=null;
		try{
			invoice= invoiceDao.getById(nomorFaktur);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return invoice;
	}
public List<Invoice> getPerson(){
	try{
		return invoiceDao.getAll();
	}catch(SQLException e){
		e.printStackTrace();
	}
		return new ArrayList<Invoice>();
}
}