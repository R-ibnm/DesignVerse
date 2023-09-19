<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page </title>
<%@ include file="/WEB-INF/include/css.jsp" %>

    <!-- Navbar Start -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light fixed-top shadow py-lg-0 px-4 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
        <a href="index.html" class="navbar-brand d-block d-lg-none">
            <h1 class="text-primary">DesignVerse Admin Space</h1>
        </a>
        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between py-4 py-lg-0" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-0">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Home</a>                
                <div class="dropdown-menu rounded-0 shadow-sm border-0 m-0">
                <a href="feature.html" class="dropdown-item">Connect as a normal user</a>
           </div> 
            <a href="" class="nav-item nav-link">Evaluations</a>
            </div>
            <a href="index.html" class="navbar-brand bg-primary py-2 px-4 mx-3 d-none d-lg-block">
                <h1 class="text-white">DesignVerse Admin Space</h1>
            </a>
            <div class="navbar-nav me-auto py-0">

                
                <a href="contact.html" class="nav-item nav-link">Update Contact</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Profil</a>
                    <div class="dropdown-menu rounded-0 shadow-sm border-0 m-0">
                        <a href = "<%= request.getContextPath() %>/Controller/editProfile" class="dropdown-item">Edit profil</a>
                         <a href="<%= request.getContextPath() %>/Controller/" class="dropdown-item">Logout</a>

                    </div>
                </div>
            </div>
            
        </div>
    </nav>
    <!-- Navbar End -->

</head>
<body>
<!-- About Start -->
<br>



</br>
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5">
                
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="h-100">
                        
                        <h1 class="display-6 mb-4">Hello ${user.username} ,</h1>
                        <p>Welcome Back! You missed a lot</p>
                        <p>What would you like to see first?</p>
                        <div class="row g-2 mb-4">
                            <div class="col-sm-6" >
                                <i class="fa fa-check text-primary me-3" ></i>Users
                            </div>
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Artefacts
                            </div>
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Palettes
                            </div>
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Orders and Evaluations
                            </div>
                        </div>
                        <a href="<%= request.getContextPath() %>/Controller/allEvaluationsByUsers"class="btn btn-primary py-3 px-5" >Evaluations</a> 
                        <a href="<%= request.getContextPath() %>/Controller/allDesignsByUsers"class="btn btn-primary py-3 px-5" >Artefacts</a> <br> <br>
                        <a href="<%= request.getContextPath() %>/Controller/"class="btn btn-primary py-3 px-5" >Palettes</a>
                        <a href="<%= request.getContextPath() %>/Controller/allDemandeByUsers"class="btn btn-primary py-3 px-5" >Orders</a><br> <br>
                        <a href="<%= request.getContextPath() %>/Controller/allUsers"class="btn btn-primary py-3 px-5" >Users</a>
                    </div>
                </div><div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="row g-3 img-twice position-relative h-100">
 
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->


   
        <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>
<%@ include file="/WEB-INF/include/footer.jsp" %>


    <!-- Copyright Start -->
    <div class="container-fluid bg-dark text-white border-top border-secondary px-0">
        <div class="d-flex flex-column flex-md-row justify-content-between">
            <div class="py-4 px-5 text-center text-md-start">
                <p class="mb-0">&copy; <a class="text-primary" href="#">Design Verse</a>. All Rights Reserved.</p>
            </div>
            <div class="py-4 px-5 bg-secondary footer-shape position-relative text-center text-md-end">
                <!--/* This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. */-->
     		 <p class="mb-0">Designed by <a class="text-primary fw-bold">Mouna & Rim</a></p>
        </div>
        </div>
    </div>
    <!-- Copyright End -->
<%@ include file="/WEB-INF/include/js.jsp" %>

</body>

</html>