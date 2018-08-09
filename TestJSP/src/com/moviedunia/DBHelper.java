package com.moviedunia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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

	public List getAllMovies() {
		ResultSet rs = null;
		List imgLinks =new ArrayList();
		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "SELECT IMAGE_LINK FROM MOVIE";

			rs = st.executeQuery(sql);


			while(rs.next()) {
				imgLinks.add(rs.getString(1));
			}			
			
		} catch (ClassNotFoundException c) {
			System.out.println(c.getMessage());
			System.out.println("OLAAA");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("OLAAA00000");
		}
		return imgLinks;
	}
	
	@SuppressWarnings("unchecked")
	public Movie getMovieDetails(String MovieID) {
		ResultSet rs = null;
		
		Movie m = new Movie(); 
		
		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "SELECT * FROM MOVIE WHERE MOVIE_ID="+MovieID;

			rs = st.executeQuery(sql);

			while(rs.next())
			{
				m.setMovieID(rs.getInt(1));					//MOVIE ID 			NUMBER
				m.setMovieName(rs.getString(2));			//MOVIE NAME 		VARCHAR
				m.setTrailerLink(rs.getString(3));			//trailer Link 		VARCHAR
				m.setImageLink(rs.getString(4));			//image Link 		VARCHAR
				m.setDirector(rs.getString(5));				//Directors 		VARCHAR
				m.setProducer(rs.getString(6));				//producer 			VARCHAR
				m.setCast(rs.getString(7));					//CASTS 			VARCHAR
				m.setReleaseDate(rs.getString(8));			//release date 		VARCHAR
				m.setDescription(rs.getString(9));			//Description		VARCHAR
				m.setRating(rs.getString(10));				//rating			VARCHAR
			}
		} catch (ClassNotFoundException c) {
			System.out.println(c.getMessage());
			System.out.println("OLAAA");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("OLAAA00000");
		}
		
		return m;
		
	}
	
}
