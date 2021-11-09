package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.InvoiceRequestDTO;
import com.example.demo.dto.InvoiceResponseDTO;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Invoice;
import com.example.demo.mappers.InvoiceMapper;
import com.example.demo.openfeign.CustomerRestClient;
import com.example.demo.repositories.InvoiceRepository;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	private InvoiceRepository invoiceRepository;
	private InvoiceMapper invoiceMapper;
	private CustomerRestClient customerRestClient;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper,
			CustomerRestClient customerRestClient) {
		super();
		this.invoiceRepository = invoiceRepository;
		this.invoiceMapper = invoiceMapper;
		this.customerRestClient = customerRestClient;
	}

	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
		Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
		invoice.setId(UUID.randomUUID().toString());
		invoice.setDate(new Date());
		Invoice saveInvoice = invoiceRepository.save(invoice);
		return invoiceMapper.fromInvoice(saveInvoice);
	}

	@Override
	public InvoiceResponseDTO getInvoice(String invoiceID) {
		Invoice invoice = invoiceRepository.findById(invoiceID).get();
		Customer customer = customerRestClient.getCustomer(invoice.getCustomerID());
		invoice.setCustomer(customer);
		return invoiceMapper.fromInvoice(invoice);
	}

	@Override
	public List<InvoiceResponseDTO> invoicesByCustomerId(String customerId) {
		List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
		return invoices
				.stream()
				.map(invoice->invoiceMapper.fromInvoice(invoice))
				.collect(Collectors.toList());
	}

}
