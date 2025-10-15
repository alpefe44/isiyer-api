package com.isiyer.isiyer.business.responses;

import java.util.List;

import com.isiyer.isiyer.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdYardResponse {
	private String yardName;
	private List<ProductResponse> products;
}
