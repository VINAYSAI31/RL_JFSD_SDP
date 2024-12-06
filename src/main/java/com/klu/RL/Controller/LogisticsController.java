package com.klu.RL.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.klu.RL.model.Logistics;
import com.klu.RL.service.LogisticsServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/logi")
public class LogisticsController {

	@Autowired
	private LogisticsServiceImp logiser;
	
	@PostMapping("/addlog")
	public ResponseEntity<?> addlogi(@RequestBody Logistics logi)
	{
		System.out.println("got req");
		try {
			boolean res=logiser.adddelivery(logi);
			if(res)
			{
			return ResponseEntity.ok("succesfully added");
			}
			else
			{
				return ResponseEntity.internalServerError().body("Internal server occured");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getLocalizedMessage());
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	
}
