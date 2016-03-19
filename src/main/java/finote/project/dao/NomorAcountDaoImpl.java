package finote.project.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import finote.project.model.NomorAcount;

public class NomorAcountDaoImpl implements NomorAcountDao {
	private Connection connection;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	private PreparedStatement deleteStatement;
	private PreparedStatement getByIdStatement;
	private PreparedStatement getAllStatement;

	private final String INSERT_QUERY = "insert into nomor_acount(id,nama,cc)values(?,?,?)";
	private final String UPDATE_QUERY = "update nomor_acount set nama=?, cc=? where id=?";
	private final String DELETE_QUERY = "delete from nomor_acount where id=?";
	private final String GET_BY_ID_QUERY = "select id,nama,cc from nomor_acount where id=?";
	private final String GET_ALL_QUERY = "select id,nama,cc from nomor_acount";

	public void setConnection(Connection connection) throws SQLException {
		this.connection = connection;
		insertStatement = this.connection.prepareStatement(INSERT_QUERY);
		updateStatement = this.connection.prepareStatement(UPDATE_QUERY);
		deleteStatement = this.connection.prepareStatement(DELETE_QUERY);
		getByIdStatement = this.connection.prepareStatement(GET_BY_ID_QUERY);
		getAllStatement = this.connection.prepareStatement(GET_ALL_QUERY);
	}

	public NomorAcount SaveOrUpdate(NomorAcount nomorAcount, boolean isupdate) throws SQLException {
		// TODO Auto-generated method stub
		if (!isupdate) {
			insertStatement.setString(1, nomorAcount.getIdAcount());
			insertStatement.setString(2, nomorAcount.getNama());
			insertStatement.setString(3, nomorAcount.getCc());
			insertStatement.executeUpdate();
		} else {
			updateStatement.setString(1, nomorAcount.getNama());
			updateStatement.setString(2, nomorAcount.getCc());
			updateStatement.setString(3, nomorAcount.getIdAcount());
		}

		return nomorAcount;
	}

	public NomorAcount delete(NomorAcount nomorAcount) throws SQLException {
		// TODO Auto-generated method stub
		deleteStatement.setString(1, nomorAcount.getIdAcount());
		deleteStatement.executeUpdate();
		return nomorAcount;
	}

	public NomorAcount getByID(String Nomor) throws SQLException {
		// TODO Auto-generated method stub
		getByIdStatement.setString(1, Nomor);
		ResultSet rs = getByIdStatement.executeQuery();
		if (rs.next()) {
			NomorAcount nomorAcount = new NomorAcount();
			nomorAcount.setIdAcount(rs.getString("id"));
			nomorAcount.setNama(rs.getString("nama"));
			nomorAcount.setCc(rs.getString("cc"));
			return nomorAcount;
		}
		return null;
	}

	public List<NomorAcount> getAll() throws SQLException {
		// TODO Auto-generated method stub
		List<NomorAcount> nomorAcount = new ArrayList<NomorAcount>();
		ResultSet rs = getAllStatement.executeQuery();
		while (rs.next()) {
			NomorAcount nomor = new NomorAcount();
			nomor.setIdAcount(rs.getString("id"));
			nomor.setNama(rs.getString("nama"));
			nomor.setCc(rs.getString("cc"));
			nomorAcount.add(nomor);
		}
		return nomorAcount;
	}

}
