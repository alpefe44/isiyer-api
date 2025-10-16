package com.isiyer.isiyer.business.abstracts;

import java.util.List;

import com.isiyer.isiyer.business.requests.CreateYardRequest;
import com.isiyer.isiyer.business.responses.GetByIdYardResponse;
import com.isiyer.isiyer.business.responses.JustYardResponse;
import com.isiyer.isiyer.business.responses.YardResponse;

public interface YardService {
	public void add(CreateYardRequest createYardRequest);
	public List<JustYardResponse> getAll();
	public GetByIdYardResponse getByIdYardResponse(int id);
	public List<YardResponse> getAllYardsAsDto();
	
}
