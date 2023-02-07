package com.employee.AssetTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.entity.Asset;
import com.employee.entity.Employee;
import com.employee.entity.repository.AssetRepository;
import com.employee.service.AssetService;

@SpringBootTest

public class AssetTestCases {
	
	@Mock
	private AssetRepository assetRepository;
	
	@InjectMocks
	private AssetService assetService;
	
	@Test
	void addAsset(){
		Employee employee = new Employee();
		Asset asset = new Asset(1,23,"Laptop","Allocated",employee);
		 when(assetRepository.save(asset)).thenReturn(asset);
		 
		Asset assetDetails = assetService.addAsset(asset);
		assertThat(assetDetails.getAssetName().equals(asset.getAssetName()));
	}
	
	@Test
    void retrieveAllAssets() {
		Employee employee = new Employee();
	
	List<Asset> assetsList = new ArrayList<>();
	
	Asset asset1 = new Asset(1,23,"Laptop","Allocated",employee);
	Asset asset2 = new Asset(2,28,"Mouse","Allocated",employee);
	
	assetsList.add(asset1);
	assetsList.add(asset2);
	
	when(assetRepository.findAll()).thenReturn(assetsList);
	
      List<Asset> assetList = assetService.retrieveAllAssets();
      
        assertEquals(2,assetList.size());
}
	
	@Test
	
    void updateAsset() {
		Employee employee = new Employee();
	
		Asset asset = new Asset(1,23,"Laptop","Allocated",employee);
	
	when(assetRepository.findById(asset.getItemNo())).thenReturn(Optional.of(asset));
	
	Asset assetDetails = assetService.updateAsset(asset);
	
	assertEquals("Laptop",assetDetails.getAssetName());
	
	verify(assetRepository,times(1)).findById(asset.getItemNo());
	
}

@Test
	
	void deleteAsset() {
		
	assetService.deleteAsset(1);
		
		verify(assetRepository,times(1)).deleteById(1);
	}


}
