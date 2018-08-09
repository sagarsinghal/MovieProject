package com.moviedunia;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "Registration Related Code", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Collected all data from User and assigned to Strings.
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String DateOfBirth = request.getParameter("dob");
		String email=request.getParameter("email");
		String password= request.getParameter("password");
		
		DBHelper db = new DBHelper();
		
		if(db.insertUserDataToDB(firstName, lastName, DateOfBirth, email, password)>0) {
			request.setAttribute("registration", "SUCCESSFUL_REGISTRATION");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
			System.out.println("error");
		
		
		
	}

}
