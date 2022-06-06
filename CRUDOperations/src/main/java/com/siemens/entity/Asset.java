package com.siemens.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset")
public class Asset {
	
	@Id
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
