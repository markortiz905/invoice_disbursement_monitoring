package com.tech24.invoice.monitoring.invoicemonitoring.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Invoice {

	private long transactionNumber;
	private long invoiceNumber;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;
	private String customerName;
	private double amount;
	private double totalPaid;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate datePaid;
	private double outstanding;
	
	public Invoice(){}
	
	public Invoice(long transactionNumber, long invoiceNumber, LocalDate date, LocalDate paymentDate,
			String customerName, double amount, double totalPaid,
			LocalDate datePaid, double outstanding) {
		this(invoiceNumber, date, paymentDate,customerName, amount, totalPaid, datePaid, outstanding);
		this.transactionNumber = transactionNumber;
		
	}
	
	public Invoice(long invoiceNumber, LocalDate date, LocalDate paymentDate,
			String customerName, double amount, double totalPaid,
			LocalDate datePaid, double outstanding) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.date = date;
		this.paymentDate = paymentDate;
		this.customerName = customerName;
		this.amount = amount;
		this.totalPaid = totalPaid;
		this.datePaid = datePaid;
		this.outstanding = outstanding;
	}
	
	public long getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
	public LocalDate getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(LocalDate datePaid) {
		this.datePaid = datePaid;
	}
	public double getOutstanding() {
		return outstanding;
	}
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}

	

	@Override
	public String toString() {
		return String
				.format("{transactionNumber:%s, invoiceNumber:%s, date:%s, paymentDate:%s, customerName:%s, amount:%s, totalPaid:%s, datePaid:%s, outstanding:%s}",
						transactionNumber, invoiceNumber, date, paymentDate,
						customerName, amount, totalPaid, datePaid, outstanding);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (invoiceNumber ^ (invoiceNumber >>> 32));
		result = prime * result
				+ (int) (transactionNumber ^ (transactionNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (invoiceNumber != other.invoiceNumber)
			return false;
		if (transactionNumber != other.transactionNumber)
			return false;
		return true;
	}
	
	
	
	
	
}
