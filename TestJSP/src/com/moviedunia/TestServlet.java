package com.moviedunia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("psw");
		String confPass = request.getParameter("psw-repeat");
		System.out.println(pass.equals(confPass));
		System.out.println(email);
		System.out.println(pass);
		if (pass.equals(confPass)) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott",
						"tiger");
				Statement st = conn.createStatement();
				String sql = "insert into testProj values(customers_seq.NEXTVAL,'" + email + "','" + pass + "')";
				int x = st.executeUpdate(sql);

				//request.setAttribute("email", email);
				request.getRequestDispatcher("index.html").forward(request, response);
			} catch (ClassNotFoundException c) {
				System.out.println(c.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
