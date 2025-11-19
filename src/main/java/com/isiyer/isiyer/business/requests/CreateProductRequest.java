package com.isiyer.isiyer.business.requests;

import com.isiyer.isiyer.entity.Product.Unit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CreateProductRequest {
	private String code;
	private String malHizmet;
	private String description;
	private int amount;
	private Unit unit;
}
