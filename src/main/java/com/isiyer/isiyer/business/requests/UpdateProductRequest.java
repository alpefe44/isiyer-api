package com.isiyer.isiyer.business.requests;

import com.isiyer.isiyer.entity.Product.Unit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    private String code;
    private String description;
    private int amount; 
    private Unit unit;  

    private int yardId;
}
