package com.ocproj.projet.beans;

public class Evaluation {
	
	private int evaluation_id;
	private String design;
	private String comment;
	private int user_id;
	private String statut;
	private String first_name;
	private String last_name;
	private String email;
	
	
	
	public Evaluation(int evaluation_id, String design, String comment, int user_id, String statut) {
		super();
		this.evaluation_id = evaluation_id;
		this.design = design;
		this.comment = comment;
		this.user_id = user_id;
		this.statut = statut;
	}
	
	public Evaluation(int evaluation_id, String design, String comment, String statut, String first_name,
			String last_name, String email) {
		super();
		this.evaluation_id = evaluation_id;
		this.design = design;
		this.comment = comment;
		this.statut = statut;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	

	public Evaluation(int evaluation_id, String design, String comment, String statut) {
		super();
		this.evaluation_id = evaluation_id;
		this.design = design;
		this.comment = comment;
		this.statut = statut;
	}

	public int getEvaluation_id() {
		return evaluation_id;
	}
	public void setEvaluation_id(int evaluation_id) {
		this.evaluation_id = evaluation_id;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
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
	
	
	
	
	
}
