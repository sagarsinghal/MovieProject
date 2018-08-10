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
		List imgLinks = new ArrayList();
		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "SELECT IMAGE_LINK FROM MOVIE";

			rs = st.executeQuery(sql);

			while (rs.next()) {
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

			String sql = "SELECT * FROM MOVIE WHERE MOVIE_ID=" + MovieID;

			rs = st.executeQuery(sql);

			while (rs.next()) {
				m.setMovieID(rs.getInt(1)); // MOVIE ID NUMBER
				m.setMovieName(rs.getString(2)); // MOVIE NAME VARCHAR
				m.setTrailerLink(rs.getString(3)); // trailer Link VARCHAR
				m.setImageLink(rs.getString(4)); // image Link VARCHAR
				m.setDirector(rs.getString(5)); // Directors VARCHAR
				m.setProducer(rs.getString(6)); // producer VARCHAR
				m.setCast(rs.getString(7)); // CASTS VARCHAR
				m.setReleaseDate(rs.getString(8)); // release date VARCHAR
				m.setDescription(rs.getString(9)); // Description VARCHAR
				m.setRating(rs.getString(10)); // rating VARCHAR
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

	public boolean bookTickets(String userID, Ticket t, Movie m) {
		boolean flag = false;

		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "INSERT INTO BOOK_TICKETS VALUES(ticketIDGenerator.NEXTVAL,'" + userID + "'," + m.getMovieID()
					+ ",'" + t.getShow_Date() + "','" + t.getShow_Time() + "'," + t.getNumber_of_Seats() + ","
					+ t.getTotalAmount() + ")";

			int x = st.executeUpdate(sql);

			if (x > 0)
				flag = true;
			else
				flag = false;
		} catch (ClassNotFoundException c) {
			System.out.println(c.getMessage());
			flag = false;
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			flag = false;
		}
		return flag;
	}

	public int getAvailableSeats(Movie m, Show s1) {
		int availSeats = 120;
		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "SELECT AVAILABLE_SEATS from AVAILABLESEATS WHERE show_date='"+s1.getShow_date()
						+"' AND show_time='"+s1.getShow_time()+"' AND MOVIE_ID="+m.getMovieID();

			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				availSeats=rs.getInt(1);
			}
		} catch (ClassNotFoundException c) {
			System.out.println(c.getMessage());
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
		return availSeats;
	}

	public boolean updateAvailSeats(Ticket t1, Movie mm) {
		int x = t1.getNumber_of_Seats();
		boolean flag = false;

		try {
			Class.forName(CLASSFORNAME);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

			Statement st = con.createStatement();

			String sql = "UPDATE AVAILABLESEATS SET available_seats=available_seats-" + x + " WHERE movie_id="
					+ mm.getMovieID() + " AND show_date='" + t1.getShow_Date() + "' AND show_time='" + t1.getShow_Time()
					+ "'";

			int x1 = st.executeUpdate(sql);

			if (x1 > 0)
				flag = true;
			else
				flag = false;
		} catch (ClassNotFoundException c) {
			System.out.println(c.getMessage());
			flag = false;
		} catch (SQLException s) {
			System.out.println(s.getMessage());
			flag = false;
		}
		return flag;
	}
}
