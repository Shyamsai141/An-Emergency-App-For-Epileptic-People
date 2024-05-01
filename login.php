<?php
$is_invalid = false;

if ($_SERVER["REQUEST_METHOD"] === "POST") {

  $mysqli = require __DIR__ . "/database.php";

  $sql = sprintf("SELECT * FROM user WHERE email = '%s'", $mysqli->real_escape_string($_POST["email"]));

  $result = $mysqli->query($sql);

  if ($result === false) {
    // Handle query error
    echo "Error: " . $mysqli->error;
    exit;
  }

  $user = $result->fetch_assoc();

  if ($user) {

    if (password_verify($_POST["password"], $user["password_hash"])) {

      session_start();

      $_SESSION["user_id"] = $user["id"];

      header("Location: home.php");
      exit;
    }
  }
  $is_invalid = true;
}
?>

<span style="font-family: verdana, geneva, sans-serif">
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <title>Login</title>
    <link rel="stylesheet" href=" style.css" />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet" />
  </head>

  <body>
    <div class="login-box">
      <h1 class="login">Login</h1>
      <?php if ($is_invalid): ?>
        <em style="color: red; margin-left:20px;">Invalid credentials!</em>
      <?php endif; ?>
      <form name="form" onsubmit="return isvalid()" method="POST">
        <label>Email</label>
        <input type="email" name="email" value="<?= htmlspecialchars($_POST["email"] ?? "") ?>" />
        <label>Password</label>
        <input type="password" name="password" />
        <input class="submit-btn" type="submit" value="login" name="submit" />
      </form>
    </div>
    <p class="para-2">
      Not have an account? <a href="signup.php">Sign Up Here</a>
    </p>
    <script>
      function isvalid() {
        var email = document.form.email.value;
        var pass = document.form.password.value;
        if (email.length == "" && pass.length == "") {
          alert("Email and password field is empty!!!");
          return false;
        }
        else if (email.length == "") {
          alert("Email is empty!!!");
          return false;
        }
        else if (pass.length == "") {
          alert("Password field is empty!!!");
          return false;
        }

      }
    </script>
  </body>

  </html>
</span>