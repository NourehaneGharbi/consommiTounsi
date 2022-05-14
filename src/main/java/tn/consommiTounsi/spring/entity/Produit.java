package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name="Produit")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Produit implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	Long idProduit;
	
	@Column(name="codeProduit")
	String codeProduit;
	
	@Column(name="libelleProduit")
	String libelleProduit;
	
	@Column(name="prix")
	double prix;
	
	@Column(name="prixPromotion")
	double prixPromotion;
	
	@Column(name="dateCreation")
	Date dateCreation;
	
	@Column(name="dateExpiration")
	Date dateExpiration;
	
	@Column(name="categorieProduit")
	CategorieProduit categorieProduit;

	//@JsonBackReference
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Commande> commandes;
	
}

