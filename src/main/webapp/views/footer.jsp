<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* Footer */
.footer {
  background-color: #333;
  color: #ffffff;
  padding: 20px 0;
  font-size: 0.9rem;
}

.footer-container {
  max-width: 1200px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  padding: 0 20px;
}

.footer-section {
  flex: 1;
  min-width: 200px;
  margin-bottom: 20px;
}

.footer-section h3 {
  color: #d9534f; /* Match button color */
  margin-bottom: 10px;
}

.footer-section p, .footer-section ul, .footer-section a {
  color: #ffffff;
  text-decoration: none;
}

.footer-section ul {
  list-style: none;
  padding: 0;
}

.footer-section ul li {
  margin-bottom: 5px;
}

.footer-section a {
  color: #ffffff;
  transition: color 0.3s;
}

.footer-section a:hover {
  color: #d9534f;
}

.footer-bottom {
  text-align: center;
  padding: 10px;
  border-top: 1px solid #444;
  color: #aaaaaa;
  font-size: 0.8rem;
}

/* Social Icons */
.footer-section.social a {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 5px;
}

.footer-section.social a i {
  font-size: 1.2rem;
}

/* Responsive Footer */
@media (max-width: 768px) {
  .footer-container {
    flex-direction: column;
    text-align: center;
  }
}

</style>
</head>
<body>
<!-- Footer -->
<footer class="footer">
  <div class="footer-container">
    <div class="footer-section about">
      <h3>About Us</h3>
      <p>Your donations make a real difference in the lives of those in need. Thank you for supporting our mission to create a better world for everyone.</p>
    </div>
    <div class="footer-section links">
      <h3>Quick Links</h3>
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#donate">Donate</a></li>
        <li><a href="#process">Process</a></li>
        <li><a href="#contact">Contact</a></li>
      </ul>
    </div>
    <div class="footer-section social">
      <h3>Follow Us</h3>
      <a href="#"><i class="fab fa-facebook-f"></i> Facebook</a>
      <a href="#"><i class="fab fa-twitter"></i> Twitter</a>
      <a href="#"><i class="fab fa-instagram"></i> Instagram</a>
      <a href="#"><i class="fab fa-linkedin-in"></i> LinkedIn</a>
    </div>
  </div>
  <div class="footer-bottom">
    &copy; 2024 Donate Today | All Rights Reserved
  </div>
</footer>

</body>
</html>