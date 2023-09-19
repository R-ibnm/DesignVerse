package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ocproj.projet.beans.User;

public class LoginDaoImpl implements LoginDAO{

private DAOFactory          daoFactory;
	
	public LoginDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	@Override
	public boolean validate(User user) throws DAOException {
		final String SQL_SELECT_PAR_NOM = "SELECT * FROM users WHERE email=? AND password = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    boolean status = false;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM,user.getEmail(), user.getPassword() );
	        resultSet = preparedStatement.executeQuery();
	        status = resultSet.next();

	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	    

		return status;
	}
	

}
