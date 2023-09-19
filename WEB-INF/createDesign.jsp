<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/include//css.jsp" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create your own design</title>

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
                <a href="<%= request.getContextPath() %>/Controller/homeUser" class="nav-item nav-link">Projects</a>
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
    
    
    
    </br>


	<div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
    <br>
    
                <h1 class="display-6 mb-5">Fill this form to create your design</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-4 col-md-5 wow fadeInUp" data-wow-delay="0.1s">
                     <div class="container-xxl px-4 bg-light py-5 my-5">
                     
                     <form action="<%= request.getContextPath() %>/Controller/createDesign" method="post">
                        <div class="row g-3">
                        <div class="col-12">
                                <div class="form-floating">
                                <input type="text" class="form-control" name="design_name" placeholder="Design Name">
                                <label for="design_name">Design Name</label>
                              
                        	<div class="col-12">
                                <div class="form-floating">
                                    <select class="form-control" name="type" placeholder="Artifact's type">
                                    <option value="Banner">Banners</option>
                                    <option value="Poster">Posters</option>
                                    <option value="Logo">Logo</option>
                                    <option value="BookMarks">BookMarks</option>
                                    <option value="Tickets">Tickets</option>
                                    <option value="Blank">Blank Page</option>
                                    <option value="CV">Curriculum Vitae</option>
                                    </select>                  
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <select class="form-control" name="dimension" placeholder="Dimension">
                                    <label for="dimension">Dimension</label>
                                    <option value="A4">A4</option>
                                    <option value="A3">A3</option>
                                    <option value="4:4">4:4</option>
                                    <option value="A2">A2</option>
                                    </select>                  
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="color" class="form-control" name="design_color" placeholder="Pick a color">
                                    <label for="couleur">Pick a color</label>
                                </div>
                            </div>


							<div class="col-12 text-center">
                                <button href="<%= request.getContextPath() %>/Controller/homeUser"class="btn btn-primary py-3 px-5" type="submit" value="submit">Generate Palette</button>
                            </div>
			</div>
			</form>

    <!-- Contact Start 
    <div class="container-xxl py-5">
        <div class="container">
            <div class="text-center mx-auto wow fadeInUp" data-wow-delay="0.1s" style="max-width: 500px;">
                <h1 class="display-6 mb-5">Create your own design</h1>
            </div>
            <div class="row g-0 justify-content-center">
                <div class="col-lg-8 wow fadeInUp" data-wow-delay="0.1s">
                    <p class="text-center mb-6"><p>hi ${user.first_name} , your username is ${user.username} </p>
                    <form action="<%= request.getContextPath() %>/Controller/createDesign" method="post">
                        <div class="row g-3">
                        <div class="col-12">
                                <div class="form-floating">
                                <input type="text" class="form-control" name="design_name" placeholder="Design Name">
                                <label for="design_name">Design Name</label>
                              
                        	<div class="col-12">
                                <div class="form-floating">
                                    <select class="form-control" name="type" placeholder="Artifact's type">
                                    <option value="Banner">Banners</option>
                                    <option value="Poster">Posters</option>
                                    <option value="Logo">Logo</option>
                                    <option value="BookMarks">BookMarks</option>
                                    <option value="Tickets">Tickets</option>
                                    <option value="Blank">Blank Page</option>
                                    <option value="CV">Curriculum Vitae</option>
                                    </select>                  
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <select class="form-control" name="dimension" placeholder="Dimension">
                                    <label for="dimension">Dimension</label>
                                    <option value="A4">A4</option>
                                    <option value="A3">A3</option>
                                    <option value="4:4">4:4</option>
                                    <option value="A2">A2</option>
                                    </select>                  
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating">
                                    <input type="color" class="form-control" name="design_color" placeholder="Pick a color">
                                    <label for="couleur">Pick a color</label>
                                </div>
                            </div>


							<div class="col-12 text-center">
                                <button href="<%= request.getContextPath() %>/Controller/homeUser"class="btn btn-primary py-3 px-5" type="submit" value="submit">Generate Palette</button>
                            </div>
			</div>
			</form>
	-->

</head>
<body style="text-align: center">
        
        
       <!--  
               <script>
            /* Cette fonction permet d'afficher une vignette pour chaque image sélectionnée */
            function readFilesAndDisplayPreview(files) {
                let imageList = document.querySelector('#list'); 
                imageList.innerHTML = "";
                
                for ( let file of files ) {
                    let reader = new FileReader();
                    
                    reader.addEventListener( "load", function( event ) {
                        let span = document.createElement('span');
                        span.innerHTML = '<img height="60" src="' + event.target.result + '" />';
                        imageList.appendChild( span );
                    });

                    reader.readAsDataURL( file );
                }
            }
        </script>
       
       
       <form method="post" action="upload" enctype="multipart/form-data">
        
            <p class="text-center mb-6"><p>Extract palette from your picture  </p>
            <input type="file" class="form-control" name="multiPartServlet" accept="image/*" multiple
                   onchange="readFilesAndDisplayPreview(this.files);" /> <br/>
                    
            
            <div id="list"></div>   
        </form> --> 

                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>
</html>