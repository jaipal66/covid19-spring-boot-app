package com.jp.design.patterns.adaptor;

public class CustomerAdaptor extends NewCustomer implements Customer {

	private OldCustomer oldCustomer;

	CustomerAdaptor(OldCustomer oldCustomer) {
    this.oldCustomer=oldCustomer;
    this.transferData();

	}

	private void transferData() {
		this.setName(oldCustomer.getName());
		this.setAge(Integer.parseInt(oldCustomer.getAge()));
		
		Address address =new Address();
		String [] add=oldCustomer.getAddress().split(",");
		address.setStreetName(add[0]);
		address.setCityName(add[1]);
		address.setPostalCode(Integer.parseInt(add[2]));
		this.setAddress(address);
		
	}

}
