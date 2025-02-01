<?php
// If an application allows users to upload files, and the application doesn't properly check the file type or validate the uploaded files, attackers may upload malicious scripts (such as PHP files) that can be executed on the server.


// Vulnerable: No validation on the uploaded file
if (isset($_FILES['file'])) {
    move_uploaded_file($_FILES['file']['tmp_name'], "uploads/" . $_FILES['file']['name']);
}
?>
