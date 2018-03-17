package dao.teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String CONNECTIONSTR = "jdbc:mysql://localhost:3306/School";
	final String USER = "root";
	final String PWD = "1212";

	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	private DaoHelper() {
	}

	private static DaoHelper instance;

	public static DaoHelper GetInstance() {
		if (instance == null) {
			instance = new DaoHelper();
		}
		return instance;
	}

	public void registerDriver() throws ClassNotFoundException {
		Class.forName(this.DRIVER);
	}

	public void getConnection() throws SQLException {
		conn = DriverManager.getConnection(this.CONNECTIONSTR, this.USER, this.PWD);
	}

	public void init() throws ClassNotFoundException, SQLException {
		this.registerDriver();
		this.getConnection();

	}

	public void createStatement() throws SQLException {
		statement = conn.createStatement();
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		return this.statement.executeQuery(sql);
	}

	public void close() throws SQLException {
		if (this.resultSet != null) {
			this.resultSet.close();
		}
		if (this.statement != null) {
			this.statement.close();
		}

		if (this.conn != null) {
			this.conn.close();
		}
	}

}
