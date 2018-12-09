package model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pId;
	@Column(name="ProductName", length=10)
	private String pName;
	@Column(name="ProductCost")
	@Min(value=100)
	@Max(value=100000)
	private String pCost;
	
	@OneToOne(mappedBy="parent")
	private ProductDetail pdetail;
	
	@ManyToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)
	private Customer cust;
	
	public ProductDetail getPdetail() {
		return pdetail;
	}
	public void setPdetail(ProductDetail pdetail) {
		this.pdetail = pdetail;
	}
	public Product() {
		
	}
	public Product(String pName, String pCost) {
		super();
		this.pName = pName;
		this.pCost = pCost;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCost() {
		return pCost;
	}
	public void setpCost(String pCost) {
		this.pCost = pCost;
	}
	
}
