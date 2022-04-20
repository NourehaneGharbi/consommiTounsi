package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Rayons")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rayons implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRayons")
	Long idRayons;
	
	@Column
	String typeRayons;
	
	@Column(name="categorieProduit")
	CategorieProduit categorieProduit;
	
	@Column(name="nbrCmdProd")
	Integer nbrCmdProd;
	
	@Column(name="LibelleProdVentMax")
	String LibelleProdVentMax;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="rayons")
    Set<Stock> stocks;
}
