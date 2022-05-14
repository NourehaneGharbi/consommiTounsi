package tn.consommiTounsi.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUser")
	Long idUser;
	
	@Column(name="email")
	String email;
	
	@Column(name="fullName")
	String fullName;
	
	
}
