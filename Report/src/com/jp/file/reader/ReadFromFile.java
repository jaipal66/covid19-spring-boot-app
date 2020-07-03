package com.jp.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.jp.file.constant.Constant;
import com.jp.file.enums.CurrencyType;

public class ReadFromFile {

	public Map<String, Float> read(String fileName, Map<String, Float> averageIncomeMap) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String line = "";
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String lineData[] = line.split(Constant.COMMA);
				if (lineData.length > 1)
					preapreMap(lineData[0], lineData[1], lineData[2], currencyConverter(lineData[4], CurrencyType.valueOf(lineData[3])),
							averageIncomeMap);

			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return averageIncomeMap;
	}

	private void preapreMap(String city, String country, String gender, float averageIncome,
			Map<String, Float> averageIncomeMap) {
		if (country.isEmpty()) {
			if (averageIncomeMap.containsKey(city + Constant.COMMA + gender)) {
				averageIncome += averageIncomeMap.get(city + Constant.COMMA + gender);
				averageIncomeMap.put(city + Constant.COMMA + gender, averageIncome);
			} else
				averageIncomeMap.put(city + Constant.COMMA + gender, averageIncome);
		} else {
			if (averageIncomeMap.containsKey(country + Constant.COMMA + gender)) {
				averageIncome += averageIncomeMap.get(country + Constant.COMMA + gender);
				averageIncomeMap.put(country + Constant.COMMA + gender, averageIncome);
			} else
				averageIncomeMap.put(country + Constant.COMMA + gender, averageIncome);
		}
	}

	private float currencyConverter(String average, CurrencyType currency) {
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
