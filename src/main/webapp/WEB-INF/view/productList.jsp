<jsp:include page="menu.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<h3 style="color: red">${msg}</h3>
	<table style="margin-top: 20px" class="table table-dark">
		<thead>
		 <tr>
      <th scope="col">Product Id</th>
      <th scope="col">Product Name</th>
        <th scope="col">Product Price</th>
      <th scope="col">Product Expiry Date</th>
         <th scope="col">Action</th>
      
  
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${product}" var="product">
    <tr>
       <td><c:out value="${product.productId}"></c:out></td>
      <td><c:out value="${product.productName}"></c:out></td>
      <td><c:out value="${product.productPrice}"></c:out></td>
      <td><c:out value="${product.productExpiryDate}"></c:out></td>
     
      <td><a href="editProduct?productId=${product.productId}">Edit</a>&emsp;<a href="deleteProduct?productId=${product.productId}">Delete</a></td>
    </tr>
    </c:forEach>
 
  </tbody>
</table>

</body>