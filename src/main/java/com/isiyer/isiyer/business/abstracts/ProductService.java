package com.isiyer.isiyer.business.abstracts;

import java.util.List;

import com.isiyer.isiyer.business.requests.CreateProductRequest;
import com.isiyer.isiyer.business.requests.UpdateProductRequest;
import com.isiyer.isiyer.business.responses.ProductResponse;

public interface ProductService {
	public void add(int yardId , CreateProductRequest productDto);
	List<ProductResponse> getProductsByYardId(int yardId);
	public void update(int productId , UpdateProductRequest request);
}
