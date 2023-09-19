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

<head>
<meta charset="UTF-8">
<title>Palette Generated </title>
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
<br>



</br>

<section class="section1">
	<div class="container-xxl py-5">
        <div class="container">
           
                <h4 class="display-6 mb-5">Color Palette Generator</h4>  
                <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <div class="container-xxl bg-light py-5 my-5">
        			<div class="container py-5">
	               <div class="row g-3">
	               <h4>Palette</h4>
	              <c:forEach var="design" items="${listDesigns}" >
	                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s" >
	                    <div class="service-item flex  bg-white ">
	                        <div class="position-relative">
	                         <div class="colors" style="width: 100%"  >
	                        <div class="color"> 
	                        	<div class="color-img" style="background-color : ${design.design_color} "></div>
	                        <div class="color-text"> ${design.design_color}</div>
	                            <div class="service-overlay">
	                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa text-primary">Modify</i></a>
	                            </div>
	                        </div>
	                        <div class="text-center p-4">
	                            <div class="color-text">Color</div></div></div></div></div> </div>
	                            </c:forEach>

	                            </div>
	                            </div></div>
	             
                
                            
	<%--
	<div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <div class="container-xxl bg-light py-5 my-5">
        			<div class="container py-5">
	               <div class="row g-3">
	               <h4>Palette</h4>
	              <c:forEach var="design" items="${listDesigns}" >
	                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s" >
	                    <div class="service-item flex  bg-white ">
	                        <div class="position-relative">
	                         <div class="colors" >
	                        <div class="color"> 
	                        	<div class="color-img" style="background-color : ${design.design_color} "></div>
	                        <div class="color-text"> ${design.design_color}</div>
	                            <div class="service-overlay">
	                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa text-primary">Modify</i></a>
	                            </div>
	                        </div>
	                        <div class="text-center p-4">
	                            <div class="color-text">Color</div></div></div></div></div> </div>
	                            </c:forEach>
	                            <a class="btn btn-primary py-3 px-4 me-5">Use</a>
	                            </div>
	                            </div></div>
	
	
	 	<div class="colors">
				<c:forEach var="artefact" items="${artefacts}" >
				<div class="col-lg-4 col-md-6 pt-lg-5 wow fadeInUp" data-wow-delay="0.1s">
				   <div class="fact-item bg-light text-center h-100 p-5">
					<div class="color">
						<div class="color-img" style="background-color : ${artefact.couleur} "></div>
						<div class="color-text">Color</div>
						 <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/modify.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary" > </i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Modify</h4>
                        </div>
						</div></div></div> </c:forEach>
						 --%>
 		
	</div></div></div> </div>
	
</section>
	 
	
	
	
		
<!--  	<div class="color">
		<div class="color-img"></div>
		<div class="color-text">#EEEDFØ</div>
		</div>
		<div class="color">
		<div class="color-img"></div>
		<div class="color-text">#EEEDFØ</div>
		</div>
		<div class="color">
		<div class="color-img"></div>
		<div class="color-text">#EEEDFØ</div>
		</div>
		<div class="color">
		<div class="color-img"></div>
		<div class="color-text">#EEEDFØ</div>
		</div>
		-->
	</div>
	</section> 
</body>
</html>

