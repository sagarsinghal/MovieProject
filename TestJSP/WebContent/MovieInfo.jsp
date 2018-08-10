<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.moviedunia.*, java.util.*, java.time.*,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="style.css">

<style>
body {
	font-family: "Times New Roman", Georgia, Serif;
}

h1, h2, h3, h4, h5, h6 {
	font-family: "Playfair Display";
	letter-spacing: 5px;
}

* {
	box-sizing: border-box
}
/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}
/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 80%; /* Could be more or less, depending on screen size */
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

input[type=text],  input[type=date], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}
</style>

</head>
<body>

<%
	String ses = (String)session.getAttribute("user_id");
		System.out.println(ses);
	if(ses==null){
		out.println("Login First <a href=\"index.jsp\"><button>Login<b/button><a>");
		return;
	}
	
	%>

	<%
		Movie m = (Movie) request.getAttribute("movieDetails");
	%>
	<!-- Header -->
	<header class="mov-display-container mov-content mov-wide"
		style="max-width:1600px;min-width:500px" id="home"> <iframe
		width=100% height="400" src="<%out.println(m.getTrailerLink());%>">
	</iframe>
	<div class="mov-display-bottomleft mov-padding-large mov-opacity">

	</div>
	</header>

	<!-- Page content -->
	<div class="mov-content" style="max-width: 1100px">

		<!-- About Section -->
		<div class="mov-row mov-padding-64" id="about">
			<div class="mov-col m6 mov-padding-large mov-hide-small">
				<img src="<%out.println(m.getImageLink());%>"
					class="mov-round mov-image mov-opacity-min" alt="Table Setting"
					width="600" height="750">
			</div>

			<div class="mov-col m6 mov-padding-large">
				<h1 class="mov-center">
					<%
						out.println(m.getMovieName());
					%>
				</h1>
				<br>
				<h5 class="mov-left">
					Release Date :
					<%
					out.println(m.getReleaseDate());
				%>
				</h5>
				<br>
				<h5 class="mov-left">
					Cast :
					<%
					out.println(m.getCast());
				%>
				</h5>
				<br>
				<h5 class="mov-left">
					Director :
					<%
					out.println(m.getDirector());
				%>
				</h5>
				<br>
				<h5 class="mov-left">
					Producer :
					<%
					out.println(m.getProducer());
				%>
				</h5>
				<br>
				<h5 class="mov-left">
					Rating :
					<%
					out.println(m.getRating());
				%>
				</h5>
				<br>
				<p class="mov-large">
					Description :
					<%
					out.println(m.getDescription());
				%>
				</p>
			</div>
		</div>


		<button
			onclick="document.getElementById('id01').style.display='block'"
			style="width: auto;">Book Now</button>

<button
			onclick="style.display='block'"
			style="width: auto;">Logout</button>
		<div id="id01" class="modal">

			<form class="modal-content animate" action="LoginServlet"
				method="post">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="close" title="Close Modal">&times;</span>

				</div>

				<div class="container">
				
				No.Of Seats : 
				<input type="number" name="quantity" min="1" max="120">
					<label for="dob"><b>Show Date : </b></label> 
					<input type="date" name="dob" id="date" min="2018-08-10" required> <b>Show Time : </b>
					 <select>
						<option value="10:00">10:00</option>
						<option value="12:00">13:00</option>
						<option value="14:00">16:00</option>
						<option value="16:00">19:00</option>
					</select> 
					
					<button type="submit">Confirm Booking</button>

				</div>

				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
					
				</div>
			</form>
		</div>


		<hr>
		
		<script type="text/javascript">
		 function checkDate() {
		        var dateString = document.getElementById('date').value;
		        var myDate = new Date(dateString);
		        var today = new Date();
		        if ( myDate <= today ) { 
		            $('#date').after('<p>You cannot enter a date in the future!.</p>');
		            return false;
		        }
		        return true;
		    }
		</script>
</body>
</html>