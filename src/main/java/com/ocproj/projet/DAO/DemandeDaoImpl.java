package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ocproj.projet.beans.Demande;
import com.ocproj.projet.beans.Design;

public class DemandeDaoImpl implements DemandeDAO {
private DAOFactory daoFactory;
	
	public DemandeDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	private static Demande map( ResultSet resultSet ) throws SQLException {
		Demande demande = new Demande(resultSet.getInt("demande_id"),resultSet.getInt("user_id"),resultSet.getString("demande_type"), resultSet.getString("demande_dimension"), resultSet.getString("commentaire"),resultSet.getString("statut"));
		return demande;
	}
	private static Demande map2( ResultSet resultSet ) throws SQLException {
		Demande demande = new Demande(resultSet.getInt("demande_id"),resultSet.getString("demande_type"), resultSet.getString("demande_dimension"), resultSet.getString("commentaire"),resultSet.getString("statut"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"));
		return demande;
	}
	private static Demande map3( ResultSet resultSet ) throws SQLException {
		Demande demande = new Demande(resultSet.getInt("demande_id"),resultSet.getString("demande_type"), resultSet.getString("demande_dimension"), resultSet.getString("commentaire"),resultSet.getString("statut"));
		return demande;
	}
	
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public void createDemande(Demande demande) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO demande_design (demande_type, demande_dimension, commentaire,statut, user_id) VALUES (?,?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, demande.getDemande_type(), demande.getDemande_dimension(), demande.getCommentaire(), demande.getStatut(),demande.getUser_id() );
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
	public List<Demande> getAllDemandeByUser(int idUser) {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT demande_id, demande_type,demande_dimension,commentaire,statut FROM demande_design WHERE user_id =? ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Demande demande = null;
		List<Demande> demandes = new ArrayList<Demande>();
        
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
	public List<Demande> getAllDemandeforAdmin() {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT demande_id, demande_type, demande_dimension, commentaire,statut,first_name,last_name,email FROM demande_design D,users U where U.user_id = D.user_id and statut='not traited'";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Demande demande = null;
		List<Demande> demandes = new ArrayList<Demande>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	demande = map2( resultSet );
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
	public Demande findDemande(int id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT demande_id, user_id, demande_type, demande_dimension, commentaire,statut FROM demande_design WHERE demande_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Demande demande = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	demande = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return demande;
	}
	@Override
	public void updateDemande(int demande_id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "UPDATE demande_design SET statut='traited' WHERE demande_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, demande_id);
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
	

}
