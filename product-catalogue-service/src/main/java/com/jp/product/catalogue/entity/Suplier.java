package com.jp.product.catalogue.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Suplier extends Person{
	@Id
	private int suplierID;
	@OneToMany(mappedBy="suplier", fetch=FetchType.LAZY)
	private Set<Product> products;
	
	@OneToOne(targetEntity=Address.class)
	@JoinColumn(name="address_id",referencedColumnName="addressID")
	private Address address;
	
	 

}
