<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
   <%@ include file="/WEB-INF/include/css.jsp" %>
    <!-- Contact Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Register</p>
                <h1 class="display-6 mb-5">Please Fill This Form to join our community</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-8 wow fadeInUp" data-wow-delay="0.1s">
                    <p class="text-center mb-4">The contact form is currently inactive. Get a functional and working contact form with Ajax & PHP in a few minutes. Just copy and paste the files, add a little code and you're done. <a href="https://htmlcodex.com/contact-form">Download Now</a>.</p>
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
                                    <input type="password" class="form-control" name="password" placeholder="Your password">
                                    <label for="name">Password</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="password" class="form-control" name="cpassword" placeholder="Confirm password">
                                    <label for="name">Confirm password</label>
                                </div>
                            </div>
                            <div class="col-12 text-center">
                                <button class="btn btn-primary py-3 px-5" type="submit" value="submit">Submit</button>
                            </div>
                        </div>
                    </form>
                    <a href="<%= request.getContextPath() %>/Controller/loginJSP">login</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Contact End -->