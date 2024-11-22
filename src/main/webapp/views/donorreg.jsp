<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Donor Register Page</title>
    <style>
        /* CSS styles for the register page */
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: linear-gradient(to right, #f0f4f8, #e1f5fe);
        }
        .container {
            display: flex;
            max-width: 800px;
            width: 100%;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            align-items: center;
        }
        .register-image {
            width: 50%;
            background-image: url('path/to/your/image.jpg'); /* Replace with the actual path to your image */
            background-size: cover;
            background-position: center;
        }
        .register-container {
            width: 50%;
            padding: 40px;
            text-align: center;
            min-height: 500px;
        }
        .register-container h2 {
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
        .form-group input,
        .form-group select,
        .form-group textarea {
            width: 100%;
            padding: 10px 10px 10px 40px;
            font-size: 16px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .form-group textarea {
            resize: none;
        }
        .btn-register {
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
        .btn-register:hover {
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
        <div class="register-image"></div>
        <div class="register-container">
            <h2>Register as a Donor</h2>
            <form action="/donorregister" method="post">
                <div class="form-group">
                    <i>&#128100;</i>
                    <input type="text" name="dname" placeholder="Your Name" required>
                </div>
                <div class="form-group">
                    <i>&#128101;</i> <!-- Gender icon -->
                    <select name="dgender" required>
                        <option value="">Select Gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <i>&#128197;</i> <!-- DOB icon -->
                    <input type="date" name="ddob" required>
                </div>
                <div class="form-group">
                    <i>&#9993;</i>
                    <input type="email" name="demail" placeholder="Your Email" required>
                </div>
                <div class="form-group">
                    <i>&#128274;</i>
                    <input type="password" name="dpwd" placeholder="Your Password" required>
                </div>
                <div class="form-group">
                    <i>&#127968;</i>
                    <input type="text" name="dlocation" placeholder="Your Address" required>
                </div>
                <div class="form-group">
                    <i>&#128241;</i>
                    <input type="tel" name="dcontact" placeholder="Your Contact Number" required>
                </div>
               
                
                <button type="submit" class="btn-register" value="Register">Register</button>
            </form>
            <div class="link-container">
                <p>Already have an account? <a href="donorlogin.jsp">Log in</a></p>
            </div>
        </div>
    </div>
    
    
</body>
</html>
