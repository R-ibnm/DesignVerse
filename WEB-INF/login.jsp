<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
  <%@ include file="/WEB-INF/include/css.jsp" %>
  <%@ include file="/WEB-INF/include//topbar.jsp" %>
  <br>
   
   
   </br>
    <!-- Contact Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Login</p>
                <h1 class="display-6 mb-5">If You Have Any Query, Please Contact Us</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-4 col-md-5 wow fadeInUp" data-wow-delay="0.1s">
                    <p class="text-center mb-4">The contact form is currently active. <a href="https://htmlcodex.com/contact-form">Contact us here</a>.</p>
                     <div class="container-xxl px-4 bg-light py-5 my-5">
                     
                     <form action="<%= request.getContextPath() %>/Controller/login" method="post">
                        <div class="row g-3" style="text-align:center">
                            <div class="col-12" >
                                <div class="form-floating" >
                                	
                                    <input type="email" class="form-control" name="email" placeholder="Your Email" >
                                    <label for="email" >Your Email</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                    <label for="name">Password</label>
                                </div>
                            </div>
                            <div class="col-12">
                            <div class="form-check">
  <input class="form-check-input" type="radio" name="typeU" id="admin" value="admin">
  <label class="form-check-label" for="admin">
    Admin
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="typeU" id="client" value="client" checked>
  <label class="form-check-label" for="client">
    Client
  </label>
</div>
                                   
                            </div>
                            <div class="col-12 text-center">
                                <button class="btn btn-primary py-3 px-5"type="submit" value="submit">Login </button>
                            </div>
                        </div>
                    </form></div>

                    	Don't have an account yet? Go ahead and register 
                    <a href="<%= request.getContextPath() %>/Controller/registerJSP">Right Here</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->