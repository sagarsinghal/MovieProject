<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.moviedunia.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Movie Details</title>
</head>
<body>
	<% request.getParameter("movieDetails");
		
		
		%>
	<h1>OLA
	
	
	</h1>
	
	
	${m1.movieID}
	${Movie.movieName}
	${Movie.trailerLink}
	${Movie.imageLink}
	${Movie.director}
	${Movie.producer}
	${Movie.cast}
	${Movie.releaseDate}
	${Movie.description}
	${Movie.rating}
	
</body>
</html>