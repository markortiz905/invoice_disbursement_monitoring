package com.tech24.invoice.monitoring.invoicemonitoring.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech24.invoice.monitoring.invoicemonitoring.model.Invoice;
import com.tech24.invoice.monitoring.invoicemonitoring.service.InvoiceServiceImpl;

@Controller
public class InvoiceController {
	
	@Value("${application.rootUrl}")
	private String rootUrl;
	
	@Autowired
	private InvoiceServiceImpl invoiceService;
	
	@RequestMapping(value="/invoicePage")
	public String invoiceLandingPage(Model model) {
		List<Invoice> invoices = invoiceService.getAllInvoice();
		model.addAttribute("invoiceList", invoices);
		return "invoiceLanding";
	}
	
	@RequestMapping(value="/invoiceViewPage/{number}")
	public String invoiceView(@PathVariable("number") long number, Model model) {
		Optional<Invoice> invoiceOp = invoiceService.searchInvoiceByInvoiceNumber(number);
		model.addAttribute("rootUrl", rootUrl);
		invoiceOp.ifPresent(o->model.addAttribute("invoice", o));
		return "invoiceView";
	}
	
	@RequestMapping(value="/invoiceAddForm")
	public String invoiceAddForm(Model model) {
		Optional<Invoice> invoices = invoiceService.getLastEntry();
		model.addAttribute("invoiceList", invoices);
		return "invoiceAdd";
	}
	
}
