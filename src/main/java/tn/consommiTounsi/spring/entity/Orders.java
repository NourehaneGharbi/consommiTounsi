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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "orders")
public class Orders implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id_cmd")
	private int idCmd;
	
	@Column(name="id_user")
	private int idUser;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="pay_type")
	private String payType;
	
	@Column(name="sum")
	private float sum;
	
	@Column(name="validation")
	private boolean validation;
	
	/////////////
	
	private int idPanier ;
	
	public int getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	
	
	//Add foreign_key to orders
	
	@OneToOne
	@JoinColumn(name="panier_idFk",referencedColumnName="id_panier")
	private Panier panier ;
	
	
	@JsonIgnore
	@OneToOne(mappedBy="order")
	private Facture facture ;
	
	
	

	
	
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	public int getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	/////////////////
	public boolean getValidation() {
		return validation;
	}
	/////////////////
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	public Orders(int idUser, String payType, float sum, boolean validation) {
		super();
		this.idUser = idUser;
		this.payType = payType;
		this.sum = sum;
		this.validation = validation;
	}
	public Orders( int idCmd) {
		super();
	
		this.idCmd= idCmd;
	}
	public Orders() {
		super();
	
	}
	public Orders(String userName, Panier panier) {
		super();
		this.userName = userName;
		this.panier = panier;
	}

	

	
	
	

}