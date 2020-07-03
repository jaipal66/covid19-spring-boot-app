package com.jp.design.patterns;

public class PlanFactory {

	public static ElectrictyPlan getPlan(PlanType plan) {
		if (plan == null)
			return null;
		else if (plan.equals(PlanType.DOMESTIC_PLAN))
			return new DomesticPlan();
		else if (plan.equals(PlanType.COMERCIAL_PLAN))
			return new ComercialPlan();

		return null;
	}
}
