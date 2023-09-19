package com.ocproj.projet.beans;

public class EvaluationAnswer {
	private String note;
	private String text;
	private int evaluation_id;
	private int user_id;	
	private int answerEval_id ;

	
	
	public EvaluationAnswer(String note, String text) {
		super();
		this.note = note;
		this.text = text;
	}
	public EvaluationAnswer(String note, String text, int evaluation_id, int user_id, int answerEval_id) {
		super();
		this.note = note;
		this.text = text;
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
		this.answerEval_id = answerEval_id;
	}
	
	
	public EvaluationAnswer(String note, String text, int evaluation_id, int user_id) {
		super();
		this.note = note;
		this.text = text;
		this.evaluation_id = evaluation_id;
		this.user_id = user_id;
	}
	public int getAnswerEval_id() {
		return answerEval_id;
	}
	public void setAnswerEval_id(int answerEval_id) {
		this.answerEval_id = answerEval_id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getEvaluation_id() {
		return evaluation_id;
	}
	public void setEvaluation_id(int evaluation_id) {
		this.evaluation_id = evaluation_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}

