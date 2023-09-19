package com.ocproj.projet.DAO;

import java.util.*;

import com.ocproj.projet.beans.*;

public interface UserDAO {
	void create(User user) throws DAOException;
	void delete(int idUser) throws DAOException;
	boolean update(User user) throws DAOException;
	User find(int idUser) throws DAOException;
	List<User> getAllUsers();
	boolean register(User user) throws DAOException;
	User InfoUser(String email, String password);
	boolean isUserAlredy(String email);
}
