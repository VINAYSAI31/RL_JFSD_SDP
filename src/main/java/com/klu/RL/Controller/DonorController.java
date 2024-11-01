package com.klu.RL.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonorController {

	@GetMapping("/donorhome")
	public String donorhome()
	{
		return "donorhome";
	}
}
