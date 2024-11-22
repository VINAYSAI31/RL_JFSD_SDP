 	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Role</title>
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        background-color: #f4f4f9;
        margin: 0;
    }
    h1 {
        margin-bottom: 10px;
    }
    .role-selection {
        text-align: center;
        margin-bottom: 20px;
    }
    .cards {
        display: flex;
        justify-content: center;
        gap: 20px;
        flex-wrap: wrap;
    }
    .card {
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        background-color: #fff;
        width: 200px;
        text-align: center;
    }
    .card img {
        width: 100%;
        height: auto;
        border-radius: 5px;
    }
    .card button {
        padding: 10px;
        margin-top: 10px;
        font-size: 16px;
        cursor: pointer;
        border: none;
        border-radius: 5px;
        color: #fff;
    }
    .donor-btn { background-color: #3498db; }
    .org-btn { background-color: #e67e22; }
    .admin-btn { background-color: #e74c3c; }
</style>
</head>
<body>
<%@include file="homenavbar.jsp" %>
    <h1>Reilie</h1>
    <h2>Select Your Role</h2>
    <div class="cards">
        <div class="card">
            <img src="path/to/donor-image.jpg" alt="Donor">
            <h3>Donor</h3>
            <button class="donor-btn" onclick="location.href='donorlogin.jsp'">Select Donor</button>
        </div>
        <div class="card">
            <img src="path/to/org-image.jpg" alt="Organization">
            <h3>Organization</h3>
            <button class="org-btn" onclick="location.href='orglogin.jsp'">Select Organization</button>
        </div>
        <div class="card">
            <img src="path/to/admin-image.jpg" alt="Admin">
            <h3>Admin</h3>
            <button class="admin-btn" onclick="location.href='adminlogin.jsp'">Select Admin</button>
        </div>
    </div>
</body>
</html>
