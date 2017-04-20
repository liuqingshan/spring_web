<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>编辑图书</title>
</head>
<body>
  <h1>Book Edit</h1>
  <a href="<c:url value="/books" />">Books</a>
  <hr/>
  <sf:form method="post" action="/books/${book.isbn}" acceptCharset="utf-8" commandName="book">
      <input type="hidden" name="_method" value="put" />
      <div>
        Title: <sf:input path="name" />
          <sf:errors path="name" />
      </div>
      <div>
        Price: <sf:input path="price" />
          <sf:errors path="price"/>
      </div>
      <div>
        <input type="submit" vallue="Save" />
      </div>
  </sf:form>
</body>
</html>
