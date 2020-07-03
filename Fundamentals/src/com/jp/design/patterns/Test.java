package com.jp.design.patterns;

public class Test {

	public static void main(String[] args) {

		
		ElectrictyPlan plan=PlanFactory.getPlan(PlanType.COMERCIAL_PLAN);
		System.out.println(plan.generateBill(10));
	}
}
