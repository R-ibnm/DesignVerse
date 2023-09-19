<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/include/css.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,
initial-scale=1.0" />

<title>List of users</title>


<!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light fixed-top shadow py-lg-0 px-4 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
        <a href="<%= request.getContextPath() %>/Controller/homeAdmin" class="navbar-brand d-block d-lg-none">
            <h1 class="text-primary">DesignVerse Admin Space</h1>
        </a>
        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between py-4 py-lg-0" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-0">
                <a href="<%= request.getContextPath() %>/Controller/" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Home</a>                
                <div class="dropdown-menu rounded-0 shadow-sm border-0 m-0">
                <a href="<%= request.getContextPath() %>/index" class="dropdown-item">Connect as a normal user</a>
           </div> 
            <a href="" class="nav-item nav-link">Evaluations</a>
            </div>
            <a href="<%= request.getContextPath() %>/Controller/homeAdmin"  class="navbar-brand bg-primary py-2 px-4 mx-3 d-none d-lg-block">
                <h1 class="text-white">DesignVerse Admin Space</h1>
            </a>
            <div class="navbar-nav me-auto py-0">

                
                <a href="contact.html" class="nav-item nav-link">Update Contact</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Profil</a>
                    <div class="dropdown-menu rounded-0 shadow-sm border-0 m-0">
                        <a href="feature.html" class="dropdown-item">Edit profil</a>
                         <a href="<%= request.getContextPath() %>/Controller/" class="dropdown-item">Logout</a>

                    </div>
                </div>
            </div>
            
        </div>
    </nav>
    <!-- Navbar End -->
</head>
<body>
	<section class="section1">
     
          <h4 class="display-6 mb-5">List Of Users</h4> 
       
           
	              <div class="container">
            <div class="row g-3"> 
       		<c:forEach var="user" items="${listUsers}" >
          
        	
            <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="row g-3 img-twice position-relative h-100">
            <div class="col-6"> 
			<div class="testimonial-item bg-white p-4">
		         <div class="d-flex align-items-center mb-4">
		           <img class="btn btn-square btn-outline-primary rounded-circle me-2" data-bs-toggle="dropdown" src="${pageContext.request.contextPath}/template/img/perso.jpg" alt="">
					<div class="ms-4">
		                     <h5 class="mb-1">${user.last_name} ${user.first_name}</h5>
		               </div>
		                    </div>

                    <p class="mb-0">User_Name  : ${user.username}</p>
                    <p class="mb-0">Email      : ${user.email}</p>
                    <p class="mb-0">Type User  : ${user.typeU}</p>
               
		                <div class="service-overlay d-flex align-items-center mb-4" >
		                &nbsp &nbsp
			        	<a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa text-primary">Modify</i></a>
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			        	<a class="btn btn-lg-square btn-outline-light rounded-circle" href="<%= request.getContextPath() %>/Controller/deleteUser?id=${user.user_id}"><i class="fa text-primary">Delete</i></a>
			       		</div>
			       		</div>
			       		</div>
		                    </div>
	       </div>
	   
	  
                </c:forEach> </div>
	    </div>
       
	
	</section> 
</body>
</html>