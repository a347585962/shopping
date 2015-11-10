package com.qx.model;

// Generated 2015-9-6 15:37:17 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Goodsinfo generated by hbm2java
 */
@JsonIgnoreProperties(value = { "cartinfos", "subOrderinfos", "pingjiainfos",
		"favoriteinfos" })
public class Goodsinfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer goodsId;
	private String goodsName;
	private BigDecimal goodsPrice1;
	private BigDecimal goodsPrice2;
	private BigDecimal goodsPrice3;
	private BigDecimal goodsPriceIn;
	private String goodsClass1;
	private String goodsClass2;
	private String goodsClass3;
	private String goodsType;
	private String goodsUntis;
	private String productAddress;
	private Date updateTime;
	private String photoUrl;
	private Integer goodsStock;
	private BigDecimal goodsPrice4;
	private Set cartinfos = new HashSet(0);
	private Set subOrderinfos = new HashSet(0);
	private Set pingjiainfos = new HashSet(0);
	private Set favoriteinfos = new HashSet(0);
	private Integer activityId;
	private String barCode;
	private String remark;
	private Integer sumsalesrate;
	private Shopgoods shopgoods;
	
	public Shopgoods getShopgoods() {
		return shopgoods;
	}

	public void setShopgoods(Shopgoods shopgoods) {
		this.shopgoods = shopgoods;
	}

	public Integer getSumsalesrate() {
		return sumsalesrate;
	}

	public void setSumsalesrate(Integer sumsalesrate) {
		this.sumsalesrate = sumsalesrate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	private Activity activityid;
	
    public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	private Integer status;
    
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Activity getActivityid() {
		return activityid;
	}

	public void setActivityid(Activity activityid) {
		this.activityid = activityid;
	}

	public Goodsinfo() {
	}

	public Goodsinfo(String goodsName) {
		this.goodsName = goodsName;
	}

	public Goodsinfo(String goodsName, BigDecimal goodsPrice1,
			BigDecimal goodsPrice2, BigDecimal goodsPrice3,
			BigDecimal goodsPriceIn, String goodsClass1, String goodsClass2,
			String goodsClass3, String goodsType, String goodsUntis,
			String productAddress, Date updateTime, String photoUrl,
			Integer goodsStock, BigDecimal goodsPrice4, Set cartinfos,
			Set subOrderinfos, Set pingjiainfos, Set favoriteinfos,
			Set cartinfos_1, Set pingjiainfos_1, Set favoriteinfos_1) {
		this.goodsName = goodsName;
		this.goodsPrice1 = goodsPrice1;
		this.goodsPrice2 = goodsPrice2;
		this.goodsPrice3 = goodsPrice3;
		this.goodsPriceIn = goodsPriceIn;
		this.goodsClass1 = goodsClass1;
		this.goodsClass2 = goodsClass2;
		this.goodsClass3 = goodsClass3;
		this.goodsType = goodsType;
		this.goodsUntis = goodsUntis;
		this.productAddress = productAddress;
		this.updateTime = updateTime;
		this.photoUrl = photoUrl;
		this.goodsStock = goodsStock;
		this.goodsPrice4 = goodsPrice4;
		this.cartinfos = cartinfos;
		this.subOrderinfos = subOrderinfos;
		this.pingjiainfos = pingjiainfos;
		this.favoriteinfos = favoriteinfos;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice1() {
		return this.goodsPrice1;
	}

	public void setGoodsPrice1(BigDecimal goodsPrice1) {
		this.goodsPrice1 = goodsPrice1;
	}

	public BigDecimal getGoodsPrice2() {
		return this.goodsPrice2;
	}

	public void setGoodsPrice2(BigDecimal goodsPrice2) {
		this.goodsPrice2 = goodsPrice2;
	}

	public BigDecimal getGoodsPrice3() {
		return this.goodsPrice3;
	}

	public void setGoodsPrice3(BigDecimal goodsPrice3) {
		this.goodsPrice3 = goodsPrice3;
	}

	public BigDecimal getGoodsPriceIn() {
		return this.goodsPriceIn;
	}

	public void setGoodsPriceIn(BigDecimal goodsPriceIn) {
		this.goodsPriceIn = goodsPriceIn;
	}

	public String getGoodsClass1() {
		return this.goodsClass1;
	}

	public void setGoodsClass1(String goodsClass1) {
		this.goodsClass1 = goodsClass1;
	}

	public String getGoodsClass2() {
		return this.goodsClass2;
	}

	public void setGoodsClass2(String goodsClass2) {
		this.goodsClass2 = goodsClass2;
	}

	public String getGoodsClass3() {
		return this.goodsClass3;
	}

	public void setGoodsClass3(String goodsClass3) {
		this.goodsClass3 = goodsClass3;
	}

	public String getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsUntis() {
		return this.goodsUntis;
	}

	public void setGoodsUntis(String goodsUntis) {
		this.goodsUntis = goodsUntis;
	}

	public String getProductAddress() {
		return this.productAddress;
	}

	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getGoodsStock() {
		return this.goodsStock;
	}

	public void setGoodsStock(Integer goodsStock) {
		this.goodsStock = goodsStock;
	}

	public BigDecimal getGoodsPrice4() {
		return this.goodsPrice4;
	}

	public void setGoodsPrice4(BigDecimal goodsPrice4) {
		this.goodsPrice4 = goodsPrice4;
	}

	public Set getCartinfos() {
		return this.cartinfos;
	}

	public void setCartinfos(Set cartinfos) {
		this.cartinfos = cartinfos;
	}

	public Set getSubOrderinfos() {
		return this.subOrderinfos;
	}

	public void setSubOrderinfos(Set subOrderinfos) {
		this.subOrderinfos = subOrderinfos;
	}

	public Set getPingjiainfos() {
		return this.pingjiainfos;
	}

	public void setPingjiainfos(Set pingjiainfos) {
		this.pingjiainfos = pingjiainfos;
	}

	public Set getFavoriteinfos() {
		return this.favoriteinfos;
	}

	public void setFavoriteinfos(Set favoriteinfos) {
		this.favoriteinfos = favoriteinfos;
	}

	@Override
	public String toString() {
		return "Goodsinfo [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice1=" + goodsPrice1 + ", goodsPrice2="
				+ goodsPrice2 + ", goodsPrice3=" + goodsPrice3
				+ ", goodsPriceIn=" + goodsPriceIn + ", goodsClass1="
				+ goodsClass1 + ", goodsClass2=" + goodsClass2
				+ ", goodsClass3=" + goodsClass3 + ", goodsType=" + goodsType
				+ ", goodsUntis=" + goodsUntis + ", productAddress="
				+ productAddress + ", updateTime=" + updateTime + ", photoUrl="
				+ photoUrl + ", goodsStock=" + goodsStock + ", goodsPrice4="
				+ goodsPrice4 + ", barCode=" + barCode + ", remark=" + remark
				+ ", sumsalesrate=" + sumsalesrate + ", status=" + status + "]";
	}

	

}
