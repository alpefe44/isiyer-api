
package com.isiyer.isiyer.business.responses;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YardResponse {
    private int id;
    private String yardName;
    private List<ProductResponse> products; 
}