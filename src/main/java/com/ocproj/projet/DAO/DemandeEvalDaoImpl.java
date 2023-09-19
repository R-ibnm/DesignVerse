package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ocproj.projet.beans.Demande;
import com.ocproj.projet.beans.Evaluation;

public class DemandeEvalDaoImpl implements DemandeEvalDAO {
	private DAOFactory daoFactory;
	
	public DemandeEvalDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	private static Evaluation map( ResultSet resultSet ) throws SQLException {
		Evaluation evaluation = new Evaluation(resultSet.getInt("evaluation_id"),resultSet.getString("design"), resultSet.getString("comment"),resultSet.getInt("user_id"),resultSet.getString("statut"));
		return evaluation;
	}
	private static Evaluation map2( ResultSet resultSet ) throws SQLException {
		Evaluation evaluation = new Evaluation(resultSet.getInt("evaluation_id"),resultSet.getString("design"), resultSet.getString("comment"), resultSet.getString("statut"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"));
		return evaluation;
	}
	private static Evaluation map3( ResultSet resultSet ) throws SQLException {
		Evaluation evaluation = new Evaluation(resultSet.getInt("evaluation_id"),resultSet.getString("design"), resultSet.getString("comment"),resultSet.getString("statut"));
		return evaluation;
	}
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	@Override
	public void createDemandeEval(Evaluation evaluation) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO demande_evaluation (design, comment, user_id,statut) VALUES (?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, evaluation.getDesign(), evaluation.getComment(), evaluation.getEvaluation_id(),evaluation.getStatut() );
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
	public Evaluation findDemandeE(int id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT evaluation_id, design, comment, user_id ,statut FROM demande_evaluation WHERE evaluation_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Evaluation evaluation = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	evaluation = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return evaluation;
	}
	@Override
	public void updateDemandeE(int evaluation_id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "UPDATE demande_evaluation SET statut='evaluated' WHERE evaluation_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, evaluation_id);
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                throw new DAOException( "Échec de modification." );
            } 

	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	}
	@Override
	public void deleteDemandeEval(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Evaluation> getAllDemandeEval() {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT evaluation_id, design,comment,statut FROM demande_evaluation WHERE statut ='evaluated' ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Evaluation demande = null;
		List<Evaluation> demandes = new ArrayList<Evaluation>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	demande = map3( resultSet );
	        	demandes.add(demande);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return demandes;
	}
	@Override
	public List<Evaluation> getAllDemandeEvalByUser(int idUser) {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT evaluation_id, design,comment,statut FROM demande_evaluation WHERE user_id =? ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Evaluation demande = null;
		List<Evaluation> demandes = new ArrayList<Evaluation>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idUser );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	demande = map3( resultSet );
	        	demandes.add(demande);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return demandes;
	}
	@Override
	public List<Evaluation> getAllDemandeEvalforAdmin() {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT evaluation_id, design, comment,statut,first_name,last_name,email FROM demande_evaluation D,users U where U.user_id = D.user_id and statut='not evaluated'";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Evaluation evaluation = null;
		List<Evaluation> evaluations = new ArrayList<Evaluation>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	evaluation = map2( resultSet );
	        	evaluations.add(evaluation);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return evaluations;
	}


}
