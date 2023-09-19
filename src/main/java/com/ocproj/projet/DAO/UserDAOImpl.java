package com.ocproj.projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ocproj.projet.beans.User;

public class UserDAOImpl implements UserDAO {
	
	private DAOFactory daoFactory;
	public  UserDAOImpl(DAOFactory daoFactory) {
		this.daoFactory= daoFactory;
	}
	
	private static User map(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setUser_id( resultSet.getInt( "user_id" ) );
		user.setEmail(resultSet.getString( "email" ));
		user.setPassword(resultSet.getString( "password" ));
		user.setFirst_name(resultSet.getString( "first_name" ));
		user.setLast_name(resultSet.getString( "last_name" ));
		user.setUsername(resultSet.getString( "username" ));
		user.setTypeU(resultSet.getString( "typeU" ));
		
		return user;
	}
	private static User mapAdmin(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setUser_id( resultSet.getInt( "user_id" ) );
		user.setEmail(resultSet.getString( "email" ));
		user.setPassword(resultSet.getString( "password" ));
		user.setFirst_name(resultSet.getString( "first_name" ));
		user.setLast_name(resultSet.getString( "last_name" ));
		user.setUsername(resultSet.getString( "username" ));
		user.setTypeU(resultSet.getString( "typeU" ));
		
		return user;
	}
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	
	@Override
	public void create(User user) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO users (first_name, last_name,username, email, password, typeU) VALUES (?,?,?,?,?,?)";
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), user.getUsername(), user.getTypeU() );
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du client, aucune ligne ajoutée dans la table." );
            }
            resultSet = preparedStatement.getGeneratedKeys();
            if ( resultSet.next() ) {
                user.setUser_id(resultSet.getInt(1));
            } else {
                throw new DAOException( "Échec de la création du client en base, aucun ID auto-généré retourné." );
            }
	    } catch ( SQLException e ) {
	        System.out.println("probleme create admin"+e);
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	}
	

	@Override
	public void delete(int idUser) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "DELETE FROM users WHERE user_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idUser );
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                throw new DAOException( "Échec de la suppression du client, aucune ligne supprimée de la table." );
            } 
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	}

	@Override
	public boolean update(User user) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "UPDATE users SET email = ?, password = ?, first_name =?, last_name =?, username=? WHERE user_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    boolean rs = false;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, user.getEmail(), user.getPassword(),user.getFirst_name(), user.getLast_name(), user.getUsername());
	        int statut = preparedStatement.executeUpdate();
	        if ( statut == 0 ) {
                rs = true;
                
            } 

	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return rs;

	}

	@Override
	public User find(int idUser) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT * FROM users WHERE user_id = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    User user = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, idUser );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	user = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT * FROM users where typeU='client' ";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    User user = null;
		List<User> users = new ArrayList<User>();
        
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM );
	        resultSet = preparedStatement.executeQuery();
	        
	        while( resultSet.next() ) {
	        	
	        	user = mapAdmin( resultSet );
	        	users.add(user);
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return users;
	}

	@Override
	public boolean register(User user) throws DAOException {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "INSERT INTO users ( email , password, first_name, last_name, username, typeU) VALUES (?,?,?,?,?,?)";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    boolean rs = false;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, user.getEmail(), user.getPassword(),user.getFirst_name(), user.getLast_name(), user.getUsername(), user.getTypeU());
	        int statut = preparedStatement.executeUpdate();
	        if ( statut !=0 ) {
                rs = true;
                
            } 

	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		return rs;
	}

	@Override
	public User InfoUser(String email, String password) {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT * FROM users WHERE email=? AND password = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    User user = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, email, password );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	user = map( resultSet );
	        }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( "ffff"+e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	    return user;
	}

	@Override
	public boolean isUserAlredy(String email) {
		// TODO Auto-generated method stub
		final String SQL_SELECT_PAR_NOM = "SELECT * FROM users WHERE email = ?";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    boolean existe = false;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, email );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	existe=true;
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	    return existe;
	}
	
}
