<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>新建图书</title>
</head>
<body>
  <h1>Book New</h1>
  <a href="<c:url value="/books" />">Books</a>
  <hr/>
  <sf:form method="post" action="/books" acceptCharset="utf-8" commandName="book">
      <div>
        ISBN: <sf:input path="isbn" />
      </div>
      <div>
        Title: <sf:input path="name" />
      </div>
      <div>
        Price: <sf:input path="price" />
      </div>
      <div>
        <input type="submit" vallue="Save" />
      </div>
  </sf:form>
</body>
</html>
