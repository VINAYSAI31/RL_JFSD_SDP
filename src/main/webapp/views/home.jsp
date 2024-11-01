<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Donate Today | Make a Difference</title>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
  <style>
    /* General Reset */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    /* Body with Background Image */
    body {
      font-family: 'Roboto', sans-serif;
      overflow-x: hidden;
      background-color: #f7f8fc;
      color: #333;
    }

    /* Navbar */


    /* Hero Section with Background Image */
     .hero-section {
      text-align: center;
      padding: 160px 20px 100px;
      min-height: 95vh; /* Full screen height */
      position: relative;
      background: url('your-background-image.jpg') no-repeat center center/cover;
      color: #ffffff;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      overflow: hidden;
    }

    /* Transparent Overlay */
    .hero-section::before {
      content: '';
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.5); /* Adjust transparency here */
      z-index: 1;
    }

    .hero-content {
      position: relative;
      z-index: 2;
    }

    .hero-content h1 {
      font-size: 2.8rem;
      margin-bottom: 20px;
    }

    .hero-content p {
      font-size: 1.2rem;
      margin-bottom: 30px;
      max-width: 700px;
    }

    .cta-buttons {
      display: flex;
      gap: 20px;
    }

    .cta-btn {
      padding: 15px 30px;
      border-radius: 50px;
      font-size: 1rem;
      font-weight: bold;
      text-decoration: none;
      transition: all 0.3s;
    }

    .primary-btn {
      background-color: #d9534f;
      color: white;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    .primary-btn:hover {
      background-color: #c9302c;
    }

    .secondary-btn {
      background-color: #ffffff;
      color: #d9534f;
      border: 2px solid #d9534f;
    }

    .secondary-btn:hover {
      background-color: #d9534f;
      color: #ffffff;
    }

    /* About Section */
    .about-section {
      padding: 80px 20px;
      background-color: #ffffff;
      text-align: center;
    }

    .about-section h2 {
      font-size: 2rem;
      margin-bottom: 20px;
      color: #d9534f;
    }

    .about-section p {
      font-size: 1.1rem;
      color: #666;
      max-width: 800px;
      margin: 0 auto;
      line-height: 1.6;
    }

    /* Decorative Section Below */
    .decorative-section {
      background: linear-gradient(to right, #f7f8fc, #ffffff);
      padding: 100px 20px;
      text-align: center;
    }

    .decorative-section h2 {
      font-size: 2.5rem;
      color: #d9534f;
      margin-bottom: 20px;
    }

    .decorative-section p {
      font-size: 1.1rem;
      color: #666;
      max-width: 800px;
      margin: 0 auto 30px;
    }

    /* Footer */
    .footer {
      text-align: center;
      padding: 30px 20px;
      background-color: #333;
      color: white;
    }

    /* Responsive Styling */
    @media (max-width: 768px) {
      .hero-content h1 {
        font-size: 2rem;
      }

      .cta-btn {
        font-size: 0.9rem;
        padding: 10px 20px;
      }

      .cta-buttons {
        flex-direction: column;
      }
    }
  </style>
</head>
<body>
  <!-- Navbar -->
<%@include file="homenavbar.jsp" %>

  <!-- Hero Section -->
  <header class="hero-section">
    <div class="hero-content">
      <h1>Make a Difference Today</h1>
      <p>Your generous contribution can bring hope and change lives. Join us in our mission to create a better world.</p>
      <div class="cta-buttons">
        <a href="#" class="cta-btn primary-btn">Donate Now</a>
        <a href="#about" class="cta-btn secondary-btn">Learn More</a>
      </div>
    </div>
  </header>

  <!-- About Section -->
  <section class="about-section" id="about">
    <h2>About Us</h2>
    <p>We are a non-profit organization committed to making a positive impact in the lives of those in need. Our team works tirelessly to address various causes, from poverty and hunger to education and healthcare. With your help, we can reach even more people and provide them with the support they deserve.</p>
  </section>

  <!-- Decorative Section -->
  <section class="decorative-section">
    <h2>Our Mission</h2>
    <p>Our mission is to create sustainable change through impactful initiatives. Every dollar donated goes directly to helping communities in need. Your support fuels our efforts to bring hope, health, and happiness to those who need it most.</p>
    <p><a href="#" class="cta-btn primary-btn">Support Our Mission</a></p>
  </section>

  <!-- Footer -->
  <footer class="footer">
    <p>&copy; 2024 Donate Today. All rights reserved. | Contact us: info@donatetoday.org</p>
  </footer>
</body>
</html>
