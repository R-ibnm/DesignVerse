package com.ocproj.projet.DAO;

import java.util.List;

import com.ocproj.projet.beans.Design;
import com.ocproj.projet.beans.Evaluation;

public interface DemandeEvalDAO {
	void createDemandeEval( Evaluation evaluation ) throws DAOException;
	 
	Evaluation findDemandeE( int id ) throws DAOException;
	 
	 void updateDemandeE (int evaluation_id)  throws DAOException;
	 
	 void deleteDemandeEval (int id)  throws DAOException;
	 
	
	
	 List<Evaluation> getAllDemandeEval();
	 List<Evaluation> getAllDemandeEvalByUser(int idUser);
	 List<Evaluation> getAllDemandeEvalforAdmin();

}
