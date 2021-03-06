package com.qx.model;
// default package
// Generated 2015-11-8 22:30:09 by Hibernate Tools 3.4.0.CR1

/**
 * Property generated by hbm2java
 */
public class Property implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer propertyId;
	private String propertyName;
	private Integer shopId;
	private Integer propertyStatus;
    private String propertyType;
    private String propertyShowname;
    
	public String getPropertyShowname() {
		return propertyShowname;
	}

	public void setPropertyShowname(String propertyShowname) {
		this.propertyShowname = propertyShowname;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public Property() {
	}

	public Property(String propertyName, Integer shopId, Integer propertyStatus) {
		this.propertyName = propertyName;
		this.shopId = shopId;
		this.propertyStatus = propertyStatus;
	}

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getPropertyStatus() {
		return this.propertyStatus;
	}

	public void setPropertyStatus(Integer propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

}
