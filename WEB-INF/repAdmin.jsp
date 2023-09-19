<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
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
    <body>
 <br>



</br>
   
   
  
    <!-- Contact Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Answer</p>
                
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-4 col-md-5 wow fadeInUp" data-wow-delay="0.1s">

                     <div class="container-xxl px-4 bg-light py-5 my-5">
                     
                     <form action="<%= request.getContextPath() %>/Controller/answerDemande?id=${demandeId}" method="post" enctype="multipart/form-data">
                        <div class="row g-3" style="text-align:center">
                            <div class="col-12" >
                                <div class="form-floating" >                               	
                                    <input type="text" class="form-control" name="comment" placeholder="Your Answer" >
                                    <label for="comment" >Your Answer</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="file" class="form-control" name="path" placeholder="Upload picture">
                                    <label for="path">Upload</label>
                                </div>
                            </div>
                                   
                            </div>
                            <div class="col-12 text-center">
                                <button class="btn btn-primary py-3 px-5"type="submit" value="submit">SUBMIT </button>
                            </div>
                        </div>
                    </form>
                    </div>

                </div>
            </div>
        </div>
</body>
