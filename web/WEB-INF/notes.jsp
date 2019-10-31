<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notes</title>
    </head>
    <body>
        <h1>Notes!</h1>
        <form action="notes" method="post">
            <table>
                <tr>
                    <th style="centered"><b>Date Created</b></th>
                    <th style="centered"><b>Title</b></th>
                    <th style="centered"></th>
                </tr>
                <c:forEach items="${notes}" var="note">
                    <tr>
                        <td>${note.datecreated}</td>
                        <td>${note.title}</td>
                        <td><input type="submit" value="Edit"></td>
                    </tr>
                </c:forEach>
                    <input type="hidden" name="action" value="edit">
            </table>
        </form>
    </body>
</html>
