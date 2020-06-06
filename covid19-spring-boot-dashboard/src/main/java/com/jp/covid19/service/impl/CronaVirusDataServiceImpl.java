package com.jp.covid19.service.impl;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jp.covid19.constants.Constant;
import com.jp.covid19.dto.LocationStatsDto;
import com.jp.covid19.service.CronaVirusDataService;

@Service
public class CronaVirusDataServiceImpl implements CronaVirusDataService{


	@Autowired
	private RestTemplate restTemplate;

	private List<LocationStatsDto> allStats = new ArrayList<>();

	@PostConstruct
	@Scheduled(cron = Constant.CRON)
	public void fetchCronaVirusData() throws IOException {
		List<LocationStatsDto> newStats = new ArrayList<>();
		String value = restTemplate.getForObject(Constant.URL, String.class);
		StringReader csvFileStringReader = new StringReader(value);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvFileStringReader);
		for (CSVRecord record : records) {
			LocationStatsDto locationStatsDto = new LocationStatsDto();
			locationStatsDto.setCountry(record.get(Constant.COUNTRY));
			locationStatsDto.setState(record.get(Constant.STATE));
			int latestCases=Integer.parseInt(record.get(record.size() - 1));
			int previousDayCases=Integer.parseInt(record.get(record.size() - 2));
			locationStatsDto.setLatestTotalCases(latestCases);
			locationStatsDto.setChnagesFromYesterday(latestCases-previousDayCases);
			newStats.add(locationStatsDto);
		}
		this.allStats = newStats;
	}
	
	public List<LocationStatsDto> getAllStats(){
		return allStats;
	}
}
