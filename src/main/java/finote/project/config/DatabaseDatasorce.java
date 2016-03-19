package finote.project.config;

import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseDatasorce {
	private MysqlDataSource mysqlDataSource;

	public DatabaseDatasorce() {
		mysqlDataSource = new MysqlDataSource();
	}

	public MysqlDataSource getMysqlDataSoure() {
		mysqlDataSource.setUser("root");
		mysqlDataSource.setPassword("");
		mysqlDataSource.setDatabaseName("Finot");
		mysqlDataSource.setServerName("LocalHost");
		mysqlDataSource.setPortNumber(3306);
		return mysqlDataSource;

	}

	public void closeMysqlConnection() {
		try {
			mysqlDataSource.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
