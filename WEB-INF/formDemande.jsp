<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Form </title>
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
        	<a href="<%= request.getContextPath() %>/Controller/" class="nav-item nav-link active">Home</a>
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
                
                <img class="btn btn-square btn-outline-primary rounded-circle me-2" data-bs-toggle="dropdown" src="${pageContext.request.contextPath}/template/img/perso.jpg" alt="">
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


<div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <h1 class="display-6 mb-5">Create your design</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-8 wow fadeInUp" data-wow-delay="0.1s">
                    <p class="text-center mb-6"><center><p>Do you want a professional designer to do it for you? Fill your order here. </p></center>
                    <form action="<%= request.getContextPath() %>/Controller/createDemande" method="post">
                        <div class="row g-3">
                        <div class="col-12">
                                <div class="form-floating" >
                                    <input type="type" class="form-control" name="demande_type" placeholder="Design Type" >
                                    <label for="email" >Design Type</label>
                                </div>
                            </div>
                             
                        	<div class="col-12">
                                <div class="form-floating">
                                    <input type="dimension" class="form-control" name="demande_dimension" placeholder="Design Dimensions" >
                                    <label for="email" >Design Dimensions</label>                
                                </div>
                            </div>
                            
                            <div class="col-12">
                                <div class="form-floating">
                                    <textarea class="form-control" name="commentaire" placeholder="Comment" ></textarea>
                                    <label for="email" >Special Request</label>                
                                </div>
                            </div>
                            
                            


							<div class="col-12 text-center">
                                <button class="btn btn-primary py-3 px-5" type="submit" value="submit">Send Order</button>
                            </div>
			</div>
			</form>








</body>
</html>