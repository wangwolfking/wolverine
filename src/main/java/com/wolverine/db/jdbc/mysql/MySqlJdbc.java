package com.wolverine.db.jdbc.mysql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.wolverine.file.FileUtil;

public class MySqlJdbc {
	// private Connection conn=null;

	private static Connection conn = null;

	private MySqlJdbc() {
	}

	public static synchronized Connection getConnection() {
		if (null == conn) {
			try {
				Properties pps = FileUtil.getProperties("system.properties");
				String mysql_jdbc_driver = pps.getProperty("mysql_jdbc_driver");
				String mysql_db_url = pps.getProperty("mysql_db_url");
				String mysql_username = pps.getProperty("mysql_username");
				String mysql_password = pps.getProperty("mysql_password");

				Class.forName(mysql_jdbc_driver);
				conn = DriverManager.getConnection(mysql_db_url, mysql_username, mysql_password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void main(String[] args) {

		// MySqlJdbc.getConnection();
		Properties pps = System.getProperties();
		pps.list(System.out);

	}

}
