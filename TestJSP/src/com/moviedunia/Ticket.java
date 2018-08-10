package com.moviedunia;

public class Ticket {
	String userID, show_Date, seat_Type, show_Time;
	int ticketID, movie_ID, number_of_Seats;
	double totalAmount;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getShow_Date() {
		return show_Date;
	}

	public void setShow_Date(String show_Date) {
		this.show_Date = show_Date;
	}

	public String getSeat_Type() {
		return seat_Type;
	}

	public void setSeat_Type(String seat_Type) {
		this.seat_Type = seat_Type;
	}

	public String getShow_Time() {
		return show_Time;
	}

	public void setShow_Time(String show_Time) {
		this.show_Time = show_Time;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public int getMovie_ID() {
		return movie_ID;
	}

	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}

	public int getNumber_of_Seats() {
		return number_of_Seats;
	}

	public void setNumber_of_Seats(int number_of_Seats) {
		this.number_of_Seats = number_of_Seats;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
