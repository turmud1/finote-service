package finote.project.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import finote.project.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao {
	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement getByIdStatement;
	private PreparedStatement getAllStatement;

	private final String INSERT_QUERY = "insert into Invoice(No_Faktur,Tangal_Faktur,Last_Update,Keterangan)values(?,?,?,?)";
	private final String UPDATE_QUERY = " Update Invoice set Tanggal_Faktur=?, Last_Update=?,Keterangan=? where No_Faktur=?";
	private final String DELETE_QUERY = " delete From Invoice where NO_Faktur=?";
	private final String GET_BY_ID_QUERY = "select Nomor_Faktur,Tanggal_Faktur,Last_Update,Keterangan from Invoice where No_Faktur=?";
	private final String GET_ALL_QUERY = " select Nomor_Faktur, Tanggal_Faktur,Last_Update, Keterangan from Invoice";

	public void Connection(Connection connection) throws SQLException {
		this.connection = connection;
		insertStatement = this.connection.prepareStatement(INSERT_QUERY);
		updateStatement = this.connection.prepareStatement(UPDATE_QUERY);
		deleteStatement = this.connection.prepareStatement(DELETE_QUERY);
		getByIdStatement = this.connection.prepareStatement(GET_BY_ID_QUERY);
		getAllStatement = this.connection.prepareStatement(GET_ALL_QUERY);
	}

	public Invoice SaveOrUpdate(Invoice invoice, boolean isUpdate) throws SQLException {
		// TODO Auto-generated method stub
		if (!isUpdate) {
			insertStatement.setString(1, invoice.getNomorFaktur());
			insertStatement.setString(2, invoice.getTanggalFaktur());
			insertStatement.setString(3, invoice.getLastUpdate());
			insertStatement.setString(4, invoice.getKeterangan());
		} else {
			updateStatement.setString(1, invoice.getTanggalFaktur());
			updateStatement.setString(2, invoice.getLastUpdate());
			updateStatement.setString(3, invoice.getKeterangan());
			updateStatement.setString(4, invoice.getNomorFaktur());
		}
		return invoice;
	}

	public Invoice delete(Invoice invoice) throws SQLException {
		// TODO Auto-generated method stub
		deleteStatement.setString(1, invoice.getNomorFaktur());
		deleteStatement.executeUpdate();
		return invoice;
	}

	public Invoice getById(String nomorFaktur) throws SQLException {
		// TODO Auto-generated method stub
		getByIdStatement.setString(1, nomorFaktur);
		ResultSet rs = getByIdStatement.executeQuery();
		if (rs.next()) {
			Invoice invoice = new Invoice();
			invoice.setNomorFaktur(rs.getString("Nomor_Faktur"));
			invoice.setTanggalFaktur(rs.getString("Tanggal_Faktur"));
			invoice.setLastUpdate(rs.getString("Last_Update"));
			invoice.setTanggalFaktur(rs.getString("Keterangan"));
			return invoice;
		}
		return null;
	}

	public List<Invoice> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Invoice> invoice = new ArrayList<Invoice>();
		ResultSet rs = getAllStatement.executeQuery();
		while (rs.next()) {
			Invoice i = new Invoice();
			i.setNomorFaktur(rs.getString("Nomor_Faktur"));
			i.setTanggalFaktur(rs.getString("Tanggal_Faktur"));
			i.setLastUpdate(rs.getString("Last_Update"));
			i.setTanggalFaktur(rs.getString("Keterangan"));
			invoice.add(i);
		}
		return invoice;
	}

}
