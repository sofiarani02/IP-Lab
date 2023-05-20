<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>💻IPL_9</title>
</head>
<body>
    <div>
        <h1>
            Welcome to PHP <hr>
        </h1>
    </div>
    <div class="jsp">
        <p style="font-size: medium;font-family: 'Courier New', Courier, monospace;">Select back Option below</p>
        <form action="p9b.php" method="GET">
            <button type="submit">Back</button>
        </form>
    </div>
    <?php
        $message = "Hello LICET";
        echo "<h1>$message</h1>";
        $data = array(
            "name" => "John Doe",
            "country" => 25,
            "role" => "New York"
        );
        echo "<h2>Associative Array:</h2>";
        echo "<ul>";
        foreach ($data as $key => $value) {
            echo "<li>$key: $value</li>";
        }
        echo "</ul>";
    ?>
</body>
</html>