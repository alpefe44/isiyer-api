package com.isiyer.isiyer.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isiyer.isiyer.entity.Yard;

public interface YardRepository extends JpaRepository<Yard, Integer>{
	
}
