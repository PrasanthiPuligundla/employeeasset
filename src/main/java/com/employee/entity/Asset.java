package com.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table

public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
     private int itemNo;
     private int serialNo;
     private String assetName;
    private String status;

   @ManyToOne
 private Employee employee;
 
 public Asset () {}

public Asset(int itemNo, int serialNo, String assetName, String status, Employee employee) {
	super();
	this.itemNo = itemNo;
	this.serialNo = serialNo;
	this.assetName = assetName;
	this.status = status;
	this.employee = employee;
}

public int getItemNo() {
	return itemNo;
}

public void setItemNo(int itemNo) {
	this.itemNo = itemNo;
}

public int getSerialNo() {
	return serialNo;
}

public void setSerialNo(int serialNo) {
	this.serialNo = serialNo;
}

public String getAssetName() {
	return assetName;
}

public void setAssetName(String assetName) {
	this.assetName = assetName;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

@Override
public String toString() {
	return "Asset [itemNo=" + itemNo + ", serialNo=" + serialNo + ", assetName=" + assetName + ", status=" + status
			+ ", employee=" + employee + "]";
}
 
  
	

}
