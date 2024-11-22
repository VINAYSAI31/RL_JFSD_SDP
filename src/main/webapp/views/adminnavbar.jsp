<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOMhM9BZz/QLV2KJbCw1e7wG1dZF9XZ5HXwnxAVv" crossorigin="anonymous">
<style>
    .sidebar {
        width: 250px;
        background-color: #2c3e50;
        color: #ffffff;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding-top: 60px;
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
        padding: 20px 30px;
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
</style>
</head>
<body>
<div class="sidebar">
    <div class="sidebar-logo">
        <img src="path/to/logo.png" alt="Organization Logo">
    </div>
    <div class="welcome-text">
        Admin
    </div>
    <div class="nav-links">
        <a href="../views/adminhome.jsp"><i class="fas fa-user"></i> My Profile</a>
        <a href="#dashboard"><i class="fas fa-users"></i> Donors</a>
        <a href="#organizations"><i class="fas fa-building"></i> Organizations</a>
        <a href="../views/addadmin.jsp"><i class="fas fa-user-plus"></i> Add Admin</a>
        <a href="#settings"><i class="fas fa-cog"></i> Settings</a>
        <a href="/"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </div>
</div>
</body>
</html>
