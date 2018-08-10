package com.moviedunia;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Mmap;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet(description = "Booking is done here", urlPatterns = { "/BookingServlet" })
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userID=(String) request.getAttribute("userID");
		
		Movie m1 = (Movie) request.getAttribute("movieDetails");
		Ticket t1 = (Ticket)request.getAttribute("ticketDetails");
		
		DBHelper db = new DBHelper();
		if(db.bookTickets(userID,t1,m1))
		{
			if(db.updateAvailSeats(t1, m1))
				request.setAttribute("BOOKING", "BOOKING SUCCESSFUL");
		}
		
	}

}
