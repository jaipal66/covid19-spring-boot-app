package com.jp.design.patterns;

public class ComercialPlan implements ElectrictyPlan {

	double rate = 8.5;

	@Override
	public double generateBill(int units) {
		return rate * units;
	}

}
