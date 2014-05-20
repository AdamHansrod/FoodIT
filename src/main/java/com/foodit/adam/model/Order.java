package com.foodit.adam.model;

import java.util.List;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

public class Order {
	String recVersion;
	String orderId;
	String easyOrderNum;
	String created;
	String storeId;
	String storeName;
	double totalValue;
	List<Meal> lineItems;
	String status;
	String timeZoneId;
	String collectionType;
	String paymentType;
	String addressDisplay;
	String contactNumber;
	String domain;
	String currencyDisplay;
	String commissionRate;
	String referenceNumber;
	String receiptLogoUrl;
	
	public Order(String recVersion, String orderId,
			String easyOrderNum, String created, String storeId,
			String storeName, double totalValue, List<Meal> lineItems,
			String status, String timeZoneId, String collectionType,
			String paymentType, String addressDisplay, String contactNumber,
			String domain, String currencyDisplay, String commissionRate,
			String referenceNumber, String receiptLogoUrl) {
		super();
		this.recVersion = recVersion;
		this.orderId = orderId;
		this.easyOrderNum = easyOrderNum;
		this.created = created;
		this.storeId = storeId;
		this.storeName = storeName;
		this.totalValue = totalValue;
		this.lineItems = lineItems;
		this.status = status;
		this.timeZoneId = timeZoneId;
		this.collectionType = collectionType;
		this.paymentType = paymentType;
		this.addressDisplay = addressDisplay;
		this.contactNumber = contactNumber;
		this.domain = domain;
		this.currencyDisplay = currencyDisplay;
		this.commissionRate = commissionRate;
		this.referenceNumber = referenceNumber;
		this.receiptLogoUrl = receiptLogoUrl;
	}

	public String getRecVersion() {
		return recVersion;
	}
	public void setRecVersion(String recVersion) {
		this.recVersion = recVersion;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getEasyOrderNum() {
		return easyOrderNum;
	}
	public void setEasyOrderNum(String easyOrderNum) {
		this.easyOrderNum = easyOrderNum;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	public List<Meal> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<Meal> lineItems) {
		this.lineItems = lineItems;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeZoneId() {
		return timeZoneId;
	}
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getAddressDisplay() {
		return addressDisplay;
	}
	public void setAddressDisplay(String addressDisplay) {
		this.addressDisplay = addressDisplay;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getCurrencyDisplay() {
		return currencyDisplay;
	}
	public void setCurrencyDisplay(String currencyDisplay) {
		this.currencyDisplay = currencyDisplay;
	}
	public String getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(String commissionRate) {
		this.commissionRate = commissionRate;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getReceiptLogoUrl() {
		return receiptLogoUrl;
	}
	public void setReceiptLogoUrl(String receiptLogoUrl) {
		this.receiptLogoUrl = receiptLogoUrl;
	}


}
