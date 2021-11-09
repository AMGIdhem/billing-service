package com.example.demo.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InvoiceRequestDTO;
import com.example.demo.dto.InvoiceResponseDTO;
import com.example.demo.services.InvoiceService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
	private InvoiceService invoiceService;
	
	public InvoiceRestController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	
	@GetMapping(path = "/invoices/{id}")
	public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String invoiceId) {
		return invoiceService.getInvoice(invoiceId);
	}
	
	@GetMapping(path = "/invoices/{customerId}")
	public List<InvoiceResponseDTO> getInvoiceByCustomer(@PathVariable String customerId) {
		return invoiceService.invoicesByCustomerId(customerId);
	}
	
	@PostMapping(path = "/invoices")
	public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
		return invoiceService.save(invoiceRequestDTO);
	}

}
