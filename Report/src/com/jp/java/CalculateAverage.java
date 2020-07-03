package com.jp.java;

import com.jp.file.constant.Constant;
import com.jp.file.service.ReportService;
import com.jp.file.service.impl.ReportServiceImpl;

public class CalculateAverage {

	public static void main(String... s) {
		ReportService service = new ReportServiceImpl();
		service.generateReport(Constant.INPUT_FILENAME, Constant.OUTPUT_FILENAME);
	}

}
