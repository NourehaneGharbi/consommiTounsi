package tn.consommiTounsi.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name = "paniers")
public class Panier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id_panier")
	private int idPanier ;
	
	@Column(name="id_user")
	private int idUser ;
	
	@Column(name="user_name")
	private String userName ;
	
	@Column(name="sum")
	private float Sum ;
	
	@JsonIgnore
	@OneToOne(mappedBy="panier")
	private Orders order ;
//	private List<Produit> p ;
	
	
	
	

	
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getSum() {
		return Sum;
	}
	public void setSum(float sum) {
		Sum = sum;
	}
	public Panier(int idUser, String userName, float sum) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		Sum = sum;
	}
	public Panier() {
		super();
		
	}
	public Panier(int idUser, String userName) {
		super();
		this.idUser = idUser;
		this.userName = userName;
	}
	public Panier(String userName) {
		super();
		this.userName = userName;
	}
	
	
	

}
