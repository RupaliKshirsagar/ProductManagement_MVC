<%
 String username=(String)session.getAttribute("username");
if(username==null){
	request.setAttribute("msg", "Please Login First !!");
	RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
}

%>

<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">JBK</a>
            <!-- <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button> -->
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="homePage">Home <span class="sr-only">(current)</span></a>
                </li>
                <%
                String role=(String)session.getAttribute("userRole");
                if(role.equals("Admin")){
                	%>
                	<li class="nav-item">
                  <a class="nav-link" href="addUserPage">Add User</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="importUsersPage">Import Users</a>
                </li>
                <% 
                }
                
                %>
                
                
                
                <li class="nav-item">
                  <a class="nav-link" href="addProductPage">Add Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="userList">User List</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="productList">Product List</a>
                  </li>
                   <li class="nav-item">
                  <a class="nav-link" href="importProductsPage">Import Products</a>
                </li>
                  <li class="nav-item">
                    <a class="nav-link" href="getProfile?username=<%=session.getAttribute("username") %>"><%=session.getAttribute("username") %></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="logoutUser">Logout</a>
                  </li>
              </ul>
            </div>
          </nav>
    </body>
</html>