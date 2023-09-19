<!-- Header Start -->
    <div class="container-fluid hero-header bg-light py-5 mb-5">
        <div class="container py-5">
            <div class="row g-5 align-items-center">
                <div class="col-lg-6">
                    <p class="text-primary text-uppercase mb-2 animated slideInDown">Welcome To DesignVerse</p>
                    <h1 class="display-4 mb-3 animated slideInDown">Where color diversity and creativity meet accessibility</h1>
                    <p class="animated slideInDown"> We welcome you to your own peronified creative space </p>
                    <div class="d-flex align-items-center pt-4 animated slideInDown">
                        <a href="<%= request.getContextPath() %>/Controller/registerJSP" class="btn btn-primary py-3 px-4 me-5">Explore More</a>
                        <button type="button" class="btn-play" data-bs-toggle="modal"
                            data-src="" data-bs-target="#videoModal">
                            <span></span>
                        </button>
                        <h5 class="ms-4 mb-0 d-none d-sm-block">Get Hired!</h5>
                    </div>
                </div>
                <div class="col-lg-6 animated fadeIn">
                    <div class="row g-3">
                        <div class="col-6 text-end">
                            <img class="img-fluid bg-white p-3 w-100 mb-3" src="${pageContext.request.contextPath}/template/img/afficheMarron.jpg" alt="">
                            <img class="img-fluid bg-white p-3 w-50" src="${pageContext.request.contextPath}/template/img/PaletteOrdonn.jpg" alt="">
                        </div>
                        <div class="col-6">
                            <img class="img-fluid bg-white p-3 w-50 mb-3" src="${pageContext.request.contextPath}/template/img/PaletteOrdonn2.jpg" alt="">
                            <img class="img-fluid bg-white p-3 w-100" src="${pageContext.request.contextPath}/template/img/afficheOrange.jpg" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->