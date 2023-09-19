package com.ocproj.projet.DAO;

import java.util.List;

import com.ocproj.projet.beans.DemandeAnswer;

public interface DemandeAnswerDAO {
	void createAnswer( DemandeAnswer demandeAnswer ) throws DAOException;
	DemandeAnswer findDemande( int id ) throws DAOException;
	DemandeAnswer getAnswer(int demande_id) throws DAOException;
	

}
