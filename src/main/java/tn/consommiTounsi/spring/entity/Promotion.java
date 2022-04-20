package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "promotion")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Promotion implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	Long idPromotion;
	
	//@Temporal (TemporalType.DATE)
	LocalDateTime datePromotionDebut;

	@Temporal (TemporalType.DATE)
	Date datePromotionFin;

	String typePromotion;
	
	double valeurPromotion;
	
	double newProductPrice; 
	
	@ManyToOne
	Stock stock;

	
}
