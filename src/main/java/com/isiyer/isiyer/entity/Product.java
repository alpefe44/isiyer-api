package com.isiyer.isiyer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Product {
	
	public enum Unit {
	    METRE,
	    ADET
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String malHizmet;
	private String description;
	private int amount;
	
	@Enumerated(EnumType.STRING)
    private Unit unit;
	
	@ManyToOne
	@JoinColumn(name = "yard_id")
	private Yard yard;
}
