package com.moviedunia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	public int insertUserDataToDB(String fName, String lName, String DateOfBirth, String email, String password) {
		int count = 0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			String sql = "INSERT INTO USER_DATA VALUES(customers_seq.NEXTVAL,?,?,?,?,?)";

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(2, fName);
			psmt.setString(3, lName);
			psmt.setString(4, email);
			psmt.setString(5, DateOfBirth);
			psmt.setString(6, password);

			count = psmt.executeUpdate();

		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		}

		return count;

	}
}
