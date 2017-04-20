<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<body>
  <h2>欢迎</h2>
  <hr/>
  <h4>${hello}</h4>
  <a href="<c:url value="/books" />">Books</a>
  <a href="<c:url value="/books/new" />">New Book</a>
</body>
</html>
