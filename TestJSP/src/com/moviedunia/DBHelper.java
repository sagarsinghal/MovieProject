package com.moviedunia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class DBHelper {
	String CLASSFORNAME = "oracle.jdbc.driver.OracleDriver";

	public int insertUserDataToDB(String fName, String lName, String DateOfBirth, String email, String password) {
		int count = 0;

		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			con.setAutoCommit(false);
			String sql = "INSERT INTO USER_DATA VALUES(customers_seq1.NEXTVAL,?,?,?,?,?)";

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, fName);
			psmt.setString(2, lName);
			psmt.setString(3, email);
			psmt.setString(4, DateOfBirth);
			psmt.setString(5, password);

			count = psmt.executeUpdate();
			con.commit();

		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		}

		return count;
	}

	public boolean LoginAuthenticate(String emailID, String password) {
		boolean flag = false;
		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "SELECT email,password FROM USER_DATA";

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString(1).equals(emailID) && rs.getString(2).equals(password)) {
					flag = true;
					break;
				} else
					flag = false;
				System.out.println(rs.getString(1) + "    " + rs.getString(2) + flag);
			}

		} // end try
		catch (ClassNotFoundException c) {
			c.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
