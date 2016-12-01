<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        body {
            background-color: #F0FFF0;
        }

        h1 {

            text-align: center;
        }

        input[type=text] {

            margin-bottom: 2%;
        }

        #input {
            width: 300px;
        }

        p {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Please, enter the absolute path of log file</h1>

<form action="/webapi/results" method="GET">
    <p>
        Path: <input type="text" id="input" name="path" required /><br>
        <button type="submit" id="btn">SUBMIT</button></p>
</form>

</body>
</html>
