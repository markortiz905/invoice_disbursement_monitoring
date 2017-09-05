package com.pinoyTech.invoice.monitoring.invoicemonitoring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.pinoyTech.invoice.monitoring.invoicemonitoring.model.Invoice;

@Component
public class InvoiceServiceImpl {
	
	AtomicInteger atomicInteger = new AtomicInteger();
	List<Invoice> data = new ArrayList<>();
	
	public Invoice createInvoice(long transactionNumber, long invoiceNumber, LocalDate date, LocalDate paymentDate,
			String customerName, double amount, double totalPaid,
			LocalDate datePaid, double outstanding) {
		Invoice i = new Invoice(invoiceNumber, date, paymentDate, customerName, amount, totalPaid, datePaid, outstanding);
		return i;
	}
	
	public void saveInvoice(Invoice invoice) {
		invoice.setTransactionNumber(atomicInteger.incrementAndGet());
		data.add(invoice);
	}
	
	public boolean deleteInvoice(Invoice i) {
		if (data.contains(i)) {
			return data.remove(i);
		}
		return false;
	}
	
	public void updateInvoice(Invoice i) {
		
	}
	
	public Optional<Invoice> searchInvoiceByInvoiceNumber(long invoiceNumber) {
		return data.stream().filter(i->
			i.getInvoiceNumber()==invoiceNumber
		).findFirst();
	}

	public List<Invoice> getAllInvoice() {
		return data;
	}

	public boolean deleteInvoice(long number) {
		return data.removeIf(a -> a.getInvoiceNumber()==number);
	}

	public boolean deleteAllInvoice() {
		data = new ArrayList<>();
		return true;
	}

	public Optional<Invoice> getLastEntry() {
		int size = data.size();
		if (size > 0)
			return Optional.of(data.get(size - 1));
		return Optional.empty();
	}
	
	
}
