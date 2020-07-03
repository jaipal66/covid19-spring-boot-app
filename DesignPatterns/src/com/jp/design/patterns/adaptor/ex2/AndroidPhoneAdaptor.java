package com.jp.design.patterns.adaptor.ex2;

public class AndroidPhoneAdaptor  implements IPhone{

	AndroidPhone androidPhone;
	
	public AndroidPhoneAdaptor(AndroidPhone androidPhone){
		this.androidPhone=androidPhone;
	}
	@Override
	public void chargePhone() {
		androidPhone.chargePhone();
		
	}

	
}
