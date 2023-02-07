package com.employee.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
