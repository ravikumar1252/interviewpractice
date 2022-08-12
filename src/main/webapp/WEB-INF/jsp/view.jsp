
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Person List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>address</th><th>age</th><th>name</th>
<th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="personDetails" items="${list}">   
   <tr>  
   <td>${personDetails.id}</td>  
   <td>${personDetails.address}</td>  
   <td>${personDetails.age}</td>
   <td>${personDetails.name}</td>  
  
    
   <td><a href="person/getAllPersons/getPersonById/${person.personId}"><button
    type="button" class="btn btn-info btn-lg">view/edit</button></a></td>
    <td><a href="deletePerson/${person.personId}"><button
    type="button" class="btn btn-info btn-lg">Delete</button></a></td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="indexpage">Add New Person</a>