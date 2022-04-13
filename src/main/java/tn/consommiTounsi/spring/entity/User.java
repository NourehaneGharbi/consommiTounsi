package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User")


public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUser")
	Long idUser;
	
	@Column(name="nomUser")
	String nomUser;
	
	@Column(name="prenomUser")
	String prenomUser;

	@Column(name="email")
	String email;
	
	@Column(name="password")
	String password;
	
	@Column(name="numTelephone")
	Integer numTelephone;
	
	@Column(name="role")
	Role role;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(Integer numTelephone) {
		this.numTelephone = numTelephone;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User() {
		
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	public User(Long idUser, String nomUser, String prenomUser, String email, String password, Integer numTelephone,
			Role role) {
		super();
		this.idUser = idUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.email = email;
		this.password = password;
		this.numTelephone = numTelephone;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", email=" + email
				+ ", password=" + password + ", numTelephone=" + numTelephone + ", role=" + role + "]";
	}
	
	

}
