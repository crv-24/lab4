<%@ palbum contentType="text/html; charset=UTF-8" palbumEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>music List</title>
    <style>
        /* Добавить стили для заголовков */

        h2 {
            font-size: 24px;
        }

        /* Добавить стили для формы */

        form {
            margin-bottom: 20px;
        }

        label {
            display: inline-block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 7px 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Добавить стили для таблицы */

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th,
        td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Добавить стили для ссылок */

        a {
            color: #4CAF50;
            text-decoration: none;
        }

        a:hover {
            color: #45a049;
        }

    </style>
</head>
<body>
<h2>Add music</h2>
<form action="insert" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" required><br>
    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br>
    <label for="album">Album:</label>
    <input type="text" id="album" name="album" required><br>
    <label for="country">Country:</label>
    <input type="text" id="country" name="country" required><br>
    <input type="submit" value="Add">
</form>
<h2>music List</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Year</th>
        <th>Album</th>
        <th>Country</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="music" items="${musics}">
        <tr>
            <td>${music.id}</td>
            <td>${music.name}</td>
            <td>${music.author}</td>
            <td>${music.year}</td>
            <td>${music.album}</td>
            <td>${music.country}</td>
            <td>
                <a href="edit?id=${music.id}">Edit</a> |
                <a href="delete?id=${music.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
