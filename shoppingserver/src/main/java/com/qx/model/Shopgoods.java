package com.qx.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

// default package
// Generated 2015-11-8 22:30:09 by Hibernate Tools 3.4.0.CR1

/**
 * Shopgoods generated by hbm2java
 */
@JsonIgnoreProperties(value = {  "subOrderinfos" })
public class Shopgoods implements java.io.Serializable {

	private Integer shopgoodsId;
	private Integer shopId;
	private Integer goodsId;
	private Integer shopgoodsStatus;
    private Integer activityId;
    private Goodsinfo goodsinfo;
    private Set subOrderinfos = new HashSet(0);
    private Date date;
    
    public Set getSubOrderinfos() {
		return subOrderinfos;
	}

	public void setSubOrderinfos(Set subOrderinfos) {
		this.subOrderinfos = subOrderinfos;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	Set<Propertyvalue> propertyvalues;
    
	public Goodsinfo getGoodsinfo() {
		return goodsinfo;
	}

	public void setGoodsinfo(Goodsinfo goodsinfo) {
		this.goodsinfo = goodsinfo;
	}

	

	public Set<Propertyvalue> getPropertyvalues() {
		return propertyvalues;
	}

	public void setPropertyvalues(Set<Propertyvalue> propertyvalues) {
		this.propertyvalues = propertyvalues;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Shopgoods() {
	}

	public Shopgoods(Integer shopId, Integer goodsId, Integer shopgoodsStatus) {
		this.shopId = shopId;
		this.goodsId = goodsId;
		this.shopgoodsStatus = shopgoodsStatus;
	}

	public Integer getShopgoodsId() {
		return this.shopgoodsId;
	}

	public void setShopgoodsId(Integer shopgoodsId) {
		this.shopgoodsId = shopgoodsId;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getShopgoodsStatus() {
		return this.shopgoodsStatus;
	}

	public void setShopgoodsStatus(Integer shopgoodsStatus) {
		this.shopgoodsStatus = shopgoodsStatus;
	}

	@Override
	public String toString() {
		return "Shopgoods [shopgoodsId=" + shopgoodsId + ", shopId=" + shopId
				+ ", goodsId=" + goodsId + ", shopgoodsStatus="
				+ shopgoodsStatus + ", activityId=" + activityId
				+ ", goodsinfo=" + goodsinfo + ", date=" + date
				+ ", propertyvalues=" + propertyvalues + "]";
	}

}