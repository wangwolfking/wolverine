package com.wolverine.db.jdbc.Oracle;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		OracleDao odDao = new OracleDao();
		try {
			Connection conn = JdbcUtil.getConnection();
			System.out.println(conn == null ? "no" : "yes");
			JdbcUtil.close(conn);
			odDao.callFunction();
			odDao.callProcedure();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// TODO: handle finally clause
		}

	}

}
