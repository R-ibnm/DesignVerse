package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ocproj.projet.beans.Demande;
import com.ocproj.projet.beans.DemandeAnswer;

	public class DemandeAnswerDaoImpl implements DemandeAnswerDAO{
	private DAOFactory daoFactory;
	public DemandeAnswerDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	private static DemandeAnswer map( ResultSet resultSet ) throws SQLException {
		DemandeAnswer demandeAnswer = new DemandeAnswer(resultSet.getString("comment"), resultSet.getString("path"),resultSet.getInt("user_id"),resultSet.getInt("demande_id"),resultSet.getInt("reponseD_id"));
		return demandeAnswer;
	}
	private static DemandeAnswer map2( ResultSet resultSet ) throws SQLException {
		DemandeAnswer demandeAnswer = new DemandeAnswer(resultSet.getString("comment"), resultSet.getString("path"),resultSet.getInt("user_id"),resultSet.getInt("demande_id"));
		return demandeAnswer;
	}
	private static DemandeAnswer map3( ResultSet resultSet ) throws SQLException {
		DemandeAnswer demandeAnswer = new DemandeAnswer(resultSet.getString("comment"), resultSet.getString("path"));
		return demandeAnswer;
	}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public void createAnswer(DemandeAnswer demandeAnswer) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO demandeAnswer (comment, path, user_id, demande_id) VALUES (?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, demandeAnswer.getComment(), demandeAnswer.getPath(),demandeAnswer.getUser_id(),demandeAnswer.getDemande_id() );
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
	public DemandeAnswer findDemande(int id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT comment, path, user_id,demande_id,reponseD_id FROM demandeAnswer WHERE reponseD_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    DemandeAnswer demandeAnswer = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	demandeAnswer = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return demandeAnswer;
	}

	@Override
	public DemandeAnswer getAnswer(int demande_id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT comment, path FROM demandeanswer WHERE demande_id =? ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    DemandeAnswer demandeAnswer = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, demande_id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	demandeAnswer = map3( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return demandeAnswer;
	}
	

}
