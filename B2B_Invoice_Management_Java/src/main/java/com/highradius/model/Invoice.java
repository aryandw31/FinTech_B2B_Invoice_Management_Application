package com.highradius.model;

public class Invoice {

	private int Sl_no, CUSTOMER_ORDER_ID, SALES_ORG, COMPANY_CODE, SOLD_TO_PARTY, CUSTOMER_NUMBER;
	private String DISTRIBUTION_CHANNEL, DIVISION, PURCHASE_ORDER_TYPE, ORDER_CREATION_DATE, ORDER_CREATION_TIME,
	CREDIT_CONTROL_AREA, REQUESTED_DELIVERY_DATE, ORDER_CURRENCY, CREDIT_STATUS;
	private double RELEASED_CREDIT_VALUE, ORDER_AMOUNT, AMOUNT_IN_USD;
	private long UNIQUE_CUST_ID;
	
    // Parameterized constructor
    public Invoice(int CUSTOMER_ORDER_ID, int SALES_ORG, String DISTRIBUTION_CHANNEL,
    		String DIVISION, double RELEASED_CREDIT_VALUE, String PURCHASE_ORDER_TYPE, int COMPANY_CODE,
    		String ORDER_CREATION_DATE, String ORDER_CREATION_TIME, String CREDIT_CONTROL_AREA,
    		int SOLD_TO_PARTY, double ORDER_AMOUNT, String REQUESTED_DELIVERY_DATE,
    		String ORDER_CURRENCY, String CREDIT_STATUS, int CUSTOMER_NUMBER,
    		double AMOUNT_IN_USD, long UNIQUE_CUST_ID) {
		this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
		this.SALES_ORG = SALES_ORG;
		this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
		this.DIVISION = DIVISION;
		this.RELEASED_CREDIT_VALUE = RELEASED_CREDIT_VALUE;
		this.PURCHASE_ORDER_TYPE = PURCHASE_ORDER_TYPE;
		this.COMPANY_CODE = COMPANY_CODE;
		this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
		this.ORDER_CREATION_TIME = ORDER_CREATION_TIME;
		this.CREDIT_CONTROL_AREA = CREDIT_CONTROL_AREA;
		this.SOLD_TO_PARTY = SOLD_TO_PARTY;
		this.ORDER_AMOUNT = ORDER_AMOUNT;
		this.REQUESTED_DELIVERY_DATE = REQUESTED_DELIVERY_DATE;
		this.ORDER_CURRENCY = ORDER_CURRENCY;
		this.CREDIT_STATUS = CREDIT_STATUS;
		this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
		this.AMOUNT_IN_USD = AMOUNT_IN_USD;
		this.UNIQUE_CUST_ID = UNIQUE_CUST_ID;
    }
    
    public Invoice(int CUSTOMER_ORDER_ID, int SALES_ORG, String DISTRIBUTION_CHANNEL, int COMPANY_CODE,
    		String ORDER_CREATION_DATE, String ORDER_CURRENCY,int CUSTOMER_NUMBER,
    		double AMOUNT_IN_USD) {
		this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
		this.SALES_ORG = SALES_ORG;
		this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
		this.COMPANY_CODE = COMPANY_CODE;
		this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
		this.ORDER_CURRENCY = ORDER_CURRENCY;
		this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
		this.AMOUNT_IN_USD = AMOUNT_IN_USD;
    }

    // Getter for invoice number
    public int get_Sl_no() {
    	return Sl_no;
    }
    
    public int get_CUSTOMER_ORDER_ID() {
    	return CUSTOMER_ORDER_ID;
    }
    
    public int get_SALES_ORG() {
    	return SALES_ORG;
    }
    
    public String get_DISTRIBUTION_CHANNEL() {
    	return DISTRIBUTION_CHANNEL;
    }
    
    public String get_DIVISION() {
    	return DIVISION;
    }
    
    public double get_RELEASED_CREDIT_VALUE() {
    	return RELEASED_CREDIT_VALUE;
    }
    
    public String get_PURCHASE_ORDER_TYPE() {
    	return PURCHASE_ORDER_TYPE;
    }
    
    public int get_COMPANY_CODE() {
    	return COMPANY_CODE;
    }
    
    public String get_ORDER_CREATION_DATE() {
    	return ORDER_CREATION_DATE;
    }
    
    public String get_ORDER_CREATION_TIME() {
    	return ORDER_CREATION_TIME;
    }
    
    public String get_CREDIT_CONTROL_AREA() {
    	return CREDIT_CONTROL_AREA;
    }
    
    public int get_SOLD_TO_PARTY() {
    	return SOLD_TO_PARTY;
    }
    
    public double get_ORDER_AMOUNT() {
    	return ORDER_AMOUNT;
    }
    
    public String get_REQUESTED_DELIVERY_DATE() {
    	return REQUESTED_DELIVERY_DATE;
    }
    
    public String get_ORDER_CURRENCY() {
    	return ORDER_CURRENCY;
    }
    
    public String get_CREDIT_STATUS() {
    	return CREDIT_STATUS;
    }
    
    public int get_CUSTOMER_NUMBER() {
    	return CUSTOMER_NUMBER;
    }
    
    public double get_AMOUNT_IN_USD() {
    	return AMOUNT_IN_USD;
    }
    
    public long get_UNIQUE_CUST_ID() {
    	return UNIQUE_CUST_ID;
    }
    
    
    // Setter for invoice number
    public void set_Sl_no(int Sl_no) {
		this.Sl_no = Sl_no;
    }
    
    public void set_CUSTOMER_ORDER_ID(int CUSTOMER_ORDER_ID) {
    	this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
    }
    
    public void set_SALES_ORG(int SALES_ORG) {
    	this.SALES_ORG = SALES_ORG;
    }
    
    public void set_DISTRIBUTION_CHANNEL(String DISTRIBUTION_CHANNEL) {
    	this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
    }
    
    public void set_Sl_no(String DIVISION) {
    	this.DIVISION = DIVISION;
    }
    
    public void set_RELEASED_CREDIT_VALUE(double RELEASED_CREDIT_VALUE) {
    	this.RELEASED_CREDIT_VALUE = RELEASED_CREDIT_VALUE;
    }
    
    public void set_PURCHASE_ORDER_TYPE(String PURCHASE_ORDER_TYPE) {
    	this.PURCHASE_ORDER_TYPE = PURCHASE_ORDER_TYPE;
    }
    
    public void set_COMPANY_CODE(int COMPANY_CODE) {
    	this.COMPANY_CODE = COMPANY_CODE;
    }
    
    public void set_ORDER_CREATION_DATE(String ORDER_CREATION_DATE) {
    	this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
    }
    
    public void set_ORDER_CREATION_TIME(String ORDER_CREATION_TIME) {
    	this.ORDER_CREATION_TIME = ORDER_CREATION_TIME;
    }
    
    public void set_CREDIT_CONTROL_AREA(String CREDIT_CONTROL_AREA) {
    	this.CREDIT_CONTROL_AREA = CREDIT_CONTROL_AREA;
    }
    
    public void set_SOLD_TO_PARTY(int SOLD_TO_PARTY) {
    	this.SOLD_TO_PARTY = SOLD_TO_PARTY;
    }
    
    public void set_ORDER_AMOUNT(double ORDER_AMOUNT) {
    	this.ORDER_AMOUNT = ORDER_AMOUNT;
    }
    
    public void set_REQUESTED_DELIVERY_DATE(String REQUESTED_DELIVERY_DATE) {
    	this.REQUESTED_DELIVERY_DATE = REQUESTED_DELIVERY_DATE;
    }
    
    public void set_ORDER_CURRENCY(String ORDER_CURRENCY) {
    	this.ORDER_CURRENCY = ORDER_CURRENCY;
    }
    
    public void set_CREDIT_STATUS(String CREDIT_STATUS) {
    	this.CREDIT_STATUS = CREDIT_STATUS;
    }
    
    public void set_CUSTOMER_NUMBER(int CUSTOMER_NUMBER) {
    	this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
    }
    
    public void set_AMOUNT_IN_USD(double AMOUNT_IN_USD) {
    	this.AMOUNT_IN_USD = AMOUNT_IN_USD;
    }
    
    public void set_UNIQUE_CUST_ID(long UNIQUE_CUST_ID) {
    	this.UNIQUE_CUST_ID = UNIQUE_CUST_ID;
    }
    
}
