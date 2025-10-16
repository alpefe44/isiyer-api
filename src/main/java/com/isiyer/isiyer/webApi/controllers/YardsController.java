package com.isiyer.isiyer.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isiyer.isiyer.business.abstracts.YardService;
import com.isiyer.isiyer.business.requests.CreateYardRequest;
import com.isiyer.isiyer.business.responses.GetByIdYardResponse;
import com.isiyer.isiyer.business.responses.YardResponse;

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
	
	@PostMapping("/add")
	public ResponseEntity<Void> addYard(@RequestBody CreateYardRequest createYardRequest) {
		this.yardService.add(createYardRequest);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
