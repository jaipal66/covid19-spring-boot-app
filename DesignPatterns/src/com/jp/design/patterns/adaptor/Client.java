package com.jp.design.patterns.adaptor;

import com.jp.design.patterns.adaptor.ex2.AndroidPhone;
import com.jp.design.patterns.adaptor.ex2.AndroidPhoneAdaptor;
import com.jp.design.patterns.adaptor.ex2.IPhone;
import com.jp.design.patterns.adaptor.ex2.IphoneX;
import com.jp.design.patterns.adaptor.ex2.OnePlus5;

public class Client {

	public static void main(String[] args) {
		
		OldCustomer old=new OldCustomer();
		old.setName("Jaipal");
		old.setAge("26");
		old.setAddress("Vagdevi Layout,Bengaluru,560037");
		
		Customer customer=new CustomerAdaptor(old);
		System.out.println(customer.getName());
		System.out.println(customer.getAge());
		System.out.println(customer.getAddress().getCityName());
		
		System.out.println("==================");
		
		IPhone iphone=new IphoneX();
		iphone.chargePhone();
		
		AndroidPhone androidPhone =new OnePlus5();
		androidPhone.chargePhone();
		
		IPhone adaptor=new AndroidPhoneAdaptor(androidPhone);
		adaptor.chargePhone();
		
		
	}
}
