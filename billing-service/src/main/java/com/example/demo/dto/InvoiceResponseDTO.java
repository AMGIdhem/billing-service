package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResponseDTO {
	private String id;
	private Date date;
	private BigDecimal amount;
	private Customer customer;
}
