<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Orders </title>
<%@ include file="/WEB-INF/include/css.jsp" %>
      <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light fixed-top shadow py-lg-0 px-4 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
        <a href="index.html" class="navbar-brand d-block d-lg-none">
            <h1 class="text-primary">DesignVerse</h1>
        </a>
        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between py-4 py-lg-0" id="navbarCollapse">
        <div class="btn btn-square btn-outline-primary rounded-circle me-2"><i class="fa-xl fa-solid fa-house-chimney"></i></div>
        	<a href="<%= request.getContextPath() %>/Controller/homeUser" class="nav-item nav-link active">Home</a>
            <div class="navbar-nav ms-auto py-0">
                
                <a href="<%= request.getContextPath() %>/Controller/homeUser" class="nav-item nav-link">About</a>
                <a href="<%= request.getContextPath() %>/Controller/userDemande?id=${idUser}" class="nav-item nav-link">Orders</a>
            </div>
            <a href="<%= request.getContextPath() %>/Controller/" class="navbar-brand bg-primary py-2 px-4 mx-3 d-none d-lg-block">
                <h1 class="text-white">DesignVerse</h1>
            </a>
            <div class="navbar-nav me-auto py-0">
                <a href="<%= request.getContextPath() %>/Controller/homeUser" class="nav-item nav-link">Projects</a>
                <a href="<%= request.getContextPath() %>/Controller/" class="nav-item nav-link">Contact</a>
               
                </div> 
                
                <div class="btn btn-square btn-outline-primary rounded-circle me-2" ><i class="fa-xl fa-solid fa-user"></i></div>
                  <div class="nav-item dropdown"> <div class="ms-4">
                            <h5 class="mb-1">${user.first_name} ${user.last_name}</h5>
                        </div>
                    <div class="dropdown-menu rounded-0 shadow-sm border-0 m-0">
                        <a class="dropdown-item"  href="<%= request.getContextPath() %>/Controller/editUser?id=${idUser}" > Edit profil</a>
                        <a href="/DesignVerse/" class="dropdown-item">Logout</a>
                    </div>
            </div>
            
        </div>
    </nav>
    <!-- Navbar End -->
    </head>
    
<body>




<section class="section1">
     
          <h4 class="display-6 mb-5">List Of Your Orders</h4> 
       
           
	         <div class="container">
	         
            <div class="row g-3"> 
       		<c:forEach var="demande" items="${listDemandes}" >
          
        	<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="row g-3 img-twice position-relative h-100">
            <div class="col-6"> 
            
			<div class="testimonial-item bg-white p-4">
		         <div class="d-flex align-items-center mb-4">
		           <img class="btn btn-square btn-outline-primary rounded-circle me-2" data-bs-toggle="dropdown" src="${pageContext.request.contextPath}/template/img/orders.jpg" alt="">
					<div class="ms-4">
		                     <h5 class="mb-1 text-primary">Order Number: ${demande.user_id}</h5>
		               </div>
		                    </div>
                    <p class="mb-0">Demande Type : ${demande.demande_type}</p>
                    <p class="mb-0">Demande Dimensions  : ${demande.demande_dimension}</p>
                    <p class="mb-0">Comment  : ${demande.commentaire}</p>
                    <p class="mb-0">Status      : ${demande.statut}</p>
        
		                <div class="service-overlay d-flex align-items-center mb-4" >
		                &nbsp &nbsp
			        	<a class="btn btn-lg-square btn-outline-light rounded-circle" href="<%= request.getContextPath() %>/Controller/showAnswer?id=${demande.user_id}"><i class="fa text-primary">Show Answer</i></a>
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			       		</div>
			       		</div>
			       		</div>
		                    </div>
	       </div>
	   
	  
                </c:forEach> </div>
	    </div>


	    
       
	
	</section> 


</body>
<%@ include file="/WEB-INF/include/js.jsp" %>
</html>