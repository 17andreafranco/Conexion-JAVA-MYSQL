package activity6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class QuerySQL {

	private Connection conn = null;
	private String db;
	private String login;
	private String password;
	private String url;

	public QuerySQL(String db, String login, String password) {

		this.db = db;
		this.login = login;
		this.password = password;
		this.url = "jdbc:mysql://localhost:3306/" + this.db;
		this.conn = Connection();

	}

	public Connection Connection() {
		try {
			this.conn = DriverManager.getConnection(this.url, this.login, this.password);
			System.out.println("-Open db: " + this.db + " - Ok");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
	}

	public void query(String query) throws SQLException {

		try {
			
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			System.out.println("-Query - Ok");
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
