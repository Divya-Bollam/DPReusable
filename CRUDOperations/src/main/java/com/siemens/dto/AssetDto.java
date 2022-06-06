package com.siemens.dto;

import java.io.Serializable;

public class AssetDto implements Serializable{
	
	private int propertyid;
	private String propertyname;
	public int getPropertyid() {
		return propertyid;
	}
	
	public void setPropertyid(int propertyid) {
		this.propertyid = propertyid;
	}
	public String getPropertyname() {
		return propertyname;
	}
	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}
	
	
	
}
