package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	List<Invoice> findByCustomerId(String customerId);
}
