package finote.project.dao;

import java.sql.SQLException;
import java.util.List;

import finote.project.model.Invoice;

public interface InvoiceDao {
	public Invoice SaveOrUpdate(Invoice invoice, boolean isUpdate) throws SQLException;

	public Invoice delete(Invoice invoice) throws SQLException;

	public Invoice getById(String nomorFaktur) throws SQLException;

	public List<Invoice> getAll() throws SQLException;
}
