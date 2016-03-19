package finote.project.service;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import javax.sql.DataSource;

import finote.project.dao.NomorAcountDao;
import finote.project.dao.NomorAcountDaoImpl;
import finote.project.model.NomorAcount;

public class NomorAcountService {

	private NomorAcountDao nomorAcountDao;
	private Connection connection;

	public void SetDataSource(DataSource dataSource) {
		try {
			connection = dataSource.getConnection();
			nomorAcountDao = new NomorAcountDaoImpl();
			((NomorAcountDaoImpl) nomorAcountDao).setConnection((com.mysql.jdbc.Connection) connection);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public NomorAcount SaveOrApdate(NomorAcount nomorAcount, boolean isUpdate) {

		try {
			connection.setAutoCommit(false);
			nomorAcountDao.SaveOrUpdate(nomorAcount, isUpdate);
			connection.commit();
			connection.setAutoCommit(true);

		} catch (SQLException ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return nomorAcount;
	}

	public NomorAcount Delete(NomorAcount nomorAcount) {
		try {
			connection.setAutoCommit(false);
			nomorAcountDao.delete(nomorAcount);
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex) {
			try {
				connection.rollback();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return nomorAcount;

	}

	public NomorAcount getPerson(String id) {
		NomorAcount nomorAcount = null;
		try {
			nomorAcount = nomorAcountDao.getByID(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomorAcount;
	}

	public List<NomorAcount> getPerson() {
		try {
			return nomorAcountDao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<NomorAcount>();
	}
}
