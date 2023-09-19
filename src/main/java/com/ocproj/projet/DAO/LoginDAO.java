package com.ocproj.projet.DAO;



import com.ocproj.projet.beans.User;


public interface LoginDAO {
	public boolean validate(User user)  throws DAOException;
}