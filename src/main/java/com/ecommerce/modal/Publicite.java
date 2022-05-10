package com.ecommerce.modal;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Publicite implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPub;
	private String typePub;
	private String canalPub;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datf;
	private Date dated;
	
	@JsonIgnore
	@ManyToOne
	Product produit;
	
	
	public void setDatf(Date datf) {
		this.datf = datf;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public Publicite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Publicite(int idPub, String typePub, String canalPub, Date datf, Date dated, Product produit) {
		super();
		this.idPub = idPub;
		this.typePub = typePub;
		this.canalPub = canalPub;
		this.datf = datf;
		this.dated = dated;
		this.produit = produit;
	}
	
	public int getIdPub() {
		return idPub;
	}
	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}
	public String getTypePub() {
		return typePub;
	}
	public void setTypePub(String typePub) {
		this.typePub = typePub;
	}
	public String getCanalPub() {
		return canalPub;
	}
	public void setCanalPub(String canalPub) {
		this.canalPub = canalPub;
	}
	public Date getDatf() {
		return datf;
	}
	public Product getProduit() {
		return produit;
	}
	public void setProduit(Product produit) {
		this.produit = produit;
	}
	public Publicite(String typePub) {
		
		this.typePub = typePub;
	}
	    
	
	

}