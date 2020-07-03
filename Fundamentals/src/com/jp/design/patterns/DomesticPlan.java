package com.jp.design.patterns;

public class DomesticPlan implements ElectrictyPlan {

	double rate = 5.5;

	@Override
	public double generateBill(int units) {
		return rate * units;
	}

}
