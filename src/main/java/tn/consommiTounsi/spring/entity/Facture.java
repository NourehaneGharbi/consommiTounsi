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



@Entity
@Table(name = "factures")
public class Facture implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id_fact")
	private int idFact ;
	
	@Column(name="user_name")
	private String userName ;
	
	@Column(name="sum")
	private float sum ;
	
	@Column(name="addr_user")
	private String addrUser ;
	
	@Column(name="phone_num")
	private String phoneNum ;
	
	//Add foreign_key to facture
	@OneToOne
	@JoinColumn(name="cmd_idFk",referencedColumnName="id_cmd")
	private Orders order ;
	
	
	//List<Produits> p ;
	
	
	
	public int getIdFact() {
		return idFact;
	}
	
	public void setIdFact(int idFact) {
		this.idFact = idFact;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public String getAddrUser() {
		return addrUser;
	}
	public void setAddrUser(String addrUser) {
		this.addrUser = addrUser;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Facture(String userName, float sum, String addrUser, String phoneNum) {
		super();
		
		this.userName = userName;
		this.sum = sum;
		this.addrUser = addrUser;
		this.phoneNum = phoneNum;
	}
	public Facture() {
		super();
		
	}
	 	
	
	
	
	

}
