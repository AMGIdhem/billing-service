package com.example.demo.mappers;

import org.mapstruct.Mapper;

import com.example.demo.dto.InvoiceRequestDTO;
import com.example.demo.dto.InvoiceResponseDTO;
import com.example.demo.entities.Invoice;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
	Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
	InvoiceResponseDTO fromInvoice(Invoice invoice);
}
