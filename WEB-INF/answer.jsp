<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin answer</title>
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

<br>



</br>
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5">
                
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="h-100">
                        
                        <h1 class="display-6 mb-4">Hello ${user.username} ,</h1>
                        <p>This is our designer's answer to your order hope you like it !</p>
                        <p></p>
                        <div class="row g-2 mb-4">
                            <div class="col-sm-6" >
                                <i class="fa fa-check text-primary me-3" ></i>${demande.comment}
                            </div>
                        </div>

                    </div>
                </div>
<center>
                            <img  src="${pageContext.request.contextPath}/images/${demande.path}" height="500">
                            
                       
 </center>                      
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- About End 




<section class="section1">
     
          <h4 class="display-6 mb-5">Answer</h4> 
       
           
	         <div class="container">
	         
            <div class="row g-3"> 

          
        	<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
            <div class="row g-3 img-twice position-relative h-100">
            <div class="col-6"> 
            
			<div class="testimonial-item bg-white p-4">
		         <div class="d-flex align-items-center mb-4">
		           <img class="btn btn-square btn-outline-primary rounded-circle me-2" data-bs-toggle="dropdown" src="${pageContext.request.contextPath}/template/img/orders.jpg" alt="">
					<div class="ms-4">
		                     <h5 class="mb-1 text-primary">Order</h5>
		               </div>
		                    </div>
                    <p class="mb-0">Demande Type : ${demande.comment}</p>
                    <p class="mb-0">Demande Dimensions  : ${demande.path}</p>
                    <img src="${pageContext.request.contextPath}/images/${demande.path}" height = "200" />
        
		                <div class="service-overlay d-flex align-items-center mb-4" >
		                &nbsp &nbsp
			        	
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
			       		</div>
			       		</div>
			       		</div>
		                    </div>
	       </div>
	   
		</div>
	    </div>
       
	
	</section>     -->
</body>
<%@ include file="/WEB-INF/include/js.jsp" %>
</html>