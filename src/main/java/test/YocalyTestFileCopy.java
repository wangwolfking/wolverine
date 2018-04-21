package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.wolverine.db.jdbc.mysql.MySqlJdbc;
import com.wolverine.file.FileUtil;

public class YocalyTestFileCopy {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String servicecode = "";
		try {
			conn = MySqlJdbc.getConnection();
			String sqlStr = "SELECT * FROM t_client_uploadreport WHERE c_state = '0'";
			ps = conn.prepareStatement(sqlStr);
			rs = ps.executeQuery();
			while (rs.next()) {
				servicecode = rs.getString(2);
				movePDF(servicecode);
				sqlStr = "update t_client_uploadreport set c_state = '1' where c_servicecode=?";
				ps = conn.prepareStatement(sqlStr);
				ps.setString(1, servicecode);
				ps.executeUpdate();
			}
		} catch (Exception ex) {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
		}

	}

	static void movePDF(String servicecode) {
		String sourceDirectoryName = "";
		String destDirectoryName = "";
		try {
			Properties pps = new Properties();
			pps = FileUtil.getProperties("system.properties");
			sourceDirectoryName = pps.getProperty("source_Directory_Name");
			destDirectoryName = pps.getProperty("dest_Directory_Name");
			servicecode += "B.DAT.PDF";
			sourceDirectoryName += servicecode;
			destDirectoryName += servicecode;

			File source = new File(sourceDirectoryName);
			System.out.println(source.exists());
			File dest = new File(destDirectoryName);
			Long aa=System.currentTimeMillis();
			FileUtil.copyFileUsingFileStreams(source, dest);
			Long bb=System.currentTimeMillis();
			System.out.println(bb-aa);
			System.out.println(1234);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
