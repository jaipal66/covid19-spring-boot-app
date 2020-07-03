package com.jp.file.converter;

import com.jp.file.enums.CurrencyType;

public class CurrencyConverter {

	public static float convert(String average, CurrencyType currency) {
		float averageIncome = 0.0f;
		if (currency != null && average != null && !average.isEmpty()) {
			averageIncome = Float.parseFloat(average);
			switch (currency) {
			case INR:
				averageIncome = averageIncome / 66;
				break;
			case GBP:
				averageIncome = (float) (averageIncome / 0.67);
				break;
			case HKD:
				averageIncome = averageIncome / 8;
				break;
			case SGP:
				averageIncome = (float) (averageIncome / 1.5);
				break;
			}
		}
		return averageIncome;
	}
}
