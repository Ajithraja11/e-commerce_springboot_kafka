package com.demo.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Order_table")
public class Order {
	
	@Column(name="order_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Id
	int order_id;
	

	@Column(name="order_status")
	String order_status;
	
	@Column(name="order_customer_id")
	int order_customer_id;
	
	@Column(name="order_item_name")
	String[] order_item_name;
	
	@Column(name="order_item_qty")
	String[] order_item_qty;
	
	@Column(name="order_subtotal")
	float order_subtotal;
	
	@Column(name="order_tax")
	float order_tax;
	
	@Column(name="order_shipping_charges")
	float order_shipping_charges;
	
	@Column(name="order_total")
	float order_total;
	
	@Column(name="order_payment_method")
	String[] order_payment_method;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy", timezone = "UTC")
	@Column(name="order_payment_date")
	Date order_payment_date;
	
	@Column(name="order_payment_confirmation_number")
	String[] order_payment_confirmation_number;
	
	@Column(name="order_billing_addressline1")
	String order_billing_addressline1;
	
	@Column(name="order_billing_addressline2")
	String order_billing_addressline2;
	
	@Column(name="order_billing_city")
	String order_billing_city;
	
	@Column(name="order_billing_state")
	String order_billing_state;
	
	@Column(name="order_billing_zip")
	int order_billing_zip;
	
	@Column(name="order_shipping_addressline1")
	String order_shipping_addressline1;
	
	@Column(name="order_shipping_addressline2")
	String order_shipping_addressline2;
	
	@Column(name="order_shipping_city")
	String order_shipping_city;
	
	@Column(name="order_shipping_state")
	String order_shipping_state;
	
	@Column(name="order_shipping_zip")
	int order_shipping_zip;
	

	public Order() {
		
	}
	
	

	public Order(int order_id, String order_status, int order_customer_id, String[] order_item_name,
			String[] order_item_qty, float order_subtotal, float order_tax, float order_shipping_charges,
			float order_total, String[] order_payment_method, Date order_payment_date,
			String[] order_payment_confirmation_number, String order_billing_addressline1,
			String order_billing_addressline2, String order_billing_city, String order_billing_state,
			int order_billing_zip, String order_shipping_addressline1, String order_shipping_addressline2,
			String order_shipping_city, String order_shipping_state, int order_shipping_zip) {
		super();
		this.order_id = order_id;
		this.order_status = order_status;
		this.order_customer_id = order_customer_id;
		this.order_item_name = order_item_name;
		this.order_item_qty = order_item_qty;
		this.order_subtotal = order_subtotal;
		this.order_tax = order_tax;
		this.order_shipping_charges = order_shipping_charges;
		this.order_total = order_total;
		this.order_payment_method = order_payment_method;
		this.order_payment_date = order_payment_date;
		this.order_payment_confirmation_number = order_payment_confirmation_number;
		this.order_billing_addressline1 = order_billing_addressline1;
		this.order_billing_addressline2 = order_billing_addressline2;
		this.order_billing_city = order_billing_city;
		this.order_billing_state = order_billing_state;
		this.order_billing_zip = order_billing_zip;
		this.order_shipping_addressline1 = order_shipping_addressline1;
		this.order_shipping_addressline2 = order_shipping_addressline2;
		this.order_shipping_city = order_shipping_city;
		this.order_shipping_state = order_shipping_state;
		this.order_shipping_zip = order_shipping_zip;
	}



	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public int getOrder_customer_id() {
		return order_customer_id;
	}

	public void setOrder_customer_id(int order_customer_id) {
		this.order_customer_id = order_customer_id;
	}

	public String[] getOrder_item_name() {
		return order_item_name;
	}

	public void setOrder_item_name(String[] order_item_name) {
		this.order_item_name = order_item_name;
	}

	public String[] getOrder_item_qty() {
		return order_item_qty;
	}

	public void setOrder_item_qty(String[] order_item_qty) {
		this.order_item_qty = order_item_qty;
	}

	public float getOrder_subtotal() {
		return order_subtotal;
	}

	public void setOrder_subtotal(float order_subtotal) {
		this.order_subtotal = order_subtotal;
	}

	public float getOrder_tax() {
		return order_tax;
	}

	public void setOrder_tax(float order_tax) {
		this.order_tax = order_tax;
	}

	public float getOrder_shipping_charges() {
		return order_shipping_charges;
	}

	public void setOrder_shipping_charges(float order_shipping_charges) {
		this.order_shipping_charges = order_shipping_charges;
	}

	public float getOrder_total() {
		return order_total;
	}

	public void setOrder_total(float order_total) {
		this.order_total = order_total;
	}

	public String[] getOrder_payment_method() {
		return order_payment_method;
	}

	public void setOrder_payment_method(String[] order_payment_method) {
		this.order_payment_method = order_payment_method;
	}

	public Date getOrder_payment_date() {
		return order_payment_date;
	}

	public void setOrder_payment_date(Date order_payment_date) {
		this.order_payment_date = order_payment_date;
	}

	public String[] getOrder_payment_confirmation_number() {
		return order_payment_confirmation_number;
	}

	public void setOrder_payment_confirmation_number(String[] order_payment_confirmation_number) {
		this.order_payment_confirmation_number = order_payment_confirmation_number;
	}

	public String getOrder_billing_addressline1() {
		return order_billing_addressline1;
	}

	public void setOrder_billing_addressline1(String order_billing_addressline1) {
		this.order_billing_addressline1 = order_billing_addressline1;
	}

	public String getOrder_billing_addressline2() {
		return order_billing_addressline2;
	}

	public void setOrder_billing_addressline2(String order_billing_addressline2) {
		this.order_billing_addressline2 = order_billing_addressline2;
	}

	public String getOrder_billing_city() {
		return order_billing_city;
	}

	public void setOrder_billing_city(String order_billing_city) {
		this.order_billing_city = order_billing_city;
	}

	public String getOrder_billing_state() {
		return order_billing_state;
	}

	public void setOrder_billing_state(String order_billing_state) {
		this.order_billing_state = order_billing_state;
	}

	public int getOrder_billing_zip() {
		return order_billing_zip;
	}

	public void setOrder_billing_zip(int order_billing_zip) {
		this.order_billing_zip = order_billing_zip;
	}

	public String getOrder_shipping_addressline1() {
		return order_shipping_addressline1;
	}

	public void setOrder_shipping_addressline1(String order_shipping_addressline1) {
		this.order_shipping_addressline1 = order_shipping_addressline1;
	}

	public String getOrder_shipping_addressline2() {
		return order_shipping_addressline2;
	}

	public void setOrder_shipping_addressline2(String order_shipping_addressline2) {
		this.order_shipping_addressline2 = order_shipping_addressline2;
	}

	public String getOrder_shipping_city() {
		return order_shipping_city;
	}

	public void setOrder_shipping_city(String order_shipping_city) {
		this.order_shipping_city = order_shipping_city;
	}

	public String getOrder_shipping_state() {
		return order_shipping_state;
	}

	public void setOrder_shipping_state(String order_shipping_state) {
		this.order_shipping_state = order_shipping_state;
	}

	public int getOrder_shipping_zip() {
		return order_shipping_zip;
	}

	public void setOrder_shipping_zip(int order_shipping_zip) {
		this.order_shipping_zip = order_shipping_zip;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_status=" + order_status + ", order_customer_id="
				+ order_customer_id + ", order_item_name=" + Arrays.toString(order_item_name) + ", order_item_qty="
				+ Arrays.toString(order_item_qty) + ", order_subtotal=" + order_subtotal + ", order_tax=" + order_tax
				+ ", order_shipping_charges=" + order_shipping_charges + ", order_total=" + order_total
				+ ", order_payment_method=" + Arrays.toString(order_payment_method) + ", order_payment_date="
				+ order_payment_date + ", order_payment_confirmation_number="
				+ Arrays.toString(order_payment_confirmation_number) + ", order_billing_addressline1="
				+ order_billing_addressline1 + ", order_billing_addressline2=" + order_billing_addressline2
				+ ", order_billing_city=" + order_billing_city + ", order_billing_state=" + order_billing_state
				+ ", order_billing_zip=" + order_billing_zip + ", order_shipping_addressline1="
				+ order_shipping_addressline1 + ", order_shipping_addressline2=" + order_shipping_addressline2
				+ ", order_shipping_city=" + order_shipping_city + ", order_shipping_state=" + order_shipping_state
				+ ", order_shipping_zip=" + order_shipping_zip + "]";
	}
	
	
	
}
