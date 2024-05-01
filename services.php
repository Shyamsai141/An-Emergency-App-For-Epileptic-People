<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patient status</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }

        header {
            background-color: rgba(46, 139, 86, 0.815);
            color: #fff;
            padding: 15px;
            text-align: center;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th,
        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: rgba(46, 139, 86, 0.815);
            color: #fff;
        }

        #status {
            padding: 5px 10px 5px 10px;
        }

        select,
        option {
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>

<body>

    <header>
        <h1>Patient Service Status</h1>
    </header>

    <div class="container">
        <h2>Patient Details</h2>
        <table id="customerTable">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Status</th>
                </tr>
                <tr>
                    <td>Darshan</td>
                    <td>darshan123@gmail.com</td>
                    <td>+91 80959 98030</td>
                    <td>JP Nagar</td>
                    <td><select id="status" name="status">
                            <option value="Active">Active</option>
                            <option value="Ontheway">On the way</option>
                            <option value="Admitted">Admitted</option>
                            <option value="Discharged">Discharged</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Karthik</td>
                    <td>Karthik123@gmail.com</td>
                    <td>+91 82969 99989</td>
                    <td>Kengeri</td>
                    <td><select id="status" name="status">
                            <option value="Active">Active</option>
                            <option value="Ontheway">On the way</option>
                            <option value="Admitted">Admitted</option>
                            <option value="Discharged">Discharged</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Chaakrika</td>
                    <td>Chaakrika123@gmail.com</td>
                    <td>+91 91766 42221</td>
                    <td>HSR Layout</td>
                    <td><select id="status" name="status">
                            <option value="Active">Active</option>
                            <option value="Ontheway">On the way</option>
                            <option value="Admitted">Admitted</option>
                            <option value="Discharged">Discharged</option>
                        </select></td>
                </tr>
                <tr>
                    <td>Shyam sai</td>
                    <td>shyamsai123@gmail.com</td>
                    <td>+91 8660469817</td>
                    <td>Electronic city</td>
                    <td><select id="status" name="status">
                            <option value="Active">Active</option>
                            <option value="Ontheway">On the way</option>
                            <option value="Admitted">Admitted</option>
                            <option value="Discharged">Discharged</option>
                        </select></td>
                </tr>
            </thead>
        </table>
    </div>

</body>

</html>