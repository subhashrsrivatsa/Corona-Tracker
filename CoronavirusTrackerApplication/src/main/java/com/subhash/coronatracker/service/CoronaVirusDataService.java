/**
 * 
 */
package com.subhash.coronatracker.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.subhash.coronatracker.model.LocationStats;

/**
 * @author Subhash
 *
 */

@Service
public class CoronaVirusDataService {

	private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

	// created LocationStats model as an ArrayList
	private List<LocationStats> allStats = new ArrayList<>();

	public List<LocationStats> getAllStats(){
		return allStats;
	}
	
	
	@PostConstruct
	@Scheduled(cron = "* * 1 * * *") // schedule to run this application on every 01:00 hrs of the day
	public void fetchVirusData() throws IOException, InterruptedException {
		List<LocationStats> newStats = new ArrayList<>();
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();

		HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader csvBodyReader = new StringReader(httpResponse.body());

		// Header auto detection code from https://commons.apache.org/proper/commons-csv/user-guide.html
		
		Iterable<CSVRecord> records =  CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader); 
		for(CSVRecord record : records) {
			LocationStats locationStat = new LocationStats();
			locationStat.setState(record.get("Province/State"));
			locationStat.setCountry(record.get("Country/Region"));
			
			locationStat.setLatestTotalCases(Integer.parseInt(record.get(record.size() - 1)));
			
			System.out.println(locationStat);
			newStats.add(locationStat);
			
		}
		this.allStats = newStats;
		 
	}
}
