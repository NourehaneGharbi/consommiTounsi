package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="Commande")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Commande implements Serializable{

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCmd")
    Long idCmd;
    
    @Column(name="payType")
    String payType;
	
   // @JsonManagedReference
    @JsonIgnore
    @ManyToMany(mappedBy="commandes", cascade = CascadeType.ALL)
	private Set<Produit> produits;
    
}
