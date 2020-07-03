package com.jp.file.write;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import com.jp.file.constant.Constant;

public class WriteToFile {

	public void write(String fileName, Map<String, Float> averageIncomeMap) {
		try {
			FileWriter writer = new FileWriter(new File(fileName));
			writer.append(Constant.OUTPUT_FILE_HEADER);
			writer.append(Constant.NEW_LINE);
			for (Map.Entry<String, Float> entry : averageIncomeMap.entrySet()) {
				String key = entry.getKey();
				Float value = entry.getValue();
				String CountryGender[] = key.split(Constant.COMMA);
				String outputFileLine = CountryGender[0] + Constant.SPACE + CountryGender[1] + Constant.SPACE + value;
				writer.append(outputFileLine);
				writer.append(Constant.NEW_LINE);
			}
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
