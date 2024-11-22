<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

    /* Navbar */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    
    .navbar {
      position: fixed;
      top: 0;
      width: 100%;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 15px 30px;
      background-color: white; /* Semi-transparent background */
      box-shadow: none; /* Remove shadow for a cleaner look */
      z-index: 1000;
      transition: background-color 0.3s;
    }

    .navbar:hover {
      background-color: rgba(255, 255, 255, 0.8); /* Solid background on hover */
    }

    .logo a {
      font-size: 28px;
      font-weight: bold;
      color: #ff3333;
      text-decoration: none;
    }

    /* Navigation Links */
    .nav-links {
      list-style: none;
      display: flex;
      gap: 30px;
      font-size:20px;
    }

    .nav-links li a {
      text-decoration: none;
      color: #333;
      font-weight: 500;
      padding: 10px 15px;
      transition: color 0.3s;
    }

    .nav-links li a:hover {
      color: #ff3333; /* Change color on hover */
    }

    /* Auth Buttons */
    .auth-buttons {
      display: flex;
      gap: 15px;
    }

    .login-btn, .signup-btn {
      text-decoration: none;
      padding: 10px 20px;
      border-radius: 25px;
      font-weight: bold;
      transition: all 0.3s;
    }

    .login-btn {
      border: 2px solid red;
      color: red;
    }

    .login-btn:hover {
      background-color: #ff3333;
      color: white;
    }

    .signup-btn {
      background-color: #ff3333;
      color: white;
    }

    .signup-btn:hover {
      background-color: #ff3333;
    }

</style>
</head>

<body>
<nav class="navbar">
    <div class="logo">
      <a href="/">Relief Link</a>
    </div>
    <ul class="nav-links">
      <li><a href="#">Home</a></li>
      <li><a href="#">About</a></li>
      <li><a href="#">Services</a></li>
      <li><a href="#">Contact</a></li>
    </ul>
    <div class="auth-buttons">
      <a href="../views/chooserole.jsp" class="login-btn">Login</a>
      <a href="../views/register.jsp" class="signup-btn">Sign Up</a>
    </div>
  </nav>
</body>
</html>