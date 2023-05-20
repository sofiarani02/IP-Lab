<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IPL_10💻</title>
</head>
<body>
<?php
$JDBC_DRIVER = "com.mysql.jdbc.Driver";
$DB_HOST = "localhost";
$DB_PORT = 3307;
$DB_NAME = "books";
$DB_USER = "root";
$DB_PASS = "";

// Set response content type
header("Content-Type: text/html");
$out1 = fopen("php://output", "w");

$title = "Welcome to Books Database";

fwrite($out1, "<html>\n");
fwrite($out1, "<head>\n");
fwrite($out1, "<title>$title</title>\n");
fwrite($out1, "</head>\n");
fwrite($out1, "<body bgcolor=\"#f0f0f0\">\n");
fwrite($out1, "<br>\n");
fwrite($out1, "<hr>\n");
fwrite($out1, "<center><h1>$title</h1></center>\n");

try {
    // Create a new MySQLi instance
    $conn = new mysqli($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME, $DB_PORT);

    // Check for connection errors
    if ($conn->connect_error) {
        throw new Exception("Failed to connect to the database: " . $conn->connect_error);
    }

    // Execute SQL query
    $stmt = $conn->prepare("UPDATE book SET Price=? WHERE ID=?");
    $stmt->bind_param("ss", $comnt, $yr);

    $comnt = $_POST['input'];
    $yr = $_POST['id'];
    $stmt->execute();
    $stmt->close();

    $sql = "SELECT * FROM book";
    $result = $conn->query($sql);

    fwrite($out1, "<style> th, td { padding-top: 10px; padding-bottom: 20px; padding-left: 30px; padding-right: 40px; }</style>\n");
    fwrite($out1, "<center><div><table border=\"1\">\n");
    fwrite($out1, "<tr><td> ID </td>");
    fwrite($out1, "<td> Name </td>");
    fwrite($out1, "<td> Author </td>");
    fwrite($out1, "<td> Year </td>");
    fwrite($out1, "<td> Price </td>");
    fwrite($out1, "<td> Edit Price </td></tr>\n");

    if ($result->num_rows > 0) {
        while ($row = $result->fetch_assoc()) {
            $id = $row['ID'];
            $name = $row['Name'];
            $au = $row['Author'];
            $yr = $row['Year'];
            $P = $row['Price'];
            
            fwrite($out1, "<tr><td>$id</td>");
            fwrite($out1, "<td>$name</td>");
            fwrite($out1, "<td>$au</td>");
            fwrite($out1, "<td>$yr</td>");
            fwrite($out1, "<td>$P</td>");
            fwrite($out1, "<td>\n");
            fwrite($out1, "<form action='p10i.php' method='post'>\n");
            fwrite($out1, "<input type='text' name='input'>\n");
            fwrite($out1, "<input type='hidden' name='id' value='$id'>\n");
            fwrite($out1, "<input type='submit' value='UPDATE'>\n");
            fwrite($out1, "</form>\n");
            fwrite($out1, "</td></tr>\n");
        }
    } else {
        fwrite($out1, "<tr><td colspan='5'>No records found.</td></tr>\n");
    }

    fwrite($out1, "</table></div></center>\n");
    fwrite($out1, "<br><br><button id='render-btn' type='submit' onclick='R()'>BACK</button>\n");
    fwrite($out1, "<script>function R() {location.replace('http://localhost/Ex10_b/p10.php')}</script>\n");

    $result->close();
    $conn->close();
} catch (Exception $e) {
    fwrite($out1, "Failed to connect to the database - Error: " . $e->getMessage());
}

fclose($out1);
?>
</body>
</html>