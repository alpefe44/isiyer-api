package com.isiyer.isiyer.webApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isiyer.isiyer.business.abstracts.YardService;
import com.isiyer.isiyer.business.responses.GetByIdYardResponse;
import com.isiyer.isiyer.business.responses.YardResponse;
import com.isiyer.isiyer.entity.Yard;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/yards")
@AllArgsConstructor
public class YardsController {
	
	private YardService yardService;
	
	@GetMapping("")
	 public List<YardResponse> getAll() {
        return yardService.getAllYardsAsDto();
    }
	
	@GetMapping("/{yardId}")
	public ResponseEntity<GetByIdYardResponse> getByIdYardResponse(@PathVariable int yardId) {
		GetByIdYardResponse response = yardService.getByIdYardResponse(yardId);
		
		return ResponseEntity.ok(response);
	}

}
