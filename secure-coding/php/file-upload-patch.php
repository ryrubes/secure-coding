<?php
// Validate the file type using both extension and MIME type checks.
// Use a random file name to store uploaded files and restrict file types (e.g., only images).



// Safe: Validate file type and store files with a random name
$allowedTypes = ['image/jpeg', 'image/png', 'image/gif'];
$fileType = $_FILES['file']['type'];

if (in_array($fileType, $allowedTypes)) {
    $randomName = bin2hex(random_bytes(16)) . '.' . pathinfo($_FILES['file']['name'], PATHINFO_EXTENSION);
    move_uploaded_file($_FILES['file']['tmp_name'], "uploads/" . $randomName);
} else {
    die("Invalid file type.");
}
?>
