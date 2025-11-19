package com.isiyer.isiyer.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.isiyer.isiyer.business.abstracts.ProductService;
import com.isiyer.isiyer.business.requests.CreateProductRequest;
import com.isiyer.isiyer.business.requests.UpdateProductRequest;
import com.isiyer.isiyer.business.responses.ProductResponse;
import com.isiyer.isiyer.dataAccess.ProductRepository;
import com.isiyer.isiyer.dataAccess.YardRepository;
import com.isiyer.isiyer.entity.Product;
import com.isiyer.isiyer.entity.Yard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@Data
@AllArgsConstructor
public class ProductManager implements ProductService {
	
	private final ProductRepository productRepository;
	private final YardRepository yardRepository;

	@Override
	public void add(int yardId , CreateProductRequest dto) {
		
		Yard yard = yardRepository.findById(yardId).orElseThrow();
			
		 Product product = new Product();
		 product.setCode(dto.getCode());
		 product.setMalHizmet(dto.getMalHizmet());
		 product.setDescription(dto.getDescription());
		 product.setAmount(dto.getAmount());
		 product.setUnit(dto.getUnit());
		    
		 product.setYard(yard);

		 productRepository.save(product);
	}

	@Override
	public List<ProductResponse> getProductsByYardId(int yardId) {
		
		   List<Product> products = productRepository.findByYard_Id(yardId);
		   Yard yard = yardRepository.findById(yardId).orElseThrow();
		   
		   ProductResponse.YardInfo yardInfo = new ProductResponse.YardInfo(
		            yard.getId(),
		            yard.getYardName()
		    );
	        
	       List<ProductResponse> response = products.stream()
	                .map(product -> new ProductResponse(
	                        product.getCode(),
	                        product.getMalHizmet(),
	                        product.getDescription(),
	                        product.getAmount(),
	                        product.getUnit(),
	                        yardInfo))
	                .collect(Collectors.toList());
	        
	        return response;
	}

	@Override
	public void update(int productId, UpdateProductRequest request) {
		Product productToUpdate = productRepository.findById(productId).orElseThrow();
		
		Yard newYard = yardRepository.findById(request.getYardId()).orElseThrow();
		
		 productToUpdate.setCode(request.getCode());
	     productToUpdate.setDescription(request.getDescription());
	     productToUpdate.setAmount(request.getAmount());
	     productToUpdate.setUnit(request.getUnit());
	     
	     productToUpdate.setYard(newYard);
	     productRepository.save(productToUpdate);
	}
}
