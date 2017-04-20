<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>图书列表</title>
</head>
<body>
   <h1>Book Index</h1>
   <a href="<c:url value="/books/new" />">New Book</a>
   <hr/>
   <c:forEach items="${bookList}" var="book" >
      <span><c:out value="${book.name}" /></span>
      <span><c:out value="${book.isbn}" /></span>
      <span><c:out value="${book.price}" /></span>
      <a href="<c:url value="/books/${book.isbn}" />"><c:out value="${book.isbn}"/></a>
      <sf:form method="post" action="/books/${book.isbn}">
          <input type="hidden" name="_method" value="DELETE"/>
          <input type="submit" value="Delete" />
      </sf:form>
      <br/>
   </c:forEach>
</body>
</html>
