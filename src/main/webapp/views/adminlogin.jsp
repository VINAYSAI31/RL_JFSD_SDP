	
	
	<!DOCTYPE html>
	<html lang="en">
	  
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Login Page</title>
	    <style>
	        /* CSS styles for the login page */
	        body {
	            font-family: Arial, sans-serif;
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            height: 100vh;
	            margin: 0;
	                  background: linear-gradient(to right, #f0f4f8,  #ffe6e6
	                  );
	
	        }
	        .container {
	            display: flex;
	            max-width: 800px;
	            width: 100%;
	            height: px; /* Set a height to increase container height */
	            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	            background-color: #fff;
	            border-radius: 8px;
	            overflow: hidden;
	            align-items: center; /* Center items vertically */
	        }
	        .login-image {
	            width: 50%;
	            background-image: url('path/to/your/image.jpg'); /* Replace with the actual path to your image */
	            background-size: cover;
	            background-position: center;
	        }
	        .login-container {
	                width: 70%;
	               padding: 73px;
	                text-align: center;
	             min-height: 416px; /* Set minimum height for the login container */
	        }
	        .login-container h2 {
	            margin-bottom: 20px;
	        }
	        .form-group {
	            display: flex;
	            align-items: center;
	            margin-bottom: 15px;
	            position: relative;
	        }
	        .form-group i {
	            position: absolute;
	            left: 10px;
	            font-size: 18px;
	        }
	        .form-group input {
	            width: 100%;
	            padding: 10px 10px 10px 40px;
	            font-size: 16px;
	            border: 1px solid #ddd;
	            border-radius: 5px;
	        }
	        .btn-login {
	            width: 100%;
	            padding: 10px;
	            background-color: #4CAF50;
	            border: none;
	            color: white;
	            font-size: 16px;
	            border-radius: 5px;
	            cursor: pointer;
	            margin-top: 10px;
	        }
	        .btn-login:hover {
	            background-color: #45a049;
	        }
	        .link-container {
	            margin-top: 10px;
	        }
	        .link-container a {
	            color: #007bff;
	            text-decoration: none;
	            font-size: 14px;
	        }
	        .link-container a:hover {
	            text-decoration: underline;
	        }
	    </style>
	</head>
	<body>
	<%@include file="homenavbar.jsp" %>
	    <div class="container">
	        <div class="login-image"></div>
	        <div class="login-container">
	            <h2>Welcome Back Admin</h2>
	             <!-- Display error message if present -->
	    
	            <form method="post" action="/checkadminlogin" >
	                <div class="form-group">
	                    <i>&#9993;</i>
	                    <input type="string" name="ausername" placeholder="Your username" required>
	                </div>
	                <div class="form-group">
	                    <i>&#128274;</i>
	                    <input type="password" name="apwd" placeholder="Password" required>
	                </div>
	                <button type="submit" class="btn-login">Log In</button>
	            </form>
	            
	        </div>
	    </div>
	</body>
	</html>
