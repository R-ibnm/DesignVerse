package com.ocproj.projet.DAO;

import java.util.List;

import com.ocproj.projet.beans.Demande;
import com.ocproj.projet.beans.Design;

public interface DemandeDAO {
	void createDemande( Demande demande ) throws DAOException;
	Demande findDemande( int id ) throws DAOException;

	List<Demande> getAllDemandeByUser(int idUser);
	List<Demande> getAllDemandeforAdmin();
	void updateDemande(int demande_id) throws DAOException;
	
}
