package com.ocproj.projet.beans;

public class Demande {
	private int demande_id;	
	private int user_id;
	private int palette_id;
	private int design_id;
	private String demande_type;
	private String demande_dimension;
	private String commentaire;
	private String statut;
	private String first_name;
	private String last_name;
	private String email;
	
	
	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Demande(int demande_id, int user_id, String demande_type, String demande_dimension, String commentaire,
			String statut) {
		super();
		this.demande_id = demande_id;
		this.user_id = user_id;
		this.demande_type = demande_type;
		this.demande_dimension = demande_dimension;
		this.commentaire = commentaire;
		this.statut = statut;
		
	}
	
	
	public Demande(int user_id, String demande_type, String demande_dimension, String commentaire) {
		super();
		this.user_id = user_id;
		this.demande_type = demande_type;
		this.demande_dimension = demande_dimension;
		this.commentaire = commentaire;
		
	}
	


	public Demande(String demande_type, String demande_dimension, String commentaire, String statut, String first_name,
			String last_name, String email) {
		super();
		this.demande_type = demande_type;
		this.demande_dimension = demande_dimension;
		this.commentaire = commentaire;
		this.statut = statut;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}


	public Demande(int demande_id ,String demande_type, String demande_dimension, String commentaire, String statut, String first_name,
			String last_name, String email) {
		super();
		this.demande_id= demande_id;
		this.demande_type = demande_type;
		this.demande_dimension = demande_dimension;
		this.commentaire = commentaire;
		this.statut = statut;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}


	public Demande(int user_id, String demande_type, String demande_dimension, String commentaire, String statut) {
		super();
		this.user_id = user_id;
		this.demande_type = demande_type;
		this.demande_dimension = demande_dimension;
		this.commentaire = commentaire;
		this.statut = statut;
	}


	public Demande(int demande_id, String statut) {
		super();
		this.demande_id = demande_id;
		this.statut = statut;
	}


	public int getDemande_id() {
		return demande_id;
	}
	public void setDemande_id(int demande_id) {
		this.demande_id = demande_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPalette_id() {
		return palette_id;
	}
	public void setPalette_id(int palette_id) {
		this.palette_id = palette_id;
	}
	public int getDesign_id() {
		return design_id;
	}
	public void setDesign_id(int design_id) {
		this.design_id = design_id;
	}
	public String getDemande_type() {
		return demande_type;
	}
	public void setDemande_type(String demande_type) {
		this.demande_type = demande_type;
	}
	public String getDemande_dimension() {
		return demande_dimension;
	}
	public void setDemande_dimension(String demande_dimension) {
		this.demande_dimension = demande_dimension;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
}
