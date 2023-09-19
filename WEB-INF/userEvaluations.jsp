<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Orders </title>
<%@ include file="/WEB-INF/include/css.jsp" %>
<style>
:root {
	  --surface-color: #fff;
	  --curve: 40;
	}

	* {
	  box-sizing: border-box;
	}

	body {
	  font-family: 'Noto Sans JP', sans-serif;
	  background-color: #efe7da;
	}

	.cards {
	  display: grid;
	  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
	  gap: 2rem;
	  margin: 4rem 5vw;
	  padding: 0;
	  list-style-type: none;
	}

	.card {
	  position: relative;
	  display: block;
	  height: 100%;  
	  border-radius: calc(var(--curve) * 1px);
	  overflow: hidden;
	  text-decoration: none;
	}

	.card__image {      
	  width: 100%;
	  height: auto;
	}

	.card__overlay {
	  position: absolute;
	  bottom: 0;
	  left: 0;
	  right: 0;
	  z-index: 1;      
	  border-radius: calc(var(--curve) * 1px);    
	  background-color: var(--surface-color);      
	  transform: translateY(100%);
	  transition: .2s ease-in-out;
	}

	.card:hover .card__overlay {
	  transform: translateY(0);
	}

	.card__header {
	  position: relative;
	  display: flex;
	  align-items: center;
	  gap: 2em;
	  padding: 2em;
	  border-radius: calc(var(--curve) * 1px) 0 0 0;    
	  background-color: var(--surface-color);
	  transform: translateY(-100%);
	  transition: .2s ease-in-out;
	}

	.card__arc {
	  width: 80px;
	  height: 80px;
	  position: absolute;
	  bottom: 100%;
	  right: 0;      
	  z-index: 1;
	}

	.card__arc path {
	  fill: var(--surface-color);
	  d: path("M 40 80 c 22 0 40 -22 40 -40 v 40 Z");
	}       

	.card:hover .card__header {
	  transform: translateY(0);
	}

	.card__thumb {
	  flex-shrink: 0;
	  width: 50px;
	  height: 50px;      
	  border-radius: 50%;      
	}

	.card__title {
	  font-size: 1em;
	  margin: 0 0 .3em;
	  color: #6A515E;
	}

	.card__tagline {
	  display: block;
	  margin: 1em 0;
	  font-family: "MockFlowFont";  
	  font-size: .8em; 
	  color: #D7BDCA;  
	}

	.card__status {
	  font-size: .8em;
	  color: #D7BDCA;
	}

	.card__description {
	  padding: 0 2em 2em;
	  margin: 0;
	  color: #D7BDCA;
	  font-family: "MockFlowFont";   
	  display: -webkit-box;
	  -webkit-box-orient: vertical;
	  -webkit-line-clamp: 3;
	  overflow: hidden;
	}    
	</style>
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
     
          <h4 class="display-6 mb-5">List Of Your Designs</h4> 
       
           
	         <div class="container">
<ul class="cards">
<c:forEach var="evaluation" items="${listDemandes}" >
  <li> 
    <a href="" class="card">
      <img src="${pageContext.request.contextPath}/images/${evaluation.design}" class="card__image" alt="" />
      <div class="card__overlay">
        <div class="card__header">
          <svg class="card__arc" xmlns="http://www.w3.org/2000/svg"><path /></svg>                     
          
          <div class="card__header-text">
            <h3 class="card__title">${evaluation.statut}</h3>            
            <span class="card__status">${evaluation.comment}</span>
          </div>
        </div>
        
      </div>
    </a>      
  </li>
  </c:forEach>  
</ul>

</section>

<%--   <section class="section1">
     
          <h4 class="display-6 mb-5">List Of Your Orders</h4> 
       
           
	         <div class="container">
	         
            <div class="row g-3"> 
       		<c:forEach var="evaluation" items="${listDemandes}" >
          
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
                    <p class="mb-0">Demande Type : ${evaluation.comment}</p>
                    <p class="mb-0">Demande Dimensions  : ${evaluation.design}</p>
                    <p class="mb-0">Status      : ${evaluation.statut}</p>
                    <img  src="${pageContext.request.contextPath}/images/${evaluation.design}" height="500">
        
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


	    
       
	
	</section> --%>

</body>
<%@ include file="/WEB-INF/include/js.jsp" %>
</html>