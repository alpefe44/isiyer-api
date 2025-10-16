package com.isiyer.isiyer.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.isiyer.isiyer.business.abstracts.YardService;
import com.isiyer.isiyer.business.requests.CreateYardRequest;
import com.isiyer.isiyer.business.responses.GetByIdYardResponse;
import com.isiyer.isiyer.business.responses.JustYardResponse;
import com.isiyer.isiyer.business.responses.ProductResponse;
import com.isiyer.isiyer.business.responses.YardResponse;
import com.isiyer.isiyer.dataAccess.YardRepository;
import com.isiyer.isiyer.entity.Product;
import com.isiyer.isiyer.entity.Yard;

import lombok.AllArgsConstructor;
import lombok.Data;


@Service
@Data
@AllArgsConstructor
public class YardManager implements YardService {

	private final YardRepository yardRepository;
	
	@Override
	public List<JustYardResponse> getAll() {
		List<Yard> yards = yardRepository.findAll();
		
		List<JustYardResponse> yardResponses = yards.stream()
				.map((yard) -> {
					return new JustYardResponse(yard.getId(), yard.getYardName());
				})
				.collect(Collectors.toList());
		
		return yardResponses;
	}

	@Override
	public GetByIdYardResponse getByIdYardResponse(int id) {

	    Yard yard = yardRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Bu ID ile şantiye bulunamadı: " + id));

	    List<Product> productEntities = yard.getProducts();


	    List<ProductResponse> productResponses = productEntities.stream()
	            .map(product -> new ProductResponse(   
	                    product.getCode(),            
	                    product.getDescription(),
	                    product.getAmount(),
	                    product.getUnit(), null
	            ))
	            .collect(Collectors.toList());          
	    GetByIdYardResponse response = new GetByIdYardResponse(yard.getYardName(), productResponses);
	    
	    return response;
	}
	
	private YardResponse convertToYardResponse(Yard yard) {
	        List<ProductResponse> productDtos = yard.getProducts().stream()
	                .map(product -> new ProductResponse(
	                        product.getCode(),
	                        product.getDescription(),
	                        product.getAmount(),
	                        product.getUnit(), null
	                ))
	                .collect(Collectors.toList());

	        return new YardResponse(yard.getId(), yard.getYardName(), productDtos);
	    }
	
	 public List<YardResponse> getAllYardsAsDto() {
	        List<Yard> yards = yardRepository.findAll();


	        List<YardResponse> yardResponses = yards.stream()
	                .map(this::convertToYardResponse) 
	                .collect(Collectors.toList());

	        return yardResponses;
	    }

	 @Override
	 public void add(CreateYardRequest createYardRequest) {
		 Yard yard = new Yard(
		            createYardRequest.getYardName()
		        );
		 
		 this.yardRepository.save(yard);
		
	 }


}
