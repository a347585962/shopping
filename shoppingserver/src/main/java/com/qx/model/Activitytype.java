package com.qx.model;

// Generated 2015-9-8 9:22:49 by Hibernate Tools 3.4.0.CR1

/**
 * Activitytype generated by hbm2java
 */
public class Activitytype implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer activitytypeId;
	private String activitytypeName;
    private String activitytypeNickname;
    private Integer shopId;
    private Integer activitytypeStatus;
    
	public Integer getActivitytypeStatus() {
		return activitytypeStatus;
	}

	public void setActivitytypeStatus(Integer activitytypeStatus) {
		this.activitytypeStatus = activitytypeStatus;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getActivitytypeNickname() {
		return activitytypeNickname;
	}

	public void setActivitytypeNickname(String activitytypeNickname) {
		this.activitytypeNickname = activitytypeNickname;
	}

	public Activitytype() {
	}

	public Activitytype(String activitytypeName) {
		this.activitytypeName = activitytypeName;
	}

	public Integer getActivitytypeId() {
		return this.activitytypeId;
	}

	public void setActivitytypeId(Integer activitytypeId) {
		this.activitytypeId = activitytypeId;
	}

	public String getActivitytypeName() {
		return this.activitytypeName;
	}

	public void setActivitytypeName(String activitytypeName) {
		this.activitytypeName = activitytypeName;
	}

	@Override
	public String toString() {
		return "Activitytype [activitytypeId=" + activitytypeId
				+ ", activitytypeName=" + activitytypeName
				+ ", activitytypeNickname=" + activitytypeNickname + "]";
	}

}
