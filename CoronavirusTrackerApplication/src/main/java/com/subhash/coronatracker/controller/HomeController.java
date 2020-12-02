/**
 * 
 */
package com.subhash.coronatracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.subhash.coronatracker.service.CoronaVirusDataService;

/**
 * @author Subhash
 *
 */

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
		return "home";
	}
}
