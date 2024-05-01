<span style="font-family: verdana, geneva, sans-serif">
  <!DOCTYPE html>
  <html lang="en">

  <head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="style.css" />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap" rel="stylesheet" />
  </head>

  <body>
    <div class="signup-box">
      <h1 class="signup">Sign Up</h1>
      <form action="signup_activity.php" method="POST" novalidate>
        <label>Hospital Name</label>
        <input type="text" name="name" />
        <label>Email</label>
        <input type="email" name="email" />
        <label>Password</label>
        <input type="password" name="password" />
        <label>Confirm Password</label>
        <input type="password" name="password_confirmation" />
        <input class="submit-btn" type="submit" value="sign up" name="submit" />
      </form>
      <p>
        By clicking the Sign Up button,you agree to our
        <a href=" #">Terms and Condition</a>
      </p>
    </div>
    <p class="para-2">
      Already have an account? <a href="login.php">Login here</a>
    </p>
  </body>

  </html>
</span>