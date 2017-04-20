<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>图书展示</title>
</head>
<body>
  <h1>Book Show</h1>
  <a href="<c:url value="/books" />">Books</a>
  <hr/>
  ISBN: <c:out value="${book.isbn}" /><br/>
  NAME: <c:out value="${book.name}" /><br/>
  PRICE: <c:out value="${book.price}" /><br/>
</body>
</html>
