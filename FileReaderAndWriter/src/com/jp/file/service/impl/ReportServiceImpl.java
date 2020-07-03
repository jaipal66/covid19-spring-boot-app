package com.jp.file.service.impl;

import java.util.Map;
import java.util.TreeMap;

import com.jp.file.reader.ReadFromFile;
import com.jp.file.service.ReportService;
import com.jp.file.write.WriteToFile;

public class ReportServiceImpl implements ReportService {
	private static Map<String, Float> averageIncomeMap = new TreeMap<>();

	@Override
	public void generateReport(String inputFileName, String outFileName) {
		averageIncomeMap=new ReadFromFile().read(inputFileName, averageIncomeMap);
		new WriteToFile().write(outFileName, averageIncomeMap);
		
	}

}
