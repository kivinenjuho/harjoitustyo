package fi.haagahelia.harjoitustyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long userid;

	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String salasana;
	
	@Column(name = "role", nullable = false)
	private String rooli;
	
	public User() {
}
	public User(String username, String salasana, String rooli) {
		super();
		this.username = username;
		this.salasana = salasana;
		this.rooli = rooli;
	}
	
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setKayttajanimi(String username) {
		this.username = username;
	}
	public String getSalasana() {
		return salasana;
	}
	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}
	public String getRooli() {
		return rooli;
	}
	public void setRooli(String rooli) {
		this.rooli = rooli;
	}
}
