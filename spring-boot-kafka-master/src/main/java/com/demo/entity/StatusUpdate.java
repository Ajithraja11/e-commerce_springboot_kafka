package com.demo.entity;

import java.util.Arrays;

public class StatusUpdate {

	int[] orderIds;
	String newStatus;
	
	public StatusUpdate() {
	
	}
	
	public int[] getOrderIds() {
		return orderIds;
	}
	public void setOrderIds(int[] orderIds) {
		this.orderIds = orderIds;
	}
	public String getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	@Override
	public String toString() {
		return "StatusUpdate [orderIds=" + Arrays.toString(orderIds) + ", newStatus=" + newStatus + "]";
	}
	
}
