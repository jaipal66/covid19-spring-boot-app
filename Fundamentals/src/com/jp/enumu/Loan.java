package com.jp.enumu;

public enum Loan {

	HOME_LOAN{
		@Override
		public String toString() {
			
			return "Home Loan is at 9.5%";
		}
	},
	AUTO_LOAN,
	CAR_LOAN,
	BIKE_LOAN;
	
	
	
}
