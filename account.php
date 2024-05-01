<?php
session_start();

if (isset($_SESSION["user_id"])) {

  $mysqli = require __DIR__ . "/database.php";

  $sql = "SELECT * FROM user
          WHERE id = {$_SESSION["user_id"]}";

  $result = $mysqli->query($sql);

  $user = $result->fetch_assoc();
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Profile</title>

  <style>
    body {
      margin: 0;
      background-color: whitesmoke;
    }

    .profile-box {
      background-color: rgba(46, 139, 86, 0.815);
      padding: 30px;
      text-align: center;
    }

    .profile-details {
      display: flex;
      flex-direction: column;
      background-color: white;
      padding: 50px 700px 50px 50px;
      box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.15);
    }

    .name,
    .address,
    .contact,
    .contact-mobile {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
    }

    .address,
    .contact,
    .contact-mobile,
    .logout-box {
      margin-top: 30px;
    }

    .inputs {
      font-size: 18px;
      color: black;
      padding: 5px 100px 5px 10px;
    }
  </style>
</head>

<body>

  <?php if (isset($_SESSION["user_id"])): ?>

    <div class="profile-box">
      <h1 class="profile-title" style="
          color: white;
          font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
            'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
            margin-top:0;margin-bottom:0;
        ">
        Profile
      </h1>
    </div>
    <div class="profile-details">
      <div class="name">
        <h3 style="
            margin-top: 0;
            margin-bottom: 0;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
              'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
          " class="hospital-name">
          Hospital Name:
        </h3>
        <input class="inputs" type="text" placeholder="<?= htmlspecialchars($user["name"]) ?>" readonly />
      </div>
      <div class="address">
        <h3 style="
            margin-top: 0;
            margin-bottom: 0;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
              'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
          " class="hospital-address">
          Hospital Address:
        </h3>
        <input class="inputs" type="text" placeholder="14th Cross Road, E-city" readonly />
      </div>
      <div class="contact">
        <h3 style="
            margin-top: 0;
            margin-bottom: 0;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
              'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
          " class="hospital-contact">
          Contact phone:
        </h3>
        <input class="inputs" type="text" placeholder="080-123-4567" readonly />
      </div>
      <div class="contact-mobile">
        <h3 style="
            margin-top: 0;
            margin-bottom: 0;
            font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
              'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
          " class="hospital-contact">
          Contact mail:
        </h3>
        <input class="inputs" type="text" placeholder="<?= htmlspecialchars($user["email"]) ?>" readonly />
      </div>
      <div class="logout-box">
        <button onclick="window.location.href='logout.php';"
          style="background-color:rgba(46, 139, 86, 0.815); font-size:18px; color:white; cursor:pointer; border-radius:8px; font-weight:bold; border:none; padding-top:10px; padding-bottom:10px; padding-right:15px; padding-left:15px;">logout</button>
      </div>
    </div>

  <?php else: ?>

    <p>session timedout</p>
    <p>please <a href="login.php">Log in</a> or <a href="signup.php">sign up</a></p>


  <?php endif; ?>

</body>

</html>