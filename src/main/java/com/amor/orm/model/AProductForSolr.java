package com.amor.orm.model;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @author huaba
 *
 */
public class AProductForSolr {
	@Field
	private Integer id;
	@Field
	private String itemCode;
	@Field
	private String itemType;
	@Field
	private String trends;
	@Field
	private String silhouette;
	@Field
	private String neckline;
	@Field
	private String waistline;
	@Field
	private String sleeve;
	@Field
	private String version;
	@Field
	private String color;
	@Field
	private String size;
	@Field
	private String all = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getTrends() {
		return trends;
	}

	public void setTrends(String trends) {
		this.trends = trends;
	}

	public String getSilhouette() {
		return silhouette;
	}

	public void setSilhouette(String silhouette) {
		this.silhouette = silhouette;
	}

	public String getNeckline() {
		return neckline;
	}

	public void setNeckline(String neckline) {
		this.neckline = neckline;
	}

	public String getWaistline() {
		return waistline;
	}

	public void setWaistline(String waistline) {
		this.waistline = waistline;
	}

	public String getSleeve() {
		return sleeve;
	}

	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAll() {
		all += itemCode + ";;";
		all += itemType  + ";;";
		all += trends  + ";;";
		all += silhouette  + ";;";
		all += neckline  + ";;";
		all += waistline  + ";;";
		all += sleeve  + ";;";
		all += version  + ";;";
		all += color  + ";;";
		all += size  + ";;";
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}
	
}