/**
 * 
 */
package com.subhash.coronatracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Subhash
 *
 */

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("testName", "TEST");
		return "home";
	}
}
