package com.moviedunia;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Login m = new Login();
			
		if (db.LoginAuthenticate(emailID, password)) {
			
			
			
			HttpSession ses = request.getSession(true);
			ses.setAttribute("user_id", String.valueOf(m.getUser_id()));
			request.getRequestDispatcher("Movies.jsp").forward(request, response);
		}
		else
			{
			request.setAttribute("registration", "FAIL_REGISTRATION");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			}



	}

}
