package com.pinoyTech.invoice.monitoring.invoicemonitoring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pinoyTech.invoice.monitoring.invoicemonitoring.model.Invoice;
import com.pinoyTech.invoice.monitoring.invoicemonitoring.service.InvoiceServiceImpl;

@RestController
public class InvoiceRestController {

	@Autowired
	private InvoiceServiceImpl invoiceServiceImpl;
	
	@RequestMapping(value="/invoice", method=RequestMethod.GET)
	public ResponseEntity<List<Invoice>> getInvoices(Model model) {
		return new ResponseEntity<List<Invoice>>(invoiceServiceImpl.getAllInvoice(),  HttpStatus.OK);
	}
	
	@RequestMapping(value="/invoice/{number}", method=RequestMethod.GET)
	public ResponseEntity<Invoice> searchInvoiceByNumber(@PathVariable("number") long number) {
		Optional<Invoice> opIn = invoiceServiceImpl.searchInvoiceByInvoiceNumber(number);
		if ( opIn.isPresent())
			return new ResponseEntity<Invoice>(opIn.get(),  HttpStatus.OK);
		return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/invoice/", method=RequestMethod.POST)
	public ResponseEntity<Void> createInvoice(@RequestBody Invoice invoice,
			UriComponentsBuilder ucBuilder) {
		Optional<Invoice> opIn = invoiceServiceImpl.searchInvoiceByInvoiceNumber(invoice.getInvoiceNumber());
		
		if (opIn.isPresent()) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		invoiceServiceImpl.saveInvoice(invoice);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/invoiceViewPage/{id}").buildAndExpand(invoice.getInvoiceNumber()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/invoice/{number}", method=RequestMethod.PUT)
	public ResponseEntity<Invoice> updateInvoice(@PathVariable("number") long number,
			@RequestBody Invoice invoice) {
		Optional<Invoice> poIn = invoiceServiceImpl.searchInvoiceByInvoiceNumber(number);
		if ( ! poIn.isPresent()) {
			return new ResponseEntity<Invoice>(HttpStatus.NOT_FOUND);
		}
		Invoice i = poIn.get();
		invoice.setTransactionNumber(i.getTransactionNumber());
		invoiceServiceImpl.updateInvoice(invoice);
		
        return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
	}
	
	@RequestMapping(value="/invoice/{number}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteInvoice(@PathVariable("number") long number) {
		Optional<Invoice> poIn = invoiceServiceImpl.searchInvoiceByInvoiceNumber(number);
		
		if ( ! poIn.isPresent()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		boolean updated = invoiceServiceImpl.deleteInvoice(number);
		
        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
	}
	
	@RequestMapping(value="/invoice/", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllInvoice() {
		boolean updated = invoiceServiceImpl.deleteAllInvoice();
        return new ResponseEntity<Boolean>(updated, HttpStatus.OK);
	}
}
