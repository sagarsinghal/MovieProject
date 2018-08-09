package com.moviedunia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Login Related Code", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);

		String emailID = request.getParameter("email");
		String password = request.getParameter("password");

		DBHelper db = new DBHelper();
			
			
		if (db.LoginAuthenticate(emailID, password)) {
			request.setAttribute("LOGIN", "SUCCESS_LOGIN");
			request.getRequestDispatcher("Movies.jsp").forward(request, response);
		}
		else
			{
			request.setAttribute("registration", "FAIL_REGISTRATION");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			}
		
	}

}
