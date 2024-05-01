<?php
session_start(); // Start the session

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Include the database connection file
    include 'database.php';

    // Get the entered email and password from the form
    $email = $_POST['email'];
    $password = $_POST['password'];

    // Sanitize the input
    $email = mysqli_real_escape_string($mysqli, $email);

    // Query to fetch user details based on email
    $query = "SELECT * FROM admins WHERE email='$email'";
    $result = mysqli_query($mysqli, $query);

    if (mysqli_num_rows($result) == 1) {
        // User found, verify password
        $row = mysqli_fetch_assoc($result);
        if (password_verify($password, $row['password'])) {
            // Password is correct, set session variables
            $_SESSION['user_id'] = $row['id'];
            $_SESSION['user_email'] = $row['email'];
            // Redirect to dashboard or any other page after successful login
            header("Location: home.php");
            exit();
        } else {
            // Password is incorrect
            $error = "Invalid password. Please try again.";
        }
    } else {
        // User not found
        $error = "No user found with this email. Please sign up.";
    }
}
?>