package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Stock")
@Getter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	Long idStock;
	
	@Column(name="quantite")
	Integer quantite;
	
	@Column(name="quantiteMin")
	Integer quantiteMin;
	
	@Column(name="libelleStock")
	String libelleStock;
	
	@Column(name="nbrLike")
	Integer nbrLike;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	//private Set<Produit> produits;
	
	@JsonIgnore
	@OneToOne
	Produit produit;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	//private Set<Promotion> promotions;
	
	
	@Column(name="dateCreationStock")
	Date dateCreationStock;

	@Column(name="dateExpiration")
	Date dateExpiration;	
	
	@Column(name="nbrCmd")
	Integer nbrCmd;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="rayons_id_rayons")
	Rayons rayons;
	
	//Date date = new Date(System.currentTimeMillis());	

	public void setIdStock(Long idStock) {
		this.idStock = idStock;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public void setQuantiteMin(Integer quantiteMin) {
		this.quantiteMin = quantiteMin;
	}

	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public void setDateCreationStock(Date date) {
		date = new Date(System.currentTimeMillis());
		this.dateCreationStock = date;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public void setRayons(Rayons rayons) {
		this.rayons = rayons;
	}

	public void setNbrCmd(Integer nbrCmd) {
		this.nbrCmd = nbrCmd;
	}

	public void setNbrLike(Integer nbrLike) {
		this.nbrLike = nbrLike;
	}

	

}