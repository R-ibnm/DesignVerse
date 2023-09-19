package com.ocproj.projet.beans;

public class DemandeAnswer {
	private String comment;
	private String path;
	private int user_id;
	private int demande_id;
	private int reponseD_id ;
	
	
	
	public DemandeAnswer(String comment, String path, int user_id, int demande_id, int reponseD_id) {
		super();
		this.comment = comment;
		this.path = path;
		this.user_id = user_id;
		this.demande_id = demande_id;
		this.reponseD_id = reponseD_id;
	}
	
	public DemandeAnswer(String comment, String path, int user_id, int demande_id) {
		super();
		this.comment = comment;
		this.path = path;
		this.user_id = user_id;
		this.demande_id = demande_id;
	}

	public DemandeAnswer(String comment, String path) {
		super();
		this.comment = comment;
		this.path = path;
	}

	public int getReponseD_id() {
		return reponseD_id;
	}
	public void setReponseD_id(int reponseD_id) {
		this.reponseD_id = reponseD_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getDemande_id() {
		return demande_id;
	}
	public void setDemande_id(int demande_id) {
		this.demande_id = demande_id;
	}


}

