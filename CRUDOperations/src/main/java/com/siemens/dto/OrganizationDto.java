package com.siemens.dto;

import java.io.Serializable;
import java.util.List;

import com.siemens.entity.Asset;
import com.siemens.entity.Employee;

public class OrganizationDto implements Serializable{
	private int orgId;
	private String orgName;
	private String orgLocation;
	private List<EmployeeDto> employees;
	private List<AssetDto> assets;

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgLocation() {
		return orgLocation;
	}

	public void setOrgLocation(String orgLocation) {
		this.orgLocation = orgLocation;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}

	public List<AssetDto> getAssets() {
		return assets;
	}

	public void setAssets(List<AssetDto> assets) {
		this.assets = assets;
	}
}
