package com.isiyer.isiyer.business.abstracts;

import java.util.List;

import com.isiyer.isiyer.business.responses.GetByIdYardResponse;
import com.isiyer.isiyer.business.responses.JustYardResponse;
import com.isiyer.isiyer.business.responses.YardResponse;
import com.isiyer.isiyer.entity.Yard;

public interface YardService {
	public List<JustYardResponse> getAll();
	public GetByIdYardResponse getByIdYardResponse(int id);
	public List<YardResponse> getAllYardsAsDto();
	
}
