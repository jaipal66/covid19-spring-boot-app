package com.jp.covid19.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jp.covid19.constants.Constant;
import com.jp.covid19.dto.LocationStatsDto;
import com.jp.covid19.service.impl.CronaVirusDataServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private CronaVirusDataServiceImpl cronaVirusDataServiceImpl;

	@GetMapping("/")
	public String root(Model model) throws Exception {
		List<LocationStatsDto> allStats = cronaVirusDataServiceImpl.getAllStats();
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalNewCases = allStats.stream().mapToInt(stat -> stat.getChnagesFromYesterday()).sum();
		model.addAttribute(Constant.LOCATION_STATS, allStats);
		model.addAttribute(Constant.TOTAL_CASES, totalCases);
		model.addAttribute(Constant.TOTAL_NEW_CASES, totalNewCases);
		return Constant.INDEX_PAGE;
	}

}
