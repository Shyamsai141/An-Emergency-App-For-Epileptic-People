<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Home</title>
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Goldman:wght@400;700&family=League+Gothic&family=Madimi+One&family=Montserrat&family=Oswald:wght@200..700&family=Patrick+Hand&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Timmana&display=swap"
    rel="stylesheet" />
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
    href="https://fonts.googleapis.com/css2?family=Goldman:wght@400;700&family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=League+Gothic&family=Madimi+One&family=Montserrat&family=Oswald:wght@200..700&family=Patrick+Hand&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Timmana&display=swap"
    rel="stylesheet" />
  <style>
    .header {
      display: flex;
      flex-direction: row;
      background-color: white;
      position: fixed;
      top: 0;
      right: 0;
      left: 64px;
      justify-content: space-between;
      align-items: center;
      height: 55px;
      z-index: 100;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    body {
      margin: 100px;
      background-color: whitesmoke;
    }

    .title {
      margin-left: 10px;
      font-family: "Poppins", sans-serif;
      font-weight: 400;
      cursor: pointer;
    }

    .title-admin {
      color: blue;
      margin-top: 0;
      margin-bottom: 0;
      font-weight: 400;
      cursor: pointer;
    }

    .admin-profile {
      height: 25px;
      width: 25px;
      object-fit: cover;
    }

    .profile-button {
      opacity: 0.8;
      position: relative;
      cursor: pointer;
      margin-right: 10px;
      background-color: white;
      border: none;
    }

    .slide-bar {
      position: fixed;
      background-color: white;
      left: 0;
      top: 0;
      bottom: 0;
      display: flex;
      flex-direction: column;
      width: 65px;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .home,
    .support,
    .settings,
    .services {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 70px;
    }

    .menu,
    .serv,
    .set,
    .sup,
    .hom {
      height: 25px;
      width: 25px;
    }

    .home-slidebar,
    .settings-slidebar,
    .support-slidebar,
    .services-slidebar {
      margin-top: 5px;
      margin-bottom: 0;
      font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
      font-weight: 100;
    }

    .menu-button {
      margin-top: 15px;
      margin-bottom: 10px;
      border: none;
      background-color: white;
      cursor: pointer;
      position: relative;
    }

    .home-button,
    .services-button,
    .support-button,
    .settings-button {
      border: none;
      background-color: white;
      cursor: pointer;
      position: relative;
    }

    .home-button:hover {
      background-color: whitesmoke;
    }

    .settings-button:hover {
      background-color: whitesmoke;
    }

    .services-button:hover {
      background-color: whitesmoke;
    }

    .support-button:hover {
      background-color: whitesmoke;
    }

    .sos-accept-button {
      display: grid;
      grid-template-columns: 1fr 1fr;
      column-gap: 20px;
      row-gap: 20px;
    }

    .sos-box {
      background-color: white;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      border-radius: 10px;
      box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.15);
      padding-top: 50px;
      padding-bottom: 50px;
    }

    .request-box {
      background-color: white;
      display: flex;
      flex-direction: column;
      padding-left: 25px;
      padding-right: 25px;
      padding-top: 80px;
      padding-bottom: 80px;
      box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.15);
    }

    .name-box,
    .mobileno-box,
    .address-box {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      font-family: oswald;
    }

    .mobileno-box,
    .address-box {
      margin-top: 60px;
    }

    .toggle-switch {
      position: relative;
      width: 60px;
      height: 34px;
      cursor: pointer;
      margin-bottom: 30px;
    }

    .toggle-switch input {
      opacity: 0;
      width: 0;
      height: 0;
    }

    .slider {
      position: absolute;
      cursor: pointer;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      background-color: #c80000;
      border-radius: 34px;
      transition: 0.4s;
    }

    .slider:before {
      position: absolute;
      content: "";
      height: 26px;
      width: 26px;
      left: 4px;
      bottom: 4px;
      background-color: #ffffff;
      border-radius: 50%;
      transition: 0.4s;
    }

    input:checked+.slider {
      background-color: #2ea44f;
    }

    input:checked+.slider:before {
      transform: translateX(26px);
    }

    .on-text {
      position: absolute;
      top: 50%;
      left: 4px;
      transform: translateY(-50%);
      color: #ffffff;
      font-size: 14px;
      display: none;
    }

    .off-text {
      position: absolute;
      top: 50%;
      right: 4px;
      transform: translateY(-50%);
      color: #ffffff;
      font-size: 12px;
    }

    input:checked+.slider+.on-text {
      display: block;
    }

    input:not(:checked)+.slider+.off-text {
      display: block;
    }

    .services-button:hover .tooltip {
      opacity: 1;
    }

    .services-button .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: 30px;
      top: 50px;
      opacity: 0;
      transition: opacity 0.5s;
      border-radius: 6px;
    }

    .home-button:hover .tooltip {
      opacity: 1;
    }

    .home-button .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: 30px;
      top: 50px;
      opacity: 0;
      border-radius: 6px;
      transition: opacity 0.5s;
    }

    .settings-button:hover .tooltip {
      opacity: 1;
    }

    .settings-button .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: 30px;
      top: 50px;
      opacity: 0;
      border-radius: 6px;
      transition: opacity 0.5s;
    }

    .support-button:hover .tooltip {
      opacity: 1;
    }

    .support-button .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: 30px;
      top: 50px;
      opacity: 0;
      border-radius: 6px;
      transition: opacity 0.5s;
    }

    .profile-button:hover .tooltip {
      opacity: 1;
    }

    .profile-button .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: -10px;
      top: 50px;
      opacity: 0;
      border-radius: 6px;
      transition: opacity 0.5s;
    }

    .menu-button:active .tooltip {
      opacity: 1;
    }

    .menu-button .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: 0;
      top: 0;
      opacity: 0;
      transition: opacity 0.5s;
    }

    .page-reloadbtn {
      background-color: transparent;
      border: none;
    }

    .page-reloadbtn:hover .tooltip {
      opacity: 1;
    }

    .page-reloadbtn .tooltip {
      position: absolute;
      background-color: gray;
      color: white;
      padding: 4px 8px 4px 8px;
      left: 25px;
      top: 63px;
      opacity: 0;
      border-radius: 6px;
      transition: opacity 0.5s;
    }
  </style>
</head>

<body>

  <?php if (isset($_SESSION["user_id"])): ?>

    <div class="header">
      <button class="page-reloadbtn" onclick="window.location.href='home.php';">
        <h1 class="title">Epi<span class="title-admin">Admin</span></h1>
        <div class="tooltip">EpiAdmin home</div>
      </button>
      <button onclick="window.location.href= 'account.php';" class="profile-button">
        <img class="admin-profile" src="images/admin-account.png" alt="error" />
        <div class="tooltip">Profile</div>
      </button>
    </div>
    <div class="slide-bar">
      <button class="menu-button">
        <div class="menu-burger">
          <img class="menu" src="images/menu.png" alt="menu" />
        </div>
        <div class="tooltip">Home</div>
      </button>
      <button class="home-button" onclick="window.location.href='home.php'">
        <div class="home">
          <img class="hom" src="images/home.png" alt="home" />
          <h5 class="home-slidebar">Home</h5>
          <div class="tooltip">Home</div>
        </div>
      </button>
      <button class="services-button" onclick="window.location.href = 'services.php';">
        <div class="services">
          <img class="serv" src="images/services.png" alt="services" />
          <div class="tooltip">Services</div>
          <h5 class="services-slidebar">Services</h5>
        </div>
      </button>
      <button class="settings-button" onclick="window.location.href = 'settings.php';">
        <div class="settings">
          <img class="set" src="images/settings.png" alt="settings" />
          <h5 class="settings-slidebar">Settings</h5>
          <div class="tooltip">Settings</div>
        </div>
      </button>
      <button class="support-button" onclick="window.location.href = 'support.php';">
        <div class="support">
          <img class="sup" src="images/support.png" alt="support" />
          <h5 class="support-slidebar">Support</h5>
          <div class="tooltip">Support</div>
        </div>
      </button>
    </div>
    <div class="sos-accept-button">
      <div class="sos-box">
        <label class="toggle-switch">
          <input type="checkbox" />
          <span class="slider"></span>
          <span class="on-text">ON</span>
          <span class="off-text">OFF</span>
        </label>
        <h2 style="
            margin-top: 0;
            margin-bottom: 0;
            color: green;
            font-family: Poppins, sans-serif;
            font-weight: 600;
            color: black;
            width: 200px;
            text-align: center;
          ">
          Incoming request
        </h2>
      </div>
      <div class="request-box">
        <!-- <h2 class="request-box-title" style="
            margin-top: 50px;
            margin-bottom: 0;
            text-align: center;
            font-family: Poppins;
            font-weight: 600;
            font-style: normal;
          ">
          Request Information
        </h2> -->
        <div class="name-box">
          <h3 style="margin-top: 0; margin-bottom: 0; font-family: Poppins, sans-serif;">Name:</h3>
          <input style="
              padding-right: 200px;
              padding-left: 10px;
              font-size: 15px;
              background-color: rgba(255, 255, 255, 0.514);
              border: 1px solid;
            " type="text" placeholder="John" readonly />
        </div>
        <div class="mobileno-box">
          <h3 style="margin-top: 0; margin-bottom: 0; font-family: Poppins, sans-serif;">Mobile no:</h3>
          <input style="
              padding-right: 200px;
              padding-left: 10px;
              font-size: 15px;
              background-color: rgba(255, 255, 255, 0.514);
              border: 1px solid;
            " type="text" placeholder="1234567890" readonly />
        </div>
        <div class="address-box">
          <h3 style="margin-top: 0; margin-bottom: 0; font-family: Poppins, sans-serif;">location:</h3>
          <input style="
              padding-right: 200px;
              padding-left: 10px;
              font-size: 15px;
              background-color: rgba(255, 255, 255, 0.226);
              border: 1px solid;
            " type="text" placeholder="Location 0" readonly />
        </div>
        <div style="margin-top: 60px; display:flex; justify-content:center;">
          <button style="padding: 6px 12px 6px 12px; cursor:pointer; border-radius: 5px; border:none; font-weight:bold; font-size: 20px; color:white; border-radius:5px; background-color: rgba(46, 139, 86, 0.815);
">Accept</button>
        </div>
      </div>
    </div>

  <?php else: ?>

    <p><a href="login.php">Log in</a> or <a href="signup.php">sign up</a></p>

  <?php endif; ?>


</body>

</html>