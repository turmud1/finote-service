package finote.project.dao;

import java.sql.SQLException;

import java.util.List;

import finote.project.model.NomorAcount;

public interface NomorAcountDao {
	public NomorAcount SaveOrUpdate(NomorAcount nomorAcount, boolean isupdate) throws SQLException;

	public NomorAcount delete(NomorAcount nomorAcount) throws SQLException;

	public NomorAcount getByID(String Nomor) throws SQLException;

	public List<NomorAcount> getAll() throws SQLException;
}
