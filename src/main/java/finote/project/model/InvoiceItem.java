package finote.project.model;

public class InvoiceItem {
	private String idAcount;
	private String idInvoice;
	private String nama;
	private String cc;
	private String idInvoiceItem;
	private String uraian;
	private String debit;
	private String kredit;

	public String getIdAcount() {
		return idAcount;
	}

	public void setIdAcount(String idAcount) {
		this.idAcount = idAcount;
	}

	public String getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(String idInvoice) {
		this.idInvoice = idInvoice;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getIdInvoiceItem() {
		return idInvoiceItem;
	}

	public void setIdInvoiceItem(String idInvoiceItem) {
		this.idInvoiceItem = idInvoiceItem;
	}

	public String getUraian() {
		return uraian;
	}

	public void setUraian(String uraian) {
		this.uraian = uraian;
	}

	public String getDebit() {
		return debit;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public String getKredit() {
		return kredit;
	}

	public void setKredit(String kredit) {
		this.kredit = kredit;
	}

}
