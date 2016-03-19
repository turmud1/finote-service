package finote.project.model;

public class Invoice {
	private String nomorFaktur;
	private String TanggalFaktur;
	private String lastUpdate;
	private String keterangan;

	public String getNomorFaktur() {
		return nomorFaktur;
	}

	public void setNomorFaktur(String nomorFaktur) {
		this.nomorFaktur = nomorFaktur;
	}

	public String getTanggalFaktur() {
		return TanggalFaktur;
	}

	public void setTanggalFaktur(String tanggalFaktur) {
		TanggalFaktur = tanggalFaktur;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}
