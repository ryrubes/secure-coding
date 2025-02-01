

<?php
// Vulnerable: Including user input directly without validation
$page = $_GET['page'];
include($page . ".php");
?>
