<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>EpiAdmin</title>
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Madimi+One&family=Montserrat&family=Patrick+Hand&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
    rel="stylesheet" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Madimi+One&family=Montserrat&family=Patrick+Hand&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Timmana&display=swap"
    rel="stylesheet" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Goldman:wght@400;700&family=Madimi+One&family=Montserrat&family=Patrick+Hand&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Timmana&display=swap"
    rel="stylesheet" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Goldman:wght@400;700&family=League+Gothic&family=Madimi+One&family=Montserrat&family=Patrick+Hand&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Timmana&display=swap"
    rel="stylesheet" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Goldman:wght@400;700&family=League+Gothic&family=Madimi+One&family=Montserrat&family=Patrick+Hand&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Timmana&display=swap"
    rel="stylesheet" />
  <style>
    .header {
      background-color: rgb(27, 2, 2);
      display: flex;
      flex-direction: row;
      height: 70px;
      justify-content: space-between;
      align-items: center;
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      z-index: 100;
    }

    .header-title {
      margin-top: 0;
      margin-bottom: 0;
      margin-left: 10px;
      color: greenyellow;
      font-family: "Poppins", sans-serif;
      font-weight: 400;
      cursor: pointer;
    }

    .options {
      margin-right: 10px;
    }

    .about,
    .contact,
    .login,
    .signup {
      padding: 7px 14px 7px 14px;
      border: none;
      font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
        "Lucida Sans", Arial, sans-serif;
      font-size: 18px;
      background-color: white;
      color: black;
      border-radius: 1px;
      font-weight: bold;
      transition: background-color 0.2s, color 0.2s, box-shadow 0.2s,
        border 0.2s;
    }

    .signup:hover {
      background-color: black;
      color: lightgreen;
      border: 2px solid lightgreen;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .login:hover {
      background-color: black;
      color: lightgreen;
      border: 2px solid lightgreen;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .about:hover {
      background-color: black;
      color: lightgreen;
      border: 2px solid lightgreen;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .contact:hover {
      background-color: black;
      color: lightgreen;
      border: 2px solid lightgreen;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .about {
      margin-right: 10px;
      font-family: "Poppins", sans-serif;
      font-weight: 500;
      font-style: normal;
      cursor: pointer;
      padding-right: 24px;
      padding-left: 24px;
    }

    .contact {
      margin-right: 10px;
      font-family: "Poppins", sans-serif;
      font-weight: 500;
      font-style: normal;
      cursor: pointer;
      text-decoration: none;
    }

    .login {
      margin-right: 10px;
      font-family: "Poppins", sans-serif;
      font-weight: 500;
      font-style: normal;
      cursor: pointer;
      padding-right: 25px;
      padding-left: 25px;
    }

    .signup {
      margin-right: 0px;
      font-family: "Poppins", sans-serif;
      font-weight: 500;
      font-style: normal;
      cursor: pointer;
      padding-right: 20px;
      padding-left: 20px;
    }

    .admin {
      color: white;
      font-family: "Poppins", sans-serif;
      font-style: normal;
      font-weight: 100px;
    }

    body {
      padding-top: 60px;
      margin: 0;
      background-color: rgba(255, 255, 255, 0.466);
    }

    .fpic {
      width: 650px;
      height: 500px;
      object-fit: cover;
    }

    .content {
      display: inline-block;
      margin-top: 0;
      margin-bottom: 0;
      position: absolute;
      font-size: 30px;
      width: 600px;
      right: -40px;
      top: 0px;
      font-family: "Poppins", sans-serif;
      font-weight: 400;
      line-height: 50px;
      text-align: center;
      padding-top: 170px;
      padding-bottom: 180px;
      padding-right: 80px;
      padding-left: 50px;
      border: none;
      border-color: rgb(172, 171, 171);
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .first-content {
      position: relative;
      background-color: white;
    }

    .second-content {
      margin-top: 100px;
      display: flex;
      flex-direction: row;
      align-items: center;
    }

    .secondcontent {
      margin-top: 0;
      margin-bottom: 0;
      width: 600px;
      line-height: 50px;
      text-align: center;
      font-size: 30px;
      padding-left: 50px;
      padding-right: 50px;
      font-family: "Poppins", sans-serif;
      font-weight: 400;
      margin-left: 100px;
      padding-top: 50px;
      padding-bottom: 50px;
      border: none;
      border-color: rgb(172, 171, 171);
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .spic {
      width: 350px;
      height: 350px;
      object-fit: cover;
      margin-left: 100px;
      border: 1px solid rgba(0, 0, 0, 0.473);
    }

    .epiapp {
      display: flex;
      flex-direction: row;
      margin-top: 100px;
      align-items: center;
      background-color: white;
    }

    .epify {
      margin-top: 0px;
      margin-bottom: 0px;
      margin-left: 50px;
      margin-right: 100px;
      text-align: center;
      font-size: 30px;
      font-family: "Poppins", sans-serif;
      font-weight: 400;
      width: 600px;
      padding-right: 50px;
      padding-left: 50px;
      line-height: 50px;
      padding-top: 150px;
      padding-bottom: 150px;
      border: none;
      border-color: rgb(172, 171, 171);
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .mapp {
      width: 450px;
      height: 450px;
      margin-left: 110px;
      object-fit: contain;
      border: 1px solid rgba(0, 0, 0, 0.473);
    }

    .contact-data {
      display: flex;
      flex-direction: row;
      background-color: rgb(27, 2, 2);
      margin-top: 500px;
      justify-content: center;
      align-items: center;
      height: 300px;
      position: relative;
    }

    .mails {
      display: flex;
      flex-direction: column;
      color: rgba(255, 255, 255, 0.527);
      font-family: "Poppins", sans-serif;
      justify-content: space-between;
    }

    .mail-heading {
      color: rgba(255, 255, 255, 0.932);
      font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
        "Lucida Sans", Arial, sans-serif;
    }

    .phone {
      margin-left: 150px;
      display: flex;
      flex-direction: column;
      color: rgba(255, 255, 255, 0.527);
      font-family: "Poppins", sans-serif;
    }

    .phone-heading {
      color: rgba(255, 255, 255, 0.932);
      font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
        "Lucida Sans", Arial, sans-serif;
    }

    h2,
    p {
      margin-top: 0;
      margin-bottom: 0;
    }

    .firth-phone,
    .third-phone,
    .second-phone,
    .firth-mail,
    .third-mail,
    .second-mail {
      margin-top: 5px;
    }

    .first-mail,
    .first-phone {
      margin-top: 20px;
    }

    .contact-title {
      position: absolute;
      background-color: rgb(46, 223, 123);
      color: rgba(0, 0, 0, 0.945);
      font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
        sans-serif;
      border: none;
      border-radius: 10px;
      padding: 10px 10px;
      top: -25px;
      left: 20px;
    }

    .page-reloadbtn {
      background-color: transparent;
      border: none;
    }
  </style>
</head>

<body>
  <div class="header">
    <button class="page-reloadbtn" onclick="window.location.href='index.php';">
      <h1 class="header-title">Epi<span class="admin">Admin</span></h1>
    </button>
    <div class="options">
      <a href="#abt"><button class="about">About</button></a>
      <a href="#cnt"><button class="contact">Contact</button></a>
      <button class="login" onclick="window.location.href = 'login.php';">
        Login
      </button>
      <button class="signup" onclick="window.location.href = 'signup.php';">
        Sign up
      </button>
    </div>
  </div>
  <div id="abt" class="first-content">
    <img class="fpic" src="images/fontpicture.webp" alt="error" />
    <p class="content">
      Epilepsy is a condition, not a choice. Understanding, support, and
      compassion can make all the difference.
    </p>
  </div>
  <div class="second-content">
    <p class="secondcontent">
      Our mission as EpiAdmin is to provide comprehensive care for epilepsy
      that focuses on improving quality of life, promoting independence, and
      fostering a sense of community.
    </p>
    <img class="spic" src="images/applogo.jpg" />
  </div>
  <div class="epiapp">
    <img class="mapp" src="images/mapplogo.jpg" />
    <p class="epify">
      If you are a Epifighter, Download our EpiCare app that will help you
      lead a healthier life.
    </p>
  </div>
  <div id="cnt" class="contact-data">
    <div class="mails">
      <h2 class="mail-heading">Mails</h2>
      <p class="first-mail">shyamsai2106@gmail.com</p>
      <p class="second-mail">darshan.rajashekar28@gmail.com</p>
      <p class="third-mail">jk4rthik@gmail.com</p>
      <p class="firth-mail">bhushankapireddy1@gmail.com</p>
    </div>
    <div class="phone">
      <h2 class="phone-heading">Mobile</h2>
      <p class="first-phone">+91 8660469817</p>
      <p class="second-phone">+91 80959 98030</p>
      <p class="third-phone">+91 82969 99989</p>
      <p class="firth-phone">+91 91766 42221</p>
    </div>
    <h2 class="contact-title">Contact Information</h2>
  </div>
</body>

</html>