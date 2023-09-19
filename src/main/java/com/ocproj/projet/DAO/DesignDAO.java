package com.ocproj.projet.DAO;

import java.util.List;

import com.ocproj.projet.beans.Design;

public interface DesignDAO {
	void createDesign( Design design ) throws DAOException;
	 
	Design findDesign( int id ) throws DAOException;
	 
	 void updateDesign (Design offer)  throws DAOException;
	 
	 void deleteDesign (int id)  throws DAOException;
	 
	
	
	 List<Design> getAllDesign();
	 List<Design> getAllDesignByUser(int idUser);
	 List<Design> getAllDesignforAdmin();
	 


}
