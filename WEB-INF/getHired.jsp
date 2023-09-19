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
                <p class="text-primary text-uppercase mb-2">Submit Your Application</p>
                <h1 class="display-6 mb-5">Do you have any Designing background and want to help others? Fill this form to join our Designing team!</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-8 wow fadeInUp" data-wow-delay="0.1s">
                    <p class="text-center mb-4">The contact form is currently active. <a href="https://htmlcodex.com/contact-form">Contact us here</a>.</p>
                    <form action="<%= request.getContextPath() %>/Controller/register" method="post">
                        <div class="row g-3">
                            <div class="col-md-6">
                                <div class="form-floating">
                                
                                    <input type="text" class="form-control" name="first_name" placeholder="First Name">
                                    <label for="name">Your Name</label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating">
                                    <input type="text" class="form-control" name="last_name" placeholder="Last Name">
                                    <label for="name">Your Last Name</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="text" class="form-control" name="username" placeholder="Your username">
                                    <label for="name">Username</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="email" class="form-control" name="email" placeholder="Your Email">
                                    <label for="email">Your Email</label>
                                </div>
                            </div>  
                             <div class="col-12">
                                <div class="form-floating">    
		                            <input type="file" class="form-control" name="CV" placeholder="Your CV">
		  							 <label for="name">Your CV</label>
		  						  </div>
                            </div>	
                            <div class="col-12 text-center">
                                <button class="btn btn-primary py-3 px-5" type="submit" value="submit">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->