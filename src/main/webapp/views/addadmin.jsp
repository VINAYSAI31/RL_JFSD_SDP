<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>ADMIN DASHBOARD</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <style>
    /* General Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body and Fonts */
    body {
      font-family: 'Roboto', sans-serif;
      color: #333;
      display: flex;
      height: 100vh;
      overflow: hidden;
      background-color: #f7f8fc;
    }

    /* Sidebar */
    .sidebar {
      width: 250px;
      background-color: #2c3e50;
      color: #ffffff;
      display: flex;
      flex-direction: column;
      align-items: center;
      padding-top: 20px;
    }

    /* Sidebar Logo */
    .sidebar-logo img {
      width: 120px;
      margin-bottom: 20px;
    }

    /* Welcome Text */
    .welcome-text {
      font-size: 1.2rem;
      font-weight: 700;
      margin-bottom: 30px;
      text-align: center;
    }

    /* Sidebar Links */
    .nav-links {
      width: 100%;
    }

    .nav-links a {
      display: flex;
      align-items: center;
      padding: 15px 20px;
      color: #ffffff;
      text-decoration: none;
      font-size: 1rem;
      transition: background-color 0.3s;
      border-left: 4px solid transparent;
    }

    .nav-links a:hover {
      background-color: #34495e;
      border-left: 4px solid #e74c3c;
    }

    .nav-links a i {
      margin-right: 10px;
    }

    /* Main Content */
    .main-content {
      flex-grow: 1;
      padding: 20px;
      background-color: #f7f8fc;
      overflow-y: auto;
    }

    /* Card Container */
    .card-container {
      display: flex;
      flex-direction: column;
      gap: 20px;
    }

    /* Top Card with Welcome and Search */
    .top-card {
      display: flex;
      align-items: center;
      justify-content: space-between;
      background-color: #ffffff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
    }

    .top-card h2 {
      font-size: 1.5rem;
      color: #2c3e50;
    }

    .top-card .search-bar {
      display: flex;
      align-items: center;
      background-color: #f0f0f0;
      padding: 5px 10px;
      border-radius: 5px;
    }

    .top-card .search-bar input {
      border: none;
      background: transparent;
      outline: none;
      padding: 5px;
    }

    .top-card .search-bar i {
      color: #888;
    }

    .top-card .bell-icon {
      margin-left: 20px;
      color: #2c3e50;
      cursor: pointer;
      font-size: 1.5rem;
    }

    /* Main Content Card */
    .main-card {
      background-color: #ffffff;
      border-radius: 10px;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
      padding: 20px;
      margin-top: 10px;
      transition: transform 0.2s ease, width 0.2s ease;
    }

    .main-card h2 {
      font-size: 1.5rem;
      margin-bottom: 10px;
      color: #2c3e50;
    }

    .main-card p {
      font-size: 1rem;
      color: #333;
    }

    .button-primary {
      background-color: #e74c3c;
      color: #ffffff;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      font-size: 1rem;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    .button-primary:hover {
      background-color: #c0392b;
    }

    /* Main Content Card Styling */
    .main-card {
      background-color: #ffffff;
      border-radius: 10px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); /* Increased shadow for depth */
      padding: 30px; /* Added more padding for better spacing */
      margin-top: 20px; /* More space between elements */
      transition: transform 0.2s ease, width 0.2s ease;
      width: 100%;
      max-width: 600px; /* Restricts width for larger screens */
      margin-left: auto; /* Centers the card horizontally */
      margin-right: auto; /* Centers the card horizontally */
    }

    /* Title in main card */
    .main-card h2 {
      font-size: 1.8rem;
      margin-bottom: 20px;
      color: #2c3e50;
      text-align: center;
    }

    /* Form Label */
    .main-card label {
      display: block;
      font-size: 1rem;
      color: #2c3e50;
      margin-bottom: 5px;
      margin-top: 15px;
    }

    /* Form Input Fields */
    .main-card input[type="text"],
    .main-card input[type="password"] {
      width: 100%;
      padding: 12px 15px;
      margin-top: 5px;
      font-size: 1rem;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #f9f9f9;
      color: #2c3e50;
      outline: none;
      transition: border-color 0.3s ease;
    }

    .main-card input[type="text"]:focus,
    .main-card input[type="password"]:focus {
      border-color: #e74c3c; /* Focus effect with red border */
    }

    /* Submit Button */
    .main-card button {
      background-color: #e74c3c;
      color: #ffffff;
      border: none;
      padding: 12px 20px;
      border-radius: 5px;
      font-size: 1rem;
      cursor: pointer;
      transition: background-color 0.3s ease;
      width: 100%;
      margin-top: 20px;
    }

    .main-card button:hover {
      background-color: #c0392b; /* Darker red on hover */
    }
    
    /* Popup (Modal) Styles */
    .popup {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.5);
      display: none;
      justify-content: center;
      align-items: center;
    }

    .popup-content {
      background-color: white;
      padding: 20px;
      border-radius: 5px;
      text-align: center;
      width: 300px;
    }

    .close {
      color: #aaa;
      font-size: 28px;
      font-weight: bold;
      position: absolute;
      top: 10px;
      right: 20px;
    }

    .close:hover,
    .close:focus {
      color: black;
      text-decoration: none;
      cursor: pointer;
    }
  </style>
</head>
<body>
  <!-- Sidebar -->
  <%@include file="adminnavbar.jsp" %>

  <!-- Main Content -->
  <div class="main-content">
    <div class="card-container">
      <!-- Top Card -->
      <div class="top-card">
        <h2>Hello, Username</h2>
        <div class="search-bar">
          <input type="text" placeholder="Search...">
          <i class="fas fa-search"></i>
        </div>
        <div class="bell-icon">
          <i class="fas fa-bell"></i>
        </div>
      </div>

      <!-- Success/Error Message Popup -->
      <c:if test="${not empty successMessage}">
    <script type="text/javascript">
        alert("${successMessage}");
    </script>
</c:if>

<c:if test="${not empty errorMessage}">
    <script type="text/javascript">
        alert("${errorMessage}");
    </script>
</c:if>


      <!-- Form Card to Add Admin -->
      <div class="main-card">
        <h2>Add Admin</h2>
        <form action="/addadmin" method="POST">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required />
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required />
            </div>
            <button type="submit" class="button-primary">Add Admin</button>
        </form>
      </div>
    </div>
  </div>

  <!-- Font Awesome Icons (for sidebar icons) -->
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
