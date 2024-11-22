<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Donor Dashboard</title>
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
     h1 {
            color: #333;
            text-align: center;
        }
        .container {
            max-width: 1000px;
            
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .profile-header {
            text-align: center;
            border-bottom: 2px solid #3498db;
            padding-bottom: 20px;
        }
        .profile-header img {
            border-radius: 50%;
            width: 100px;
            height: 100px;
        }
        .profile-header h2 {
            margin: 10px 0;
            color: #3498db;
        }
        .profile-info {
            margin: 20px 0;
        }
        .profile-info div {
            margin-bottom: 10px;
        }
        .donation-history {
            margin: 20px 0;
        }
        .donation-history table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        .donation-history th, .donation-history td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }
        .donation-history th {
            background-color: #3498db;
            color: white;
        }
        .btn {
            padding: 10px 15px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            display: inline-block;
            margin-top: 10px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #2980b9;
        }
  </style>
</head>
<body>
  <!-- Sidebar -->
  <%@include file="donornavbar.jsp" %>

  <!-- Main Content -->
  <div class="main-content">
    <div class="card-container">
      <!-- Top Card -->
      <div class="top-card">
<h2>Hello, ${sessionScope.userName}</h2>
        <div class="search-bar">
          <input type="text" placeholder="Search...">
          <i class="fas fa-search"></i>
        </div>
        <div class="bell-icon">
          <i class="fas fa-bell"></i>
        </div>
      </div>

      <!-- Main Card -->
      <div class="container">
    <div class="profile-header">
        <img src="<%= session.getAttribute("profileImage") %>" alt="Profile Picture">
        <h2>${sessionScope.userName}</h2>
        <p>Email: ${sessionScope.userEmail}</p>
        <p>Member Since: January 2023</p> <!-- You could also dynamically set this if you store the joining date in the session -->
    </div>

    <div class="profile-info">
        <h3>Profile Information</h3>
        <div><strong>Name:</strong> ${sessionScope.userName}</div>
        <div><strong>Email:</strong> ${sessionScope.userEmail}</div>
        <div><strong>Phone:</strong> ${sessionScope.userPhone}</div>
        <div><strong>Address:</strong> ${sessionScope.userAddress}</div>
    </div>

    <div class="donation-history">
        <h3>Donation History</h3>
        <table>
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Organization</th>
                    <th>Amount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="donation" items="${sessionScope.donationHistory}">
                    <tr>
                        <td>${donation.date}</td>
                        <td>${donation.organization}</td>
                        <td>${donation.amount}</td>
                        <td>${donation.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="editProfile.jsp" class="btn">Edit Profile</a>
    </div>
</div>
      
    
      

  <!-- Font Awesome Icons (for sidebar icons) -->
  <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</body>
</html>
