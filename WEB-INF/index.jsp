<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DesignVerse</title>
<%@ include file="/WEB-INF/include//css.jsp" %>
<%@ include file="/WEB-INF/include//topbar.jsp" %>
</head>
<body>

<%@ include file="/WEB-INF/include//header.jsp" %>

    <!-- Video Modal Start -->
    <div class="modal modal-video fade" id="videoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content rounded-0">
                <div class="modal-header">
                    <h3 class="modal-title" id="exampleModalLabel">We're Hiring!</h3>
                    
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <!-- 16:9 aspect ratio -->
                  <div class="d-flex align-items-center pt-4 animated slideInDown">
                  <div class="col-6">
                            <img class="img-fluid bg-light p-3" src="${pageContext.request.contextPath}/template/img/hiring.jpg" alt="">
                        </div>
                  <a href="<%= request.getContextPath() %>/Controller/getHired" class="btn btn-primary py-3 px-4 me-5">Submit your Application</a>
                </div></div>
            </div>
        </div>
    </div>
    <!-- Video Modal End -->


    <!-- About Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5">
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="row g-3 img-twice position-relative h-100">
                        <div class="col-6">
                            <img class="img-fluid bg-light p-3" src="${pageContext.request.contextPath}/template/img/afficheDonut.jpg" alt="">
                        </div>
                        <div class="col-6 align-self-end">
                            <img class="img-fluid bg-light p-3" src="${pageContext.request.contextPath}/template/img/MixPalette.jpg" alt="">
                        </div>
                        <div class="col-6 align-self-end">
                            <img class="img-fluid bg-light p-3" src="${pageContext.request.contextPath}/template/img/afficheRed.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="h-100">
                        <p class="text-primary text-uppercase mb-2">About Us</p>
                        <h1 class="display-6 mb-4">We Are Creative And Professional Designers</h1>
                        <p>Our plateform will allow you to make multiple designs with many different color palettes depending on your taste.</p>
                        <p>Within our plateform, you will be able to do many things such as:</p>
                        <div class="row g-2 mb-4">
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Develop your own products
                            </div>
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Generate a palette by a color
                            </div>
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Submit an order to a designer
                            </div>
                            <div class="col-sm-6">
                                <i class="fa fa-check text-primary me-3"></i>Submit your own design for review
                            </div>
                        </div>
                        <a class="btn btn-primary py-3 px-5" href="">Read More</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- About End -->


    <!-- Facts Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Why Choose Us!</p>
                <h1 class="display-6 mb-5">Fast, inclusive and always available</h1>
            </div>
            <div class="row g-3">
                <div class="col-lg-4 col-md-6 pt-lg-5 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="fact-item bg-light text-center h-100 p-5">
                        <h1 class="display-2 text-primary mb-3" data-toggle="counter-up">35</h1>
                        <h4 class="mb-3">Active Designers</h4>
                        <span>To help you with each and every request and submition you put.</span>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="fact-item bg-light text-center h-100 p-5">
                        <h1 class="display-2 text-primary mb-3" data-toggle="counter-up">630</h1>
                        <h4 class="mb-3">Different palettes</h4>
                        <span>To make sure each one finds at least one they like</span>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 pt-lg-5 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="fact-item bg-light text-center h-100 p-5">
                        <h1 class="display-2 text-primary mb-3" data-toggle="counter-up">12345</h1>
                        <h4 class="mb-3">Happy Clients</h4>
                        <span>Satisfaction rates are off the roof</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Facts End -->


    <!-- Service Start -->
    <div class="container-xxl bg-light py-5 my-5">
        <div class="container py-5">
            <div class="text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Our Services</p>
                <h1 class="display-6 mb-4">We Provide The Most Diverse Design Options</h1>
            </div>
            <div class="row g-3">
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/affichePink.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Posters</h4>
                        </div>
                    </div>
                </div> 
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/bookmarks.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>BookMarks</h4>
                        </div>
                    </div>
                </div>  
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/LogoDesign.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Logo</h4>
                        </div>
                    </div>
                </div> 
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/afficheBlank.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Blank Page</h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/cv.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Curriculum Vitae</h4>
                        </div>
                    </div>
                </div>
              <div class="col-lg-3 col-md-6 pt-lg-5 wow fadeInUp" data-wow-delay="0.3s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/tickets.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Tickets</h4>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 pt-lg-5 wow fadeInUp" data-wow-delay="0.7s">
                    <div class="service-item d-flex flex-column bg-white p-3 pb-0">
                        <div class="position-relative">
                            <img class="img-fluid" src="${pageContext.request.contextPath}/template/img/banners.jpg" alt="">
                            <div class="service-overlay">
                                <a class="btn btn-lg-square btn-outline-light rounded-circle" href=""><i class="fa fa-link text-primary"></i></a>
                            </div>
                        </div>
                        <div class="text-center p-4">
                            <h4>Banners</h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Service End -->


  


    <!-- Testimonial Start -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto mb-5 wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <p class="text-primary text-uppercase mb-2">Coming Soon</p>
                <h1 class="display-6 mb-0">Many more other options</h1>
            </div>
            <div class="owl-carousel testimonial-carousel wow fadeInUp" data-wow-delay="0.1s">
                <div class="testimonial-item bg-white p-4">
                    <div class="d-flex align-items-center mb-4">
                        <div class="flex-shrink-0 rounded-circle border p-1" ><i class="fa-xl fa-solid fa-eye-dropper"></i> </div>
                        <div class="ms-4">
                            <h5 class="mb-1">Color Analyzer</h5>
                        <span></span>
                        </div>
                    </div>
                    <p class="mb-0">You will be able to insert a picture in order to generate a color palette from it.</p>
                </div>
                <div class="testimonial-item bg-white p-4">
                    <div class="d-flex align-items-center mb-4">
                        <div class="flex-shrink-0 rounded-circle border p-1" ><i class="fa-xl fa-solid fa-mobile-screen-button"></i></div>
                        <div class="ms-4">
                            <h5 class="mb-1">Mobile App</h5>
                         <span></span>
                        </div>
                    </div>
                    <p class="mb-0">For us to be with you at all times when needed.</p>
                </div>
                
                <div class="testimonial-item bg-white p-4">
                    <div class="d-flex align-items-center mb-4">
                        <div class="flex-shrink-0 rounded-circle border p-1" ><i class="fa-xl fa-sharp fa-solid fa-shirt"></i> </div>
                        <div class="ms-4">
                            <h5 class="mb-1">Clothes Adaptible</h5>
                            <span></span>
                        </div>
                    </div>
                    <p class="mb-0">For you to be able to design your own clothes, mugs and more with a proper model</p>
                </div>
                <div class="testimonial-item bg-white p-4">
                    <div class="d-flex align-items-center mb-4">
                        <div class="flex-shrink-0 rounded-circle border p-1" ><i class="fa-xl fa-solid fa-eye-dropper"></i></div>
                        <div class="ms-4">
                            <h5 class="mb-1">Color Recommendation</h5>
                            <span></span>
                        </div>
                    </div>
                    <p class="mb-0">To have a recommendation of different palettes depending on your most used color</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Testimonial End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i class="bi bi-arrow-up"></i></a>
<%@ include file="/WEB-INF/include/footer.jsp" %>

    <!-- Copyright Start -->
    <div class="container-fluid bg-dark text-white border-top border-secondary px-0">
        <div class="d-flex flex-column flex-md-row justify-content-between">
            <div class="py-4 px-5 text-center text-md-start">
                <p class="mb-0">&copy; <a class="text-primary" href="#">DesignVerse</a>. All Rights Reserved.</p>
            </div>
            <div class="py-4 px-5 bg-secondary footer-shape position-relative text-center text-md-end">
                <!--/* This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. */-->
                <p class="mb-0">Designed by <a class="text-primary fw-bold">Mouna & Rim</a></p>
            </div>
        </div>
    </div>
    <!-- Copyright End -->
</body>
<%@ include file="/WEB-INF/include/js.jsp" %>
</html> 