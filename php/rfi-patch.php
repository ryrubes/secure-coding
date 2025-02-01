

<?php
// Never include files based on user input directly. Use whitelists and validate inputs properly.
// Disable allow_url_include in php.ini.


// Safe: Whitelist file names and validate input
$allowed_pages = ['home', 'about', 'contact'];

$page = $_GET['page'];
if (in_array($page, $allowed_pages)) {
    include($page . ".php");
} else {
    die("Invalid page.");
}
?>
