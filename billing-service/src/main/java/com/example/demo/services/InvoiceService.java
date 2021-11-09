package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.InvoiceRequestDTO;
import com.example.demo.dto.InvoiceResponseDTO;

public interface InvoiceService {
	InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
	InvoiceResponseDTO getInvoice(String invoiceID);
	List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);
}
