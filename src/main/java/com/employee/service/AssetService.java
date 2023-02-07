package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Asset;
import com.employee.entity.repository.AssetRepository;

@Service

public class AssetService {
	
	@Autowired
	AssetRepository assetRepository;
	
	public Asset addAsset(Asset asset) {
		return assetRepository.save(asset);
	}
	
    public List<Asset> retrieveAllAssets(){
		
		List<Asset> assets = assetRepository.findAll();
		
		return assets;
	}
    
	
	public void deleteAsset(int itemNo) {
		assetRepository.deleteById(itemNo);
	}
	
	public Asset updateAsset(Asset asset) {
		Optional<Asset>assetDetails = assetRepository.findById(asset.getItemNo());
		
		assetDetails.get().setAssetName(asset.getAssetName());
		assetDetails.get().setSerialNo(asset.getSerialNo());
		assetDetails.get().setStatus(asset.getStatus());
		assetRepository.save(assetDetails.get());
		return assetDetails.get();
				}

	public List<Asset> retriveAssetForEmployee(int id) {
		List<Asset> assets = new ArrayList();
		List<Asset> assetList = assetRepository.findAll();
	
		for(Asset asset : assetList) {
			if(id == asset.getEmployee().getId()) {
				assets.add(asset);
		
				}
			}
		return assets;
		
	}

}
