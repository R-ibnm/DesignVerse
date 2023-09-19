package com.ocproj.projet.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.ocproj.projet.DAO.DAOFactory;
import com.ocproj.projet.DAO.DemandeAnswerDAO;
import com.ocproj.projet.DAO.DemandeDAO;
import com.ocproj.projet.DAO.DemandeEvalDAO;
import com.ocproj.projet.DAO.DesignDAO;
import com.ocproj.projet.DAO.EvaluationAnswerDAO;
import com.ocproj.projet.DAO.LoginDAO;
import com.ocproj.projet.DAO.UserDAO;
import com.ocproj.projet.beans.Demande;
import com.ocproj.projet.beans.DemandeAnswer;
import com.ocproj.projet.beans.Design;
import com.ocproj.projet.beans.Evaluation;
import com.ocproj.projet.beans.EvaluationAnswer;
import com.ocproj.projet.beans.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.sql.*;
import java.time.LocalDateTime;

@MultipartConfig

@WebServlet("/Controller/*")
public class Controller extends HttpServlet{
	private UserDAO userDao;
	private LoginDAO loginDao;
	private DesignDAO designDao;
	private DemandeDAO demandeDao;
	private DemandeAnswerDAO demandeAnswerDao;
	private DemandeEvalDAO demandeEvalDao;
	private EvaluationAnswerDAO evaluationAnswerDao;
	
	public void init() throws ServletException{
    	DAOFactory daoFactroy = DAOFactory.getInstance();


		this.userDao = daoFactroy.getUserDAO();
		this.loginDao = daoFactroy.getLoginDAO();
		this.designDao = daoFactroy.getDesignDAO();
		this.demandeDao= daoFactroy.getDemandeDAO();
		this.demandeAnswerDao = daoFactroy.getDemandeAnswerDAO();
		this.demandeEvalDao = daoFactroy.getDemandeEvalDAO();
		this.evaluationAnswerDao = daoFactroy.getDemandeEvalAnswerDAO();
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getRequestURI();
		action = action.substring(action.lastIndexOf("/"));
		
		switch (action) {
		case "/registerJSP":
			registerJSP(request,response);
			break;
		case "/loginJSP":
			loginJSP(request,response);
			break;
		case "/register":
			register(request,response);
			break;
		case "/login":
			login(request,response);
			break;
		case "/homeAdmin":
			homeAdmin(request,response);
			break;
		case "/homeUser":
			homeUser(request,response);
			break;
		case "/createDesign":
			createDesign(request,response);
			break;
		case "/create":
			create(request,response);
			break;
		case "/deleteDesign":
			deleteDesign(request,response);
			break;
		case "/editDesign":
			editDesign(request,response);
			break;
		case "/updateDesign":
			updateDesign(request,response);
			break;
		case "/palette":
			generatePalette(request,response);
			break;
		case "/allUsers":
			allUsers(request,response);
			break;
		case "/deleteUser":
			deleteUser(request,response);
			break;
		case "/allDesignsByUsers":
			allDesignsByUsers(request,response);
			break;
		case "/createDemande":
			createDemande(request,response);
			break;
		case "/createD":
			createD(request,response);
			break;
		case "/userDemande":
			userDemande(request,response);
			break;
		case "/allDemandeByUsers":
			allDemandeByUsers(request,response);
			break;
		case "/updateDemande":
			updateDemande(request,response);
			break;
		case "/editProfile":
			editProfile(request,response);
			break;
		case "/editUser":
			editUser(request,response);
			break;
		case "/answerDemande":
			answerDemande(request,response);
			break;
		case "/createA":
			createA(request,response);
			break;
		case "/showAnswer":
			showAnswer(request,response);
			break;
		case "/generatePaletteRandom" :
			generatePaletteRandom(request,response);
			break;
		case "/createDemandeEval" :
			createDemandeEval(request,response);
			break;
		case "/createE" :
			createE(request,response);
			break;
		case "/userEvaluations":
			userEvaluations(request,response);
			break;	
		case "/allEvaluationsByUsers":
			allEvaluationsByUsers(request,response);
			break;
		case "/getHired":
			getHired(request,response);
			break;
		case "/createEval":
			createEval(request,response);
			break;
		case "/answerEvaluation":
			answerEvaluation(request,response);
			break;
		case "/allEvaluationsPerUser":
			allEvaluationsPerUser(request,response);
			break;
		default: 
			home(request,response);
			break;
		
		}
	}
	private void getHired(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/getHired.jsp");
		dispatcher.forward(request, response);
	}
	private void generatePaletteRandom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/generatePalette.jsp");
		dispatcher.forward(request, response);
	}

	private void showAnswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ereuuuuuuuuur");
		String demande_id = request.getParameter("id");
		int demandeId = Integer.parseInt(demande_id);
		DemandeAnswer demande = demandeAnswerDao.getAnswer(demandeId);
		request.setAttribute("demande", demande);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/answer.jsp");
		dispatcher.forward(request, response);
	}


	private void allDesignsByUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Design> listDesigns = designDao.getAllDesignforAdmin();

		request.setAttribute("listDesigns", listDesigns);
		request.setAttribute("idUser", idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/allDesigns.jsp");
		dispatcher.forward(request, response);

	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("id");
		int id  = Integer.parseInt(user_id);
		userDao.delete(id);
		response.sendRedirect("allUsers");
		
	}


	private void allUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");

		List<User> listUsers = userDao.getAllUsers();
		request.setAttribute("listUsers", listUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/allUsers.jsp");
		dispatcher.forward(request, response);
		
	}


	private void generatePalette(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Design>listDesigns = designDao.getAllDesign();
		request.setAttribute("listDesigns", listDesigns);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/palette.jsp");
		dispatcher.forward(request , response);
	}


	

	private void registerJSP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/register.jsp");
		dispatcher.forward(req, resp);		
	}
	private void loginJSP(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(req, resp);		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	private void editProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user_id");
		int user_id = (int) user.getUser_id();
		System.out.println("hehheehe : "+ user_id);
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String typeU = request.getParameter("typeU");
		
		
		if(password.length()<6) {
					
		}else {
					user.setUser_id(user_id);
					user.setFirst_name(first_name);
					user.setLast_name(last_name);
					user.setUsername(username);
					user.setEmail(email);
					user.setPassword(password);
				
				
				boolean res = userDao.update(user);;
				if(res) {
					User userSession = new User();
					userSession = userDao.InfoUser(email, password);

					 session.setAttribute("user",userSession);
					response.sendRedirect("homeUser");
				}else {
					response.sendRedirect("homeUser");
				}
			
		}
	}
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("id");
		int id  = Integer.parseInt(user_id);
		User user = userDao.find(id);
		request.setAttribute("user", user);
		request.setAttribute("userId", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editProfile.jsp");
		dispatcher.forward(request, response);	
	}
	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String typeU = request.getParameter("typeU");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String Cpassword = request.getParameter("cpassword");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");

		if(!email.isEmpty() && !password.isEmpty() && !Cpassword.isEmpty()) {
			boolean existe = userDao.isUserAlredy(email);
			if(!existe) {
				if(password.equals(Cpassword)) {
					if(password.length()>=6) {
						
							User user = new User();
							user.setEmail(email);
							user.setPassword(password);
							user.setFirst_name(first_name);
							user.setLast_name(last_name);
							user.setUsername(username);
							user.setTypeU("client");
							
							boolean result = userDao.register(user);
							
							if(result) {
								request.setAttribute("notification", "User registred successfully");
								 response.sendRedirect("loginJSP");
								
							}else {
								request.setAttribute("notification", "Error lors de l'insertion de user");
								response.sendRedirect("registerJSP");
							}
							
					}else {
						request.setAttribute("notification", "password <6");
						response.sendRedirect("registerJSP");
					}
				}else {
					request.setAttribute("notification", "differents password");
					response.sendRedirect("registerJSP");
				}
			}else {
				request.setAttribute("notification", "user already exist");
				response.sendRedirect("registerJSP");
			}
			
		}else {
			request.setAttribute("notification", "champ vide");
			response.sendRedirect("registerJSP");
		}
		
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String typeU=request.getParameter("typeU");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setTypeU(typeU);
		
		if(loginDao.validate(user)) {
			
			User userSession = new User();
			userSession = userDao.InfoUser(email, password);
			if(typeU.equals("admin") && userSession.getTypeU().equals("admin")) {
				HttpSession session = request.getSession();
				userSession.setUsername(userSession.getUsername());
				 session.setAttribute("user",userSession);
				 session.setMaxInactiveInterval(-1);
				 System.out.println( "ghfjfj"+ session.getMaxInactiveInterval());
				 response.sendRedirect("homeAdmin");
				 
			}
			else if(typeU.equals("client") && userSession.getTypeU().equals("client")){
				HttpSession session = request.getSession();
				 session.setAttribute("user",userSession);
				 response.sendRedirect("homeUser");
				
				}
			
			else {
				response.sendRedirect("index");
			}
			
		}
		else {
			response.sendRedirect("index");
		}
	}
	private void homeAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeAdmin.jsp");
		dispatcher.forward(request, response);
	}
	private void homeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Design> listDesigns = designDao.getAllDesignByUser(idUser);
		request.setAttribute("listDesigns", listDesigns);
		request.setAttribute("idUser", idUser);
		List<Evaluation> listDemandes = demandeEvalDao.getAllDemandeEval();
		
		request.setAttribute("listDemandes", listDemandes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeUser.jsp");
		dispatcher.forward(request, response);

	}
	private void createDesign(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		String design_name = request.getParameter("design_name");
		String type = request.getParameter("type");
		String dimension = request.getParameter("dimension");
		String design_color = request.getParameter("design_color");
		
		System.out.println(design_color);
		final LocalDateTime design_date = LocalDateTime.now();
		
		Design newDesign= new Design(design_name,  type,  dimension,  design_color,idUser);
		
		System.out.println(newDesign.getDesign_name());
		
		designDao.createDesign(newDesign);
		response.sendRedirect("palette");
	}
	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("gggggg");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/createDesign.jsp");
		dispatcher.forward(req, resp);		
	}
	private void updateDesign(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String design_id = request.getParameter("id");
		int designId= Integer.parseInt(design_id);
		String design_name = request.getParameter("design_name");
		String type = request.getParameter("type");
		String dimension = request.getParameter("dimension");
		String design_color = request.getParameter("design_color");
		
		System.out.println(design_color);
		final LocalDateTime design_date = LocalDateTime.now();
		
		Design newDesign= new Design(designId, design_name,  type,  dimension,  design_color);
		
		System.out.println(newDesign.getDesign_name());
		
		designDao.updateDesign(newDesign);
		response.sendRedirect("homeUser");
	}


	private void editDesign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String design_id = request.getParameter("id");
		int id  = Integer.parseInt(design_id);
		Design design = designDao.findDesign(id);
		request.setAttribute("design", design);
		request.setAttribute("designID", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/editDesign.jsp");
		dispatcher.forward(request, response);	
	}


	private void deleteDesign(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String design_id = request.getParameter("id");
		int id  = Integer.parseInt(design_id);
		designDao.deleteDesign(id);
		response.sendRedirect("homeUser");
	}
	private void createDemande(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		String demande_type = request.getParameter("demande_type");
		String demande_dimension = request.getParameter("demande_dimension");
		String commentaire = request.getParameter("commentaire");
		String statut = "not traited";
		
		
		System.out.println(demande_type);
		final LocalDateTime design_date = LocalDateTime.now();
		
		Demande newDamande= new Demande(idUser,demande_type,  demande_dimension,  commentaire, statut);
		
		System.out.println(newDamande.getDemande_type());
		
		demandeDao.createDemande(newDamande);
		response.sendRedirect("homeUser");
	}
	private void createD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("gggggg");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/formDemande.jsp");
		dispatcher.forward(req, resp);		
	}
	private void userDemande(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Demande> listDemandes = demandeDao.getAllDemandeByUser(idUser);
		request.setAttribute("listDemandes", listDemandes);
		System.out.println(listDemandes.get(0).getDemande_id());
		request.setAttribute("idUser", idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userDemande.jsp");
		dispatcher.forward(request, response);
		

	}
	private void allDemandeByUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Demande> listDemandes = demandeDao.getAllDemandeforAdmin();
		
		request.setAttribute("listDemandes", listDemandes);
		request.setAttribute("idUser", idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/allDemandes.jsp");
		dispatcher.forward(request, response);

	}
	private void updateDemande(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String demande_id = request.getParameter("id");
		int demandeId= Integer.parseInt(demande_id);
		

		
		demandeDao.updateDemande(demandeId);
		response.sendRedirect("allDemandeByUsers");
	}
	private void answerDemande(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		String demande_id = request.getParameter("id");
		int demandeId= Integer.parseInt(demande_id);
		String comment = request.getParameter("comment");
//		String path = request.getParameter("path");
		
		System.out.println("In do post method of Add Image servlet.");
		Part file=request.getPart("path");
		
		String path=file.getSubmittedFileName();  // get selected image file name
		System.out.println("Selected Image File Name : "+path);
		
		String uploadPath="C:\\Users\\rim\\Documents\\DesignVerse\\WebContent\\images"+path;  // upload path where we have to upload our actual image
		System.out.println("Upload Path : "+uploadPath);
		try
		{
		
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println(comment);
		
		DemandeAnswer newDamandeA= new DemandeAnswer(comment,  path,  idUser, demandeId);
		
		System.out.println(newDamandeA.getComment());
		
		demandeAnswerDao.createAnswer(newDamandeA);
		demandeDao.updateDemande(demandeId);
		response.sendRedirect("homeAdmin");
	}
	private void createA(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("gggggg");
		String demande_id = req.getParameter("id");
		int demandeId= Integer.parseInt(demande_id); 
		req.setAttribute("demandeId", demandeId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/repAdmin.jsp");
		dispatcher.forward(req, resp);		
	}	
	private void createDemandeEval(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
//		String design = request.getParameter("design");
		String comment = request.getParameter("comment");
		String statut = "not evaluated";
		
		
		System.out.println("In do post method of Add Image servlet.");
		Part file=request.getPart("design");
		
		String design=file.getSubmittedFileName();  // get selected image file name
		System.out.println("Selected Image File Name : "+design);
		
		String uploadPath="C:\\Users\\rim\\Documents\\DesignVerse\\WebContent\\images"+design;  // upload path where we have to upload our actual image
		System.out.println("Upload Path : "+uploadPath);
		try
		{
		
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		System.out.println(comment);
		
		Evaluation newEvaluation= new Evaluation(idUser,design,  comment, statut);
		
		System.out.println(newEvaluation.getComment());
		
		demandeEvalDao.createDemandeEval(newEvaluation);
		response.sendRedirect("homeUser");
	}
	private void createE(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("gggggg");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/formDemandeEval.jsp");
		dispatcher.forward(req, resp);		
	}
	private void userEvaluations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Evaluation> listDemandes = demandeEvalDao.getAllDemandeEvalByUser(idUser);
		request.setAttribute("listDemandes", listDemandes);
		System.out.println(listDemandes.get(0).getEvaluation_id());
		request.setAttribute("idUser", idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/userEvaluations.jsp");
		dispatcher.forward(request, response);
		

	}
	private void allEvaluationsByUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Evaluation> listDemandes = demandeEvalDao.getAllDemandeEvalforAdmin();
		
		request.setAttribute("listDemandes", listDemandes);
		request.setAttribute("idUser", idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/allEvaluations.jsp");
		dispatcher.forward(request, response);

	}
	private void answerEvaluation(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		/*HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");*/
		int idUser = 15;
		String evaluation_id = request.getParameter("id");
		int evaluationId= Integer.parseInt(evaluation_id);
		System.out.println(evaluationId);
		String note = request.getParameter("note");
		String text = request.getParameter("text");
		
		
		EvaluationAnswer newDamandeA= new EvaluationAnswer(note,  text,  evaluationId, idUser);
		
		System.out.println(newDamandeA.getEvaluation_id());
		
		evaluationAnswerDao.createEvalAnswer(newDamandeA);
		demandeEvalDao.updateDemandeE(evaluationId);
		response.sendRedirect("homeAdmin");
	}
	private void createEval(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String evaluation_id = req.getParameter("id");
		int evaluationId= Integer.parseInt(evaluation_id); 
		req.setAttribute("evaluationId", evaluationId);
		System.out.println(evaluationId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/formAnswerEval.jsp");
		dispatcher.forward(req, resp);		
	}
	private void allEvaluationsPerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hhhhh");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int idUser = (int) user.getUser_id();
		List<Evaluation> listDemandes = demandeEvalDao.getAllDemandeEval();
		System.out.println(listDemandes.get(0).getComment());
		
		request.setAttribute("listDemandes", listDemandes);
		request.setAttribute("idUser", idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/homeUser.jsp");
		dispatcher.forward(request, response);

	}
	

	}
