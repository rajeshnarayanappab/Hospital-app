<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

    <style>
        ul {
          list-style-type: none;
          margin: 0;
          padding: 0;
          overflow: hidden;
          background-color: rgb(117, 116, 116);
        }
        
        li {
          float: left;
        }
        
        li a {
          display: block;
          color: white;
          text-align: center;
          padding: 14px 16px;
          text-decoration: none;
        }
        
        li a:hover {
          background-color: rgb(0, 0, 0);
        }
        

        </style>
        </head>
             
        <ul>
          <li><a href="create_person.jsp">Create Person</a></li>
          <li style="float:right"><a class="active" href="display">View Person</a></li>
          <li style="float:right"><a href="logout">Logout</a></li>
          
        </ul>
</body>
</html>