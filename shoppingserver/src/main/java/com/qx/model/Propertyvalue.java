package com.qx.model;
// default package
// Generated 2015-11-8 22:30:09 by Hibernate Tools 3.4.0.CR1

/**
 * Propertyvalue generated by hbm2java
 */
public class Propertyvalue implements java.io.Serializable {

	private Integer propertyvalueId;
	private String propertyvalueValue;              
	private Integer shopgoodsId;
	private Integer propertyStatus;
    private Integer propertyId;
    
	public Integer getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public Propertyvalue() {
	}

	public Propertyvalue(String propertyvalueValue, Integer shopgoodsId,
			Integer propertyStatus) {
		this.propertyvalueValue = propertyvalueValue;
		this.shopgoodsId = shopgoodsId;
		this.propertyStatus = propertyStatus;
	}

	public Integer getPropertyvalueId() {
		return this.propertyvalueId;
	}

	public void setPropertyvalueId(Integer propertyvalueId) {
		this.propertyvalueId = propertyvalueId;
	}

	public String getPropertyvalueValue() {
		return this.propertyvalueValue;
	}

	public void setPropertyvalueValue(String propertyvalueValue) {
		this.propertyvalueValue = propertyvalueValue;
	}

	public Integer getShopgoodsId() {
		return this.shopgoodsId;
	}

	public void setShopgoodsId(Integer shopgoodsId) {
		this.shopgoodsId = shopgoodsId;
	}

	public Integer getPropertyStatus() {
		return this.propertyStatus;
	}

	public void setPropertyStatus(Integer propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	@Override
	public String toString() {
		return "Propertyvalue [propertyvalueId=" + propertyvalueId
				+ ", propertyvalueValue=" + propertyvalueValue
				+ ", shopgoodsId=" + shopgoodsId + ", propertyStatus="
				+ propertyStatus + ", propertyId=" + propertyId + "]";
	}

}