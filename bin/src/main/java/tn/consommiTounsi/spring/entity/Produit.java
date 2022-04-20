package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
@Entity
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProd ;
	
	@Pattern(regexp ="^619\\d{3}$",message = "format invalide")
	private String codeProd ;
	
	
	
	@NotNull
	@Size(min = 3,max = 10, message = "le nombre de caractere doit etre compris entre 3 et 5")
	private String nomProd ;
	@NotNull
	@Min(10)
	private int quantiteProd;
	
	
	@NotNull
	private float prixProd;
	private String image;
	private CategorieProduit categorieproduit;
	
	
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="produit")
	private Set<Publicite> publicites;
	
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getCodeProd() {
		return codeProd;
	}
	public void setCodeProd(String codeProd) {
		this.codeProd = codeProd;
	}
	public String getNomProd() {
		return nomProd;
	}
	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}
	public int getQuantiteProd() {
		return quantiteProd;
	}
	public void setQuantiteProd(int quantiteProd) {
		this.quantiteProd = quantiteProd;
	}
	public float getPrixProd() {
		return prixProd;
	}
	public void setPrixProd(float prixProd) {
		this.prixProd = prixProd;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public CategorieProduit getCategorieproduit() {
		return categorieproduit;
	}
	public void setCategorieproduit(CategorieProduit categorieproduit) {
		this.categorieproduit = categorieproduit;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Produit(int idProd, @Pattern(regexp = "^619\\d{3}$", message = "format invalide") String codeProd,
			@Size(min = 3, max = 10, message = "le nombre de caractere doit etre compris entre 3 et 5") String nomProd,
			@Min(10) int quantiteProd, float prixProd, String image, CategorieProduit categorieproduit,
			Set<Publicite> publicites) {
		super();
		this.idProd = idProd;
		this.codeProd = codeProd;
		this.nomProd = nomProd;
		this.quantiteProd = quantiteProd;
		this.prixProd = prixProd;
		this.image = image;
		this.categorieproduit = categorieproduit;
		this.publicites = publicites;
	}
	public Set<Publicite> getPublicites() {
		return publicites;
	}
	public void setPublicites(Set<Publicite> publicites) {
		this.publicites = publicites;
	}
	public Produit(String nomProd) {
		super();
		this.nomProd = nomProd;
	}
	
}
