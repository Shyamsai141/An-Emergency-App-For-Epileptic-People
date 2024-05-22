<?php
require 'connection.php'; // Using the connection.php file for database connection

// Check if the request method is POST
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Retrieve data from POST request
    $name = $_POST['name'];
    $mobile = $_POST['mobile'];
    $location = $_POST['location'];

    // Prepare and bind
    $stmt = $conn->prepare("INSERT INTO sos_requests (name, mobile, location) VALUES (?, ?, ?)");
    $stmt->bind_param("sss", $name, $mobile, $location);

    // Execute the statement
    if ($stmt->execute()) {
        echo "SOS request sent successfully";
    } else {
        echo "Error: " . $stmt->error;
    }

    // Close connections
    $stmt->close();
    $conn->close();
} else {
    echo "Invalid request method.";
}
?>