package com.ocproj.projet.beans;

import java.time.LocalDateTime;
import java.util.Date;

public class Design {
	private Integer design_id ; 
	private String design_name;
	private String type;
	private String dimension;
	private String design_color;	
	private String palette_id;
//	private LocalDateTime design_date;
	private Integer user_id ;
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
	public void setEnail(String enail) {
		this.email = email;
	}
	public Integer getDesign_id() {
		return design_id;
	}
	public void setDesign_id(Integer design_id) {
		this.design_id = design_id;
	}
	public String getDesign_name() {
		return design_name;
	}
	public void setDesign_name(String design_name) {
		this.design_name = design_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getDesign_color() {
		return design_color;
	}
	public void setDesign_color(String design_color) {
		this.design_color = design_color;
	}
	public String getPalette_id() {
		return palette_id;
	}
	public void setPalette_id(String palette_id) {
		this.palette_id = palette_id;
	}
//	public LocalDateTime getDesign_date() {
//		return design_date;
//	}
//	public void setDesign_date(LocalDateTime design_date) {
//		this.design_date = design_date;
//	}
	public Design(int design_id, String design_name, String type, String dimension, String design_color, int user_id) {
		super();
		this.design_id = design_id;
		this.design_name = design_name;
		this.dimension = dimension;
		this.type = type;
		this.design_color = design_color;
		this.setUser_id(user_id);
				
	}
	public Design(int design_id, String design_name, String type, String dimension, String design_color) {
		super();
		this.design_id = design_id;
		this.design_name = design_name;
		this.dimension = dimension;
		this.type = type;
		this.design_color = design_color;
				
	}
	public Design(String design_name2, String type2, String dimension2, String design_color2,
			int idUser) {
		// TODO Auto-generated constructor stub
		super();
		this.design_name = design_name2;
//		this.design_date = design_date;
		this.dimension = dimension2;
		this.type = type2;
		this.design_color = design_color2;
		this.setUser_id(idUser);
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Design(String design_name, String type, String dimension, String design_color, String first_name,
			String last_name, String enail) {
		super();
		this.design_name = design_name;
		this.type = type;
		this.dimension = dimension;
		this.design_color = design_color;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = enail;
	}
	
	
	
	
	
}
