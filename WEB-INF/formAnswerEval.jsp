<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
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
                <a href="<%= request.getContextPath() %>/Controller/userEvaluations?id=${idUser}" class="nav-item nav-link">Evaluations</a>
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
  <br>
   <br>
   
  
    <!-- Contact Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Evaluation</p>
                <h1 class="display-6 mb-5">Submit Your Own Design For An Evaluation</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-4 col-md-5 wow fadeInUp" data-wow-delay="0.1s">

                     <div class="container-xxl px-4 bg-light py-5 my-5">
                     
                     <form action="<%= request.getContextPath() %>/Controller/answerEvaluation?id=${evaluationId}" method="post" enctype="multipart/form-data">
                        <div class="row g-3" style="text-align:center">
                            <div class="col-12" >
                                <div class="form-floating" >                               	
                                    <input type="text" class="form-control" name="note" placeholder="note" >
                                    <label for="comment" >Enter Your Note</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" name="text" placeholder="note" >
                                    <label for="comment" >Have a text to add ?</label>
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

