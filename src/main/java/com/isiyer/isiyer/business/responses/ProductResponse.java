package com.isiyer.isiyer.business.responses;

import com.isiyer.isiyer.entity.Product.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String code;
    private String description;
    private String malHizmet;
    private int amount;
    private Unit unit;
    
    private YardInfo yard; 
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class YardInfo {
        private int id;
        private String name; 
    }
}