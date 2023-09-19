package com.ocproj.projet.DAO;

import com.ocproj.projet.beans.DemandeAnswer;
import com.ocproj.projet.beans.EvaluationAnswer;

public interface EvaluationAnswerDAO {
	void createEvalAnswer( EvaluationAnswer evaluationAnswer ) throws DAOException;
	EvaluationAnswer findDemandeEval( int id ) throws DAOException;
	EvaluationAnswer getEvalAnswer(int demande_id) throws DAOException;
	

}
