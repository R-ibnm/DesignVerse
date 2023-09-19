package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ocproj.projet.beans.DemandeAnswer;
import com.ocproj.projet.beans.EvaluationAnswer;

public class EvaluationAnswerDaoImpl implements EvaluationAnswerDAO {
	private DAOFactory daoFactory;
	public EvaluationAnswerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	private static EvaluationAnswer map( ResultSet resultSet ) throws SQLException {
		EvaluationAnswer evaluationAnswer = new EvaluationAnswer(resultSet.getString("note"), resultSet.getString("text"),resultSet.getInt("user_id"),resultSet.getInt("evaluation_id"),resultSet.getInt("answwerEval_id"));
		return evaluationAnswer;
	}
	private static EvaluationAnswer map2( ResultSet resultSet ) throws SQLException {
		EvaluationAnswer evaluationAnswer = new EvaluationAnswer(resultSet.getString("note"), resultSet.getString("text"));
		return evaluationAnswer;
	}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	@Override
	public void createEvalAnswer(EvaluationAnswer evaluationAnswer) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO answereval (note, text, user_id, evaluation_id) VALUES (?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, evaluationAnswer.getNote(), evaluationAnswer.getText(),evaluationAnswer.getUser_id(),evaluationAnswer.getAnswerEval_id() );
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de demande, aucune ligne ajoutée dans la table." );
            }
           
	    } catch ( SQLException e ) {
	        System.out.println("probleme create demande"+e);
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }	
		
	}
	@Override
	public EvaluationAnswer findDemandeEval(int id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT note, text, user_id,evaluation_id,answwerEval_id FROM answereval WHERE answwerEval_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    EvaluationAnswer evaluationAnswer = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	evaluationAnswer = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return evaluationAnswer;
	}
	@Override
	public EvaluationAnswer getEvalAnswer(int demande_id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT note, text FROM answereval WHERE evaluation_id =? ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    EvaluationAnswer evaluationAnswer = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, demande_id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	evaluationAnswer = map2( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return evaluationAnswer;
	}

}
