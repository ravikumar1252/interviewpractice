<!DOCTYPE html>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html lang="en">
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
</head>
<body>
<div class="container">
        <h1>Add New Person</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>ID:</td>   
          <td><form:input path="id"  /></td>  
         </tr>    
         <tr>    
          <td>ADDRESS:</td>    
          <td><form:textarea path="address" /></td>  
         </tr>   
         <tr>    
          <td>AGE:</td>    
          <td><form:textarea path="age" /></td>  
         </tr>
          <tr>    
          <td>NAME:</td>    
          <td><form:textarea path="name" /></td>  
         </tr>
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save/update" /></td>
          <a href="getAllPersons">All Persons</a>  
              
         </tr>    
        </table>    
       </form:form>    
</div>
</body>
</html>      