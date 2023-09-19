package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

import com.ocproj.projet.beans.Design;

public class DesignDaoImpl implements DesignDAO{
	private DAOFactory daoFactory;
	
	public DesignDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	private static Design map( ResultSet resultSet ) throws SQLException {
		Design design = new Design(resultSet.getString("design_name"), resultSet.getString("type"), resultSet.getString("dimension"),resultSet.getString("design_color"),resultSet.getInt("user_id"));
		return design;
	}
	private static Design map2( ResultSet resultSet ) throws SQLException {
		Design design = new Design(resultSet.getInt("design_id"),resultSet.getString("design_name"), resultSet.getString("type"), resultSet.getString("dimension"),resultSet.getString("design_color"),resultSet.getInt("user_id"));
		return design;
	}
	private static Design map3( ResultSet resultSet ) throws SQLException {
		Design design = new Design(resultSet.getString("design_name"), resultSet.getString("type"), resultSet.getString("dimension"),resultSet.getString("design_color"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("email"));
		return design;
	}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}

	@Override
	public void createDesign(Design design) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO design (design_name, type, dimension, design_color, user_id) VALUES (?,?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, design.getDesign_name(),design.getType(), design.getDimension(), design.getDesign_color(), design.getUser_id() );
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du client, aucune ligne ajoutée dans la table." );
            }
           
	    } catch ( SQLException e ) {
	        System.out.println("probleme create design"+e);
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
	}

	@Override
	public Design findDesign(int id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT design_id, design_name, type, dimension, design_color, user_id FROM design WHERE design_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Design design = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, id );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	design = map2( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return design;
	}

	@Override
	public void updateDesign(Design design) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "UPDATE design SET design_name =? , type=?, dimension=?, design_color=? WHERE design_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, design.getDesign_name(), design.getType(), design.getDimension(), design.getDesign_color(), design.getDesign_id());
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
	public void deleteDesign(int id) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "DELETE FROM design WHERE design_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, id);
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du design, aucune ligne supprimée de la table." );
            } 
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
	}

	@Override
	public List<Design> getAllDesign() {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT design_id, design_name,type, dimension, design_color, user_id FROM design ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Design design = null;
		List<Design> designs = new ArrayList<Design>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	design = map2( resultSet );
	        	designs.add(design);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return designs;
	}

	@Override
	public List<Design> getAllDesignByUser(int idUser) {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT design_id, design_name, type, dimension, design_color, user_id FROM design where user_id =? ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Design design = null;
		List<Design> designs = new ArrayList<Design>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idUser );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	design = map2( resultSet );
	        	designs.add(design);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return designs;
	}


	@Override
	public List<Design> getAllDesignforAdmin() {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT design_id, design_name,type, dimension, design_color, first_name, last_name, email FROM design D, users U where U.user_id = D.user_id";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Design design = null;
		List<Design> designs = new ArrayList<Design>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	design = map3( resultSet );
	        	designs.add(design);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return designs;
	}

	
}
