<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/include/css.jsp" %>
<%@ include file="/WEB-INF/include/cssGenPal.jsp" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,
 initial-scale=1.0" />

<head>
<meta charset="UTF-8">
<title>Palette Generator</title>
 

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
</head>
<body>

<div class="palette">
	<button id="button">Generate New palette</button>
	<div class='colors'>
		<div>
			<h4 class="hex">#1234</h4>
			<div class="color"></div>
		</div>
		<div>
			<h4 class="hex">#1234</h4>
			<div class="color"></div>
		</div>
		<div>
			<h4 class="hex">#1234</h4>
			<div class="color"></div>
		</div>
		<div>
			<h4 class="hex">#1234</h4>
			<div class="color"></div>
		</div>
	</div>
</div>





</body>
<script>
//Getting the elements

const atn = document.querySelector('#button');
const color1 = document.querySelectorAll('.color');
const hex1 = document.querySelectorAll('.hex');

//adding clicking event on button 
console.log(atn);
atn.addEventListener('click', generateColors);

function generateColors(){
	for(let i=0; i<color1.length; i++){
		//generate random color
		const randomColor = Math.floor(Math.random()*16777215).toString(16);
		//add the color to the background
		color1[i].style.background = "#" +randomColor;
		//adding animation
		color1[i].classList.add('fade-in');
		setTimeout(()=> color1[i].classList.remove('fade-in'), 400);
		//add hex code above color
		hex1[i].innerHTML = randomColor;
		
	}
}

//generate palette
generateColors();

</script>
</html>